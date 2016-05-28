package fp.grados.tipos.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import fp.grados.excepciones.ExcepcionAlumnoNoValido;
import fp.grados.excepciones.ExcepcionAlumnoOperacionNoPermitida;
import fp.grados.tipos.Alumno;
import fp.grados.tipos.AlumnoImpl;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Convocatoria;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.utiles.Grados;

public class TestAlumno {
	public static void main(String[] args) {
		testConstructorNormal();
		testConstructorExcepcion();
		
		testConstructorStringNormal();
		
		testMetodoCreacionalParametrosNormal();
		
		testMetodoCreacionalCopiaNormal();
		
		testMetodoCreacionalStringNormal();
		
		testMetodoCreacionalFicheroNormal();
		
		testSetEmailNormal();
		testSetEmailExcepcion();
		
		testGetCurso1();
		testGetCurso2();

		testMatriculaAsignaturaNormal();
		testMatriculaAsignaturaExcepcion();

		testEliminaAsignaturaNormal();
		testEliminaAsignaturaExcepcion();
		
		testEvaluaAlumno1Normal();
		testEvaluaAlumno1Excepcion();
		
		testEvaluaAlumno2Normal();
		testEvaluaAlumno2Excepcion();
		
		testGetCalificacionPorAsignatura();
		
		testMetodosPoblacionales();
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
		List<Alumno> alumnos = Grados.leeFichero("res/alumnos.txt", s -> new AlumnoImpl(s));
		testConstructorString(alumnos);
		//Nota: para hacer saltar una excepci�n, habr�a que modificar el fichero de texto
	}
	
	private static void testMetodoCreacionalParametrosNormal() {
		System.out.println("\n========Probando m�todo creacional por par�metros======================================================================================");
		testMetodoCreacionalParametros("12345678Z", "Pepito", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		//Nota: para hacer saltar la excepci�n, habr�a que modificar los datos
	}
	
	private static void testMetodoCreacionalCopiaNormal() {
		System.out.println("\n========Probando m�todo creacional por copia======================================================================================");
		Alumno a = new AlumnoImpl("12345678Z", "Pepita", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		testMetodoCreacionalCopia(a, fp, 2015, Convocatoria.PRIMERA, 9.5, true);
		//Nota: para hacer saltar la excepci�n, habr�a que modificar los datos
	}
	
	private static void testMetodoCreacionalStringNormal() {
		System.out.println("\n========Probando m�todo creacional por string======================================================================================");
		testMetodoCreacionalString("12345678Z,Hector,Lopez Garcia,20/7/1998,juan@alum.us.es");
		//Nota: para hacer saltar la excepci�n, habr�a que modificar los datos
	}

	private static void testMetodoCreacionalFicheroNormal(){
		System.out.println("\n========Probando m�todo creacional con fichero======================================================================================");
		testMetodoCreacionalFichero("res/alumnos.txt");
		//Nota: para hacer saltar una excepci�n, habr�a que modificar el fichero de texto
	}

	private static void testSetEmailNormal() {
		System.out.println("\n========Probando setEmail======================================================================================");
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		testSetEmail(a, "juan@alum.us.es");
	}

	private static void testSetEmailExcepcion() {
		System.out.println("\n========Probando setEmail, email incorrecto======================================================================================");
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		testSetEmail(a, "juan@gmail.com");
	}
	
	private static void testGetCurso1() {
		System.out.println("\n========Probando el m�todo getCurso para un alumno con asignaturas matriculadas======================================================================================");
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Asignatura adda = new AsignaturaImpl("Analisis y Dise�o de Datos y Algoritmos", "2050010", 12.0, TipoAsignatura.ANUAL, 2);
		testMatriculaAsignatura(a, fp);
		testMatriculaAsignatura(a, adda);
		testGetCurso(a);
	}
	
	private static void testGetCurso2() {
		System.out.println("\n========Probando el m�todo getCurso para un alumno sin asignaturas matriculadas======================================================================================");
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		testGetCurso(a);
	}

	private static void testMatriculaAsignaturaNormal() {
		System.out.println("\n========Probando matriculaAsignatura======================================================================================");
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15),"juan.nadie@alum.us.es");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programaci�n", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		testMatriculaAsignatura(a, asig);
	}

