package es.upm.fi.sos;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.axis2.AxisFault;

import es.upm.fi.sos.aa.*;
import es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.LoginBackEnd;
import es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.*;
import es.upm.fi.sos.xsd.*;

public class UPMSocialReadingSkeleton {

	// Clase que guarda información sobre una cuenta
	private class Cuenta {

		private User user;
		private int sesiones;
		private ArrayList<String> friends;
		private ArrayList<Book> lecturas;

		public Cuenta(User u) {
			this.sesiones = 0;
			this.user = u;
			this.friends = new ArrayList<String>();
			this.lecturas = new ArrayList<Book>();
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public int getSesiones() {
			return sesiones;
		}

		public void addSesion() {
			this.sesiones++;
		}

		public void removeSesion() {
			this.sesiones--;
		}

		public ArrayList<String> getFriends() {
			return this.friends;
		}

		public ArrayList<Book> getLecturas() {
			return this.lecturas;
		}

	}

	// Usuario admin
	private static User admin;
	// Para comprobar si se ha iniciado anteriormente
	private static boolean started = false;
	// Flag para ver si ya se ha autenticado un usuario
	private boolean autenticado;
	// Mapa de todos los usuarios dados de alta y sus respectivas cuentas
	private static Map<String, Cuenta> bbddCuentas;
	// Usuario actual
	private User usuarioActual;
	// Contador de sesiones activas locales
	private int sesionesActivas;
	// Conexión stub UPMAuthenticationAuthoritation
	private static UPMAuthenticationAuthorizationWSSkeletonStub upmAA;

	public UPMSocialReadingSkeleton() throws AxisFault {
		if (!started) {
			admin = new User();
			admin.setName("admin");
			admin.setPwd("admin");
			bbddCuentas = new HashMap<String, Cuenta>();
			started = true;
			upmAA = new UPMAuthenticationAuthorizationWSSkeletonStub();
		}
		this.usuarioActual = new User();
		this.usuarioActual.setName("");
		this.usuarioActual.setPwd("");
		this.autenticado = false;
		this.sesionesActivas = 0;

	}

	// funcion que devuelve lecturas de un usuario
	private String[] getListaLecturas(ArrayList<Book> lista) {
		String[] lecturas = new String[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			// primero se ponen los últimos libros leídos
			lecturas[i] = lista.get(lista.size() - (i + 1)).getTitle();
		}
		return lecturas;
	}

	public void logout(es.upm.fi.sos.Logout logout) {
		Cuenta cuenta = bbddCuentas.get(usuarioActual.getName());
		if (cuenta != null && autenticado) {
			// se cierra una sesión
			cuenta.removeSesion();
			this.sesionesActivas--;
			if (sesionesActivas == 0) {
				autenticado = false;
				usuarioActual = null;
			}
		} else if (this.usuarioActual.getName().compareTo("admin") == 0) {
			this.sesionesActivas--;
			if (sesionesActivas == 0) {
				autenticado = false;
				usuarioActual = null;
			}
		}
	}

	public es.upm.fi.sos.AddFriendResponse addFriend(
			es.upm.fi.sos.AddFriend addFriend) {
		AddFriendResponse addRes = new AddFriendResponse();
		Response res = new Response();
		String friend = addFriend.getArgs0().getUsername();
		boolean done = false;

		if (bbddCuentas.containsKey(this.usuarioActual.getName())
				&& this.autenticado && bbddCuentas.containsKey(friend)) {
			Cuenta cuentaActual = bbddCuentas.get(usuarioActual.getName());
			// comprueba si ya son amigos
			if (cuentaActual.getFriends().indexOf(friend) == -1) {
				cuentaActual.getFriends().add(friend);
				done = true;
			}

		}
		res.setResponse(done);
		addRes.set_return(res);
		return addRes;
	}

