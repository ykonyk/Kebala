package kabala_V2_4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operaciones {

	private static String red = "\033[31m";
	private static String green = "\033[32m";
	private static String reset = "\u001B[0m";
	public static double precio = 0;
	public static String correoCliente, DatosParaEnvio = "";
	public static String correoAplicativo = "KebalaApp2021@gmail.com";
	public static String contraseñaCorreoAplicativo = "KebabApp1234";
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<String> Pedido = new ArrayList<String>();

	public static Calendar calendario = Calendar.getInstance();
	public static Date dia = calendario.getTime();
	public static String diaS = dia.toString();

	public static void banner() {
		System.out.println(
				"**************************************************************************************************");
		System.out.println(
				"**************************************************************************************************");
		System.out.println(
				"                                         bbbbbbbb                             bbbbbbbb            \r\n"
						+ "  KKKKKKKKK    KKKKKKK                   b::::::b                             b::::::b            \r\n"
						+ "  K:::::::K    K:::::K                   b::::::b                             b::::::b            \r\n"
						+ "  K:::::::K    K:::::K                   b::::::b                             b::::::b            \r\n"
						+ "  K:::::::K   K::::::K                    b:::::b                              b:::::b            \r\n"
						+ "  KK::::::K  K:::::KKK    eeeeeeeeeeee    b:::::bbbbbbbbb      aaaaaaaaaaaaa   b:::::bbbbbbbbb    \r\n"
						+ "    K:::::K K:::::K     ee::::::::::::ee  b::::::::::::::bb    a::::::::::::a  b::::::::::::::bb  \r\n"
						+ "    K::::::K:::::K     e::::::eeeee:::::eeb::::::::::::::::b   aaaaaaaaa:::::a b::::::::::::::::b \r\n"
						+ "    K:::::::::::K     e::::::e     e:::::eb:::::bbbbb:::::::b           a::::a b:::::bbbbb:::::::b\r\n"
						+ "    K:::::::::::K     e:::::::eeeee::::::eb:::::b    b::::::b    aaaaaaa:::::a b:::::b    b::::::b\r\n"
						+ "    K::::::K:::::K    e:::::::::::::::::e b:::::b     b:::::b  aa::::::::::::a b:::::b     b:::::b\r\n"
						+ "    K:::::K K:::::K   e::::::eeeeeeeeeee  b:::::b     b:::::b a::::aaaa::::::a b:::::b     b:::::b\r\n"
						+ "  KK::::::K  K:::::KKKe:::::::e           b:::::b     b:::::ba::::a    a:::::a b:::::b     b:::::b\r\n"
						+ "  K:::::::K   K::::::Ke::::::::e          b:::::bbbbbb::::::ba::::a    a:::::a b:::::bbbbbb::::::b\r\n"
						+ "  K:::::::K    K:::::K e::::::::eeeeeeee  b::::::::::::::::b a:::::aaaa::::::a b::::::::::::::::b \r\n"
						+ "  K:::::::K    K:::::K  ee:::::::::::::e  b:::::::::::::::b   a::::::::::aa:::ab:::::::::::::::b  \r\n"
						+ "  KKKKKKKKK    KKKKKKK    eeeeeeeeeeeeee  bbbbbbbbbbbbbbbb     aaaaaaaaaa  aaaabbbbbbbbbbbbbbbb   ");
		System.out.println(
				"**************************************************************************************************");
		System.out.println(
				"**************************************************************************************************");
		System.out.println();
	}

	public static void errorNumerico() {
		System.out.println(red + "\nEntrada numerica incorrecta," + reset + green + " repetir seleccion!\n" + reset);
	}

	public static void errorCaracter() {
		System.out
				.println(red + "\nEntrada de caracteres prohibidos," + reset + green + " repetir seleccion!\n" + reset);
	}

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

	public static void cargaFict() {
		System.out.println();
		for (byte v = 0; v < 45; v++) {
			System.out.print("* ");
		}
		System.out.println();
	}

	public static void cargaFictRetardo() throws Exception {
		System.out.println();
		for (byte v = 0; v < 45; v++) {
			TimeUnit.MILLISECONDS.sleep(30);
			System.out.print("* ");
		}
		System.out.println();
	}

	public static void resumen() throws Exception {
		cargaFict();
		System.out.print(green + "\nResumen del pedido: " + Pedido + " \n");
		System.out.println("Total: " + "\t" + precio + "€.\n" + reset);
		cargaFict();
		finalizarOrden();
		System.out.println();
	}

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
			selectorPago();
			break;
		case 2:
			Pedido.add("|*|");
			seleccionComida();
			break;
		case 3:
			Pedido.add("|*|");
			seleccionExtras();
		case 4:
			cancelarPedido();
		}
	}

	public static void cancelarPedido() {
		System.out.println(green + "Muchas gracias." + red
				+ "\nSi quiere hacer otro pedido, por favor vuelva a ejutarme." + reset);
		System.exit(0);
	}

	public static void selectorPago() throws Exception {
		short operacion = 0;
		boolean ok = true;
		do {
			ok = true;
			System.out.println(green + "Seleccione: 1 para pago con Efectivo --- 2 para pago con Tarjeta" + reset);
			try {
				String s = sc.nextLine();
				operacion = Short.parseShort(s);
			} catch (NumberFormatException n) {
				errorCaracter();
				ok = false;
			}
		} while (ok == false);
		if (operacion == 1) {
			pagoEfectivo();
		} else if (operacion == 2) {
			pagoTarjeta();
		} else {
			errorNumerico();
			selectorPago();
		}
	}

	public static void pagoEfectivo() throws Exception {
		double operacion = 0;
		do {
			boolean ok = true;
			do {
				ok = true;
				double precioRedondeado = (double) (Math.round(precio * 100D) / 100D);
				System.out.println(green + "\nTotal:\t" + precioRedondeado + "€" + "\nIntroduzca el efectivo aqui: " + reset);
				try {
					String s = sc.nextLine();
					operacion = Double.parseDouble(s);
				} catch (NumberFormatException n) {
					errorCaracter();
					ok = false;
				}
			} while (ok == false);
		} while (operacion <= precio);
		
		
		double cambio = operacion - precio;
		double cambioRedondeado = (double) (Math.round(cambio * 100D) / 100D);
		System.out.println(green + "\nRecoja su cambio de: " + reset + cambioRedondeado + green + " €." + reset);
		conversionDatosTicket();
		preguntaEnviarFacturaMail();
	}

	public static void pagoTarjeta() throws Exception {
		boolean tru;
		System.out.println(green + "\nPor favor, siga las instrucciones del terminal de pago." + reset);
		tru = Math.random() < 0.95;
		cargaFictRetardo();
		System.out.println(green + "\nPonga la tarjeta al lector." + reset);
		TimeUnit.SECONDS.sleep(2);
		if (tru == true) {
			System.out.println(green + "\nPago realizado con exito." + reset);
			conversionDatosTicket();
			preguntaEnviarFacturaMail();
		} else if (tru == false) {
			System.out.println(green + "\nPago fallido, vuelva a relizar la operacion." + reset);
			pagoTarjeta();
		}
	}

	public static void preguntaEnviarFacturaMail() throws Exception {
		short operacion = 0;
		System.out.println(green + "\n¿Deseas recibir la factura en tu correo electronico?" + reset);
		boolean ok = true;
		do {
			ok = true;
			System.out.println(green + "Seleccione: 1 para no enviar --- 2 para enviar" + reset);
			try {
				String s = sc.nextLine();
				operacion = Short.parseShort(s);
				if (operacion > 2 || operacion < 0) {
					errorNumerico();
					preguntaEnviarFacturaMail();
				}
			} catch (NumberFormatException n) {
				errorCaracter();
				ok = false;
			}
		} while (ok == false);
		System.out.println();
		if (operacion == 1) {
			System.out.println(green + "Gracias por su visita y vuelva pronto!" + reset);
		} else if (operacion == 2) {
			ingresarCorreo();
		}
	}

	public static void ingresarCorreo() throws Exception {
		System.out.print(green + "Introduzca su correo electrónico: " + reset);
		correoCliente = sc.nextLine();
		validarEmail();
	}

	public static void validarEmail() throws Exception {
		Pattern patron = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		String mail = correoCliente;
		Matcher mather = patron.matcher(mail);
		if (mather.find() == true) {
			System.out.println(
					green + "\nEl email ingresado es válido, lo recibira en " + mail + " dentro de unos instantes.");
			System.out.println(green + "\nGracias por su visita y vuelva pronto!");
			conversionDatos();
		} else {
			System.out.println(green + "\nEl email ingresado es invalido, repita el ingreso.\n" + reset);
			ingresarCorreo();
		}
	}

	public static void conversionDatos() throws Exception {
		String precioStr = String.valueOf(precio);
		for (byte x = 0; x < Pedido.size(); x++) {
			String aux3 = Pedido.get(x);
			aux3 += "  ";
			DatosParaEnvio += aux3;
		}
		DatosParaEnvio += precioStr;
		EnviarFacturaMail();
		EscribirFichero();
	}

	public static void conversionDatosTicket() throws Exception {
		String precioStr = String.valueOf(precio);
		for (byte x = 0; x < Pedido.size(); x++) {
			String aux3 = Pedido.get(x);
			aux3 += "  ";
			DatosParaEnvio += aux3;
		}
		DatosParaEnvio += precioStr + "€";
		EscribirFichero();

	}

	public static void EnviarFacturaMail() throws Exception {
		String to = correoCliente;
		String from = correoAplicativo;
		int contadorFacturas = (int) (Math.random() * (101));
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(correoAplicativo, contraseñaCorreoAplicativo);
			}
		});
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject("Factura Numero: " + contadorFacturas + " de Kebala");
		message.setText("Resumen de la factura electronica:\n" + DatosParaEnvio + "€" + "\n\nGracias, hasta pronto.");
		Transport.send(message);
		System.out.println("Enviado correctamente !");
	}

	@SuppressWarnings("deprecation")
	public static void EscribirFichero() throws Exception {
		Date fecha = new Date();
		int fechayhora = ((int) fecha.getDate() * 1000000) + ((int) fecha.getHours() * 10000)
				+ ((int) fecha.getMinutes() * 100) + ((int) fecha.getSeconds());
		String fechayhoraString = String.valueOf(fechayhora) + ".txt";
		String ruta = "G:/Kebala 25_05/Facturas/" + fechayhoraString;
		File archivo = new File(ruta);
		BufferedWriter bw;
		if (archivo.exists()) {
			bw = new BufferedWriter(new FileWriter(archivo));
			bw.write(DatosParaEnvio);
		} else {
			bw = new BufferedWriter(new FileWriter(archivo));
			bw.write(DatosParaEnvio);
		}
		bw.close();
	}

}
