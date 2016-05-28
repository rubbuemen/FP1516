package fp.grados.tipos.test;

import java.util.List;

import fp.grados.excepciones.ExcepcionEspacioNoValido;
import fp.grados.tipos.Espacio;
import fp.grados.tipos.EspacioImpl;
import fp.grados.tipos.TipoEspacio;
import fp.grados.utiles.Grados;

public class TestEspacio {
	public static void main(String[] args) {
		testConstructorNormal();
		testConstructorExcepcional();
		
		testConstructorStringNormal();
		
		testMetodoCreacionalParametrosNormal();
		
		testMetodoCreacionalCopiaNormal();
		
		testMetodoCreacionalStringNormal();
		
		testMetodoCreacionalFicheroNormal();
		
		testSetCapacidadNormal();
		testSetCapacidadExcepcional();
		
		testIgualdad();
		testOrden();
		
		testMetodosPoblacionales();
	}

	private static void testConstructorNormal() {
		System.out.println("========Probando el constructor======================================================================================");
		testConstructor(TipoEspacio.LABORATORIO, "A3.10", 30, 2);
	}
	
	private static void testConstructorExcepcional() {
		System.out.println("\n========Probando el constructor con capacidad menor que 0======================================================================================");
		testConstructor(TipoEspacio.LABORATORIO, "A3.10", -10, 2);
	}
	
	private static void testConstructorStringNormal(){
		System.out.println("\n========Probando el constructor con String======================================================================================");
		List<Espacio> espacios = Grados.leeFichero("res/espacios.txt", s -> new EspacioImpl(s));
		testConstructorString(espacios);
		//Nota: para hacer saltar una excepción, habría que modificar el fichero de texto
	}
	
	private static void testMetodoCreacionalParametrosNormal() {
		System.out.println("\n========Probando método creacional por parámetros======================================================================================");
		testMetodoCreacionalParametros(TipoEspacio.LABORATORIO, "A3.10", 30, 2);
		//Nota: para hacer saltar la excepción, habría que modificar los datos
	}
	
	private static void testMetodoCreacionalCopiaNormal() {
		System.out.println("\n========Probando método creacional por copia======================================================================================");
		Espacio es = new EspacioImpl(TipoEspacio.LABORATORIO, "A3.10", 30, 2);
		testMetodoCreacionalCopia(es);
		//Nota: para hacer saltar la excepción, habría que modificar los datos
	}
	
	private static void testMetodoCreacionalStringNormal() {
		System.out.println("\n========Probando método creacional por string======================================================================================");
		testMetodoCreacionalString("D2.34,2,50,TEORIA");
		//Nota: para hacer saltar la excepción, habría que modificar los datos
	}

