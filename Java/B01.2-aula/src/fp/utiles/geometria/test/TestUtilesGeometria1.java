package fp.utiles.geometria.test;

import fp.geometria.tipos.Punto;
import fp.geometria.tipos.PuntoImpl;
import fp.utiles.geometria.UtilesGeometria;

public class TestUtilesGeometria1 {

	public static void main(String[] args) {
		Punto a = new PuntoImpl(-2.0, 2.0);
		Punto b = new PuntoImpl(1.0, 6.0);
		Punto c = new PuntoImpl(6.0, -6.0);
		Punto d = new PuntoImpl(-2.0, 1.0);
		Punto e = new PuntoImpl(2.0, -1.0);
		Punto f = new PuntoImpl(0.0, 6.0);
		Punto g = new PuntoImpl(5.0, 1.0);
		Punto h = new PuntoImpl(5.0, -3.0);
		Punto i = new PuntoImpl(2.0, -1.0);
		Double perimetroABC = UtilesGeometria.calcularPerimetro(a, b, c);
		Double perimetroDEF = UtilesGeometria.calcularPerimetro(d, e, f);
		Double perimetroGHI = UtilesGeometria.calcularPerimetro(g, h, i);
		System.out.println("El perímetro del triángulo formado por A" + a + ", B" + b + ", C" + c + " es " + perimetroABC);
		System.out.println("El perímetro del triángulo formado por D" + d + ", E" + e + ", F" + f + " es " + perimetroDEF);
		System.out.println("El perímetro del triángulo formado por G" + g + ", H" + h + ", I" + i + " es " + perimetroGHI);
	}

}
