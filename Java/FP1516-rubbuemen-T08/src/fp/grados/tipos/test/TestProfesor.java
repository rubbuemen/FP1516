package fp.grados.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import fp.grados.excepciones.ExcepcionProfesorNoValido;
import fp.grados.excepciones.ExcepcionProfesorOperacionNoPermitida;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.tipos.Tutoria;
import fp.grados.tipos.TutoriaImpl;

public class TestProfesor {
	public static void main(String[] args) {
		testConstructor1Normal();
		testConstructor1Excepcion();
		
		testConstructor2Normal();
		testConstructor2Excepcion();
		
		testSetFechaNacimientoNormal();
		testSetFechaNacimientoExcepcion();

		testSetCategoriaNormal();
		testSetCategoriaExcepcion();
		
		testSetDepartamento();
		
		testGetDedicacionTotalNormal();
		
		testNuevaTutoria();

		testBorraTutoria();
		
		testBorraTutorias();
		
		testImparteAsignatura1Normal();
		testImparteAsignatura1Excepcion1();
		testImparteAsignatura1Excepcion2();
		testImparteAsignatura1Excepcion3();
		testImparteAsignatura1Excepcion4();
		testImparteAsignatura1Excepcion5();
		
		testImparteAsignatura2Normal();
		testImparteAsignatura2Excepcion1();
		testImparteAsignatura2Excepcion2();
		testImparteAsignatura2Excepcion3();
		testImparteAsignatura2Excepcion4();
		testImparteAsignatura2Excepcion5();
		
		testDedicacionAsignatura();
		
		testEliminaAsignatura();
	}

	private static void testConstructor1Normal() {
		System.out.println("========Probando el primer constructor======================================================================================");
		testConstructor1("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.es", Categoria.TITULAR);
	}