	public es.upm.fi.sos.RemoveFriendResponse removeFriend(
			es.upm.fi.sos.RemoveFriend removeFriend) {
		RemoveFriendResponse remRes = new RemoveFriendResponse();
		Response res = new Response();

		String friend = removeFriend.getArgs0().getUsername();
		boolean done = false;

		if (this.autenticado
				&& bbddCuentas.containsKey(this.usuarioActual.getName())
				&& bbddCuentas.containsKey(friend)) {

			Cuenta cuentaActual = bbddCuentas.get(usuarioActual.getName());
			// comprueba si ya son amigos o no
			if (cuentaActual.getFriends().indexOf(friend) != -1) {
				cuentaActual.getFriends().remove(friend);
				done = true;
			}

		}

		res.setResponse(done);
		remRes.set_return(res);
		return remRes;

	}

	public es.upm.fi.sos.GetMyFriendReadingsResponse getMyFriendReadings(
			es.upm.fi.sos.GetMyFriendReadings getMyFriendReadings) {

		GetMyFriendReadingsResponse getRes = new GetMyFriendReadingsResponse();
		TitleList listaLibros = new TitleList();
		String[] libros = null;
		String name = getMyFriendReadings.getArgs0().getUsername();
		ArrayList<Book> lista;
		boolean done = false;

		if (this.autenticado
				&& bbddCuentas.containsKey(this.usuarioActual.getName())) {
			Cuenta cuenta = bbddCuentas.get(usuarioActual.getName());
			// se comprueba si son amigos
			if (cuenta.getFriends().contains(name)) {
				Cuenta cuentaAmigo = bbddCuentas.get(name);
				lista = cuentaAmigo.getLecturas();
				done = true;
				if (!lista.isEmpty()) {
					libros = this.getListaLecturas(lista);
				} else {
					libros = new String[0];
				}
			}
		}

		listaLibros.setResult(done);
		listaLibros.setTitles(libros);
		getRes.set_return(listaLibros);
		return getRes;
	}

	public es.upm.fi.sos.GetMyFriendListResponse getMyFriendList(
			es.upm.fi.sos.GetMyFriendList getMyFriendList) {

		GetMyFriendListResponse getRes = new GetMyFriendListResponse();
		FriendList list = new FriendList();
		ArrayList<String> arr;
		String[] friendList;
		boolean done = false;

		if (this.autenticado
				&& bbddCuentas.containsKey(this.usuarioActual.getName())) {
			Cuenta cuentaActual = bbddCuentas.get(usuarioActual.getName());
			arr = cuentaActual.getFriends();
			int existentes = 0;
			// comprueba cuantos amigos siguen existiendo
			for (int i = 0; i < arr.size(); i++) {
				if (bbddCuentas.containsKey(arr.get(i)))
					existentes++;
				else {
					arr.remove(i);
					i--;
				}
			}
			friendList = new String[existentes];

			// se copian en un array
			for (int i = 0; i < existentes; i++) {
				friendList[i] = arr.get(i);
			}

			list.setFriends(friendList);
			done = true;
		}

		list.setResult(done);
		getRes.set_return(list);
		return getRes;
	}

	public es.upm.fi.sos.AddUserResponse addUser(es.upm.fi.sos.AddUser addUser)
			throws RemoteException {
		AddUserResponse addResp = new AddUserResponse();
		es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.AddUser addUser2 = new es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.AddUser();
		es.upm.fi.sos.xsd.AddUserResponse aux = new es.upm.fi.sos.xsd.AddUserResponse();
		es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.AddUserResponseBackEnd be = new es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.AddUserResponseBackEnd();

		boolean done = false;
		String pass = "";

		if (usuarioActual != null
				&& usuarioActual.getName().compareTo("admin") == 0) {
			es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.UserBackEnd userBE = new es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.UserBackEnd();
			userBE.setName(addUser.getArgs0().getUsername());
			addUser2.setUser(userBE);
			be = upmAA.addUser(addUser2).get_return();
			// si sale bien se mete en el mapa
			if (done = be.getResult()) {
				User user = new User();
				pass = be.getPassword();
				user.setName(addUser.getArgs0().getUsername());
				user.setPwd(pass);
				Cuenta cuentaNueva = new Cuenta(user);
				bbddCuentas.put(addUser.getArgs0().getUsername(), cuentaNueva);
			}
		}

		aux.setResponse(done);
		aux.setPwd(pass);
		addResp.set_return(aux);
		return addResp;
	}

