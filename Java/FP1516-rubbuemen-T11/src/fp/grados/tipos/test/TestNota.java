package fp.grados.tipos.test;

import java.util.List;

import fp.grados.excepciones.ExcepcionNotaNoValida;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Convocatoria;
import fp.grados.tipos.Nota;
import fp.grados.tipos.NotaImpl;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.utiles.Grados;

public class TestNota {
	public static void main(String[] args) {
		testConstructor1Normal();
		testConstructor1Excepcional1();
		testConstructor1Excepcional2();
		
		testConstructor2Normal();
		testConstructor2Excepcional();
		
		testConstructorStringNormal();
		
		testIgualdad();
		testOrden();
	}

	private static void testConstructor1Normal() {
		System.out.println("========Probando el primer constructor======================================================================================");
		Asignatura a = new AsignaturaImpl("Fundamentos de Programaci�n", "0000230", 10.0, TipoAsignatura.ANUAL, 1);
		testConstructor1(a, 2015, Convocatoria.PRIMERA, 9.5, true);
	}
	
	private static void testConstructor1Excepcional1() {
		System.out.println("\n========Probando el primer constructor con un valor fuera del rango======================================================================================");
		Asignatura a = new AsignaturaImpl("Fundamentos de Programaci�n", "0000230", 10.0, TipoAsignatura.ANUAL, 1);
		testConstructor1(a, 2015, Convocatoria.PRIMERA, 12.5, true);
	}
	
	private static void testConstructor1Excepcional2() {
		System.out.println("\n========Probando el primer constructor con una menci�n de honor que no puede ser======================================================================================");
		Asignatura a = new AsignaturaImpl("Fundamentos de Programaci�n", "0000230", 10.0, TipoAsignatura.ANUAL, 1);
		testConstructor1(a, 2015, Convocatoria.PRIMERA, 6.4, true);
	}

	private static void testConstructor2Normal() {
		System.out.println("\n========Probando el segundo constructor======================================================================================");
		Asignatura a = new AsignaturaImpl("Fundamentos de Programaci�n", "0000230", 10.0, TipoAsignatura.ANUAL, 1);
		Nota n = new NotaImpl(a, 2015, Convocatoria.SEGUNDA, 6.5);
		mostrarNota(n);
	}
	
	private static void testConstructor2Excepcional() {
		System.out.println("\n========Probando el segundo constructor con un valor fuera del rango======================================================================================");
		Asignatura a = new AsignaturaImpl("Fundamentos de Programaci�n", "0000230", 10.0, TipoAsignatura.ANUAL, 1);
		testConstructor2(a, 2015, Convocatoria.SEGUNDA, 12.5);
	}
	
	private static void testConstructorStringNormal(){
		System.out.println("\n========Probando el constructor con String======================================================================================");
		List<Nota> notas = Grados.leeFichero("res/notas.txt", s -> new NotaImpl(s));
		testConstructorString(notas);
		//Nota: para hacer saltar una excepci�n, habr�a que modificar el fichero de texto
	}
	
	private static void testIgualdad() {
		System.out.println("\n========Probando igualdad con dos objetos iguales======================================================================================");
		Asignatura a1 = new AsignaturaImpl("Fundamentos de Programaci�n", "0000230", 10.0, TipoAsignatura.ANUAL, 1);
		Asignatura a2 = new AsignaturaImpl("�lgebra Lineal", "0000730", 10.0, TipoAsignatura.ANUAL, 1);
		Nota n1 = new NotaImpl(a1, 2015, Convocatoria.SEGUNDA, 9.4, true);
		Nota n2 = new NotaImpl(a1, 2015, Convocatoria.SEGUNDA, 9.4, true);
		Nota n3 = new NotaImpl(a1, 2014, Convocatoria.SEGUNDA, 9.4, true);
		Nota n4 = new NotaImpl(a2, 2015, Convocatoria.SEGUNDA, 9.4, true);
		Nota n5 = new NotaImpl(a1, 2015, Convocatoria.PRIMERA, 9.4, true);
		System.out.println("C�digo hash del objeto n1 (" + n1 + "): " + n1.hashCode());
		System.out.println("C�digo hash del objeto n2 (" + n2 + "): " + n2.hashCode());
		System.out.println("C�digo hash del objeto n3 (" + n3 + "): " + n3.hashCode());
		System.out.println("C�digo hash del objeto n4 (" + n4 + "): " + n4.hashCode());
		System.out.println("C�digo hash del objeto n5 (" + n5 + "): " + n5.hashCode());
		System.out.println("�Es n1 igual a n2? (debe ser true): " + n1.equals(n2));
		System.out.println("�Es n1 distinto de n3? (debe ser true): " + !n1.equals(n3));
		System.out.println("�Es n1 distinto de n4? (debe ser true): " + !n1.equals(n4));
		System.out.println("�Es n1 distinto de n5? (debe ser true): " + !n1.equals(n5));
	}

