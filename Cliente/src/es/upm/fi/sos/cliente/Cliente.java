package es.upm.fi.sos.cliente;

import java.rmi.RemoteException;
import java.util.Scanner;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.AddFriend;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.AddFriendResponse;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.AddReading;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.AddReadingResponse;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.AddUser;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.AddUserResponseE;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.Book;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.ChangePassword;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.ChangePasswordResponse;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.FriendList;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.GetMyFriendList;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.GetMyFriendListResponse;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.GetMyFriendReadings;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.GetMyFriendReadingsResponse;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.GetMyReadings;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.GetMyReadingsResponse;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.Login;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.LoginResponse;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.Logout;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.PasswordPair;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.RemoveFriend;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.RemoveFriendResponse;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.RemoveUser;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.RemoveUserResponse;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.TitleList;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.User;
import es.upm.fi.sos.cliente.UPMSocialReadingStub.Username;

public class Cliente {
	
	//método privado que devuelve un nombre de usuario aleatorio
	//para que en cada ejecución, los clientes sean diferentes
	private static String createUsername(){
		String name = ( Math.random() > 0.5)? "hlopezv":"glopezg";
		return (name = name +(int) (Math.random()*1000));
	}

	public static void main(String[] args) throws RemoteException {

		UPMSocialReadingStub stub = new UPMSocialReadingStub();
		stub._getServiceClient().getOptions().setManageSession(true);
		stub._getServiceClient().engageModule("addressing");

		// Datos de usuarios
		String cliente1 = createUsername();
		String pass1 = "";
		String cliente2 = createUsername();
		String pass2 = "";
		String cliente3 = createUsername();
		String pass3 = "";
		String clienteExistente = "hlopezv1";
		//String passClienteExistente = "hlopezv11698";

		String admin = "admin";
		String pAdmin = "admin"; //OJO CAMBIAR¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿!!!!!!!!!!!!!!¿!¿!¿!¿!¿!¿!¿¿!¿!¿¿!¿!¿!¿¿

		Login l;
		LoginResponse logRes;
		User user;
		Logout lo;
		Username name;
		AddUser addUser;
		AddUserResponseE addRes;
		ChangePassword chps;
		ChangePasswordResponse chpRes;
		PasswordPair pair;
		AddFriend addFriend;
		AddFriendResponse addFRes;
		GetMyFriendList getList;
		GetMyFriendListResponse getLRes;
		FriendList fList;
		RemoveFriend rFriend;
		RemoveFriendResponse rFRes;
		AddReading addReading;
		AddReadingResponse addRRes;
		GetMyReadings getReadings;
		GetMyReadingsResponse getRRes;
		TitleList tList;
		GetMyFriendReadings getFriendReadings;
		GetMyFriendReadingsResponse getFRRes;
		RemoveUser remUser;
		RemoveUserResponse remRes;

		Book l1 = new Book();
		Book l2 = new Book();
		Book l3 = new Book();

		l1.setAuthor("Stephen King");
		l1.setTitle("La niebla");
		l1.setCalification(8);

		l2.setAuthor("Patrick Ruffus");
		l2.setTitle("El nombre del viento");
		l2.setCalification(7);

		l3.setAuthor("Brandon Sanderson");
		l3.setTitle("Imperio final");
		l3.setCalification(10);

		System.out.println("------- Cliente iniciado -------");
		System.out.println();

		// Se logea un admin
		System.out.println("#Prueba 1 - Login con admin");
		System.out.println("\t---> Debería devolver: true");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		l = new Login();
		logRes = new LoginResponse();
		user = new User();

		user.setName(admin);
		user.setPwd(pAdmin);
		l.setArgs0(user);
		logRes = stub.login(l);

		System.out.println("Resultado de prueba: "
				+ logRes.get_return().getResponse());
		System.out.println("Sesión iniciada como: " + user.getName());
		System.out.println("Fin de la prueba\n\n");

		// Admin añade clientes
		System.out
				.println("#Prueba 2 - Admin usa addUser para añadir clientes.");
		System.out
				.println("Añade tres usuarios que no existen anteriormente, y uno que sí.");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		addUser = new AddUser();
		addRes = new AddUserResponseE();
		name = new Username();

		System.out.println("Añade a cliente 1, no existe: " + cliente1);
		System.out.println("\t---> Debería devolver: true");

		name.setUsername(cliente1);
		addUser.setArgs0(name);
		addRes = stub.addUser(addUser);
		System.out.println("Resultado de addUser de " + name.getUsername()
				+ ": " + addRes.get_return().getResponse());
		System.out.println("Contraseña devuelta: "
				+ addRes.get_return().getPwd());
		pass1 = addRes.get_return().getPwd();
		System.out.println();

		System.out.println("Añade a cliente 2, no existe: " + cliente2);
		System.out.println("\t---> Debería devolver: true");

		name.setUsername(cliente2);
		addUser.setArgs0(name);
		addRes = stub.addUser(addUser);
		System.out.println("Resultado de addUser de " + name.getUsername()
				+ ": " + addRes.get_return().getResponse());
		System.out.println("Contraseña devuelta: "
				+ addRes.get_return().getPwd());
		pass2 = addRes.get_return().getPwd();
		System.out.println();

		System.out.println("Añade a cliente 3, no existe: " + cliente3);
		System.out.println("\t---> Debería devolver: true");

		name.setUsername(cliente3);
		addUser.setArgs0(name);
		addRes = stub.addUser(addUser);
		System.out.println("Resultado de addUser de " + name.getUsername()
				+ ": " + addRes.get_return().getResponse());
		System.out.println("Contraseña devuelta: "
				+ addRes.get_return().getPwd());
		pass3 = addRes.get_return().getPwd();
		System.out.println();

		System.out
				.println("Añade a cliente que ya existe: " + clienteExistente);
		System.out.println("\t---> Debería devolver: false");

		name.setUsername(clienteExistente);
		addUser.setArgs0(name);
		addRes = stub.addUser(addUser);
		System.out.println("Resultado de addUser de " + name.getUsername()
				+ ": " + addRes.get_return().getResponse());
		System.out.println();
		System.out.println("Fin de la prueba\n\n");

		// Admin cambia su contraseña
		System.out.println("#Prueba 3 - Admin cambia su contraseña a admin2.");
		System.out.println("\t---> Debería devolver: true");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		chps = new ChangePassword();
		chpRes = new ChangePasswordResponse();
		pair = new PasswordPair();

		pair.setNewpwd("admin");  //OJO?¿?¿?¿?¿¿¿???????!?!?!?!¿!¿?!¿!!!!!?!¿?!¿?!!¿
		pair.setOldpwd(pAdmin);
		chps.setArgs0(pair);
		chpRes = stub.changePassword(chps);

		System.out.println("Resultado change password: "
				+ chpRes.get_return().getResponse());
		pAdmin = pair.getNewpwd();
		System.out.println("Fin de la prueba\n\n");

		// Se logea un admin
		System.out.println("#Prueba 4 - Login con admin otra vez");
		System.out.println("\t---> Debería devolver: true");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		l = new Login();
		logRes = new LoginResponse();
		user = new User();

		user.setName(admin);
		user.setPwd(pAdmin);
		l.setArgs0(user);
		logRes = stub.login(l);

		System.out.println("Resultado de prueba: "
				+ logRes.get_return().getResponse());
		System.out.println("Sesión iniciada como: " + user.getName());
		System.out.println("Fin de la prueba\n\n");

		// Se hace un logout de un admin
		System.out.println("#Prueba 5 - Logout de una sesión del admin");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		lo = new Logout();
		stub.logout(lo);
		System.out.println("Fin de la prueba\n\n");

		// Se intenta login de cliente1
		System.out.println("#Prueba 6 - Login de cliente1");
		System.out
				.println("Cliente1 intenta hacer login pero no puede porque hay una sesión\nde admin abierta.");
		System.out.println("\t---> Debería devolver: false");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		l = new Login();
		logRes = new LoginResponse();
		user = new User();

		user.setName(cliente1);
		user.setPwd(pass1);
		l.setArgs0(user);
		logRes = stub.login(l);

		System.out.println("Resultado de prueba: "
				+ logRes.get_return().getResponse());
		System.out.println("Fin de la prueba\n\n");

		// Se hace un logout de un admin
		System.out.println("#Prueba 7 - Logout de una sesión del admin");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		lo = new Logout();
		stub.logout(lo);
		System.out.println("Fin de la prueba\n\n");

		// Se intenta login de cliente1
		System.out.println("#Prueba 8 - Login de cliente1");
		System.out.println("Esta vez sí puede hacer login.");
		System.out.println("\t---> Debería devolver: true");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		l = new Login();
		logRes = new LoginResponse();
		user = new User();

		user.setName(cliente1);
		user.setPwd(pass1);
		l.setArgs0(user);
		logRes = stub.login(l);

		System.out.println("Resultado de prueba: "
				+ logRes.get_return().getResponse());
		System.out.println("Fin de la prueba\n\n");

		// Admin cambia su contraseña
		System.out.println("#Prueba 9 - Cliente1 cambia su contraseña a 1234.");
		System.out.println("\t---> Debería devolver: true");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		chps = new ChangePassword();
		chpRes = new ChangePasswordResponse();
		pair = new PasswordPair();

		pair.setNewpwd("1234");
		pair.setOldpwd(pass1);
		chps.setArgs0(pair);
		chpRes = stub.changePassword(chps);

		System.out.println("Resultado change password: "
				+ chpRes.get_return().getResponse());
		pass1 = pair.getNewpwd();
		System.out.println("Fin de la prueba\n\n");

		// Se intenta login de cliente1
		System.out.println("#Prueba 10 - Login de cliente1");
		System.out.println("Usa la nueva contraseña.");
		System.out.println("\t---> Debería devolver: true");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		l = new Login();
		logRes = new LoginResponse();
		user = new User();

		user.setName(cliente1);
		user.setPwd(pass1);
		l.setArgs0(user);
		logRes = stub.login(l);

		System.out.println("Resultado de prueba: "
				+ logRes.get_return().getResponse());
		System.out.println("Fin de la prueba\n\n");

		// Cliente 1 añade como amigo a cliente2
		System.out
				.println("#Prueba 11 - Cliente1 añade como amigo a Cliente2 y Cliente3");
		System.out.println("\t---> Debería devolver: true");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		name = new Username();
		addFriend = new AddFriend();
		addFRes = new AddFriendResponse();

		name.setUsername(cliente2);
		addFriend.setArgs0(name);
		addFRes = stub.addFriend(addFriend);
		System.out.println("Resultado de prueba: "
				+ addFRes.get_return().getResponse());

		name.setUsername(cliente3);
		addFriend.setArgs0(name);
		addFRes = stub.addFriend(addFriend);
		System.out.println("Resultado de prueba: "
				+ addFRes.get_return().getResponse());
		System.out.println("Fin de la prueba\n\n");

		// Cliente1 obtiene lista de amigos
		System.out.println("#Prueba 12 - Cliente1 obtiene su lista de amigos.");
		System.out
				.println("\t---> Debería devolver: FriendList(no vacía) y true");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		getList = new GetMyFriendList();
		getLRes = new GetMyFriendListResponse();

		getLRes = stub.getMyFriendList(getList);
		fList = getLRes.get_return();

		System.out.println("Lista de amigos -> " + fList.getFriends()[0] + ", "
				+ fList.getFriends()[1]);

		System.out.println("Resultado de prueba: "
				+ getLRes.get_return().getResult());
		System.out.println("Fin de la prueba\n\n");

		// Cliente1 quita a Cliente3 como amigo
		System.out
				.println("#Prueba 13 - Cliente1 elimina a Cliente3 de sus amigos.");
		System.out.println("\t---> Debería devolver: true");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		rFriend = new RemoveFriend();
		rFRes = new RemoveFriendResponse();
		name = new Username();

		name.setUsername(cliente3);
		rFriend.setArgs0(name);
		rFRes = stub.removeFriend(rFriend);

		System.out.println("Resultado de prueba: "
				+ rFRes.get_return().getResponse());
		System.out.println("Fin de la prueba\n\n");

		// Cliente1 obtiene lista de amigos
		System.out.println("#Prueba 14 - Cliente1 obtiene su lista de amigos.");
		System.out
				.println("\t---> Debería devolver: FriendList(no vacía) y true");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		getList = new GetMyFriendList();
		getLRes = new GetMyFriendListResponse();

		getLRes = stub.getMyFriendList(getList);
		fList = getLRes.get_return();

		System.out.println("Lista de amigos -> " + fList.getFriends()[0]);

		System.out.println("Resultado de prueba: "
				+ getLRes.get_return().getResult());
		System.out.println("Fin de la prueba\n\n");

		// Cliente1 lectura de libros
		System.out.println("#Prueba 15 - Cliente1 añade tres lecturas.");
		System.out.println("\t---> Debería devolver: true");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		addReading = new AddReading();
		addRRes = new AddReadingResponse();

		System.out.println("Se añade primer Libro.");
		addReading.setArgs0(l1);
		addRRes = stub.addReading(addReading);
		System.out.println("Resultado de prueba: "
				+ addRRes.get_return().getResponse());
		System.out.println("Se añade segundo Libro.");
		addReading.setArgs0(l2);
		addRRes = stub.addReading(addReading);
		System.out.println("Resultado de prueba: "
				+ addRRes.get_return().getResponse());
		System.out.println("Se añade tercer Libro.");
		addReading.setArgs0(l3);
		addRRes = stub.addReading(addReading);
		System.out.println("Resultado de prueba: "
				+ addRRes.get_return().getResponse());

		System.out.println("Fin de la prueba\n\n");

		// Cliente1 obtiene sus lecturas
		System.out.println("#Prueba 16 - Cliente1 obtiene sus lecturas.");
		System.out
				.println("\t---> Debería devolver: TitleList(no vacía) y true");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		getReadings = new GetMyReadings();
		getRRes = new GetMyReadingsResponse();

		getRRes = stub.getMyReadings(getReadings);
		tList = getRRes.get_return();

		System.out.println("Lista de libros: ");
		System.out.println(" - " + tList.getTitles()[0]);
		System.out.println(" - " + tList.getTitles()[1]);
		System.out.println(" - " + tList.getTitles()[2]);
		System.out.println("Resultado de prueba: "
				+ getRRes.get_return().getResult());
		System.out.println("Fin de la prueba\n\n");

		// Cliente1 hace logout
		System.out.println("#Prueba 17 - Logout de una sesión del cliente1");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		lo = new Logout();
		stub.logout(lo);
		System.out.println("Fin de la prueba\n\n");

		// Se intenta login de cliente2
		System.out.println("#Prueba 18 - Login de cliente2");
		System.out
				.println("Cliente2 intenta hacer login pero no puede porque hay una sesión\nde cliente1 abierta.");
		System.out.println("\t---> Debería devolver: false");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		l = new Login();
		logRes = new LoginResponse();
		user = new User();

		user.setName(cliente2);
		user.setPwd(pass2);
		l.setArgs0(user);
		logRes = stub.login(l);

		System.out.println("Resultado de prueba: "
				+ logRes.get_return().getResponse());
		System.out.println("Fin de la prueba\n\n");

		// Se hace un logout de un cliente1
		System.out.println("#Prueba 19 - Logout de una sesión del cliente1");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		lo = new Logout();
		stub.logout(lo);
		System.out.println("Fin de la prueba\n\n");

		// Se intenta login de cliente2
		System.out.println("#Prueba 20 - Login de cliente2");
		System.out.println("Esta vez sí puede hacer login.");
		System.out.println("\t---> Debería devolver: true");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		l = new Login();
		logRes = new LoginResponse();
		user = new User();

		user.setName(cliente2);
		user.setPwd(pass2);
		l.setArgs0(user);
		logRes = stub.login(l);

		System.out.println("Resultado de prueba: "
				+ logRes.get_return().getResponse());
		System.out.println("Fin de la prueba\n\n");

		// Cliente2 añade a cliente 1 como amigo
		System.out
				.println("#Prueba 21 - Cliente2 añade como amigo a Cliente1.");
		System.out.println("\t---> Debería devolver: true");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		name = new Username();
		addFriend = new AddFriend();
		addFRes = new AddFriendResponse();

		name.setUsername(cliente1);
		addFriend.setArgs0(name);
		addFRes = stub.addFriend(addFriend);
		System.out.println("Resultado de prueba: "
				+ addFRes.get_return().getResponse());

		System.out.println("Fin de la prueba\n\n");

		// Cliente2 obtiene lecturas de amigos
		System.out.println("#Prueba 22 - Cliente2 obtiene lecturas de amigos.");
		System.out
				.println("\t---> Debería devolver: TitleList(no vacía) y true");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		name = new Username();
		getFriendReadings = new GetMyFriendReadings();
		getFRRes = new GetMyFriendReadingsResponse();

		name.setUsername(cliente1);
		getFriendReadings.setArgs0(name);
		getFRRes = stub.getMyFriendReadings(getFriendReadings);

		tList = getFRRes.get_return();
		System.out.println("Lista de libros: ");
		System.out.println(" - " + tList.getTitles()[0]);
		System.out.println(" - " + tList.getTitles()[1]);
		System.out.println(" - " + tList.getTitles()[2]);
		System.out.println("Resultado de prueba: "
				+ getFRRes.get_return().getResult());
		System.out.println("Fin de la prueba\n\n");

		// Cliente2 hace logout
		System.out.println("#Prueba 23 - Logout de una sesión del cliente2");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		lo = new Logout();
		stub.logout(lo);
		System.out.println("Fin de la prueba\n\n");

		// Se logea un admin
		System.out.println("#Prueba 24 - Login con admin");
		System.out.println("\t---> Debería devolver: true");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		l = new Login();
		logRes = new LoginResponse();
		user = new User();

		user.setName(admin);
		user.setPwd(pAdmin);
		l.setArgs0(user);
		logRes = stub.login(l);

		System.out.println("Resultado de prueba: "
				+ logRes.get_return().getResponse());
		System.out.println("Sesión iniciada como: " + user.getName());
		System.out.println("Fin de la prueba\n\n");

		// restablecemos contraseña original
		chps = new ChangePassword();
		chpRes = new ChangePasswordResponse();
		pair = new PasswordPair();
		pair.setNewpwd("admin");
		pair.setOldpwd(pAdmin);
		chps.setArgs0(pair);
		chpRes = stub.changePassword(chps);
		pAdmin = pair.getNewpwd();

		// Admin elimina cliente3
		System.out.println("#Prueba 25 - Admin elimina al cliente3");
		System.out.println("\t---> Debería devolver: true");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		name = new Username();
		remUser = new RemoveUser();
		remRes = new RemoveUserResponse();

		name.setUsername(cliente3);
		remUser.setArgs0(name);
		remRes = stub.removeUser(remUser);
		System.out.println("Resultado de prueba: "
				+ logRes.get_return().getResponse());
		System.out.println("Fin de la prueba\n\n");

		// Admin hace logout
		System.out.println("#Prueba 26 - Logout de una sesión del admin");
		System.out.println("");
		System.out.println("Ejecutando prueba...");
		lo = new Logout();
		stub.logout(lo);
		System.out.println("Fin de la prueba\n\n");

		System.out.println("Pruebas terminadas, pulse enter para finalizar.");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		scan.close();
		
		//eliminamos clientes creados en la ejecucion
		l = new Login();
		logRes = new LoginResponse();
		user = new User();

		user.setName(admin);
		user.setPwd(pAdmin);
		l.setArgs0(user);
		logRes = stub.login(l);
		
		name = new Username();
		remUser = new RemoveUser();
		remRes = new RemoveUserResponse();

		name.setUsername(cliente1);
		remUser.setArgs0(name);
		remRes = stub.removeUser(remUser);
		
		name.setUsername(cliente2);
		remUser.setArgs0(name);
		remRes = stub.removeUser(remUser);

	}

}
