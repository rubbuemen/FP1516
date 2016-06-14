package main;

import java.time.LocalDate;
import java.util.Scanner;

public class Nacimiento {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca su edad:");
		
		Integer edad = sc.nextInt();
		Integer anyoActual = LocalDate.now().getYear();
		Integer anyoNacimiento = anyoActual - edad;
		
		System.out.println("Tu año de nacimiento es " + anyoNacimiento + " si ya ha pasado tu cumpleaños; si no, naciste en " + (anyoNacimiento - 1));
		sc.close();
	}
}
