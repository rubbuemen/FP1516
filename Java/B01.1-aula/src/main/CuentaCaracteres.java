package main;

import java.util.Scanner;

public class CuentaCaracteres {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca una frase:");
		String frase= sc.nextLine();
		System.out.println("La frase tiene " + frase.length() + " caracteres");
		sc.close();
	}

}
