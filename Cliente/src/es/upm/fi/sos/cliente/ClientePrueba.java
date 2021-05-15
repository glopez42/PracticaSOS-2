package es.upm.fi.sos.cliente;

import java.rmi.RemoteException;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.*;

public class ClientePrueba {

	public static void main(String[] args) throws RemoteException {

		UPMSocialReadingStub stub = new UPMSocialReadingStub();
		stub._getServiceClient().getOptions().setManageSession(true);
		stub._getServiceClient().engageModule("addressing");

		// Inicia sesión como admin
		Login l = new Login();
		LoginResponse logRes = new LoginResponse();
		User user = new User();
		Logout lo = new Logout();
		Response res = new Response();
		Username name = new Username();

//
		// Añade a un usuario siendo admin
//		Username name = new Username();
//		AddUser addUser = new AddUser();
//		AddUserResponseE addRes = new AddUserResponseE();
//
//		name.setUsername("hlopezv3");
//		addUser.setArgs0(name);
//		addRes = stub.addUser(addUser);
//		System.out.println("Resultado de addUser de " + name.getUsername()
//				+ ": " + addRes.get_return().getResponse());
//		System.out.println("Contraseña devuelta: "
//				+ addRes.get_return().getPwd());
//		System.out.println();
//		
//		stub.logout(lo);
//		System.out.println("Sesión terminada");

		
		// Inicia sesión
		l = new Login();
		logRes = new LoginResponse();
		user = new User();

		user.setName("hlopezv3");
		user.setPwd("hlopezv39980");
		l.setArgs0(user);
		logRes = stub.login(l);

		System.out.println("Resultado de login: "
				+ logRes.get_return().getResponse());
		System.out.println("Sesión fuera como: " + user.getName());
		
		
		//Change Password
		ChangePassword chps = new ChangePassword();
		ChangePasswordResponse chpRes = new ChangePasswordResponse();
		
		PasswordPair pair = new PasswordPair();
		pair.setNewpwd("caca");
		pair.setOldpwd("hlopezv39980");
		chps.setArgs0(pair);
		chpRes = stub.changePassword(chps);
		
		System.out.println("Resultado change password: " + chpRes.get_return().getResponse());
		
		// Logout
		stub.logout(lo);
		System.out.println("Sesión terminada");
		
		//Login
		user.setName("hlopezv3");
		user.setPwd("caca");
		l.setArgs0(user);
		logRes = stub.login(l);

		System.out.println("Resultado de login: "
				+ logRes.get_return().getResponse());
		System.out.println("Sesión fuera como: " + user.getName());
		
		// Logout
		stub.logout(lo);
		System.out.println("Sesión terminada");
		
		//Login admin
		user.setName("admin");
		user.setPwd("admin");
		l.setArgs0(user);
		logRes = stub.login(l);

		System.out.println("Resultado de login: "
				+ logRes.get_return().getResponse());
		System.out.println("Sesión iniciada como: " + user.getName());
		System.out.println();
		
		
		//Remove User
		name.setUsername("hlopezv3");
		RemoveUser remUser = new RemoveUser();
		RemoveUserResponse remRes = new RemoveUserResponse();
		remUser.setArgs0(name);
		
		remRes = stub.removeUser(remUser);
		System.out.println("Resultado de remUser: " + remRes.get_return().getResponse());
		
		// Logout
		stub.logout(lo);
		System.out.println("Sesión terminada");
		
		//Login
		user.setName("hlopezv3");
		user.setPwd("caca");
		l.setArgs0(user);
		logRes = stub.login(l);

		System.out.println("Resultado de login: "
				+ logRes.get_return().getResponse());
		System.out.println("Sesión fuera como: " + user.getName());
		System.out.println();
		
		

	}

}
