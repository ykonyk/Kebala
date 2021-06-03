package kebala_V3;
/**
 * @author YK, RM, SM
 * @version 3.0 27/05/2021
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu {
	
	public static double precio = 0;
	public static String red = "\033[31m";
	public static String green = "\033[32m";
	public static String reset = "\u001B[0m";
	public static String correoCliente, DatosParaEnvio = "", DatosParaEnvio2 = "";
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<String> Pedido = new ArrayList<String>();
	
/**
 * Se usa en caso de introduccion valores numéricos fuera de rango.
 */
	public static void errorNumerico() {
		System.out.println(red + "\nEntrada numerica incorrecta," + reset + green + " repetir seleccion!\n" + reset);
	}
	
/**
 * Se usa en caso de introduccion caracteres prohíbidos. 
 */
	public static void errorCaracter() {
		System.out
				.println(red + "\nEntrada de caracteres prohibidos," + reset + green + " repetir seleccion!\n" + reset);
	}
	
/**
 * Selección de valores numéricos por consola asociados al producto deseado.
 * @throws Exception a cuasa de la llamada de otros metodos en el interior.
 */
	public static void seleccionComida() throws Exception {
		short operacion = 0;
		do {
			System.out.println(green + "¿Que desea como entrante principal?");
			boolean ok = true;
			do {
				ok = true;
				System.out.println(green + "1.Durum(4€) \t2.kebab(5€) \t3.plato(6,50€) \t4.Ir a extras" + reset);
				try {
					String s = sc.nextLine();
					operacion = Short.parseShort(s);
					if (operacion > 4 || operacion < 0) {
						errorNumerico();
						seleccionComida();
					}
				} catch (NumberFormatException n) {
					errorCaracter();
					ok = false;
				}
			} while (ok == false);
		} while (operacion < 1 || operacion > 4);
		switch (operacion) {
		case 1:
			Pedido.add("Durum");
			precio = (precio + 4);
			seleccionTipoCarne();
			break;
		case 2:
			Pedido.add("Kebab");
			precio = (precio + 5);
			seleccionTipoCarne();
			break;
		case 3:
			Pedido.add("Plato");
			precio = (precio + 6.5);
			seleccionTipoCarne();
			break;
		case 4:
			seleccionExtras();
		}
	}
	
/**
 * Selección de valores numéricos por consola asociados al producto deseado.
 * @throws Exception a cuasa de la llamada de seleccionRelleno() en el interior.
 */
	public static void seleccionTipoCarne() throws Exception {
		short operacion = 0;
		do {
			System.out.println(green + "\n¿Con que tipo de carne lo prefiere?" + reset);
			boolean ok = true;
			do {
				ok = true;
				System.out.println(green + "1.Pollo \t" + "2.Ternera(+ 0.50€) \t" + "3.Mixto(+ 0.25€)" + reset);
				try {
					String s = sc.nextLine();
					operacion = Short.parseShort(s);
					if (operacion > 3 || operacion < 0) {
						errorNumerico();
						seleccionTipoCarne();
					}
				} catch (NumberFormatException n) {
					errorCaracter();
					ok = false;
				}
			} while (ok == false);
		} while (operacion < 1 || operacion > 3);
		switch (operacion) {
		case 1:
			Pedido.add("Pollo");
			break;
		case 2:
			Pedido.add("Ternera");
			precio = (precio + 0.50);
			break;
		case 3:
			Pedido.add("Mixto");
			precio = (precio + 0.25);
		}
		seleccionRelleno();
	}
	
/**
 * Selección de valores numéricos por consola asociados al producto deseado.
 * @throws Exception a cuasa de la llamada de seleccionBebida() en el interior.
 */
	public static void seleccionRelleno() throws Exception {
		short operacion = 0;
		do {
			System.out.println(green + "\n¿Relleno de solo carne o carne con ensalada?" + reset);
			boolean ok = true;
			do {
				ok = true;
				System.out.println(green + "1.Carne \t" + "2.Ensalada" + reset);
				try {
					String s = sc.nextLine();
					operacion = Short.parseShort(s);
					if (operacion > 2 || operacion < 0) {
						errorNumerico();
						seleccionRelleno();
					}
				} catch (NumberFormatException n) {
					errorCaracter();
					ok = false;
				}
			} while (ok == false);
		} while (operacion < 1 || operacion > 5);
		switch (operacion) {
		case 1:
			break;
		case 2:
			Pedido.add("Ensalada");
		}
		seleccionBebida();
	}

/**
 * Selección de valores numéricos por consola asociados al producto deseado.
 * @throws Exception a cuasa de la llamada de seleccionExtras() en el interior.
 */
	public static void seleccionBebida() throws Exception {
		short operacion = 0;
		do {
			System.out.println(green + "\n¿Que desea para beber?" + reset);
			boolean ok = true;
			do {
				ok = true;
				System.out.println(green + "1.Coca-Cola(0,75€) \t" + "2.Fanta(0,70€) \t" + "3.Cerveza(1€) \t"
						+ "4.Agua(0.40€) \t5.Otro(1.20€)" + reset);
				try {
					String s = sc.nextLine();
					operacion = Short.parseShort(s);
					if (operacion > 5 || operacion < 0) {
						errorNumerico();
						seleccionBebida();
					}
				} catch (NumberFormatException n) {
					errorCaracter();
					ok = false;
				}
			} while (ok == false);
		} while (operacion < 1 || operacion > 5);
		switch (operacion) {
		case 1:
			Pedido.add("Coca-Cola");
			precio = (precio + 0.75);
			break;
		case 2:
			Pedido.add("Fanta");
			precio = (precio + 0.7);
			break;
		case 3:
			Pedido.add("Cerveza");
			precio = (precio + 1);
			break;
		case 4:
			Pedido.add("Agua");
			precio = (precio + 0.4);
			break;
		case 5:
			System.out.println(green + "¿Que desea?" + reset);
			precio = (precio + 1.2);
			Pedido.add(sc.nextLine());
		}
		seleccionExtras();
	}

