package main;

import java.util.Scanner;

public class Minuscula {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un carácter:");
		String linea= sc.nextLine();
		Character c = linea.charAt(0);
		System.out.print("El carácter " + c);
		if (Character.isLowerCase(c)){
			System.out.println(" es minúscula");
		}
		else{
			System.out.println(" no es minúscula");
		}
		sc.close();

	}

}
