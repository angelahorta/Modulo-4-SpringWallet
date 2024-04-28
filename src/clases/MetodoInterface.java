package clases;

import java.util.Scanner;

public interface MetodoInterface {

	void menu(Scanner sc, Usuario usuario);
	Boolean validateUser( String user, String password);

}
