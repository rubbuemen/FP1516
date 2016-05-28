package main;

import java.util.Scanner;

public class IMC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca su peso (en kilos):");
		Float peso = sc.nextFloat();
		
		System.out.println("Introduzca su estatura (en metros):");
		Float estatura = sc.nextFloat();
		
		Float imc = peso / (estatura * estatura);
		
		System.out.println("Su IMC es: " + imc);
		sc.close();

	}

}