	public es.upm.fi.sos.RemoveUserResponse removeUser(
			es.upm.fi.sos.RemoveUser removeUser) throws RemoteException {
		RemoveUserResponse remUser = new RemoveUserResponse();
		es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.RemoveUser removeUserStub = new es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.RemoveUser();
		es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.RemoveUserE removeUserE = new es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.RemoveUserE();
		es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.RemoveUserResponseE removeUserResponse = new es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.RemoveUserResponseE();

		es.upm.fi.sos.xsd.Response aux = new es.upm.fi.sos.xsd.Response();

		String username = removeUser.getArgs0().getUsername();
		boolean done = false;

		// el admin elimina
		if (usuarioActual != null
				&& usuarioActual.getName().compareTo("admin") == 0
				&& bbddCuentas.containsKey(username)
				&& username.compareTo("admin") != 0) {

			removeUserStub.setName(username);
			removeUserStub.setPassword(bbddCuentas.get(username).getUser()
					.getPwd());
			removeUserE.setRemoveUser(removeUserStub);
			removeUserResponse = upmAA.removeUser(removeUserE);
			done = removeUserResponse.get_return().getResult();

			// si se ha eliminado
			if (done && bbddCuentas.containsKey(username)) {
				bbddCuentas.remove(username);
			}

		}

		// el propio usuario se elimina
		if (usuarioActual != null
				&& bbddCuentas.containsKey(usuarioActual.getName())
				&& bbddCuentas.containsKey(username)
				&& usuarioActual.getName().compareTo(username) == 0) {
			removeUserStub.setName(username);
			removeUserStub.setPassword(bbddCuentas.get(username).getUser()
					.getPwd());
			removeUserE.setRemoveUser(removeUserStub);
			removeUserResponse = upmAA.removeUser(removeUserE);
			done = removeUserResponse.get_return().getResult();

			// si se ha eliminado
			if (done && bbddCuentas.containsKey(username)) {
				bbddCuentas.remove(username);
			}
		}

		aux.setResponse(done);
		remUser.set_return(aux);
		return remUser;
	}

	public es.upm.fi.sos.GetMyReadingsResponse getMyReadings(
			es.upm.fi.sos.GetMyReadings getMyReadings) {

		GetMyReadingsResponse getRes = new GetMyReadingsResponse();
		TitleList listaLibros = new TitleList();
		String[] libros = null;
		ArrayList<Book> lista;
		boolean done = false;

		if (this.autenticado
				&& bbddCuentas.containsKey(this.usuarioActual.getName())) {
			Cuenta cuentaActual = bbddCuentas.get(this.usuarioActual.getName());
			lista = cuentaActual.getLecturas();
			done = true;
			if (!lista.isEmpty()) {
				libros = this.getListaLecturas(lista);
			} else {
				libros = new String[0];
			}
		}

		listaLibros.setResult(done);
		listaLibros.setTitles(libros);
		getRes.set_return(listaLibros);
		return getRes;

	}

	public es.upm.fi.sos.AddReadingResponse addReading(
			es.upm.fi.sos.AddReading addReading) {
		AddReadingResponse addRes = new AddReadingResponse();
		Response res = new Response();
		ArrayList<Book> lecturas;
		Book libro = addReading.getArgs0();
		Book aux;

		boolean done = false;

		if (this.autenticado
				&& bbddCuentas.containsKey(this.usuarioActual.getName())) {
			Cuenta cuentaActual = bbddCuentas.get(usuarioActual.getName());
			lecturas = cuentaActual.getLecturas();

			int i = 0;
			boolean encontrado = false;
			while (!encontrado && i < lecturas.size()) {
				if (lecturas.get(i).getTitle().compareTo(libro.getTitle()) == 0) {
					encontrado = true;
				}
				i++;
			}

			if (encontrado) {
				aux = lecturas.get(i);
				// se cambia solo el autor y la calificacion
				aux.setAuthor(libro.getAuthor());
				aux.setCalification(libro.getCalification());
			} else {
				lecturas.add(libro);
			}
			done = true;
		}

		res.setResponse(done);
		addRes.set_return(res);
		return addRes;
	}

