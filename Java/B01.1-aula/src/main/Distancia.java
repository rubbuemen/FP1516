package main;

import java.util.Scanner;

import fp.geometria.tipos.Punto;
import fp.geometria.tipos.PuntoImpl;

public class Distancia {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca la coordenada X:");
		Double x = sc.nextDouble();
		System.out.println("Introduzca la coordenada Y:");
		Double y = sc.nextDouble();
		Punto p = new PuntoImpl(x, y);
		Punto origen = new PuntoImpl();
		Double distancia = p.getDistancia(origen);
		System.out.println("La distancia de " + p + " al origen es " + distancia);
		sc.close();
	}

}