/**
 * Selección de valores numericos por consola asociados al producto deseado.
 * @throws Exception a cuasa de la llamada de seleccionPostres() en el interior.
 */
	public static void seleccionExtras() throws Exception {
		short operacion = 0;
		do {
			System.out.println(green + "\n¿Desea algun extra?" + reset);
			boolean ok = true;
			do {
				ok = true;
				System.out.println(green + "1.Patatas(0,75€) \t" + "2.Alitas de pollo(2,70€) \t"
						+ "3.Arroz(0.50€) \t 4.Ninguno" + reset);
				try {
					String s = sc.nextLine();
					operacion = Short.parseShort(s);
					if (operacion > 4 || operacion < 0) {
						errorNumerico();
						seleccionExtras();
					}
				} catch (NumberFormatException n) {
					errorCaracter();
					ok = false;
				}
			} while (ok == false);
		} while (operacion < 1 || operacion > 4);
		switch (operacion) {
		case 1:
			Pedido.add("Patatas");
			precio = (precio + 0.75);
			break;
		case 2:
			Pedido.add("Alitas de pollo");
			precio = (precio + 2.7);
			break;
		case 3:
			Pedido.add("Arroz");
			precio = (precio + 0.5);
			break;
		case 4:
			break;
		}
		seleccionPostres();
	}

/**
 * Selección de valores numéricos por consola asociados al producto deseado.
 * @throws Exception a cuasa de la llamada de resumen() en el interior.
 */
	public static void seleccionPostres() throws Exception {
		short operacion = 0;
		do {
			System.out.println(green + "\n¿Desea algun postre?" + reset);
			boolean ok = true;
			do {
				ok = true;
				System.out.println(green + "1.Helado (1,75€) \t" + "2.Pastel(1,70€) \t" + "3.Natillas(1€)\t"
						+ "4.Ninguno" + reset);
				try {
					String s = sc.nextLine();
					operacion = Short.parseShort(s);
					if (operacion > 4 || operacion < 0) {
						errorNumerico();
						seleccionPostres();
					}
				} catch (NumberFormatException n) {
					errorCaracter();
					ok = false;
				}
			} while (ok == false);
		} while (operacion < 1 || operacion > 4);
		switch (operacion) {
		case 1:
			Pedido.add("Helado");
			precio = (precio + 1.75);
			break;
		case 2:
			Pedido.add("Pastel");
			precio = (precio + 1.7);
			break;
		case 3:
			Pedido.add("Natillas");
			precio = (precio + 1);
			break;
		case 4:
			break;
		}
		if (precio < 0.1) {
			System.out.println(green + "Fallo en el pedido:" + red + " **EMPTY SELECTION**" + reset);
			System.exit(0);
		} else {
			resumen();
		}
	}

/**
 * Realiza una función estética a la hora de crear la factura, creando una linea de *.
 */
	public static void cargaFict() {
		System.out.println();
		for (byte v = 0; v < 45; v++) {
			System.out.print("* ");
		}
		System.out.println();
	}

/**
 * Realiza una función estética a la hora de crear la factura, creando una linea de * con retardo, lo que simula una carga.
 * @throws Exception a causa de TimeUnit lo que permite crear el retardo de ejecucion en unidades establecidas.
 */
	public static void cargaFictRetardo() throws Exception {
		System.out.println();
		for (byte v = 0; v < 45; v++) {
			TimeUnit.MILLISECONDS.sleep(30);
			System.out.print("* ");
		}
		System.out.println();
	}

/**
 * Muestra los productos elegidos por el usuario y el precio total del pedido.
 * @throws Exception a causa de realizar la llamada de finalizarOrden() en el interior.
 */
	public static void resumen() throws Exception {
		cargaFict();
		System.out.print(green + "\nResumen del pedido: " + Pedido + " \n");
		System.out.println("Total: " + "\t" + precio + "€.\n" + reset);
		cargaFict();
		finalizarOrden();
		System.out.println();
	}

/**
 * Da a elegir al usuario una serie de acciónes.
 * @throws Exception a cuasa de la llamada de otros metodos en el interior.
 */
	@SuppressWarnings("unused")
	public static void finalizarOrden() throws Exception {
		short operacion = 0;
		System.out.println(green + "¿Como desea proceder?" + reset);
		boolean ok = true;
		do {
			ok = true;
			System.out.println(green
					+ "Seleccione: 1 para Finalizar --- 2 para Realizar otro pedido --- 3 Para añadir algun extra. ---"
					+ red + " 4.Cancelar el pedido" + reset);
			try {
				String s = sc.nextLine();
				operacion = Short.parseShort(s);
				if (operacion > 4 || operacion < 0) {
					errorNumerico();
					finalizarOrden();
				}
			} catch (NumberFormatException n) {
				errorCaracter();
				ok = false;
			}
		} while (operacion < 1 || operacion > 4);
		System.out.println();
		switch (operacion) {
		case 1:
			Pago.selectorPago();
			break;
		case 2:
			Pedido.add("|*|");
			seleccionComida();
			break;
		case 3:
			Pedido.add("|*|");
			seleccionExtras();
			break;
		case 4:
			cancelarPedido();
		}
	}

/**
 * Se implementa en caso de que el ususario cancele el pedido.
 */
	public static void cancelarPedido() {
		System.out.println(green + "Muchas gracias." + red
				+ "\nSi quiere hacer otro pedido, por favor vuelva a ejutar." + reset);
		System.exit(0);
	}
}
