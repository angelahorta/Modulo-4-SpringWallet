package ejercicios;

import java.util.Scanner;

import clases.ImpMetodos;
import clases.Usuario;

public class Main {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ImpMetodos metodos = new ImpMetodos();
        // Inicialización de la clase Usuario
        Usuario usuario = new Usuario();
        usuario.setNombre("sofia");
        usuario.setSaldo(50000);
                
        boolean salir = false; // Variable para determinar el fin del bucle
        
        System.out.println("### Bienvenido a Alka Wallet ###");
        
        while (!salir) {
            System.out.println("Ingrese su usuario:");
            String user = sc.nextLine();

            System.out.println("Ingrese su contraseña:");
            String pass = sc.nextLine();

            // Verificar si los datos ingresados son correctos
            if (metodos.validateUser(user, pass)) {
                salir = true;

                // Mostrar el menú
                metodos.menu(sc, usuario);
            } else {
                System.out.println("Usuario y/o contraseña incorrectos");
            }
        }
        
    }
}
