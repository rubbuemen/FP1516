package main;

import java.util.Scanner;

public class PositivoPar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un n�mero:");
		Integer n = sc.nextInt();
		System.out.print("El n�mero " + n + " es ");
		if(n>0){
			System.out.print("positivo");
		}
		else if(n<0){
			System.out.print("negativo");
		}
		else{
			System.out.print("cero");
		}
		System.out.print(" y ");
		if(n%2==0){
			System.out.println("par");
		}
		else{
			System.out.println("impar");
		}
		sc.close();
	}

}
