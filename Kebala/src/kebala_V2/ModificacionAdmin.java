package kebala_V2;

import java.util.ArrayList;
import java.util.Scanner;

public class ModificacionAdmin {
	
	public Scanner sc = new Scanner(System.in);
	public int IntroducirCont;
	public String Añadir;
	public byte a, a1, a3;
	
	public ArrayList<String> Kebabs = new ArrayList<String>();
	public ArrayList<String> Complementos = new ArrayList<String>();
	
	public void Admin() {
		int contraseña = 1234;
		System.out.println("Inicie sesión para entrar como administrador \n" + "Contraseña:");
		IntroducirCont = Integer.valueOf(sc.nextLine());
		if (contraseña == IntroducirCont) {
			System.out.println("1.Añadir un kebab \n" + "2.Eliminar un Kebab \n" + "3.Añadir Complementos");
			byte a = Byte.valueOf(sc.nextLine());
			switch (a) {

			case 1:
				Añadirkebab();
				break;
			case 2:
				Borrarkebab();
				break;
			case 3:
				AñadirComplementos();
			}
		} else {
			System.out.println("Prueba de nuevo");
		}
	}
	
	public void Añadirkebab() {
		System.out.println("¿Qué desea añadir?");
		Añadir = String.valueOf(sc.nextLine());
		Kebabs.add(Añadir);
		do {
			System.out.println("1.Añadir algo más \n" + "2.Terminar");
			byte a = Byte.valueOf(sc.nextLine());
			if (a == 1) {
				System.out.println("¿Qué desea añadir?");
				Añadir = String.valueOf(sc.nextLine());
				Kebabs.add(Añadir);
			} else {
				System.out.println("Por ahora hay añadido: " + Kebabs);
				Admin();
				break;
			}
		} while (a != 1);

	}

	public void Borrarkebab() {
		System.out.println("¿Qué desea borrar? \n" + Kebabs);
		byte a1 = Byte.valueOf(sc.nextLine());
		Kebabs.remove(a1);
		do {
			System.out.println("1.Eliminar algo más \n" + "2.Terminar");
			byte a = Byte.valueOf(sc.nextLine());
			if (a == 1) {
				System.out.println("¿Qué desea borrar? \n" + Kebabs);
				byte a3 = Byte.valueOf(sc.nextLine());
				Kebabs.remove(a3);
			} else {
				System.out.println("Por ahora hay añadido: " + Kebabs);
			}
		} while (a != 1);
	}

	public void AñadirComplementos() {
		System.out.println("¿Qué desea añadir?");
		Añadir = String.valueOf(sc.nextLine());
		Complementos.add(Añadir);
		do {
			System.out.println("1.Añadir algo más \n" + "2.Terminar");
			byte a = Byte.valueOf(sc.nextLine());
			if (a == 1) {
				System.out.println("¿Qué desea añadir?");
				Añadir = String.valueOf(sc.nextLine());
				Complementos.add(Añadir);
			} else {
				System.out.println("Por ahora hay añadido: " + Complementos);
			}
		} while (a != 1);
	}
}
