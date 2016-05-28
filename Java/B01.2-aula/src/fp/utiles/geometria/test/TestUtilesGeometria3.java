package fp.utiles.geometria.test;

import fp.geometria.tipos.Punto;
import fp.geometria.tipos.PuntoImpl;
import fp.tipos.geometria.Cuadrante;
import fp.utiles.geometria.UtilesGeometria;


public class TestUtilesGeometria3 {

	public static void main(String[] args) {
		Punto p1= new PuntoImpl();
		TestCuadrante(p1);
		Punto p2 = new PuntoImpl(2.0, 2.0);
		TestCuadrante(p2);
		Punto p3 = new PuntoImpl(-2.0, 2.0);
		TestCuadrante(p3);
		Punto p4 = new PuntoImpl(-2.0, -2.0);
		TestCuadrante(p4);
		Punto p5 = new PuntoImpl(2.0, -2.0);
		TestCuadrante(p5);
		Punto p6 = new PuntoImpl(2.0, 0.0);
		TestCuadrante(p6);
		Punto p7 = new PuntoImpl(0.0, -2.0);
		TestCuadrante(p7);
	}
	
	private static void TestCuadrante(Punto p){
		Cuadrante c = UtilesGeometria.obtenerCuadrante(p);
		System.out.println("El punto " + p + " pertenece al " + c);
	}

}
