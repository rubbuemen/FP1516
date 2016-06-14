package fp.grados.tipos.test;

import fp.grados.excepciones.ExcepcionCentroNoValido;
import fp.grados.excepciones.ExcepcionCentroOperacionNoPermitida;
import fp.grados.tipos.Centro;
import fp.grados.tipos.CentroImpl;
import fp.grados.tipos.Espacio;
import fp.grados.tipos.EspacioImpl;
import fp.grados.tipos.TipoEspacio;

public class TestCentro {
	public static void main(String[] args) {
		testConstructorNormal();
		testConstructorExcepcional1();
		testConstructorExcepcional2();
		
		testNuevoEspacioNormal();
		testNuevoEspacioExcepcion();
		
		testEliminaEspacio();
		
		testIgualdad();
		testOrden();
	}

	private static void testConstructorNormal() {
		System.out.println("========Probando el constructor======================================================================================");
		testConstructor("Escuela Técnica Superior de Ingeniería Informática", "Av. de la Reina Mercedes", 3, 1);
	}
	
	private static void testConstructorExcepcional1() {
		System.out.println("\n========Probando el constructor con un número de plantas menor a 1======================================================================================");
		testConstructor("Escuela Técnica Superior de Ingeniería Informática", "Av. de la Reina Mercedes", 0, 1);
	}
	
	private static void testConstructorExcepcional2() {
		System.out.println("\n========Probando el constructor con un número de sotanos negativo======================================================================================");
		testConstructor("Escuela Técnica Superior de Ingeniería Informática", "Av. de la Reina Mercedes", 2, -1);
	}
	
	private static void testNuevoEspacioNormal(){
		System.out.println("\n========Probando nuevoEspacio======================================================================================");
		Espacio es = new EspacioImpl(TipoEspacio.LABORATORIO, "A3.10", 30, -2);
		Centro c = new CentroImpl("Escuela Técnica Superior de Ingeniería Informática", "Av. de la Reina Mercedes", 5, 2);
		testNuevoEspacio(c, es);
	}
	
	private static void testNuevoEspacioExcepcion(){
		System.out.println("\n========Probando nuevoEspacio con un número incorrecto de pisos/sotanos respecto a las plantas======================================================================================");
		Espacio es = new EspacioImpl(TipoEspacio.LABORATORIO, "A3.10", 30, -2);
		Centro c = new CentroImpl("Escuela Técnica Superior de Ingeniería Informática", "Av. de la Reina Mercedes", 1, 1);
		testNuevoEspacio(c, es);
	}
	
	private static void testEliminaEspacio(){
		System.out.println("\n========Probando eliminaEspacio======================================================================================");
		Espacio es = new EspacioImpl(TipoEspacio.LABORATORIO, "A3.10", 30, 0);
		Centro c = new CentroImpl("Escuela Técnica Superior de Ingeniería Informática", "Av. de la Reina Mercedes", 1, 0);
		c.nuevoEspacio(es);
		testEliminaEspacio(c, es);
	}
	
	private static void testIgualdad() {
		System.out.println("\n========Probando igualdad con dos objetos iguales======================================================================================");
		Centro c1 = new CentroImpl("Escuela Técnica Superior de Ingeniería Informática", "Av. de la Reina Mercedes", 5, 2);
		Centro c2 = new CentroImpl("Escuela Técnica Superior de Ingeniería Informática", "Av. de la Reina Mercedes", 5, 2);
		Centro c3 = new CentroImpl("Facultad de biología", "Av. de la Reina Mercedes", 5, 2);
		Centro c4 = new CentroImpl("Facultad de física", "Av. de la Reina Mercedes", 5, 2);
		System.out.println("Código hash del objeto c1 (" + c1 + "): " + c1.hashCode());
		System.out.println("Código hash del objeto c2 (" + c2 + "): " + c2.hashCode());
		System.out.println("Código hash del objeto c3 (" + c3 + "): " + c3.hashCode());
		System.out.println("Código hash del objeto c4 (" + c4 + "): " + c4.hashCode());
		System.out.println("¿Es c1 igual a c2? (debe ser true): " + c1.equals(c2));
		System.out.println("¿Es c1 distinto de c3? (debe ser true): " + !c1.equals(c3));
		System.out.println("¿Es c1 distinto de c4? (debe ser true): " + !c1.equals(c4));
	}

	private static void testOrden() {
		System.out.println("\n========Probando orden natural======================================================================================");
		Centro menor = new CentroImpl("Escuela Técnica Superior de Ingeniería Informática", "Av. de la Reina Mercedes", 5, 2);
		Centro igual1 = new CentroImpl("Facultad de biología", "Av. de la Reina Mercedes", 5, 2);
		Centro igual2 = new CentroImpl("Facultad de biología", "Av. de la Reina Mercedes", 5, 2);
		Centro mayor = new CentroImpl("Facultad de física", "Av. de la Reina Mercedes", 5, 2);
		System.out.println("- Debe ser ANTES: ");
		compara(menor, igual1);
		System.out.println("- Debe ser MISMA POSICIÓN: ");
		compara(igual1, igual2);
		System.out.println("- Debe ser DESPUÉS: ");
		compara(mayor, igual2);
	}
	
	
	
	//////////////////////////////////////////////////
	//Métodos auxiliares
	
	private static void testConstructor(String nombre, String direccion, Integer numeroPlantas, Integer numeroSotanos) {
		try {
			Centro c = new CentroImpl(nombre, direccion, numeroPlantas, numeroSotanos);
			mostrarCentro(c);
		} catch (ExcepcionCentroNoValido e) {
			System.out.println("Se ha capturado la excepción ExcepcionCentroNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción inesperada.");
		}
	}
	
	private static void testNuevoEspacio(Centro c, Espacio es) {
		try {
			System.out.println("Los espacios del centro antes de la operación son: " + c.getEspacios());
			System.out.println("Nuevo espacio a añadir: " + es);
			c.nuevoEspacio(es);
			System.out.println("Los espacios del centro después de la operación son: " + c.getEspacios());
		} catch (ExcepcionCentroOperacionNoPermitida e) {
			System.out.println("Se ha capturado la excepción ExcepcionCentroOperacionNoPermitida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción inesperada.");
		}
	}
	
	private static void testEliminaEspacio(Centro c, Espacio es) {
		System.out.println("Los espacios del centro antes de la operación son: " + c.getEspacios());
		System.out.println("Espacio a eliminar: " + es);
		c.eliminaEspacio(es);
		System.out.println("Los espacios del centro después de la operación son: " + c.getEspacios());
	}

	private static void compara(Centro c1, Centro c2) {
		System.out.print("El objeto <" + c1 + ">");
		if (c1.compareTo(c2) < 0) {
			System.out.print(" va ANTES que el objeto ");
		} else if (c1.compareTo(c2) > 0) {
			System.out.print(" va DESPUÉS que el objeto ");
		} else {
			System.out.print(" va en la MISMA POSICIÓN que el objeto ");
		}
		System.out.println("<" + c2 + ">");
	}

	private static void mostrarCentro(Centro c) {
		System.out.println("Centro--> <" + c + ">");
		System.out.println("Nombre: <" + c.getNombre() + ">");
		System.out.println("Dirección: <" + c.getDireccion() + ">");
		System.out.println("Número de plantas: <" + c.getNumeroPlantas() + ">");
		System.out.println("Número de sotanos: <" + c.getNumeroSotanos() + ">");
		System.out.println("Espacios: <" + c.getEspacios() + ">");
	}
}