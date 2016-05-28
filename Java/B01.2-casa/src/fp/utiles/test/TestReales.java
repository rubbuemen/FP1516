package fp.utiles.test;

import java.util.Scanner;
import fp.utiles.Reales;

public class TestReales {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserte un valor: ");
		Double x = sc.nextDouble();
		testIntervalo(x);
		sc.close();
	}
	
	private static void testIntervalo(Double x){
		Boolean pertenece = Reales.estaEnIntervalo(x);
		System.out.print("El valor " + x);
		if(!pertenece){
			System.out.print(" no");
		}
		System.out.println(" pertenece al intervalo");
	}

}