	public es.upm.fi.sos.ChangePasswordResponse changePassword(
			es.upm.fi.sos.ChangePassword changePassword) throws RemoteException {
		ChangePasswordResponse changePassResp = new ChangePasswordResponse();
		es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.ChangePassword changePassStub = new es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.ChangePassword();
		es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.ChangePasswordBackEnd changePassBE = new es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.ChangePasswordBackEnd();
		es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.ChangePasswordResponseE be = new es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.ChangePasswordResponseE();

		es.upm.fi.sos.xsd.Response aux = new es.upm.fi.sos.xsd.Response();
		PasswordPair p = changePassword.getArgs0();

		boolean done = false;

		// si es el admin
		if (usuarioActual != null
				&& usuarioActual.getName().compareTo("admin") == 0
				&& p.getOldpwd().compareTo(admin.getPwd()) == 0) {
			admin.setPwd(p.getNewpwd());
			done = true;
		} else if (autenticado
				&& bbddCuentas.containsKey(this.usuarioActual.getName())
				&& usuarioActual.getPwd().compareTo(p.getOldpwd()) == 0) {

			changePassBE.setName(usuarioActual.getName());
			changePassBE.setOldpwd(p.getOldpwd());
			changePassBE.setNewpwd(p.getNewpwd());
			changePassStub.setChangePassword(changePassBE);
			be = upmAA.changePassword(changePassStub);

			done = be.get_return().getResult();
			if (done) {
				Cuenta c = bbddCuentas.get(usuarioActual.getName());
				usuarioActual.setPwd(p.getNewpwd());
				c.getUser().setPwd(p.getNewpwd());
			}
		}

		aux.setResponse(done);
		changePassResp.set_return(aux);
		return changePassResp;
	}

	// Método login
	public es.upm.fi.sos.LoginResponse login(es.upm.fi.sos.Login login)
			throws RemoteException {

		LoginResponse loginResponse = new LoginResponse();
		Response response = new Response();
		String username = login.getArgs0().getName();
		String pass = login.getArgs0().getPwd();
		Cuenta cuentaAux;
		boolean done = false;

		// si es el admin
		if (username.compareTo("admin") == 0
				&& pass.compareTo(admin.getPwd()) == 0) {
			done = true;
			this.usuarioActual = admin;
			this.autenticado = true;
			this.sesionesActivas++;
			System.out.println("Soy admin");
		} else {

			// Si no coincide el autenticado con el nuevo login
			if (this.autenticado
					&& username.compareTo(this.usuarioActual.getName()) != 0) {
				done = false;
			} else {
				// si existe el usuario
				done = true;
				// Si no está autenticado en esta sesión
				if (!this.autenticado) {
					es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.Login log = new es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.Login();
					LoginBackEnd lbe = new LoginBackEnd();
					lbe.setName(username);
					lbe.setPassword(pass);
					log.setLogin(lbe);

					es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.LoginResponse res = upmAA
							.login(log);
					done = res.get_return().getResult();
				}

				if (done) {

					// busca si existe el usuario, si no se mete en la memoria
					// interna
					if (!bbddCuentas.containsKey(username)) {
						User user = new User();
						user.setName(username);
						user.setPwd(pass);
						bbddCuentas.put(username, new Cuenta(user));
					}
					cuentaAux = bbddCuentas.get(username);
					// se añade una sesión
					cuentaAux.addSesion();
					this.autenticado = true;
					this.usuarioActual = cuentaAux.getUser();
					this.sesionesActivas++;
				}
			}

		}

		response.setResponse(done);
		loginResponse.set_return(response);
		return loginResponse;
	}

}
