package kebala_V2;

import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operacion {
	
	public static int n = 0;
	public static byte o1, o2, o3, o4;
	public static double precio = 0;
	public static String correoCliente, DatosParaEnvio = "";
	public static String correoAplicativo = "KebalaApp2021@gmail.com";
	public static String contraseñaCorreoAplicativo = "KebabApp1234";
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<String> Pedido = new ArrayList<String>();

	public static void constructo() throws Exception {
		seleccionComida();
		seleccionTipoCarne();
		seleccionRelleno();
		seleccionBebida();
		resumen();
		finalizarOrden();
	}

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

	public static void seleccionComida() {
		do {
			System.out.println("¿Que desea como entrante principal?");
			System.out.println("1.Durum (4€) \t" + "2.Kebab(5€)\t" + "3.Plato(6,50€)");
			byte o1 = Byte.valueOf(sc.nextLine());
			switch (o1) {
			case 1:
				Pedido.add("Durum");
				precio = (precio + 4);
				break;
			case 2:
				Pedido.add("Kebab");
				precio = (precio + 5);
				break;
			case 3:
				Pedido.add("Plato");
				precio = (precio + 6.5);
				break;
			default:
				System.out.println("\nEntrada incorrecta, repetir seleccion de tipo de entrante!\n");
				seleccionComida();
			}
		} while (o1 > 0 && o1 < 4);
	}

	public static void seleccionTipoCarne() {
		do {
			System.out.println("\n¿Con que tipo de carne lo prefiere?");
			System.out.println("1.Pollo \t" + "2.Ternera(+ 0.50€) \t" + "3.Mixto(+ 0.25€)");
			byte o2 = Byte.valueOf(sc.nextLine());
			switch (o2) {
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
				break;
			default:
				System.out.println("\nEntrada incorrecta, repetir seleccion variedad carne!\n");
				seleccionTipoCarne();
			}
		} while (o2 > 0 && o2 < 4);
	}

	public static void seleccionRelleno() {
		do {
			System.out.println("\n¿Relleno de solo carne o carne con ensalada?");
			System.out.println("1.Carne \t" + "2.Ensalada");
			byte o3 = Byte.valueOf(sc.nextLine());
			switch (o3) {
			case 1:
				Pedido.add("Carne");
				precio = (precio + 4);
				break;
			case 2:
				Pedido.add("Ensalada");
				break;
			default:
				System.out.println("\nEntrada incorrecta, repetir seleccion relleno!\n");
				seleccionRelleno();
			}
		} while (o3 > 0 && o3 < 3);
	}

	public static void seleccionBebida() {
		do {
			System.out.println("\n¿Que desea para beber?");
			System.out.println("1.Coca-Cola (0,75€) \t" + "2.Fanta(0,70€) \t" + "3.Cerveza(1€)\t" + "4.Agua(0.40€)");
			byte o4 = Byte.valueOf(sc.nextLine());
			switch (o4) {
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
			default:
				System.out.println("\nEntrada incorrecta, repetir seleccion bebida!\n");
				seleccionBebida();
			}
		} while (o4 > 0 && o4 < 5);
	}
	
	public static void cargaFict() throws Exception {
		System.out.println();
		for (byte v = 0; v < 30; v++) {
			TimeUnit.MILLISECONDS.sleep(80);
			System.out.print("*" + " ");
		}
		System.out.println();
	}

	public static void resumen() throws Exception {
		cargaFict();
		System.out.print("\nResumen del pedido: " + Pedido + " \n");
		System.out.println("Total: " + "\t" + precio + "€\n");
	}

	public static void finalizarOrden() throws Exception {
		System.out.println("¿Como desea proceder?");
		System.out.println("Seleccione: 1 para Finalizar --- 2 para Realizar otro pedido.");
		int aux2 = Byte.valueOf(sc.nextLine());
		System.out.println();
		if (aux2 == 1) {
			selectorPago();
		} else if (aux2 == 2) {
			Pedido.add(" |*| ");
			constructo();
		} else {
			System.out.println("Entrada incorrecta, repetir seleccion!\n");
			finalizarOrden();
		}
	}

	public static void selectorPago() throws Exception {
		System.out.println("Seleccione: 1 para pago con Efectivo --- 2 para pago con Tarjeta");
		byte x = Byte.valueOf(sc.nextLine());
		if (x == 1) {
			pagoEfectivo();
		} else if (x == 2) {
			pagoTarjeta();
		} else {
			System.out.println("\nEntrada incorrecta, repetir seleccion de tipo de pago!\n");
			selectorPago();
		}
	}

	public static void pagoEfectivo() throws Exception {
		System.out.println("\nIntroduzca el efectivo aqui: ");
		double cantiIntro = Double.valueOf(sc.nextLine());
		double aux4 = cantiIntro - precio;
		double cambio = (double)(Math.round(aux4  * 100D) / 100D);
		System.out.println("\nRecoja su cambio de: " + cambio + "€");
		preguntaEnviarFacturaMail();
		System.exit(0);
	}

	public static void pagoTarjeta() throws Exception {
		boolean tru;
		System.out.println("\nPor favor, siga las instrucciones del terminal de pago.");
		tru = Math.random() < 0.95;
		cargaFict();
		System.out.println("\nAcerce la tarjeta al lector.");
		TimeUnit.SECONDS.sleep(2);
		if (tru == true) {
			System.out.println("\nPago realizado con exito.");
			preguntaEnviarFacturaMail();
		} else if (tru == false) {
			System.out.println("\nPago fallido, vuelva a relizar la operacion.");
			pagoTarjeta();
			System.exit(0);
		}
	}

	public static void preguntaEnviarFacturaMail() throws Exception {
		System.out.println("\n¿Deseas recibir la factura en tu correo electronico?");
		System.out.println("Seleccione: 1 para no enviar --- 2 para enviar");
		byte aux1 = Byte.valueOf(sc.nextLine());
		System.out.println();
		if (aux1 == 1) {
			System.out.println("Gracias por su visita y vuelva pronto!");
		} else if (aux1 == 2) {
			ingresarCorreo();
		} else {
			System.out.println("Entrada incorrecta, repetir respuesta al envio de correo!");
			preguntaEnviarFacturaMail();
		}
	}

	public static void ingresarCorreo() throws Exception {
		System.out.print("Introduzca su correo electrónico: ");
		correoCliente = sc.nextLine();
		validarEmail();
	}

	public static void validarEmail() throws Exception {
		Pattern patron = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		String mail = correoCliente;
		Matcher mather = patron.matcher(mail);
		if (mather.find() == true) {
			System.out.println("\nEl email ingresado es válido, lo recibira en " + mail + " dentro de unos instantes.");
			System.out.println("\nGracias por su visita y vuelva pronto!");
			conversionDatos();
		} else {
			System.out.println("\nEl email ingresado es invalido, repita el ingreso.\n");
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
	}

	public static void EnviarFacturaMail() throws Exception {
		String to = correoCliente;
		String from = correoAplicativo;
		int contadorFacturas = (int)(Math.random() * (101));
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
		message.setText("Resumen de la factura electronica:\n\n" + DatosParaEnvio + "€" + "\n\nGracias, hasta pronto.");
		Transport.send(message);
		System.out.println("Enviado correctamente!");
	}
}
