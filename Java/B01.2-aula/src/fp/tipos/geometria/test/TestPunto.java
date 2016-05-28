package fp.tipos.geometria.test;

import fp.geometria.tipos.Punto;
import fp.geometria.tipos.PuntoImpl;

public class TestPunto {

	public static void main(String[] args){
		Punto P1 = new PuntoImpl();
		System.out.println("Test constructor por defecto");
		System.out.println("============================");
		System.out.println("Punto 1 " + P1);
		System.out.println(" ");
		
		Punto P2 = new PuntoImpl(1.0,-1.0);
		System.out.println("Test constructor con parámetros");
		System.out.println("============================");
		System.out.println("Punto 2 " + P2);
		System.out.println(" ");
		
		Double xP2 = P2.getX();
		Double yP2 = P2.getY();
		System.out.println("Test observadores");
		System.out.println("============================");
		System.out.println("Coordenada x de P2 " + xP2);
		System.out.println("Coordenada y de P2 " + yP2);
		System.out.println(" ");
		
		P1.setX(3.0);
		P2.setY(-3.0);
		System.out.println("Test modificadores");
		System.out.println("============================");
		System.out.println("Cambiar coordenada X de P1 a 3.0");
		System.out.println("Punto 1 " + P1);
		System.out.println("Cambiar coordenada Y de P2 a -3.0");
		System.out.println("Punto 2 " + P2);
		System.out.println(" ");
		
		Double distanciaP1P2 = P1.getDistancia(P2);
		Double distanciaP2P2 = P2.getDistancia(P2);
		System.out.println("Test getDistancia");
		System.out.println("============================");
		System.out.println("La distancia de " + P1 + " a " + P2 + " es " + distanciaP1P2);
		System.out.println("La distancia de " + P2 + " a " + P2 + " es " + distanciaP2P2);
	}
	

}
