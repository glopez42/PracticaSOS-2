package es.upm.fi.sos;

import java.rmi.RemoteException;
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

		public Cuenta(User u) {
			this.sesiones = 0;
			this.user = u;
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

	}

	// Usuario admin
	private static User admin = new User();
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
	private UPMAuthenticationAuthorizationWSSkeletonStub upmAA;

	public UPMSocialReadingSkeleton() throws AxisFault {
		if (!started) {
			admin.setName("admin");
			admin.setPwd("admin");
			bbddCuentas = new HashMap<String, Cuenta>();
			started = true;
		}
		this.usuarioActual = new User();
		this.upmAA = new UPMAuthenticationAuthorizationWSSkeletonStub();
		this.autenticado = false;
		this.sesionesActivas = 0;

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
		}
	}

	public es.upm.fi.sos.AddFriendResponse addFriend(
			es.upm.fi.sos.AddFriend addFriend) {
		// TODO : fill this with the necessary business logic
		throw new java.lang.UnsupportedOperationException("Please implement "
				+ this.getClass().getName() + "#addFriend");
	}

	public es.upm.fi.sos.RemoveFriendResponse removeFriend(
			es.upm.fi.sos.RemoveFriend removeFriend) {
		// TODO : fill this with the necessary business logic
		throw new java.lang.UnsupportedOperationException("Please implement "
				+ this.getClass().getName() + "#removeFriend");
	}

	public es.upm.fi.sos.GetMyFriendReadingsResponse getMyFriendReadings(
			es.upm.fi.sos.GetMyFriendReadings getMyFriendReadings) {
		// TODO : fill this with the necessary business logic
		throw new java.lang.UnsupportedOperationException("Please implement "
				+ this.getClass().getName() + "#getMyFriendReadings");
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param getMyFriendList
	 * @return getMyFriendListResponse
	 */

	public es.upm.fi.sos.GetMyFriendListResponse getMyFriendList(
			es.upm.fi.sos.GetMyFriendList getMyFriendList) {
		// TODO : fill this with the necessary business logic
		throw new java.lang.UnsupportedOperationException("Please implement "
				+ this.getClass().getName() + "#getMyFriendList");
	}

	public es.upm.fi.sos.AddUserResponse addUser(es.upm.fi.sos.AddUser addUser)
			throws RemoteException {
		AddUserResponse addResp = new AddUserResponse();
		es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.AddUser addUser2 = new es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.AddUser();
		es.upm.fi.sos.xsd.AddUserResponse aux = new es.upm.fi.sos.xsd.AddUserResponse();
		es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.AddUserResponseBackEnd be = new es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.AddUserResponseBackEnd();

		boolean done = false;

		if (usuarioActual != null && usuarioActual.getName().compareTo("admin") == 0) {
			es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.UserBackEnd userBE = new es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.UserBackEnd();
			userBE.setName(addUser.getArgs0().getUsername());
			addUser2.setUser(userBE);
			be = upmAA.addUser(addUser2).get_return();

			// si sale bien se mete en el mapa
			if (done = be.getResult()) {
				User user = new User();
				user.setName(addUser.getArgs0().getUsername());
				user.setPwd(be.getPassword());
				Cuenta cuentaNueva = new Cuenta(user);
				bbddCuentas.put(addUser.getArgs0().getUsername(), cuentaNueva);

			}

		}

		aux.setResponse(done);
		// HAY QUE DEVOLVER CONTRASEÑA
		// ?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
		addResp.set_return(aux);
		return addResp;

	}

	public es.upm.fi.sos.RemoveUserResponse removeUser(es.upm.fi.sos.RemoveUser removeUser) throws RemoteException {
		RemoveUserResponse remUser = new RemoveUserResponse();
		es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.RemoveUser removeUserStub = new es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.RemoveUser();
		es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.RemoveUserE removeUserE = new es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.RemoveUserE();
		es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.RemoveUserResponseE removeUserResponse = new es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.RemoveUserResponseE ();

		es.upm.fi.sos.xsd.Response aux = new es.upm.fi.sos.xsd.Response();

		
		String username = removeUser.getArgs0().getUsername();
		boolean done = false;
		
		if (usuarioActual != null && usuarioActual.getName().compareTo("admin") == 0 && username.compareTo("admin") != 0) {
			
			removeUserStub.setName(username);
			removeUserStub.setPassword(bbddCuentas.get(username).getUser().getPwd());
			removeUserE.setRemoveUser(removeUserStub);
			removeUserResponse = this.upmAA.removeUser(removeUserE);
			done = removeUserResponse.get_return().getResult();
			
			//si se ha eliminado
			if (done){
				bbddCuentas.remove(username);
			}
			
		}
		
		aux.setResponse(done);
		remUser.set_return(aux);
		return remUser;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param getMyReadings
	 * @return getMyReadingsResponse
	 */

	public es.upm.fi.sos.GetMyReadingsResponse getMyReadings(
			es.upm.fi.sos.GetMyReadings getMyReadings) {
		// TODO : fill this with the necessary business logic
		throw new java.lang.UnsupportedOperationException("Please implement "
				+ this.getClass().getName() + "#getMyReadings");
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param addReading
	 * @return addReadingResponse
	 */

	public es.upm.fi.sos.AddReadingResponse addReading(
			es.upm.fi.sos.AddReading addReading) {
		// TODO : fill this with the necessary business logic
		throw new java.lang.UnsupportedOperationException("Please implement "
				+ this.getClass().getName() + "#addReading");
	}



	public es.upm.fi.sos.ChangePasswordResponse changePassword(es.upm.fi.sos.ChangePassword changePassword) throws RemoteException {
		ChangePasswordResponse changePassResp = new ChangePasswordResponse();
		es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.ChangePassword changePassStub = new es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.ChangePassword();
		es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.ChangePasswordBackEnd changePassBE = new es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.ChangePasswordBackEnd();
		es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.ChangePasswordResponseE be = new es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.ChangePasswordResponseE();

		es.upm.fi.sos.xsd.Response aux = new es.upm.fi.sos.xsd.Response();
		PasswordPair p = changePassword.getArgs0();
		
		boolean done = false;
		
		//si es el admin
		if (usuarioActual != null && usuarioActual.getName().compareTo("admin") == 0 && p.getOldpwd().compareTo(admin.getPwd()) == 0){
			admin.setPwd(p.getNewpwd());
			done = true;
		} else if(autenticado && usuarioActual.getPwd().compareTo(p.getOldpwd()) == 0){
			
			changePassBE.setName(usuarioActual.getName());
			changePassBE.setOldpwd(p.getOldpwd());
			changePassBE.setNewpwd(p.getNewpwd());
			changePassStub.setChangePassword(changePassBE);
			be = this.upmAA.changePassword(changePassStub);
			
			done = be.get_return().getResult();
			if (done){
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
		} else {
			// busca si existe el usuario
			if (bbddCuentas.containsKey(username)) {

				// Si no coincide el autenticado con el nuevo login
				if (this.autenticado
						&& username.compareTo(this.usuarioActual.getName()) != 0) {
					done = false;
				} else {
					cuentaAux = bbddCuentas.get(username);
					done = true;
					// Si no está autenticado en esta sesión
					if (!this.autenticado) {
						es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.Login log = new es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.Login();
						LoginBackEnd lbe = new LoginBackEnd();
						lbe.setName(username);
						lbe.setPassword(pass);
						log.setLogin(lbe);

						es.upm.fi.sos.aa.UPMAuthenticationAuthorizationWSSkeletonStub.LoginResponse res = this.upmAA
								.login(log);

						done = res.get_return().getResult();
						if (done) {
							// se añade una sesión
							cuentaAux.addSesion();
							this.autenticado = true;
							this.usuarioActual = cuentaAux.getUser();
							this.sesionesActivas++;
						}
					}
				}
			}
		}

		response.setResponse(done);
		loginResponse.set_return(response);
		return loginResponse;
	}

}
