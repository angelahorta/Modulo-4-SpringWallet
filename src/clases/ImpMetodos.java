package clases;

import java.util.Scanner;

public class ImpMetodos implements MetodoInterface {

	@Override
	public void menu(Scanner sc, Usuario usuario) {
		
        // Inicialización de la clase Moneda clp
        Moneda clp = new Moneda();
        clp.setCurrency_name("Pesos Chilenos");
        clp.setCurrency_symbol("$");
        clp.setCurrency_value(1);
        
        // Inicialización de la clase Moneda usd
        Moneda usd = new Moneda();
        usd.setCurrency_name("Dolar");
        usd.setCurrency_symbol("$");
        usd.setCurrency_value(954);
		
		int opcion;
        do {
        	System.out.println("******************************************");
        	System.out.println("1.- Administración de fondos");
            System.out.println("2.- Conversión de moneda");
            System.out.println("3.- Salir del programa");
            System.out.println("Ingrese su opción: ");

            while (!sc.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                sc.next(); // Limpiar el buffer del scanner
            }
            
            opcion = sc.nextInt();
            
            switch (opcion) {
                // Opción 1 "Administración de fondos"
                case 1:
                	sc.nextLine(); // Limpiar el buffer del scanner
                    System.out.println("******************************************");
                    System.out.println("### Administración de fondos ###");
                    System.out.println("Seleccione una de las siguientes opciones: ");
                    System.out.println("1.- Ver su saldo disponible");
                    System.out.println("2.- Realizar depósitos");
                    System.out.println("3.- Retiros de fondos");
                    System.out.println("4.- Volver al menú principal");
                    System.out.println("Ingrese su opción: ");
                    
                    // Se valida que solo pueda ingressar valores numericos
                    while (!sc.hasNextInt()) {
                        System.out.println("Por favor, ingrese un número válido.");
                        sc.next(); // Limpiar el buffer del scanner
                    }
                    int menuAdmFondos = sc.nextInt();
                    
                    switch (menuAdmFondos) {
                    case 1:
                      System.out.println("Su saldo disponible es: "+usuario.getSaldo());
                      break;
                    case 2:
                      System.out.println("Ingrese el monto que quiere depositar: ");
                      
                      // Se valida que solo se pueda ingresar valores numericos
                      while (!sc.hasNextInt()) {
                          System.out.println("Por favor, ingrese un número válido.");
                          sc.next(); // Limpiar el buffer del scanner
                      }
                      // Se obtiene valor a depositar del usuario
                      int montoDepositar = sc.nextInt();
                      
                      //Se agrega el deposito al saldo del usuario
                      usuario.setSaldo(usuario.deposito(montoDepositar));
                      break;
                    case 3:
                      System.out.println("Ingrese el monto que quiere retirar: ");
                      
                      // Se valida que solo se pueda ingresar valores numericos
                      while (!sc.hasNextInt()) {
                          System.out.println("Por favor, ingrese un número válido.");
                          sc.next(); // Limpiar el buffer del scanner
                      }
                      // Se obtiene valor a retirar del usuario
                      int montoRetiro = sc.nextInt();
                      
                      // Se valida que antes de retirar el saldo del usuario no pueda superar al saldo actual
                      if(usuario.validarRetiro(montoRetiro)) {
                          System.out.println("No puede sobregirar, ya que su saldo es de: "+usuario.getSaldo());
                          break;
                      }
                      
                      // Se realiza retiro del saldo actual del usuario
                      usuario.setSaldo(usuario.retiro(montoRetiro));
                      break;
                    case 4:
                      // Volver al menú principal
                      break;
                    default:
                      System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                      break;
                  }
                    
                    break;
                // Opción 2 "Conversión de moneda"
                case 2:               	
                	sc.nextLine(); // Limpiar el buffer del scanner
                    System.out.println("******************************************");
                    System.out.println("### Conversión de moneda ###");
                    System.out.println("Seleccione una de las siguientes opciones: ");
                    System.out.println("1.- Convertir el saldo a CLP ");
                    System.out.println("2.- Convertir el saldo a USD ");
                    System.out.println("3.- Volver al menú principal");
                    System.out.println("Ingrese su opción: ");
                    
                    // Se valida que solo pueda ingressar valores numericos
                    while (!sc.hasNextInt()) {
                        System.out.println("Por favor, ingrese un número válido.");
                        sc.next(); // Limpiar el buffer del scanner
                    }
                    int menuConverMoneda = sc.nextInt();
                    
                    switch (menuConverMoneda) {
                    case 1:
                 	   System.out.println("Su saldo en "+ clp.getCurrency_name() +" es : "+clp.getCurrency_symbol()+(usuario.getSaldo()/clp.getCurrency_value()));
                        break;
                    case 2:
                 	   System.out.println("Su saldo en "+ usd.getCurrency_name() +" es : "+usd.getCurrency_symbol()+(usuario.getSaldo()/usd.getCurrency_value()));
                        break;
                    case 3:
                    // Volver al menú principal
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                        break;
                    }
                    
                    break;
                case 3:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número del 1 al 3.");
            }
        } while (opcion != 3);
	}

	@Override
	public Boolean validateUser(String user, String password) {
		return user.equals("sofia") && password.equals("123");
	}


}
