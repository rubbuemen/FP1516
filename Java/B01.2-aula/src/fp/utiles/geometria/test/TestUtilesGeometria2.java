package fp.utiles.geometria.test;

import fp.geometria.tipos.Circulo;
import fp.geometria.tipos.CirculoImpl;
import fp.geometria.tipos.Punto;
import fp.geometria.tipos.PuntoImpl;
import fp.utiles.geometria.UtilesGeometria;

public class TestUtilesGeometria2 {

	public static void main(String[] args) {
		Punto centro1 = new PuntoImpl(6.0, 6.0);
		Circulo c1 = new CirculoImpl(centro1, 6.0);
		Punto centro2 = new PuntoImpl(8.0, 2.0);
		Circulo c2 = new CirculoImpl(centro2, 4.0);
		Punto centro3 = new PuntoImpl();
		Circulo c3 = new CirculoImpl(centro3, 2.0);
		testInteseccion(c1, c2);
		testInteseccion(c2, c3);
	}
	
	private static void testInteseccion(Circulo a, Circulo b){
		Boolean intersectan = UtilesGeometria.tienenPuntosInterseccion(a, b);
		System.out.print("El círculo con " + a + " y el círculo con " + b);
		if(!intersectan){
			System.out.print(" NO");
		}
		System.out.println(" tienen puntos de intersección");
	}

}