	private static void testMetodoCreacionalFicheroNormal(){
		System.out.println("\n========Probando método creacional con fichero======================================================================================");
		testMetodoCreacionalFichero("res/espacios.txt");
		//Nota: para hacer saltar una excepción, habría que modificar el fichero de texto
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
	
	private static void testIgualdad() {
		System.out.println("\n========Probando igualdad con dos objetos iguales======================================================================================");
		Espacio es1 = new EspacioImpl(TipoEspacio.LABORATORIO, "A3.10", 30, 2);
		Espacio es2 = new EspacioImpl(TipoEspacio.LABORATORIO, "A3.10", 30, 2);
		Espacio es3 = new EspacioImpl(TipoEspacio.LABORATORIO, "A4.10", 30, 2);
		Espacio es4 = new EspacioImpl(TipoEspacio.LABORATORIO, "A5.10", 30, 1);
		System.out.println("Código hash del objeto es1 (" + es1 + "): " + es1.hashCode());
		System.out.println("Código hash del objeto es2 (" + es2 + "): " + es2.hashCode());
		System.out.println("Código hash del objeto es3 (" + es3 + "): " + es3.hashCode());
		System.out.println("Código hash del objeto es4 (" + es4 + "): " + es4.hashCode());
		System.out.println("¿Es es1 igual a es2? (debe ser true): " + es1.equals(es2));
		System.out.println("¿Es es1 distinto de es3? (debe ser true): " + !es1.equals(es3));
		System.out.println("¿Es es1 distinto de es4? (debe ser true): " + !es1.equals(es4));
	}
	
	private static void testOrden() {
		System.out.println("\n========Probando orden natural======================================================================================");
		Espacio menor = new EspacioImpl(TipoEspacio.LABORATORIO, "A3.10", 30, 1);
		Espacio igual1 = new EspacioImpl(TipoEspacio.LABORATORIO, "A3.10", 30, 2);
		Espacio igual2 = new EspacioImpl(TipoEspacio.LABORATORIO, "A3.10", 30, 2);
		Espacio mayor = new EspacioImpl(TipoEspacio.LABORATORIO, "A3.10", 30, 3);
		System.out.println("- Debe ser ANTES: ");
		compara(menor, igual1);
		System.out.println("- Debe ser MISMA POSICIÓN: ");
		compara(igual1, igual2);
		System.out.println("- Debe ser DESPUÉS: ");
		compara(mayor, igual2);
	}
	
	private static void testMetodosPoblacionales() {
		System.out.println("\n========Probando métodos poblacionales======================================================================================");
		Grados.createDespacho("A2.03,2,6");
		System.out.println("Número de espacios creados: " + Grados.getNumEspaciosCreados());
		System.out.println("Espacios creados: " + Grados.getEspaciosCreados());
		System.out.println("Número de planta máxima: " + Grados.getPlantaMayorEspacio());
		System.out.println("Número de planta mínima: " + Grados.getPlantaMenorEspacio());
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
	
	private static void testConstructorString(List<Espacio> espacios){
		for (Espacio es : espacios) {
			try {
				mostrarEspacio(es);
			} catch (ExcepcionEspacioNoValido e) {
				System.out.println("Se ha capturado la excepción ExcepcionEspacioNoValido: \n\t" + e.getMessage());
			} catch (Exception e) {
				System.out.println("Se ha capturado una excepción inesperada.");
			}
		}
	}
	
	private static void testMetodoCreacionalParametros(TipoEspacio tipo, String nombre, Integer capacidad, Integer planta) {
		try {
			Espacio es = Grados.createEspacio(tipo, nombre, capacidad, planta);
			mostrarEspacio(es);
		} catch (ExcepcionEspacioNoValido e) {
			System.out.println("Se ha capturado la excepción ExcepcionEspacioNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción inesperada.");
		}
	}
	
	private static void testMetodoCreacionalCopia(Espacio es) {
		try {
			Espacio res = Grados.createEspacio(es);
			mostrarEspacio(res);
		} catch (ExcepcionEspacioNoValido e) {
			System.out.println("Se ha capturado la excepción ExcepcionEspacioNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción inesperada.");
		}
	}
	
	private static void testMetodoCreacionalString(String es) {
		try {
			Espacio res = Grados.createEspacio(es);
			mostrarEspacio(res);
		} catch (ExcepcionEspacioNoValido e) {
			System.out.println("Se ha capturado la excepción ExcepcionEspacioNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción inesperada.");
		}
	}
	
	private static void testMetodoCreacionalFichero(String fichero) {
		List<Espacio> espacios = Grados.createEspacios(fichero);
		for (Espacio es : espacios) {
			mostrarEspacio(es);
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
	
	private static void compara(Espacio es1, Espacio es2) {
		System.out.print("El objeto <" + es1 + ">");
		if (es1.compareTo(es2) < 0) {
			System.out.print(" va ANTES que el objeto ");
		} else if (es1.compareTo(es2) > 0) {
			System.out.print(" va DESPUÉS que el objeto ");
		} else {
			System.out.print(" va en la MISMA POSICIÓN que el objeto ");
		}
		System.out.println("<" + es2 + ">");
	}

	private static void mostrarEspacio(Espacio es) {
		System.out.println("Espacio--> <" + es + ">");
		System.out.println("\tTipo de espacio: <" + es.getTipo() + ">");
		System.out.println("\tNombre: <" + es.getNombre() + ">");
		System.out.println("\tCapacidad: <" + es.getCapacidad() + ">");
		System.out.println("\tPlanta: <" + es.getPlanta() + ">");
	}
}