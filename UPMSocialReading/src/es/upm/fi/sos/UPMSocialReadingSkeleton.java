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

	}

	public void logout(es.upm.fi.sos.Logout logout) {
		// TODO : fill this with the necessary business logic

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

	/**
	 * Auto generated method signature
	 * 
	 * @param getMyFriendReadings
	 * @return getMyFriendReadingsResponse
	 */

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

	/**
	 * Auto generated method signature
	 * 
	 * @param addUser
	 * @return addUserResponse
	 */

	public es.upm.fi.sos.AddUserResponse addUser(es.upm.fi.sos.AddUser addUser) {
		// TODO : fill this with the necessary business logic
		throw new java.lang.UnsupportedOperationException("Please implement "
				+ this.getClass().getName() + "#addUser");
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param removeUser
	 * @return removeUserResponse
	 */

	public es.upm.fi.sos.RemoveUserResponse removeUser(
			es.upm.fi.sos.RemoveUser removeUser) {
		// TODO : fill this with the necessary business logic
		throw new java.lang.UnsupportedOperationException("Please implement "
				+ this.getClass().getName() + "#removeUser");
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

	/**
	 * Auto generated method signature
	 * 
	 * @param changePassword
	 * @return changePasswordResponse
	 */

	public es.upm.fi.sos.ChangePasswordResponse changePassword(
			es.upm.fi.sos.ChangePassword changePassword) {
		// TODO : fill this with the necessary business logic
		throw new java.lang.UnsupportedOperationException("Please implement "
				+ this.getClass().getName() + "#changePassword");
	}

	
	//Método login
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
				if (this.autenticado && username.compareTo(this.usuarioActual.getName()) != 0) {
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
							//se añade una sesión
							cuentaAux.addSesion();
							this.autenticado = true;
							this.usuarioActual = cuentaAux.getUser();
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
