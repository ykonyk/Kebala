package kebala_V2;

import java.util.ArrayList;

public class test {
	
	
	public static int ped = 0;
	public static double num = 14.64843161436843546;
	public static String DatosParaEnvio = "";
	public static ArrayList<String> Pedido = new ArrayList<String>();

	public static void car() {
		ped = (ped + 1);
	}
	
	public static void dd() {
		double cambio = (double)(Math.round(num  * 100D) / 100D);
		System.out.println(cambio);
	}
	
	public static void cargar() {
		Pedido.add("Durum");
		Pedido.add("Cus cus");
		Pedido.add("Shashlik");
		Pedido.add("Tortilla");
	}

	public static void bucle() {
		String precioStr = String.valueOf(num);
		for (byte x = 0; x < Pedido.size(); x++) {
			String aux3 = Pedido.get(x);
			aux3 += "  ";
			DatosParaEnvio += aux3;
		}
		DatosParaEnvio += precioStr;
		System.out.println(DatosParaEnvio);
		System.out.println(ped);
	}

	public static void main(String[] args) throws Exception {
		dd();
		car();
		cargar();
		bucle();
	}
}
