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
	public short o1,o2,o3,o4,o5,o6;

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
			do {																			//O1P	O2 Principio
				
				boolean ok = true;
				do
				{	ok = true;
				System.out.println("1[Durum (4€)] 2[kebab(5€)] 3[plato(6,50€)]");			
				try 
				{	String s = sc.nextLine();
					o1 = Short.parseShort(s);
					
				} 
				catch (NumberFormatException n) 
				{	ok = false;
				}
			}	while (ok==false);
				
			
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
			
			}
			while (o1<1 || o1>3);															//O1F		O1 final

			System.out.println("¿Con que carne lo prefiere?");								//O2P
			do {
			boolean ok2 = true;
			do
			{	ok2 = true;
			System.out.println("1[Pollo] 2[Ternera] 3[Mixto]");
			try 
			{	String s = sc.nextLine();
				o2 = Short.parseShort(s);
				
			} 
			catch (NumberFormatException n) 
			{	ok2 = false;
			}
		}	while (ok2==false);
			
			}
			while (o2<1 || o2>3);
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
			
			
																							//O2F
			System.out.println("¿Solo carne o ensalada?");									//O3P
			
			do {
			boolean ok3 = true;
			do
			{	ok3 = true;
			System.out.println("1[Carne] 2[Ensalada]");
			try 
			{	String s = sc.nextLine();
				o3 = Short.parseShort(s);
				
			} 
			catch (NumberFormatException n) 
			{	ok3 = false;
			}
		}	while (ok3==false);
			}
			while (o3<1||o3>5);		
			
			switch (o3) {
			case 1:
				Pedido.add("Carne");
				precio = (precio + 4);
				break;
			case 2:
				Pedido.add("Ensalada");
			}
																//O3F
			
			
			

			System.out.println("¿Que desea para beber?");								//O4P
			do {
			boolean ok2 = true;
			do
			{	ok2 = true;
			System.out.println("1[Coca-Cola (0,75€)] 2[Fanta(0,70€)] 3[cerveza(1€)] 4[Agua(0.40€)] 5[otro(1.20€)]");
			try 
			{	String s = sc.nextLine();
				o4 = Short.parseShort(s);
				
			} 
			catch (NumberFormatException n) 
			{	ok2 = false;
			}
		}	while (ok2==false);
			}
			while (o4<1||o4>5);
			
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
			case 5:
				System.out.println("¿Que desea?");
				precio = (precio +1.2);
				Pedido.add(sc.nextLine());

			}
			System.out.println("------");
			System.out.println("******");
			System.out.println("------");
			System.out.println("Ticket:");
			System.out.println(Pedido + "");
			System.out.println("Total" + "\t" + precio + "€");
			System.out.println("¿Desea algo más?");
			
			do {
			boolean ok = true;
			do
			{	ok = true;
			System.out.println("1 Finalizar y Pagar	2 hacer otro pedido");			
			try 
			{	String s = sc.nextLine();
				o5 = Short.parseShort(s);
				
			} 
			catch (NumberFormatException n) 
			{	ok = false;
			}
		}	while (ok==false);
			}
			while (o5<1||o5>2);
			
			switch (bucle) {
			
			case 2:
				Pedido.add("** ");
			}
		} while (bucle == 2);
		
		
		
		
		do {
		boolean ok = true;
		do
		{	ok = true;
		System.out.println("1 Efectivo  2 Tarjeta");			
		try 
		{	String s = sc.nextLine();
			o6 = Short.parseShort(s);
			
		} 
		catch (NumberFormatException n) 
		{	ok = false;
		}
	}	while (ok==false);
		}
		while (o6<1||o6>2);
		
		switch (o6) {
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
