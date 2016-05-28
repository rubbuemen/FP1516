package fp.grados.tipos.test;

import fp.grados.excepciones.ExcepcionEspacioNoValido;
import fp.grados.tipos.Espacio;
import fp.grados.tipos.EspacioImpl;
import fp.grados.tipos.TipoEspacio;

public class TestEspacio {
	public static void main(String[] args) {
		testConstructorNormal();
		testConstructorExcepcional();
		
		testSetCapacidadNormal();
		testSetCapacidadExcepcional();
	}

	private static void testConstructorNormal() {
		System.out.println("========Probando el constructor======================================================================================");
		testConstructor(TipoEspacio.LABORATORIO, "A3.10", 30, 2);
	}
	
	private static void testConstructorExcepcional() {
		System.out.println("\n========Probando el constructor con capacidad menor que 0======================================================================================");
		testConstructor(TipoEspacio.LABORATORIO, "A3.10", -10, 2);
	}
	
	private static void testSetCapacidadNormal() {
		System.out.println("\n========Probando setCapacidad======================================================================================");
		Espacio es = new EspacioImpl(TipoEspacio.LABORATORIO, "A3.10", 30, 2);
		testSetCapacidad(es, 20);
	}
	
	private static void testSetCapacidadExcepcional() {
		System.out.println("\n========Probando setCapacidad con capacidad menor que 0======================================================================================");
		Espacio es = new EspacioImpl(TipoEspacio.LABORATORIO, "A3.10", 30, 2);
		testSetCapacidad(es, -10);
	}
	
	
	
	//////////////////////////////////////////////////
	//Métodos auxiliares
	
	private static void testConstructor(TipoEspacio tipo, String nombre, Integer capacidad, Integer planta) {
		try {
			Espacio es = new EspacioImpl(tipo, nombre, capacidad, planta);
			mostrarEspacio(es);
		} catch (ExcepcionEspacioNoValido e) {
			System.out.println("Se ha capturado la excepción ExcepcionEspacioNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción insesperada.");
		}
	}
	
	private static void testSetCapacidad(Espacio es, Integer nuevaCapacidad) {
		try {
			System.out.println("La capacidad antes de la operación es: " + es.getCapacidad());
			System.out.println("La nueva capacidad es: " +  nuevaCapacidad);
			es.setCapacidad(nuevaCapacidad);
			System.out.println("La capacidad después de la operación es: " + es.getCapacidad());
		} catch (ExcepcionEspacioNoValido e) {
			System.out.println("Se ha capturado la excepción ExcepcionEspacioNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción insesperada.");
		}
	}

	private static void mostrarEspacio(Espacio es) {
		System.out.println("Espacio--> <" + es + ">");
		System.out.println("\tTipo de espacio: <" + es.getTipo() + ">");
		System.out.println("\tNombre: <" + es.getNombre() + ">");
		System.out.println("\tCapacidad: <" + es.getCapacidad() + ">");
		System.out.println("\tPlanta: <" + es.getPlanta() + ">");
	}
}