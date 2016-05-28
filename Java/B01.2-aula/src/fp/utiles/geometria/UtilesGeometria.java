package fp.utiles.geometria;

import fp.geometria.tipos.Circulo;
import fp.geometria.tipos.Punto;
import fp.tipos.geometria.Cuadrante;

public class UtilesGeometria {
	
	public static Double calcularPerimetro(Punto p1, Punto p2, Punto p3) {
		Double distP1P2 = p1.getDistancia(p2);
		Double distP2P3 = p2.getDistancia(p3);
		Double distP3P1 = p3.getDistancia(p1);
		Double perimetro = distP1P2 + distP2P3 + distP3P1;
		return perimetro;
	}
	
	public static Boolean tienenPuntosInterseccion(Circulo c1, Circulo c2){
		Boolean res;
		Double distanciaCentros = c1.getCentro().getDistancia(c2.getCentro());
		Double sumaRadios = c1.getRadio() +c2.getRadio();
		res = distanciaCentros <= sumaRadios;
		return res;
	}
	
	public static Cuadrante obtenerCuadrante(Punto p){
		Cuadrante c;
		if (p.getX() > 0 && p.getY() > 0){
			c = Cuadrante.PRIMER_CUADRANTE;
		}
		else if (p.getX() < 0 && p.getY() > 0){
			c = Cuadrante.SEGUNDO_CUADRANTE;
		}
		else if (p.getX() < 0 && p.getY() < 0){
			c = Cuadrante.TERCER_CUADRANTE;
		}
		else if (p.getX() > 0 && p.getY() < 0){
			c = Cuadrante.CUARTO_CUADRANTE;
		}
		else{
			c= Cuadrante.EJE;
		}
		return c;
	}
	
	public static String abreviaturaCuadrante(Cuadrante c){
		String res;
		switch (c) {
		case PRIMER_CUADRANTE:
			res= "1ER CUADRANTE";
			break;
		case SEGUNDO_CUADRANTE:
			res= "2º CUADRANTE";
			break;	
		case TERCER_CUADRANTE:
			res= "3ER CUADRANTE";
			break;
		case CUARTO_CUADRANTE:
			res= "4º CUADRANTE";
			break;	
		default:
			res = c.toString();
			break;
		}
		return res;
	}

}
