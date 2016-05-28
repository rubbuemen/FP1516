package main;

import java.util.Scanner;

public class Eco {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca una frase:");
		String linea= sc.nextLine();
		System.out.println("ECO: " + linea);
		sc.close();
	}

}
