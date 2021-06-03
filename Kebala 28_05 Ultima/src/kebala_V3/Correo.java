package kebala_V3;
/**
 * @author YK, RM, SM
 * @version 3.0 27/05/2021
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Correo extends Menu {
	
	public static String correoAplicativo = "KebalaApp2021@gmail.com";
	public static String contraseñaCorreoAplicativo = "KebabApp1234";
	
/**
 * Selección realizada por el usuario de enviar el correo electrónico o no.
 * @throws Exception a causa de que se realiza la llamada de ingresarCorreo() en el interior.
 */
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
					Menu.errorNumerico();
					preguntaEnviarFacturaMail();
				}
			} catch (NumberFormatException n) {
				Menu.errorCaracter();
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

/**
 * Introducción del correo electrónico del usuario por consola.
 * @throws Exception a causa de que se realiza la llamada de validarEmail() en el interior.
 */
	public static void ingresarCorreo() throws Exception {
		System.out.print(green + "Introduzca su correo electrónico: " + reset);
		correoCliente = sc.nextLine();
		validarEmail();
	}

/**
 * Validacion del correo introducido, comparandolo con un patron estandar y repeticion en caso de fallo.
 * @throws Exception a causa de que se llaman varios métodos en el interior.
 */
	public static void validarEmail() throws Exception {
		//Conjunto de caracteres unidos para comprar los datos entrantes.
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

/**
 * Convierte los datos recogidos en el ArrayDinamico 'precio' y los junta en un Objeto String para poder realizar el envio de datos por correo.
 * @throws Exception a causa de que se realiza la llamada de EnviarFacturaMail() en el interior.
 */
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

/**
 * Realiza el envio de datos procesados a traves del protocolo smtp al correo estipulado junto con un correo host y su respectiva autentificación.
 * @throws Exception a causa de que se realiza la llamada de metodos de la api de java.mail en el interior.
 */
	public static void EnviarFacturaMail() throws Exception {
		//CorreoCliente es el destino.
		//CorreoAplicativo el origen.
		String to = correoCliente;
		String from = correoAplicativo;
		int contadorFacturas = (int) (Math.random() * (101));
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		//Autentificacion.
		//CorreoAplicativo es el correo desde donde se envia, contraseñaCorreoAplicativo es la contraseña de acceso a la cuenta.
		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(correoAplicativo, contraseñaCorreoAplicativo);
			}
		});
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		//Sujeto del correo.
		message.setSubject("Factura Numero: " + contadorFacturas + " de Kebala");
		//Contenido del correo.
		message.setText("Resumen de la factura electronica:\n" + DatosParaEnvio + "€" + "\n\nGracias, hasta pronto.");
		Transport.send(message);
		System.out.println("\nEnviado correctamente !");
	}
}
