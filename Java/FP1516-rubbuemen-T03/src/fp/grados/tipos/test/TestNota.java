package fp.grados.tipos.test;

import fp.grados.excepciones.ExcepcionNotaNoValida;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Convocatoria;
import fp.grados.tipos.Nota;
import fp.grados.tipos.NotaImpl;
import fp.grados.tipos.TipoAsignatura;

public class TestNota {
	public static void main(String[] args) {
		testConstructor1Normal();
		testConstructor1Excepcional1();
		testConstructor1Excepcional2();
		
		testConstructor2Normal();
		testConstructor2Excepcional();
	}

	private static void testConstructor1Normal() {
		System.out.println("========Probando el primer constructor======================================================================================");
		Asignatura a = new AsignaturaImpl("Fundamentos de Programación", "0000230", 10.0, TipoAsignatura.ANUAL, 1);
		testConstructor1(a, 2015, Convocatoria.PRIMERA, 9.5, true);
	}
	
	private static void testConstructor1Excepcional1() {
		System.out.println("\n========Probando el primer constructor con un valor fuera del rango======================================================================================");
		Asignatura a = new AsignaturaImpl("Fundamentos de Programación", "0000230", 10.0, TipoAsignatura.ANUAL, 1);
		testConstructor1(a, 2015, Convocatoria.PRIMERA, 12.5, true);
	}
	
	private static void testConstructor1Excepcional2() {
		System.out.println("\n========Probando el primer constructor con una mención de honor que no puede ser======================================================================================");
		Asignatura a = new AsignaturaImpl("Fundamentos de Programación", "0000230", 10.0, TipoAsignatura.ANUAL, 1);
		testConstructor1(a, 2015, Convocatoria.PRIMERA, 6.4, true);
	}

	private static void testConstructor2Normal() {
		System.out.println("\n========Probando el segundo constructor======================================================================================");
		Asignatura a = new AsignaturaImpl("Fundamentos de Programación", "0000230", 10.0, TipoAsignatura.ANUAL, 1);
		Nota n = new NotaImpl(a, 2015, Convocatoria.SEGUNDA, 6.5);
		mostrarNota(n);
	}
	
	private static void testConstructor2Excepcional() {
		System.out.println("\n========Probando el segundo constructor con un valor fuera del rango======================================================================================");
		Asignatura a = new AsignaturaImpl("Fundamentos de Programación", "0000230", 10.0, TipoAsignatura.ANUAL, 1);
		testConstructor2(a, 2015, Convocatoria.SEGUNDA, 12.5);
	}

	
	
	//////////////////////////////////////////////////
	//Métodos auxiliares
	
	private static void testConstructor1(Asignatura asignatura, Integer cursoAcademico, Convocatoria convocatoria, Double valor, Boolean mencionHonor) {
		try {
			Nota n = new NotaImpl(asignatura, cursoAcademico, convocatoria, valor, mencionHonor);
			mostrarNota(n);
		} catch (ExcepcionNotaNoValida e) {
			System.out.println("Se ha capturado la excepción ExcepcionNotaNoValida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción insesperada.");
		}
	}
	
	private static void testConstructor2(Asignatura asignatura, Integer cursoAcademico, Convocatoria convocatoria, Double valor) {
		try {
			Nota n = new NotaImpl(asignatura, cursoAcademico, convocatoria, valor);
			mostrarNota(n);
		} catch (ExcepcionNotaNoValida e) {
			System.out.println("Se ha capturado la excepción ExcepcionNotaNoValida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción insesperada.");
		}
	}
	
	private static void mostrarNota(Nota n) {
		System.out.println("Nota--> <" + n + ">");
		System.out.println("\tAsignatura: <" + n.getAsignatura() + ">");
		System.out.println("\tCurso academico: <" + n.getCursoAcademico() + "-" + Integer.toString(n.getCursoAcademico()+1).substring(2,4) + ">");
		System.out.println("\tConvocatoria: <" + n.getConvocatoria() + ">");
		System.out.println("\tValor: <" + n.getValor() + ">");
		System.out.println("\tMención de honor: <" + n.getMencionHonor() + ">");
		System.out.println("\tCalificación: <" + n.getCalificacion() + ">");
	}
}