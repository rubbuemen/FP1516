package main;

import java.util.Scanner;

public class Minuscula {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un car�cter:");
		String linea= sc.nextLine();
		Character c = linea.charAt(0);
		System.out.print("El car�cter " + c);
		if (Character.isLowerCase(c)){
			System.out.println(" es min�scula");
		}
		else{
			System.out.println(" no es min�scula");
		}
		sc.close();

	}

}