	private static void testMatriculaAsignaturaExcepcion() {
		System.out.println("\n========Probando matriculaAsignatura, matricula doble en una asignatura======================================================================================");
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15),"juan.nadie@alum.us.es");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programaci�n", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		a.matriculaAsignatura(asig);
		testMatriculaAsignatura(a, asig);
	}

	private static void testEliminaAsignaturaNormal() {
		System.out.println("\n========Probando eliminaAsignatura======================================================================================");
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programaci�n", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		a.matriculaAsignatura(asig);
		testEliminaAsignatura(a, asig);
	}

	private static void testEliminaAsignaturaExcepcion() {
		System.out.println("\n========Probando eliminaAsignatura, asignatura no matriculada======================================================================================");
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programaci�n", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		testEliminaAsignatura(a, asig);
	}
	
	private static void testEvaluaAlumno1Normal() {
		System.out.println("\n========Probando el m�todo evaluaAlumno1======================================================================================");
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		a.matriculaAsignatura(fp);
		testEvaluaAlumno1(a, fp, 2015, Convocatoria.PRIMERA, 9.5);
	}
	
	private static void testEvaluaAlumno1Excepcion() {
		System.out.println("\n========Probando el m�todo evaluaAlumno1 de un alumno que no est� matriculado en la asignatura");
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		testEvaluaAlumno1(a, fp, 2015, Convocatoria.PRIMERA, 9.5);
	}
	
	private static void testEvaluaAlumno2Normal() {
		System.out.println("\n========Probando el m�todo evaluaAlumno2======================================================================================");
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		a.matriculaAsignatura(fp);
		testEvaluaAlumno2(a, fp, 2015, Convocatoria.PRIMERA, 9.5, true);
	}
	
	private static void testEvaluaAlumno2Excepcion() {
		System.out.println("\n========Probando el m�todo evaluaAlumno2 de un alumno que no est� matriculado en la asignatura");
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		testEvaluaAlumno2(a, fp, 2015, Convocatoria.PRIMERA, 9.5, true);
	}
	
	private static void testGetCalificacionPorAsignatura() {
		System.out.println("\n========Probando el m�todo getCalificacionPorAsignatura()======================================================================================");
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Asignatura adda = new AsignaturaImpl("Analisis y Dise�o de Datos y Algoritmos", "2050010", 12.0, TipoAsignatura.ANUAL, 2);
		Asignatura ir = new AsignaturaImpl("Ingenier�a de Requisitos", "2050020", 9.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 3);
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
	
	private static void testMetodosPoblacionales() {
		System.out.println("\n========Probando m�todos poblacionales======================================================================================");
		System.out.println("N�mero de alumnos creados: " + Grados.getNumAlumnosCreados());
		System.out.println("Alumnos creados: " + Grados.getAlumnosCreados());
	}
	
	
	
	//////////////////////////////////////////////////
	//M�todos auxiliares
	
	private static void testConstructor(String dni, String nombre, String apellidos, LocalDate fechaNacimiento,	String email) {
		try {
			Alumno a = new AlumnoImpl(dni, nombre, apellidos, fechaNacimiento, email);
			mostrarAlumno(a);
		} catch (ExcepcionAlumnoNoValido e) {
			System.out.println("Se ha capturado la excepci�n ExcepcionAlumnoNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepci�n inesperada.");
		}
	}
	
	private static void testConstructorString(List<Alumno> alumnos){
		for (Alumno a : alumnos) {
			try {
				mostrarAlumno(a);
			} catch (ExcepcionAlumnoNoValido e) {
				System.out.println("Se ha capturado la excepci�n ExcepcionAlumnoNoValido: \n\t" + e.getMessage());
			} catch (Exception e) {
				System.out.println("Se ha capturado una excepci�n inesperada.");
			}
		}
	}
	
	private static void testMetodoCreacionalParametros(String dni, String nombre, String apellidos, LocalDate fechaNacimiento,	String email) {
		try {
			Alumno a = Grados.createAlumno(dni, nombre, apellidos, fechaNacimiento, email);
			mostrarAlumno(a);
		} catch (ExcepcionAlumnoNoValido e) {
			System.out.println("Se ha capturado la excepci�n ExcepcionAlumnoNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepci�n inesperada.");
		}
	}
	
	private static void testMetodoCreacionalCopia(Alumno a, Asignatura asig, Integer curso, Convocatoria convocatoria, Double nota, Boolean mencionHonor) {
		try {
			a.matriculaAsignatura(asig);
			a.evaluaAlumno(asig, curso, convocatoria, nota, mencionHonor);
			Alumno res = Grados.createAlumno(a);
			mostrarAlumno(res);
		} catch (ExcepcionAlumnoNoValido e) {
			System.out.println("Se ha capturado la excepci�n ExcepcionAlumnoNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepci�n inesperada.");
		}
	}
	
	private static void testMetodoCreacionalString(String a) {
		try {
			Alumno res = Grados.createAlumno(a);
			mostrarAlumno(res);
		} catch (ExcepcionAlumnoNoValido e) {
			System.out.println("Se ha capturado la excepci�n ExcepcionAlumnoNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepci�n inesperada.");
		}
	}
	
	private static void testMetodoCreacionalFichero(String fichero) {
		List<Alumno> alumnos = Grados.createAlumnos(fichero);
		for (Alumno a : alumnos) {
			mostrarAlumno(a);
		}
	}

	private static void testSetEmail(Alumno a, String nuevoEmail) {
		try {
			System.out.println("El email antes de la operaci�n es: " + a.getEmail());
			System.out.println("El nuevo email es: " + nuevoEmail);
			a.setEmail(nuevoEmail);
			System.out.println("El email despu�s de la operaci�n es: " + a.getEmail());
		} catch (ExcepcionAlumnoNoValido e) {
			System.out.println("Se ha capturado la excepci�n ExcepcionAlumnoNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepci�n inesperada.");
		}
	}
	
	private static void testGetCurso(Alumno a) {
		System.out.println("Las asignaturas del alumno " + a.getNombre() + " " + a.getApellidos() + " son: " + a.getAsignaturas());
		System.out.println("El curso de este alumno es: " + a.getCurso());
	}

	private static void testMatriculaAsignatura(Alumno a, Asignatura asig) {
		try {
			System.out.println("Las asignaturas antes de la operaci�n son: " + a.getAsignaturas());
			System.out.println("Nueva asignatura a matricular: " + asig);
			a.matriculaAsignatura(asig);
			System.out.println("Las asignaturas despu�s de la operaci�n son: " + a.getAsignaturas());
		} catch (ExcepcionAlumnoOperacionNoPermitida e) {
			System.out.println("Se ha capturado la excepci�n ExcepcionAlumnoOperacionNoPermitida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepci�n inesperada.");
		}
	}

	private static void testEliminaAsignatura(Alumno a, Asignatura asig) {
		try {
			System.out.println("Las asignaturas antes de la operaci�n son: " + a.getAsignaturas());
			System.out.println("Asignatura a eliminar: " + asig);
			a.eliminaAsignatura(asig);
			System.out.println("Las asignaturas despu�s de la operaci�n son: " + a.getAsignaturas());
		} catch (ExcepcionAlumnoOperacionNoPermitida e) {
			System.out.println("Se ha capturado la excepci�n ExcepcionAlumnoOperacionNoPermitida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepci�n inesperada.");
		}
	}
	
	private static void testEvaluaAlumno1(Alumno a, Asignatura asig, Integer curso, Convocatoria convocatoria, Double nota) {
		try {
			System.out.println("Las asignaturas del alumno son: " + a.getAsignaturas());
			System.out.println("Asignatura a la que se va a a�adir una nota: " + asig);
			System.out.println("El expediente del alumno antes de la operaci�n es: " + a.getExpediente());
			a.evaluaAlumno(asig, curso, convocatoria, nota);
			System.out.println("El expediente del alumno despu�s de la operaci�n es: " + a.getExpediente());
		} catch (ExcepcionAlumnoOperacionNoPermitida e) {
			System.out.println("Se ha capturado la excepci�n ExcepcionAlumnoOperacionNoPermitida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepci�n inesperada.");
		}
	}
	
	private static void testEvaluaAlumno2(Alumno a, Asignatura asig, Integer curso, Convocatoria convocatoria, Double nota, Boolean mencionHonor) {
		try {
			System.out.println("Las asignaturas del alumno son: " + a.getAsignaturas());
			System.out.println("Asignatura a la que se va a a�adir una nota: " + asig);
			System.out.println("El expediente del alumno antes de la operaci�n es: " + a.getExpediente());
			a.evaluaAlumno(asig, curso, convocatoria, nota, mencionHonor);
			System.out.println("El expediente del alumno despu�s de la operaci�n es: " + a.getExpediente());
		} catch (ExcepcionAlumnoOperacionNoPermitida e) {
			System.out.println("Se ha capturado la excepci�n ExcepcionAlumnoOperacionNoPermitida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepci�n inesperada.");
		}
	}
	
	private static void testGetCalificacionPorAsignatura(Alumno a) {
		System.out.println("Las asignaturas del alumno " + a.getNombre() + " " + a.getApellidos() + " son: " + a.getAsignaturas());
		System.out.println("Las notas del expediente del alumno es: " + a.getExpediente().getNotas());
		System.out.println("Las calificaciones m�ximas por asignaturas del alumno son: " + a.getCalificacionPorAsignatura());
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