package fp.grados.tipos.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fp.grados.excepciones.ExcepcionDespachoNoValido;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Despacho;
import fp.grados.tipos.DespachoImpl;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.TipoEspacio;

public class TestDespacho {
	public static void main(String[] args) {
		testConstructor1Normal();
		testConstructor1Excepcion();
		
		testConstructor2();
		
		testConstructor3();
		
		testSetProfesoresNormal();
		testSetProfesoresExcepcion();
		
		testSetCapacidadNormal();
		testSetCapacidadExcepcion();

		testSetTipoExcepcion();
	}

	private static void testConstructor1Normal() {
		System.out.println("========Probando el primer constructor======================================================================================");
		Profesor pr1 = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		Profesor pr2 = new ProfesorImpl("12345678Z", "Pepe", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		Profesor pr3 = new ProfesorImpl("12345678Z", "Carlos", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		Set<Profesor> listaProfesores = new HashSet<>();
		listaProfesores.add(pr1);
		listaProfesores.add(pr2);
		listaProfesores.add(pr3);
		testConstructor1("A3.10", 6, 2, listaProfesores);
	}
	
	private static void testConstructor1Excepcion() {
		System.out.println("\n========Probando el primer constructor con una capacidad menor al n�mero de profesores======================================================================================");
		Profesor pr1 = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		Profesor pr2 = new ProfesorImpl("12345678Z", "Pepe", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		Profesor pr3 = new ProfesorImpl("12345678Z", "Carlos", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		Set<Profesor> listaProfesores = new HashSet<Profesor>();
		listaProfesores.add(pr1);
		listaProfesores.add(pr2);
		listaProfesores.add(pr3);
		testConstructor1("A3.10", 2, 2, listaProfesores);
	}

	private static void testConstructor2() {
		System.out.println("\n========Probando el segundo constructor======================================================================================");
		Profesor pr = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		Despacho des = new DespachoImpl("A3.10", 30, 2, pr);
		mostrarDespacho(des);
	}

	private static void testConstructor3() {
		System.out.println("\n========Probando el tercer constructor======================================================================================");
		Despacho des = new DespachoImpl("A3.10", 30, 2);
		mostrarDespacho(des);
	}
	
	private static void testSetProfesoresNormal() {
		System.out.println("\n========Probando setProfesores======================================================================================");
		Profesor pr1 = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		Profesor pr2 = new ProfesorImpl("12345678Z", "Pepe", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		Profesor pr3 = new ProfesorImpl("12345678Z", "Carlos", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		Profesor pr4 = new ProfesorImpl("12345678Z", "Ivan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		Profesor pr5 = new ProfesorImpl("12345678Z", "Rafael", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		Set<Profesor> listaProfesores = new HashSet<>();
		Set<Profesor> listaProfesores2 = new HashSet<>();
		listaProfesores.add(pr1);
		listaProfesores.add(pr2);
		listaProfesores2.add(pr3);
		listaProfesores2.add(pr4);
		listaProfesores2.add(pr5);
		Despacho des = new DespachoImpl("A3.10", 4, 3, listaProfesores);
		testSetProfesores(des, listaProfesores2);
	}
	
	private static void testSetProfesoresExcepcion() {
		System.out.println("\n========Probando setProfesores con un n�mero de profesores mayor a la capacidad======================================================================================");
		Profesor pr1 = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		Profesor pr2 = new ProfesorImpl("12345678Z", "Pepe", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		Profesor pr3 = new ProfesorImpl("12345678Z", "Carlos", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		Profesor pr4 = new ProfesorImpl("12345678Z", "Ivan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		Profesor pr5 = new ProfesorImpl("12345678Z", "Rafael", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		Set<Profesor> listaProfesores = new HashSet<>();
		Set<Profesor> listaProfesores2 = new HashSet<>();
		listaProfesores.add(pr1);
		listaProfesores.add(pr2);
		listaProfesores2.add(pr3);
		listaProfesores2.add(pr4);
		listaProfesores2.add(pr5);
		Despacho des = new DespachoImpl("A3.10", 2, 3, listaProfesores);
		testSetProfesores(des, listaProfesores2);
	}
	
	private static void testSetCapacidadNormal() {
		System.out.println("\n========Probando setCapacidad======================================================================================");
		Profesor pr1 = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		Profesor pr2 = new ProfesorImpl("12345678Z", "Pepe", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		Profesor pr3 = new ProfesorImpl("12345678Z", "Carlos", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		Set<Profesor> listaProfesores = new HashSet<>();
		listaProfesores.add(pr1);
		listaProfesores.add(pr2);
		listaProfesores.add(pr3);
		Despacho des = new DespachoImpl("A3.10", 30, 3, listaProfesores);
		testSetCapacidad(des, 25);
	}
	
	private static void testSetCapacidadExcepcion() {
		System.out.println("\n========Probando setCapacidad con una capacidad menor al n�mero de profesores======================================================================================");
		Profesor pr1 = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		Profesor pr2 = new ProfesorImpl("12345678Z", "Pepe", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		Profesor pr3 = new ProfesorImpl("12345678Z", "Carlos", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		Set<Profesor> listaProfesores = new HashSet<>();
		listaProfesores.add(pr1);
		listaProfesores.add(pr2);
		listaProfesores.add(pr3);
		Despacho des = new DespachoImpl("A3.10", 30, 3, listaProfesores);
		testSetCapacidad(des, 2);
	}

	private static void testSetTipoExcepcion() {
		System.out.println("\n========Probando setTipoExcepcion======================================================================================");
		Set<Profesor> listaProfesores = new HashSet<>();
		Despacho des = new DespachoImpl("A3.10", 30, 2, listaProfesores);
		testSetTipo(des, TipoEspacio.LABORATORIO);
	}
	
	
	
	//////////////////////////////////////////////////
	//M�todos auxiliares
	
	private static void testConstructor1(String nombre, Integer capacidad, Integer planta, Set<Profesor> profesores) {
		try {
			Despacho des = new DespachoImpl(nombre, capacidad, planta, profesores);
			mostrarDespacho(des);
		} catch (ExcepcionDespachoNoValido e) {
			System.out.println("Se ha capturado la excepci�n ExcepcionDespachoNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepci�n inesperada.");
		}
	}
	
	private static void testSetProfesores(Despacho des, Set<Profesor> profesores) {
		try {
			System.out.println("Los profesores antes de la operaci�n son: " + des.getProfesores());
			System.out.println("Los nuevos profesores son: " + profesores);
			des.setProfesores(profesores);
			System.out.println("Los profesores despu�s de la operaci�n son: " + des.getProfesores());
		} catch (ExcepcionDespachoNoValido e) {
			System.out.println("Se ha capturado la excepci�n ExcepcionDespachoNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepci�n inesperada.");
		}
	}
	
	private static void testSetCapacidad(Despacho des, Integer nuevaCapacidad) {
		try {
			System.out.println("La capacidad antes de la operaci�n es: " + des.getCapacidad());
			System.out.println("La nueva capacidad es: " + nuevaCapacidad);
			des.setCapacidad(nuevaCapacidad);
			System.out.println("La capacidad despu�s de la operaci�n es: " + des.getCapacidad());
		} catch (ExcepcionDespachoNoValido e) {
			System.out.println("Se ha capturado la excepci�n ExcepcionDespachoNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepci�n inesperada.");
		}
	}
	
	private static void testSetTipo(Despacho des, TipoEspacio nuevoTipo) {
		try {
			System.out.println("El tipo antes de la operaci�n es: " + des.getTipo());
			System.out.println("El nuevo tipo es: " + nuevoTipo);
			des.setTipo(nuevoTipo);
		} catch (UnsupportedOperationException e) {
			System.out.println("Se ha capturado la excepci�n UnsupportedOperationException: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepci�n inesperada.");
		}
	}

	private static void mostrarDespacho(Despacho des) {
		System.out.println("Despacho --> <" + des + ">");
		System.out.println("\tTipo de espacio: <" + des.getTipo() + ">");
		System.out.println("\tNombre: <" + des.getNombre() + ">");
		System.out.println("\tCapacidad: <" + des.getCapacidad() + ">");
		System.out.println("\tPlanta: <" + des.getPlanta() + ">");
		System.out.println("\tProfesores:  <" + des.getProfesores() + ">");
	}
}