package fp.grados.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import fp.grados.excepciones.ExcepcionProfesorNoValido;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.Tutoria;
import fp.grados.tipos.TutoriaImpl;

public class TestProfesor {
	public static void main(String[] args) {
		testConstructorNormal();
		testConstructorExcepcion();
		
		testSetFechaNacimientoNormal();
		testSetFechaNacimientoExcepcion();

		testSetCategoria();
		
		testNuevaTutoria();

		testBorraTutoria();
		
		testBorraTutorias();
	}

	private static void testConstructorNormal() {
		System.out.println("========Probando el constructor======================================================================================");
		testConstructor("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.es", Categoria.TITULAR);
	}

	private static void testConstructorExcepcion() {
		System.out.println("\n========Probando el constructor siendo el profesor menor de edad======================================================================================");
		testConstructor("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(2000, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
	}
	
	private static void testSetFechaNacimientoNormal() {
		System.out.println("\n========Probando setFechaNacimiento======================================================================================");
		Profesor pr = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.es", Categoria.TITULAR);
		testSetFechaNacimiento(pr, LocalDate.of(1960, 3, 15));
	}
	
	private static void testSetFechaNacimientoExcepcion() {
		System.out.println("\n========Probando setFechaNacimiento con un profesor menor de edad======================================================================================");
		Profesor pr = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.es", Categoria.TITULAR);
		testSetFechaNacimiento(pr, LocalDate.of(2005, 3, 15));
	}

	private static void testSetCategoria() {
		System.out.println("\n========Probando setCategoria======================================================================================");
		Profesor pr = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.es", Categoria.TITULAR);
		testSetCategoria(pr, Categoria.INTERINO);
	}

	private static void testNuevaTutoria(){
		System.out.println("\n========Probando nuevaTutoria======================================================================================");
		Profesor pr = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		testNuevaTutoria(LocalTime.of(10, 30), 30, DayOfWeek.FRIDAY, pr);
	}

	private static void testBorraTutoria(){
		System.out.println("\n========Probando borraTutoria======================================================================================");
		Profesor pr = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		pr.nuevaTutoria(LocalTime.of(10, 30), 60, DayOfWeek.FRIDAY);
		testBorraTutoria(LocalTime.of(10, 30), DayOfWeek.FRIDAY, pr);
	}
	
	private static void testBorraTutorias(){
		System.out.println("\n========Probando borraTutorias======================================================================================");
		Profesor pr = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
		pr.nuevaTutoria(LocalTime.of(10, 30), 60, DayOfWeek.WEDNESDAY);
		pr.nuevaTutoria(LocalTime.of(12, 30), 30, DayOfWeek.FRIDAY);
		testBorraTutorias(pr);
	}


	
	//////////////////////////////////////////////////
	//Métodos auxiliares
	
	private static void testConstructor(String dni, String nombre, String apellidos, LocalDate fechaNacimiento,	String email, Categoria categoria) {
		try {
			Profesor pr = new ProfesorImpl(dni, nombre, apellidos, fechaNacimiento, email, categoria);
			mostrarProfesor(pr);
		} catch (ExcepcionProfesorNoValido e) {
			System.out.println("Se ha capturado la excepción ExcepcionProfesorNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción inesperada.");
		}
	}
	
	private static void testSetFechaNacimiento(Profesor pr, LocalDate fechaNacimiento) {
		try {
			System.out.println("La fecha de nacimiento del profesor antes de la operación es: " + pr.getFechaNacimiento());
			System.out.println("La nueva fecha de nacimiento es: " + fechaNacimiento);
			pr.setFechaNacimiento(fechaNacimiento);;
			System.out.println("La categoría después de la operación es: " + pr.getFechaNacimiento());
		} catch(ExcepcionProfesorNoValido e){
			System.out.println("Se ha capturado la excepción ExcepcionProfesorNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción inesperada.");
		}
	}

	private static void testSetCategoria(Profesor pr, Categoria nuevaCategoria) {
		System.out.println("La categoría antes de la operación es: " + pr.getCategoria());
		System.out.println("La categoría es: " + nuevaCategoria);
		pr.setCategoria(nuevaCategoria);
		System.out.println("La categoría después de la operación es: " + pr.getCategoria());
	}

	private static void testNuevaTutoria(LocalTime horaComienzo, Integer duracion, DayOfWeek diaSemana, Profesor pr) {
		Tutoria tutoria = new TutoriaImpl(diaSemana, horaComienzo, duracion);
		System.out.println("Las tutorias del profesor antes de la operación es: " + pr.getTutorias());
		pr.nuevaTutoria(horaComienzo, duracion, diaSemana);
		System.out.println("Nueva tutoria: " + tutoria);
		System.out.println("Las tutorias del profesor después de la operación es: " + pr.getTutorias());
	}

	private static void testBorraTutoria(LocalTime horaComienzo, DayOfWeek diaSemana, Profesor pr) {
		Tutoria tutoria = new TutoriaImpl(diaSemana, horaComienzo, 60);
		System.out.println("Las tutorias del profesor antes de la operación es: " + pr.getTutorias());
		System.out.println("Tutoria a borrar: " + tutoria);
		pr.borraTutoria(horaComienzo, diaSemana);
		System.out.println("Las tutorias del profesor después de la operación es: " + pr.getTutorias());
	}
	
	private static void testBorraTutorias(Profesor pr) {
		System.out.println("Las tutorias del profesor antes de la operación son: " + pr.getTutorias());
		System.out.println("Tutorias a borrar: " + pr.getTutorias());
		pr.borraTutorias();
		System.out.println("Las tutorias del profesor después de la operación es: " + pr.getTutorias());
	}

	private static void mostrarProfesor(Profesor pr) {
		System.out.println("Profesor --> <" + pr + ">");
		System.out.println("\tDNI: <" + pr.getDNI() + ">");
		System.out.println("\tNombre: <" + pr.getNombre() + ">");
		System.out.println("\tApellidos: <" + pr.getApellidos() + ">");
		System.out.println("\tFecha Nacimiento: <" + pr.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ">");
		System.out.println("\tEdad: <" + pr.getEdad() + ">");
		System.out.println("\tEmail:  <" + pr.getEmail() + ">");
		System.out.println("\tCategoría:  <" + pr.getCategoria() + ">");
		System.out.println("\tTutorias:  <" + pr.getTutorias() + ">");
	}
}