	private static void testOrden() {
		System.out.println("\n========Probando orden natural======================================================================================");
		Asignatura a = new AsignaturaImpl("Fundamentos de Programaci�n", "0000230", 10.0, TipoAsignatura.ANUAL, 1);
		Nota menor = new NotaImpl(a, 2014, Convocatoria.SEGUNDA, 9.4, true);
		Nota igual1 = new NotaImpl(a, 2015, Convocatoria.PRIMERA, 9.4, true);
		Nota igual2 = new NotaImpl(a, 2015, Convocatoria.PRIMERA, 9.4, true);
		Nota mayor = new NotaImpl(a, 2015, Convocatoria.SEGUNDA, 9.4, true);
		System.out.println("- Debe ser ANTES: ");
		compara(menor, igual1);
		System.out.println("- Debe ser MISMA POSICI�N: ");
		compara(igual1, igual2);
		System.out.println("- Debe ser DESPU�S: ");
		compara(mayor, igual2);
	}

	
	
	//////////////////////////////////////////////////
	//M�todos auxiliares
	
	private static void testConstructor1(Asignatura asignatura, Integer cursoAcademico, Convocatoria convocatoria, Double valor, Boolean mencionHonor) {
		try {
			Nota n = new NotaImpl(asignatura, cursoAcademico, convocatoria, valor, mencionHonor);
			mostrarNota(n);
		} catch (ExcepcionNotaNoValida e) {
			System.out.println("Se ha capturado la excepci�n ExcepcionNotaNoValida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepci�n insesperada.");
		}
	}
	
	private static void testConstructor2(Asignatura asignatura, Integer cursoAcademico, Convocatoria convocatoria, Double valor) {
		try {
			Nota n = new NotaImpl(asignatura, cursoAcademico, convocatoria, valor);
			mostrarNota(n);
		} catch (ExcepcionNotaNoValida e) {
			System.out.println("Se ha capturado la excepci�n ExcepcionNotaNoValida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepci�n insesperada.");
		}
	}
	
	private static void testConstructorString(List<Nota> notas){
		for (Nota n : notas) {
			try {
				mostrarNota(n);
			} catch (ExcepcionNotaNoValida e) {
				System.out.println("Se ha capturado la excepci�n ExcepcionNotaNoValida: \n\t" + e.getMessage());
			} catch (Exception e) {
				System.out.println("Se ha capturado una excepci�n inesperada.");
			}
		}
	}
	
	private static void compara(Nota n1, Nota n2) {
		System.out.print("El objeto <" + n1 + ">");
		if (n1.compareTo(n2) < 0) {
			System.out.print(" va ANTES que el objeto ");
		} else if (n1.compareTo(n2) > 0) {
			System.out.print(" va DESPU�S que el objeto ");
		} else {
			System.out.print(" va en la MISMA POSICI�N que el objeto ");
		}
		System.out.println("<" + n2 + ">");
	}
	
	private static void mostrarNota(Nota n) {
		System.out.println("Nota--> <" + n + ">");
		System.out.println("\tAsignatura: <" + n.getAsignatura() + ">");
		System.out.println("\tCurso academico: <" + n.getCursoAcademico() + "-" + Integer.toString(n.getCursoAcademico()+1).substring(2,4) + ">");
		System.out.println("\tConvocatoria: <" + n.getConvocatoria() + ">");
		System.out.println("\tValor: <" + n.getValor() + ">");
		System.out.println("\tMenci�n de honor: <" + n.getMencionHonor() + ">");
		System.out.println("\tCalificaci�n: <" + n.getCalificacion() + ">");
	}
}