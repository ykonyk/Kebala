package kebala_v1;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public int n = 0;
	public double precio = 0;
	public double cambio;
	public byte bucle = 2;
	public Scanner sc = new Scanner(System.in);
	public ArrayList<String> Pedido = new ArrayList<String>();

	public void Carta() {
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
		do {
			System.out.println("¿Que desea para comer?");
			System.out.println("1[Durum (4€)] 2[kebab(5€)] 3[plato(6,50€)]");
			byte o1 = Byte.valueOf(sc.nextLine());
			switch (o1) {
			case 1:
				Pedido.add("Durum");
				precio = (precio + 4);
				break;
			case 2:
				Pedido.add("kebab");
				precio = (precio + 5);
				break;
			case 3:
				Pedido.add("Plato");
				precio = (precio + 6.5);
			}

			System.out.println("¿Con que carne lo prefiere?");
			System.out.println("1[Pollo] 2[Ternera] 3[Mixto]");
			byte o2 = Byte.valueOf(sc.nextLine());
			switch (o2) {

			case 1:
				Pedido.add("pollo");
				break;
			case 2:
				Pedido.add("Ternera");
				break;
			case 3:
				Pedido.add("Mixto");
			}

			System.out.println("¿Solo carne o ensalada?");
			System.out.println("1[Carne] 2[Ensalada]");
			byte o3 = Byte.valueOf(sc.nextLine());
			switch (o3) {
			case 1:
				Pedido.add("Carne");
				precio = (precio + 4);
				break;
			case 2:
				Pedido.add("Ensalada");
			}

			System.out.println("¿Que desea para beber?");
			System.out.println("1[Coca-Cola (0,75€)] 2[Fanta(0,70€)] 3[cerveza(1€)] 4[Agua(0.40€)]");
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

			}
			System.out.println("------");
			System.out.println("******");
			System.out.println("------");
			System.out.println("Ticket:");
			System.out.println(Pedido + "");
			System.out.println("Total" + "\t" + precio + "€");
			System.out.println("¿Desea algo más?");
			System.out.println("1 Finalizar y Pagar	2 hacer otro pedido");
			bucle = Byte.valueOf(sc.nextLine());
			switch (bucle) {
			case 2:
				Pedido.add("** ");
			}
		} while (bucle == 2);
		
		System.out.println("1 Efectivo  2 Tarjeta");
		byte x = Byte.valueOf(sc.nextLine());
		switch (x) {
		case 1:
			System.out.println("Insertar Dinero");
			cambio = Double.valueOf(sc.nextLine());
			precio = cambio - precio;
			System.out.println("Su cambio es : " + precio + "€. \nMuchas gracias. Hasta pronto.");
			break;
		case 2:
			System.out.println("Pi.... Pi.... *Correcto*");
		}
	}

	public static void main(String[] args) {
		Menu u1 = new Menu();
		u1.Carta();
	}
}