	private static void testConstructor1Excepcion() {
		System.out.println("\n========Probando el primer constructor siendo menor de edad======================================================================================");
		testConstructor1("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(2000, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR);
	}
	
	private static void testConstructor2Normal() {
		System.out.println("\n========Probando el segundo constructor======================================================================================");
		Departamento dep = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		testConstructor2("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.es", Categoria.TITULAR, dep);
	}

	private static void testConstructor2Excepcion() {
		System.out.println("\n========Probando el segundo constructor siendo menor de edad======================================================================================");
		Departamento dep = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		testConstructor2("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(2000, 3, 15), "juan.nadie@gmail.com", Categoria.TITULAR, dep);
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

	private static void testSetCategoriaNormal() {
		System.out.println("\n========Probando setCategoria======================================================================================");
		Profesor pr = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.es", Categoria.TITULAR);
		testSetCategoria(pr, Categoria.INTERINO);
	}
	
	private static void testSetCategoriaExcepcion() {
		System.out.println("\n========Probando setCategoria en el caso de que se cambie la categoría a ayudante y supere el máximo de créditos que puede impartir el profesor de dicha categoría======================================================================================");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Departamento lsi = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		Profesor pr = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie",LocalDate.of(1950, 3, 15), "juan.nadie@.us.es", Categoria.TITULAR);
		lsi.nuevaAsignatura(fp);
		lsi.nuevoProfesor(pr);
		testImparteAsignatura(fp, 12.0, pr);
		testSetCategoria(pr, Categoria.AYUDANTE);
	}
	
	private static void testSetDepartamento() {
		System.out.println("\n========Probando setDepartamento======================================================================================");
		Departamento dep = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		Departamento dep2 = new DepartamentoImpl("Ingeniería de sistemas y automática");
		Profesor pr = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.es", Categoria.TITULAR, dep);
		testSetDepartamento(pr, dep2);
	}
	
	private static void testGetDedicacionTotalNormal(){
		System.out.println("\n========Probando el método getDedicacionTotal======================================================================================");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Asignatura adda = new AsignaturaImpl("Analisis y Diseño de Datos y Algoritmos", "2050010", 12.0, TipoAsignatura.ANUAL, 2);
		Departamento lsi = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		Profesor pr = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@.us.es", Categoria.TITULAR);
		lsi.nuevaAsignatura(fp);
		lsi.nuevaAsignatura(adda);
		lsi.nuevoProfesor(pr);
		testDedicacionAsignatura(fp, 12.0, lsi, pr);
		testDedicacionAsignatura(adda, 6.0, lsi, pr);
		testGetDedicacionTotal(pr);
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

	private static void testImparteAsignatura1Normal() {
		System.out.println("\n========Probando el método imparteAsignatura en el caso de nuevaAsignatura======================================================================================");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Departamento lsi = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		Profesor pr = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie",LocalDate.of(1950, 3, 15), "juan.nadie@.us.es", Categoria.TITULAR);
		lsi.nuevaAsignatura(fp);
		lsi.nuevoProfesor(pr);
		testImparteAsignatura(fp, 12.0, pr);
	}
	
	private static void testImparteAsignatura1Excepcion1() {
		System.out.println("\n========Probando el método imparteAsignatura en el caso de nuevaAsignatura, añadiendo asignatura que no es del departamento del profesor======================================================================================");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Departamento lsi = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		Profesor pr = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie",LocalDate.of(1950, 3, 15), "juan.nadie@.us.es", Categoria.TITULAR);
		lsi.nuevoProfesor(pr);
		testImparteAsignatura(fp, 12.0, pr);
	}
	
	private static void testImparteAsignatura1Excepcion2() {
		System.out.println("\n========Probando el método imparteAsignatura en el caso de nuevaAsignatura, excediendo el número de créditos de la asignatura======================================================================================");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Departamento lsi = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		Profesor pr = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie",LocalDate.of(1950, 3, 15), "juan.nadie@.us.es", Categoria.TITULAR);
		lsi.nuevaAsignatura(fp);
		lsi.nuevoProfesor(pr);
		testImparteAsignatura(fp, 15.0, pr);
	}
	
	private static void testImparteAsignatura1Excepcion3() {
		System.out.println("\n========Probando el método imparteAsignatura en el caso de nuevaAsignatura, número de créditos igual a 0======================================================================================");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Departamento lsi = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		Profesor pr = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie",LocalDate.of(1950, 3, 15), "juan.nadie@.us.es", Categoria.TITULAR);
		lsi.nuevaAsignatura(fp);
		lsi.nuevoProfesor(pr);
		testImparteAsignatura(fp, 0.0, pr);
	}
	
	private static void testImparteAsignatura1Excepcion4() {
		System.out.println("\n========Probando el método imparteAsignatura en el caso de nuevaAsignatura, con un profesor (que no es tipo ayudante) que imparte más creditos de los permitidos======================================================================================");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Asignatura adda = new AsignaturaImpl("Analisis y Diseño de Datos y Algoritmos", "2050010", 12.0, TipoAsignatura.ANUAL, 2);
		Asignatura ir = new AsignaturaImpl("Ingeniería de Requisitos", "2050020", 9.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 3);
		Departamento lsi = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		Profesor pr = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie",LocalDate.of(1950, 3, 15), "juan.nadie@.us.es", Categoria.TITULAR);		
		lsi.nuevaAsignatura(fp);
		lsi.nuevaAsignatura(adda);
		lsi.nuevaAsignatura(ir);
		lsi.nuevoProfesor(pr);
		pr.imparteAsignatura(fp, 12.0);
		pr.imparteAsignatura(adda, 12.0);
		testImparteAsignatura(ir, 9.0, pr);
	}
	
	private static void testImparteAsignatura1Excepcion5() {
		System.out.println("\n========Probando el método imparteAsignatura en el caso de nuevaAsignatura, con un profesor de tipo 'ayudante' que imparte más creditos de los permitidos======================================================================================");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 3.0, TipoAsignatura.ANUAL, 1);
		Asignatura adda = new AsignaturaImpl("Analisis y Diseño de Datos y Algoritmos", "2050010", 5.0, TipoAsignatura.ANUAL, 2);
		Departamento lsi = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		Profesor pr = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie",LocalDate.of(1950, 3, 15), "juan.nadie@.us.es", Categoria.AYUDANTE);		
		lsi.nuevaAsignatura(fp);
		lsi.nuevaAsignatura(adda);
		lsi.nuevoProfesor(pr);
		pr.imparteAsignatura(fp, 3.0);
		testImparteAsignatura(adda, 5.0, pr);
	}	
	
	private static void testImparteAsignatura2Normal() {
		System.out.println("\n========Probando el método imparteAsignatura en el caso de actualizaDedicacion======================================================================================");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Departamento lsi = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		Profesor pr = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie",LocalDate.of(1950, 3, 15), "juan.nadie@.us.es", Categoria.TITULAR);		
		lsi.nuevaAsignatura(fp);
		lsi.nuevoProfesor(pr);
		pr.imparteAsignatura(fp, 12.0);
		testImparteAsignatura(fp, 10.0, pr);
	}
	
	private static void testImparteAsignatura2Excepcion1() {
		System.out.println("\n========Probando el método imparteAsignatura en el caso de actualizaDedicacion, actualizando la asignatura de manera que no es del departamento del profesor======================================================================================");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Departamento lsi = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		Departamento isa = new DepartamentoImpl("Ingeniería de sistemas y automática");
		Profesor pr = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie",LocalDate.of(1950, 3, 15), "juan.nadie@.us.es", Categoria.TITULAR);		
		lsi.nuevaAsignatura(fp);
		lsi.nuevoProfesor(pr);
		pr.imparteAsignatura(fp, 12.0);
		fp.setDepartamento(isa);
		testImparteAsignatura(fp, 7.0, pr);
	}
	
	private static void testImparteAsignatura2Excepcion2() {
		System.out.println("\n========Probando el método imparteAsignatura en el caso de actualizaDedicacion, excediendo el número de créditos de la asignatura======================================================================================");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Departamento lsi = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		Profesor pr = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie",LocalDate.of(1950, 3, 15), "juan.nadie@.us.es", Categoria.TITULAR);
		lsi.nuevaAsignatura(fp);
		lsi.nuevoProfesor(pr);
		pr.imparteAsignatura(fp, 12.0);
		testImparteAsignatura(fp, 15.0, pr);
	}
	
	private static void testImparteAsignatura2Excepcion3() {
		System.out.println("\n========Probando el método imparteAsignatura en el caso de actualizaDedicacion, número de créditos igual a 0======================================================================================");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Departamento lsi = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		Profesor pr = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie",LocalDate.of(1950, 3, 15), "juan.nadie@.us.es", Categoria.TITULAR);
		lsi.nuevaAsignatura(fp);
		lsi.nuevoProfesor(pr);
		pr.imparteAsignatura(fp, 12.0);
		testImparteAsignatura(fp, 0.0, pr);
	}
	
	private static void testImparteAsignatura2Excepcion4() {
		System.out.println("\n========Probando el método imparteAsignatura en el caso de actualizaDedicacion, con un profesor (que no es tipo ayudante) que imparte más creditos de los permitidos======================================================================================");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 30.0, TipoAsignatura.ANUAL, 1);
		Asignatura adda = new AsignaturaImpl("Analisis y Diseño de Datos y Algoritmos", "2050010", 12.0, TipoAsignatura.ANUAL, 2);
		Departamento lsi = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		Profesor pr = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie",LocalDate.of(1950, 3, 15), "juan.nadie@.us.es", Categoria.TITULAR);		
		lsi.nuevaAsignatura(fp);
		lsi.nuevaAsignatura(adda);
		lsi.nuevoProfesor(pr);
		pr.imparteAsignatura(fp, 25.0);
		pr.imparteAsignatura(adda, 2.0);
		testImparteAsignatura(adda, 8.0, pr);
	}
	
	private static void testImparteAsignatura2Excepcion5() {
		System.out.println("\n========Probando el método imparteAsignatura en el caso de actualizaDedicacion, con un profesor de tipo 'ayudante' que imparte más creditos de los permitidos======================================================================================");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 3.0, TipoAsignatura.ANUAL, 1);
		Asignatura adda = new AsignaturaImpl("Analisis y Diseño de Datos y Algoritmos", "2050010", 6.0, TipoAsignatura.ANUAL, 2);
		Departamento lsi = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		Profesor pr = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie",LocalDate.of(1950, 3, 15), "juan.nadie@.us.es", Categoria.AYUDANTE);		
		lsi.nuevaAsignatura(fp);
		lsi.nuevaAsignatura(adda);
		lsi.nuevoProfesor(pr);
		pr.imparteAsignatura(fp, 3.0);
		pr.imparteAsignatura(adda, 2.0);
		testImparteAsignatura(adda, 4.0, pr);
	}
	
	private static void testDedicacionAsignatura() {
		System.out.println("\n========Probando el método dedicacionAsignatura======================================================================================");
		Asignatura fp=new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Departamento lsi = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		Profesor pr = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@.us.es", Categoria.TITULAR);
		lsi.nuevaAsignatura(fp);
		lsi.nuevoProfesor(pr);
		testDedicacionAsignatura(fp, 12.0, lsi, pr);
	}
	
	private static void testEliminaAsignatura() {
		System.out.println("\n========Probando el método eliminaAsignatura======================================================================================");
		Asignatura fp=new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Departamento lsi = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		Profesor pr = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@.us.es", Categoria.TITULAR);
		lsi.nuevaAsignatura(fp);
		lsi.nuevoProfesor(pr);
		testEliminaAsignatura(fp, 12.0, lsi, pr);
	}


	
	//////////////////////////////////////////////////
	//Métodos auxiliares
	
	private static void testConstructor1(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email, Categoria categoria) {
		try {
			Profesor pr = new ProfesorImpl(dni, nombre, apellidos, fechaNacimiento, email, categoria);
			mostrarProfesor(pr);
		} catch (ExcepcionProfesorNoValido e) {
			System.out.println("Se ha capturado la excepción ExcepcionProfesorNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción inesperada.");
		}
	}
	
	private static void testConstructor2(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email, Categoria categoria, Departamento dep) {
		try {
			Profesor pr = new ProfesorImpl(dni, nombre, apellidos, fechaNacimiento, email, categoria, dep);
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
		try {
			System.out.println("La categoría antes de la operación es: " + pr.getCategoria());
			System.out.println("La nueva categoría es: " + nuevaCategoria);
			pr.setCategoria(nuevaCategoria);
			System.out.println("La categoría después de la operación es: " + pr.getCategoria());
		} catch(ExcepcionProfesorOperacionNoPermitida e){
			System.out.println("Se ha capturado la excepción ExcepcionProfesorOperacionNoPermitida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción inesperada.");
		}
	}
	
	private static void testSetDepartamento(Profesor pr, Departamento dep) {
		System.out.println("El departamento del profesor antes de la operación es: " + pr.getDepartamento());
		System.out.println("El nuevo departamento es: " + dep);
		pr.setDepartamento(dep);
		System.out.println("El departamento del profesor después de la operación es: " + pr.getDepartamento());
	}
	
	private static void testGetDedicacionTotal(Profesor pr) {
		System.out.println("Las asignaturas impartidas por el profesor " + pr.getNombre() + " " + pr.getApellidos() + " son: " + pr.getAsignaturas());
		System.out.println("La dedicación total es: " + pr.getDedicacionTotal());
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
	
	private static void testImparteAsignatura(Asignatura asig, Double dedicacion, Profesor pr) {
		try{
			System.out.println("Asignaturas que imparte el profesor antes de la operación: " +pr.getAsignaturas());
			System.out.println("Créditos totales que imparte el profesor antes de la operación: " + pr.getDedicacionTotal());
			System.out.println("Asignatura a la que se le va a realizar la operación: " + asig);
			System.out.println("Profesor al que se le va a realizar la operación: " + pr);
			System.out.println("Departamento al que pertenece la asignatura: " + asig.getDepartamento());
			System.out.println("Departamento al que pertenece el profesor: " + pr.getDepartamento());
			System.out.println("Créditos de la asignatura: " + asig.getCreditos());
			System.out.println("Créditos que va a impartir el profesor en dicha asignatura: " + dedicacion);
			pr.imparteAsignatura(asig, dedicacion);
			System.out.println("Asignaturas que imparte el profesor después de la operación: " + pr.getAsignaturas());
			System.out.println("Créditos totales que imparte el profesor después de la operación: " + pr.getDedicacionTotal());
		} catch(ExcepcionProfesorOperacionNoPermitida e){
			System.out.println("Se ha capturado la excepción ExcepcionProfesorOperacionNoPermitida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción inesperada.");
		}
	}
	
	private static void testDedicacionAsignatura(Asignatura asig, Double creditos, Departamento dep, Profesor pr) {
		System.out.println("Asignaturas que imparte el profesor antes de la operación: " + pr.getAsignaturas());
		System.out.println("Créditos que imparte el profesor antes de la operación: " + pr.getCreditos());
		System.out.println("Nueva asignatura que va a impartir el profesor: " + asig);
		System.out.println("Créditos que va a impartir el profesor: " + creditos);
		System.out.println("- Añadiendo la asignatura " + asig.getNombre() + " al profesor " + pr.getNombre() + ": ");
		pr.imparteAsignatura(asig, creditos);
		System.out.println("Asignaturas que imparte el profesor después de la operación: " + pr.getAsignaturas());
		System.out.println("Créditos que imparte el profesor después de la operación: " + pr.getCreditos());
		System.out.println("La dedicación en " + asig.getNombre() + " es: " + pr.dedicacionAsignatura(asig));
	}
	
	private static void testEliminaAsignatura(Asignatura asig, Double creditos, Departamento dep, Profesor pr) {
		System.out.println("Asignaturas que imparte el profesor antes de la operación: " + pr.getAsignaturas());
		System.out.println("Créditos que imparte el profesor antes de la operación: " + pr.getCreditos());
		System.out.println("Nueva asignatura que va a impartir el profesor: " + asig);
		System.out.println("Créditos que va a impartir el profesor: " + creditos);
		System.out.println("- Añadiendo la asignatura " + asig.getNombre() + " al profesor " + pr.getNombre() + ": ");
		pr.imparteAsignatura(asig, creditos);
		System.out.println("Asignaturas que imparte el profesor después de la operación: " + pr.getAsignaturas());
		System.out.println("Créditos que imparte el profesor después de la operación: " + pr.getCreditos());
		System.out.println("- Eliminando la asignatura " + asig.getNombre() + ": ");
		pr.eliminaAsignatura(asig);
		System.out.println("Asignaturas que imparte el profesor después de la operación: " + pr.getAsignaturas());
		System.out.println("Créditos que imparte el profesor después de la operación: " + pr.getCreditos());
	}

	private static void mostrarProfesor(Profesor pr) {
		System.out.println("Profesor --> <" + pr + ">");
		System.out.println("\tDNI: <" + pr.getDNI() + ">");
		System.out.println("\tNombre: <" + pr.getNombre() + ">");
		System.out.println("\tApellidos: <" + pr.getApellidos() + ">");
		System.out.println("\tFecha Nacimiento: <" + pr.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ">");
		System.out.println("\tEdad: <" + pr.getEdad() + ">");
		System.out.println("\tEmail: <" + pr.getEmail() + ">");
		System.out.println("\tCategoría: <" + pr.getCategoria() + ">");
		System.out.println("\tTutorias: <" + pr.getTutorias() + ">");
		System.out.println("\tDepartamento: <" + pr.getDepartamento() + ">");
		System.out.println("\tAsignaturas que imparte: <" + pr.getAsignaturas() + ">");
		System.out.println("\tCréditos que imparte: <" + pr.getCreditos() + ">");
	}
}