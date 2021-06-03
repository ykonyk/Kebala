package kebala_V3;
/**
 * @author YK, RM, SM
 * @version 3.0 27/05/2021
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Date;

public class EscribirFichero extends Correo {
	
	public static Calendar calendario = Calendar.getInstance();
	public static Date dia = calendario.getTime();
	public static String diaS = dia.toString();

/**
 * Convierte los datos recogidos en el ArrayDinamico 'precio' y los junta en un Objeto String para poder escribir el archivo de texto.
 * @throws Exception a causa de la llamada de escribirFichero() en el interior.
 */
	public static void conversionDatosTicket() throws Exception {
		String precioStr = String.valueOf(precio);
		for (byte x = 0; x < Pedido.size(); x++) {
			String aux3 = Pedido.get(x);
			aux3 += "  ";
			DatosParaEnvio2 += aux3;
		}
		DatosParaEnvio2 += precioStr + "€";
		escribirFichero();
	}

/**
 * Realiza la escritura del archivo, utilizando la fecha y hora a nivel de segundos para el nombre del mismo.
 * @throws Exception a causa del BufferedWriter.
 */
	@SuppressWarnings("deprecation")
	public static void escribirFichero() throws Exception {
		Date fecha = new Date();
		int fechayhora = ((int) fecha.getDate() * 1000000) + ((int) fecha.getHours() * 10000)
				+ ((int) fecha.getMinutes() * 100) + ((int) fecha.getSeconds());
		String fechayhoraString = String.valueOf(fechayhora) + ".txt";
		String ruta = "C:\\Users\\yaros\\Desktop\\" + fechayhoraString;
		File archivo = new File(ruta);
		BufferedWriter bw;
		if (archivo.exists()) {
			bw = new BufferedWriter(new FileWriter(archivo));
			bw.write(DatosParaEnvio2);
		} else {
			bw = new BufferedWriter(new FileWriter(archivo));
			bw.write(DatosParaEnvio2);
		}
		bw.close();
	}
}
