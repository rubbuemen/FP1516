package fp.grados.tipos.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import fp.grados.excepciones.ExcepcionAlumnoNoValido;
import fp.grados.excepciones.ExcepcionAlumnoOperacionNoPermitida;
import fp.grados.tipos.Alumno;
import fp.grados.tipos.AlumnoImpl2;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Convocatoria;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.utiles.Grados;

public class TestAlumno2 {
	public static void main(String[] args) {
		testConstructorNormal();
		testConstructorExcepcion();
		
		testConstructorStringNormal();
		
		testMetodoCreacionalParametrosNormal();
		
		testMetodoCreacionalCopiaNormal();
		
		testMetodoCreacionalStringNormal();
		
		testMetodoCreacionalFicheroNormal();
		
		testGetCurso1();
		testGetCurso2();
		
		testGetCalificacionPorAsignatura();
	}

	private static void testConstructorNormal() {
		System.out.println("========Probando el primer constructor======================================================================================");
		testConstructor("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
	}

	private static void testConstructorExcepcion() {
		System.out.println("\n========Probando el primer constructor, email incorrecto======================================================================================");
		testConstructor("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
	}
	
	private static void testConstructorStringNormal(){
		System.out.println("\n========Probando el constructor con String======================================================================================");
		List<Alumno> alumnos = Grados.leeFichero("res/alumnos.txt", s -> new AlumnoImpl2(s));
		testConstructorString(alumnos);
		//Nota: para hacer saltar una excepción, habría que modificar el fichero de texto
	}
	
	private static void testMetodoCreacionalParametrosNormal() {
		System.out.println("\n========Probando método creacional por parámetros======================================================================================");
		testMetodoCreacionalParametros("12345678Z", "Pepito", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		//Nota: para hacer saltar la excepción, habría que modificar los datos
	}
	
	private static void testMetodoCreacionalCopiaNormal() {
		System.out.println("\n========Probando método creacional por copia======================================================================================");
		Alumno a = new AlumnoImpl2("12345678Z", "Pepita", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		testMetodoCreacionalCopia(a, fp, 2015, Convocatoria.PRIMERA, 9.5, true);
		//Nota: para hacer saltar la excepción, habría que modificar los datos
	}
	
	private static void testMetodoCreacionalStringNormal() {
		System.out.println("\n========Probando método creacional por string======================================================================================");
		testMetodoCreacionalString("12345678Z,Hector,Lopez Garcia,20/7/1998,juan@alum.us.es");
		//Nota: para hacer saltar la excepción, habría que modificar los datos
	}

	private static void testMetodoCreacionalFicheroNormal(){
		System.out.println("\n========Probando método creacional con fichero======================================================================================");
		testMetodoCreacionalFichero("res/alumnos.txt");
		//Nota: para hacer saltar una excepción, habría que modificar el fichero de texto
	}
	
	private static void testGetCurso1() {
		System.out.println("\n========Probando el método getCurso para un alumno con asignaturas matriculadas======================================================================================");
		Alumno a = new AlumnoImpl2("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Asignatura adda = new AsignaturaImpl("Analisis y Diseño de Datos y Algoritmos", "2050010", 12.0, TipoAsignatura.ANUAL, 2);
		testMatriculaAsignatura(a, fp);
		testMatriculaAsignatura(a, adda);
		testGetCurso(a);
	}
	
	private static void testGetCurso2() {
		System.out.println("\n========Probando el método getCurso para un alumno sin asignaturas matriculadas======================================================================================");
		Alumno a = new AlumnoImpl2("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		testGetCurso(a);
	}
	
	private static void testGetCalificacionPorAsignatura() {
		System.out.println("\n========Probando el método getCalificacionPorAsignatura()======================================================================================");
		Alumno a = new AlumnoImpl2("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Asignatura adda = new AsignaturaImpl("Analisis y Diseño de Datos y Algoritmos", "2050010", 12.0, TipoAsignatura.ANUAL, 2);
		Asignatura ir = new AsignaturaImpl("Ingeniería de Requisitos", "2050020", 9.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 3);
		a.matriculaAsignatura(fp);
		a.matriculaAsignatura(adda);
		a.matriculaAsignatura(ir);
		a.evaluaAlumno(fp, 2015, Convocatoria.PRIMERA, 6.5);
		a.evaluaAlumno(fp, 2015, Convocatoria.SEGUNDA, 1.5);
		a.evaluaAlumno(adda, 2015, Convocatoria.SEGUNDA, 0.5);
		a.evaluaAlumno(adda, 2015, Convocatoria.PRIMERA, 8.5);
		a.evaluaAlumno(ir, 2015, Convocatoria.PRIMERA, 10.0);
		a.evaluaAlumno(ir, 2015, Convocatoria.SEGUNDA, 1.5);
		testGetCalificacionPorAsignatura(a);
	}
	
	
	
	//////////////////////////////////////////////////
	//Métodos auxiliares
	
	private static void testConstructor(String dni, String nombre, String apellidos, LocalDate fechaNacimiento,	String email) {
		try {
			Alumno a = new AlumnoImpl2(dni, nombre, apellidos, fechaNacimiento, email);
			mostrarAlumno(a);
		} catch (ExcepcionAlumnoNoValido e) {
			System.out.println("Se ha capturado la excepción ExcepcionAlumnoNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción inesperada.");
		}
	}
	
	private static void testConstructorString(List<Alumno> alumnos){
		for (Alumno a : alumnos) {
			try {
				mostrarAlumno(a);
			} catch (ExcepcionAlumnoNoValido e) {
				System.out.println("Se ha capturado la excepción ExcepcionAlumnoNoValido: \n\t" + e.getMessage());
			} catch (Exception e) {
				System.out.println("Se ha capturado una excepción inesperada.");
			}
		}
	}
	
	private static void testMetodoCreacionalParametros(String dni, String nombre, String apellidos, LocalDate fechaNacimiento,	String email) {
		try {
			Grados.setUsarJava8(true);
			Alumno a = Grados.createAlumno(dni, nombre, apellidos, fechaNacimiento, email);
			mostrarAlumno(a);
		} catch (ExcepcionAlumnoNoValido e) {
			System.out.println("Se ha capturado la excepción ExcepcionAlumnoNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción inesperada.");
		}
	}
	
	private static void testMetodoCreacionalCopia(Alumno a, Asignatura asig, Integer curso, Convocatoria convocatoria, Double nota, Boolean mencionHonor) {
		try {
			Grados.setUsarJava8(true);
			a.matriculaAsignatura(asig);
			a.evaluaAlumno(asig, curso, convocatoria, nota, mencionHonor);
			Alumno res = Grados.createAlumno(a);
			mostrarAlumno(res);
		} catch (ExcepcionAlumnoNoValido e) {
			System.out.println("Se ha capturado la excepción ExcepcionAlumnoNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción inesperada.");
		}
	}
	
	private static void testMetodoCreacionalString(String a) {
		try {
			Grados.setUsarJava8(true);
			Alumno res = Grados.createAlumno(a);
			mostrarAlumno(res);
		} catch (ExcepcionAlumnoNoValido e) {
			System.out.println("Se ha capturado la excepción ExcepcionAlumnoNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción inesperada.");
		}
	}
	
	private static void testMetodoCreacionalFichero(String fichero) {
		List<Alumno> alumnos = Grados.createAlumnos(fichero);
		for (Alumno a : alumnos) {
			mostrarAlumno(a);
		}
	}
	
	private static void testGetCurso(Alumno a) {
		System.out.println("Las asignaturas del alumno " + a.getNombre() + " " + a.getApellidos() + " son: " + a.getAsignaturas());
		System.out.println("El curso de este alumno es: " + a.getCurso());
	}

	private static void testMatriculaAsignatura(Alumno a, Asignatura asig) {
		try {
			System.out.println("Las asignaturas antes de la operación son: " + a.getAsignaturas());
			System.out.println("Nueva asignatura a matricular: " + asig);
			a.matriculaAsignatura(asig);
			System.out.println("Las asignaturas después de la operación son: " + a.getAsignaturas());
		} catch (ExcepcionAlumnoOperacionNoPermitida e) {
			System.out.println("Se ha capturado la excepción ExcepcionAlumnoOperacionNoPermitida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción inesperada.");
		}
	}
	
	private static void testGetCalificacionPorAsignatura(Alumno a) {
		System.out.println("Las asignaturas del alumno " + a.getNombre() + " " + a.getApellidos() + " son: " + a.getAsignaturas());
		System.out.println("Las notas del expediente del alumno es: " + a.getExpediente().getNotas());
		System.out.println("Las calificaciones máximas por asignaturas del alumno son: " + a.getCalificacionPorAsignatura());
	}

	private static void mostrarAlumno(Alumno a) {
		System.out.println("Alumno --> <" + a + ">");
		System.out.println("\tDNI: <" + a.getDNI() + ">");
		System.out.println("\tNombre: <" + a.getNombre() + ">");
		System.out.println("\tApellidos: <" + a.getApellidos() + ">");
		System.out.println("\tFecha Nacimiento: <" + a.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ">");
		System.out.println("\tEdad: <" + a.getEdad() + ">");
		System.out.println("\tEmail:  <" + a.getEmail() + ">");
		System.out.println("\tAsignaturas:  <" + a.getAsignaturas() + ">");
		System.out.println("\tExpediente:  <" + a.getExpediente() + ">");
	}
}