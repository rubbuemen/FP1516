package main;

import java.util.Scanner;

public class Cuadrado {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un número:");
		Integer n = sc.nextInt();
		Integer cuadrado = n*n;
		System.out.println("El cuadrado de " + n + " es " + cuadrado);
		sc.close();
	}

}
