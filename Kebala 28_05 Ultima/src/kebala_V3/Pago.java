package kebala_V3;
/**
 * @author YK, RM, SM
 * @version 3.0 27/05/2021
 */
import java.util.concurrent.TimeUnit;

public class Pago extends Menu{

/**
 * Selección entre los dos posibles tipos de pago.
 * @throws Exception a causa de que se llaman varios métodos en el interior.
 */
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
	
/**
 * Implementa o recrea un pago en efectivo realizado por el usuario.
 * @throws Exception a causa de que se llaman varios métodos en el interior.
 */
	public static void pagoEfectivo() throws Exception {
		double operacion = 0;
		do {
			boolean ok = true;
			do {
				ok = true;
				double precioRedondeado = (double) (Math.round(precio * 100D) / 100D);
				System.out.println(
						green + "\nTotal:\t" + precioRedondeado + "€" + "\nIntroduzca el efectivo aqui: " + reset);
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
		EscribirFichero.conversionDatosTicket();
		Correo.preguntaEnviarFacturaMail();
	}

/**
 * Recrea un pago utilizando el lector de tarjetas realizado por el usuario.
 * @throws Exception a causa de que se llaman varios métodos en el interior junto a, TimeUnit para crear un ligero retardo de ejecución.
 */
	public static void pagoTarjeta() throws Exception {
		boolean tru;
		System.out.println(green + "\nPor favor, siga las instrucciones del terminal de pago." + reset);
		tru = Math.random() < 0.95;
		cargaFictRetardo();
		System.out.println(green + "\nPonga la tarjeta al lector." + reset);
		TimeUnit.SECONDS.sleep(2);
		if (tru == true) {
			System.out.println(green + "\nPago realizado con exito." + reset);
			EscribirFichero.conversionDatosTicket();
			Correo.preguntaEnviarFacturaMail();
		} else if (tru == false) {
			System.out.println(green + "\nPago fallido, vuelva a relizar la operacion." + reset);
			pagoTarjeta();
		}
	}
}
