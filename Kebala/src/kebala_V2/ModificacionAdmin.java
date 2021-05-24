package kebala_V2;

import java.util.ArrayList;
import java.util.Scanner;

public class ModificacionAdmin {
	
	public Scanner sc = new Scanner(System.in);
	public int IntroducirCont;
	public String A�adir;
	public byte a, a1, a3;
	
	public ArrayList<String> Kebabs = new ArrayList<String>();
	public ArrayList<String> Complementos = new ArrayList<String>();
	
	public void Admin() {
		int contrase�a = 1234;
		System.out.println("Inicie sesi�n para entrar como administrador \n" + "Contrase�a:");
		IntroducirCont = Integer.valueOf(sc.nextLine());
		if (contrase�a == IntroducirCont) {
			System.out.println("1.A�adir un kebab \n" + "2.Eliminar un Kebab \n" + "3.A�adir Complementos");
			byte a = Byte.valueOf(sc.nextLine());
			switch (a) {

			case 1:
				A�adirkebab();
				break;
			case 2:
				Borrarkebab();
				break;
			case 3:
				A�adirComplementos();
			}
		} else {
			System.out.println("Prueba de nuevo");
		}
	}
	
	public void A�adirkebab() {
		System.out.println("�Qu� desea a�adir?");
		A�adir = String.valueOf(sc.nextLine());
		Kebabs.add(A�adir);
		do {
			System.out.println("1.A�adir algo m�s \n" + "2.Terminar");
			byte a = Byte.valueOf(sc.nextLine());
			if (a == 1) {
				System.out.println("�Qu� desea a�adir?");
				A�adir = String.valueOf(sc.nextLine());
				Kebabs.add(A�adir);
			} else {
				System.out.println("Por ahora hay a�adido: " + Kebabs);
				Admin();
				break;
			}
		} while (a != 1);

	}

	public void Borrarkebab() {
		System.out.println("�Qu� desea borrar? \n" + Kebabs);
		byte a1 = Byte.valueOf(sc.nextLine());
		Kebabs.remove(a1);
		do {
			System.out.println("1.Eliminar algo m�s \n" + "2.Terminar");
			byte a = Byte.valueOf(sc.nextLine());
			if (a == 1) {
				System.out.println("�Qu� desea borrar? \n" + Kebabs);
				byte a3 = Byte.valueOf(sc.nextLine());
				Kebabs.remove(a3);
			} else {
				System.out.println("Por ahora hay a�adido: " + Kebabs);
			}
		} while (a != 1);
	}

	public void A�adirComplementos() {
		System.out.println("�Qu� desea a�adir?");
		A�adir = String.valueOf(sc.nextLine());
		Complementos.add(A�adir);
		do {
			System.out.println("1.A�adir algo m�s \n" + "2.Terminar");
			byte a = Byte.valueOf(sc.nextLine());
			if (a == 1) {
				System.out.println("�Qu� desea a�adir?");
				A�adir = String.valueOf(sc.nextLine());
				Complementos.add(A�adir);
			} else {
				System.out.println("Por ahora hay a�adido: " + Complementos);
			}
		} while (a != 1);
	}
}
