package main;

import fp.geometria.tipos.Punto;
import fp.geometria.tipos.PuntoImpl;

public class Perimetro {

	public static void main(String[] args) {
		Punto A = new PuntoImpl(-2.0, 2.0);
		Punto B = new PuntoImpl(1.0, 6.0);
		Punto C = new PuntoImpl(6.0, -6.0);
		Double distancia1 = A.getDistancia(B);
		Double distancia2 = B.getDistancia(C);
		Double distancia3 = C.getDistancia(A);
		Double perimetro = distancia1 + distancia2 + distancia3;
		System.out.println("El perímetro del triángulo formado por A" + A + ", B" + B + ", C" + C + " es " + perimetro);

	}

}
