package fp.grados.tipos.test;

import fp.grados.excepciones.ExcepcionCentroNoValido;
import fp.grados.excepciones.ExcepcionCentroOperacionNoPermitida;
import fp.grados.tipos.Centro;
import fp.grados.tipos.CentroImpl2;
import fp.grados.tipos.Espacio;
import fp.grados.tipos.EspacioImpl;
import fp.grados.tipos.TipoEspacio;
import fp.grados.utiles.Grados;

public class TestCentro2 {
	public static void main(String[] args) {
		testConstructorNormal();
		testConstructorExcepcional1();
		testConstructorExcepcional2();
		
		testMetodoCreacionalParametrosNormal();
		
		testMetodoCreacionalCopiaNormal();
			
		testGetEspacioMayorCapacidadNormal();
		testGetEspacioMayorCapacidadExcepcion();
		
		testMetodosPoblacionales();
	}

	private static void testConstructorNormal() {
		System.out.println("========Probando el constructor======================================================================================");
		testConstructor("Escuela Técnica Superior de Ingeniería Informática", "Av. de Reina Mercedes s/n", 3, 1);
	}
	
	private static void testConstructorExcepcional1() {
		System.out.println("\n========Probando el constructor con un número de plantas menor a 1======================================================================================");
		testConstructor("Escuela Técnica Superior de Ingeniería Informática", "Av. Reina Mercedes s/n, Sevilla", 0, 1);
	}
	
	private static void testConstructorExcepcional2() {
		System.out.println("\n========Probando el constructor con un número de sotanos negativo======================================================================================");
		testConstructor("Escuela Técnica Superior de Ingeniería Informática", "Av. Reina Mercedes s/n, Sevilla", 2, -1);
	}
	
	private static void testMetodoCreacionalParametrosNormal() {
		System.out.println("\n========Probando método creacional por parámetros======================================================================================");
		testMetodoCreacionalParametros("Escuela Técnica Superior de Ingeniería Informática", "Av. de Reina Mercedes s/n", 3, 1);
		//Nota: para hacer saltar la excepción, habría que modificar los datos
	}
	
	private static void testMetodoCreacionalCopiaNormal() {
		System.out.println("\n========Probando método creacional por copia======================================================================================");
		Espacio es = new EspacioImpl(TipoEspacio.LABORATORIO, "A3.10", 30, 1);
		Centro c = new CentroImpl2("Escuela Técnica Superior de Ingeniería", "Av. de Reina Mercedes s/n", 2, 5);
		testMetodoCreacionalCopia(c, es);
		//Nota: para hacer saltar la excepción, habría que modificar los datos
	}
	
	private static void testGetEspacioMayorCapacidadNormal(){
		System.out.println("\n========Probando getEspacioMayorCapacidad======================================================================================");
		Espacio es1 = new EspacioImpl(TipoEspacio.LABORATORIO, "A3.10", 30, 0);
		Espacio es2 = new EspacioImpl(TipoEspacio.LABORATORIO, "B4.10", 16, 1);
		Espacio es3 = new EspacioImpl(TipoEspacio.LABORATORIO, "C5.10", 45, 0);
		Centro c = new CentroImpl2("Escuela Técnica Superior de Ingeniería Informática", "Av. Reina Mercedes s/n, Sevilla", 2, 0);
		c.nuevoEspacio(es1);
		c.nuevoEspacio(es2);
		c.nuevoEspacio(es3);
		testGetEspacioMayorCapacidad(c);
	}
	
	private static void testGetEspacioMayorCapacidadExcepcion(){
		System.out.println("\n========Probando getEspacioMayorCapacidad sin espacios======================================================================================");
		Centro c = new CentroImpl2("Escuela Técnica Superior de Ingeniería Informática", "Av. Reina Mercedes s/n, Sevilla", 2, 0);
		testGetEspacioMayorCapacidad(c);
	}

	private static void testMetodosPoblacionales() {
		System.out.println("\n========Probando métodos poblacionales======================================================================================");
		System.out.println("Número de centros creados: " + Grados.getNumCentrosCreados());
		System.out.println("Centros creados: " + Grados.getCentrosCreados());
		System.out.println("Número máximo de plantas: " + Grados.getMaxPlantas());
		System.out.println("Número máximo de sotanos: " + Grados.getMaxSotanos());
		System.out.println("Número medio de plantas: " + Grados.getMediaPlantas());
		System.out.println("Número medio de sotanos: " + Grados.getMediaSotanos());
	}
	
	
	
	//////////////////////////////////////////////////
	//Métodos auxiliares
	
	private static void testConstructor(String nombre, String direccion, Integer numeroPlantas, Integer numeroSotanos) {
		try {
			Centro c = new CentroImpl2(nombre, direccion, numeroPlantas, numeroSotanos);
			mostrarCentro(c);
		} catch (ExcepcionCentroNoValido e) {
			System.out.println("Se ha capturado la excepción ExcepcionCentroNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción inesperada.");
		}
	}
	
	private static void testMetodoCreacionalParametros(String nombre, String direccion, Integer numeroPlantas, Integer numeroSotanos) {
		try {
			Grados.setUsarJava8(true);
			Centro c = Grados.createCentro(nombre, direccion, numeroPlantas, numeroSotanos);
			mostrarCentro(c);
		} catch (ExcepcionCentroNoValido e) {
			System.out.println("Se ha capturado la excepción ExcepcionCentroNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción inesperada.");
		}
	}
	
	private static void testMetodoCreacionalCopia(Centro c, Espacio es) {
		try {
			Grados.setUsarJava8(true);
			c.nuevoEspacio(es);
			Centro res = Grados.createCentro(c);
			mostrarCentro(res);
		} catch (ExcepcionCentroNoValido e) {
			System.out.println("Se ha capturado la excepción ExcepcionCentroNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción inesperada.");
		}
	}
	
	private static void testGetEspacioMayorCapacidad(Centro c){
		try{
			System.out.println("Espacios del centro " + c + " con su capacidad:");
			for (Espacio es : c.getEspacios()) {
				System.out.println(es + " <" + es.getCapacidad() + ">");
			}
			System.out.println("El espacio del centro " + c + " con mayor capacidad es: " + c.getEspacioMayorCapacidad());
		} catch (ExcepcionCentroOperacionNoPermitida e) {
			System.out.println("Se ha capturado la excepción ExcepcionCentroOperacionNoPermitida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción inesperada.");
		}
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