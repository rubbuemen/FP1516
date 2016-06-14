package fp.grados.tipos.test;

import fp.grados.excepciones.ExcepcionAsignaturaNoValida;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.TipoAsignatura;

public class TestAsignatura {
	public static void main(String[] args) {
		testConstructorNormal();
		testConstructorExcepcion1();
		testConstructorExcepcion2();
		testConstructorExcepcion3();
		testConstructorExcepcion4();
		testConstructorExcepcion5();
		testConstructorExcepcion6();
		testConstructorExcepcion7();

		testIgualdad();
		testOrden();
	}

	private static void testConstructorNormal() {
		System.out.println("========Probando el constructor======================================================================================");
		testConstructor("Fundamentos de Programaci�n", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
	}

	private static void testConstructorExcepcion1() {
		System.out.println("\n========Probando el constructor, c�digo de asignatura m�s largo======================================================================================");
		testConstructor("Fundamentos de Programaci�n", "20500010", 12.0, TipoAsignatura.ANUAL, 1);
	}

	private static void testConstructorExcepcion2() {
		System.out.println("\n========Probando el constructor, c�digo de asignatura m�s corto======================================================================================");
		testConstructor("Fundamentos de Programaci�n", "205000", 12.0, TipoAsignatura.ANUAL, 1);
	}

	private static void testConstructorExcepcion3() {
		System.out.println("\n========Probando el constructor, c�digo de asignatura no num�rico======================================================================================");
		testConstructor("Fundamentos de Programaci�n", "2A50001", 12.0, TipoAsignatura.ANUAL, 1);
	}

	private static void testConstructorExcepcion4() {
		System.out.println("\n========Probando el constructor, cr�ditos incorrectos (0.0)======================================================================================");
		testConstructor("Fundamentos de Programaci�n", "2050001", 0.0, TipoAsignatura.ANUAL, 1);
	}

	private static void testConstructorExcepcion5() {
		System.out.println("\n========Probando el constructor, cr�ditos incorrectos (-1.0)======================================================================================");
		testConstructor("Fundamentos de Programaci�n", "2050001", -1.0, TipoAsignatura.ANUAL, 1);
	}

	private static void testConstructorExcepcion6() {
		System.out.println("\n========Probando el constructor, curso menor de 1======================================================================================");
		testConstructor("Fundamentos de Programaci�n", "2050001", 12.0, TipoAsignatura.ANUAL, -2);
	}

	private static void testConstructorExcepcion7() {
		System.out.println("\n========Probando el constructor, curso mayor de 4======================================================================================");
		testConstructor("Fundamentos de Programaci�n", "2050001", 12.0, TipoAsignatura.ANUAL, 5);
	}
	
	private static void testIgualdad() {
		System.out.println("\n========Probando igualdad======================================================================================");
		Asignatura a1 = new AsignaturaImpl("Fundamentos de Programaci�n", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Asignatura a2 = new AsignaturaImpl("Fundamentos de Programaci�n", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Asignatura a3 = new AsignaturaImpl("Estructura de Computadores", "2050009", 6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1);
		System.out.println("C�digo hash del objeto a1 (" + a1 + "): " + a1.hashCode());
		System.out.println("C�digo hash del objeto a2 (" + a2 + "): " + a2.hashCode());
		System.out.println("C�digo hash del objeto a3 (" + a3 + "): " + a3.hashCode());
		System.out.println("�Es a1 igual a a2? (debe ser true): " + a1.equals(a2));
		System.out.println("�Es a1 distinto de a3? (debe ser true): " + !a1.equals(a3));
	}
	
	private static void testOrden() {
		System.out.println("\n========Probando orden natural======================================================================================");
		Asignatura menor = new AsignaturaImpl("Fundamentos de Programaci�n", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Asignatura igual1 = new AsignaturaImpl("Estructura de Computadores", "2050009", 6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1);
		Asignatura igual2 = new AsignaturaImpl("Estructura de Computadores", "2050009", 6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1);
		Asignatura mayor = new AsignaturaImpl("Ingenier�a de Requisitos", "2050020", 6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 3);
		System.out.println("- Debe ser ANTES: ");
		compara(menor, igual1);
		System.out.println("- Debe ser MISMA POSICI�N: ");
		compara(igual1, igual2);
		System.out.println("- Debe ser DESPU�S: ");
		compara(mayor, igual2);
	}


	
	//////////////////////////////////////////////////
	//M�todos auxiliares
	
	private static void testConstructor(String nombre, String codigo, Double creditos, TipoAsignatura tipo, Integer curso) {
		try {
			Asignatura a = new AsignaturaImpl(nombre, codigo, creditos, tipo, curso);
			mostrarAsignatura(a);
		} catch (ExcepcionAsignaturaNoValida e) {
			System.out.println("Se ha capturado la excepci�n ExcepcionAsignaturaNoValida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepci�n insesperada.");
		}
	}
	
	private static void compara(Asignatura a1, Asignatura a2) {
		System.out.print("El objeto <" + a1 + ">");
		if (a1.compareTo(a2) < 0) {
			System.out.print(" va ANTES que el objeto ");
		} else if (a1.compareTo(a2) > 0) {
			System.out.print(" va DESPU�S que el objeto ");
		} else {
			System.out.print(" va en la MISMA POSICI�N que el objeto ");
		}
		System.out.println("<" + a2 + ">");
	}

	private static void mostrarAsignatura(Asignatura a) {
		System.out.println("Asignatura --> <" + a + ">");
		System.out.println("\tNombre: <" + a.getNombre() + ">");
		System.out.println("\tC�digo: <" + a.getCodigo() + ">");
		System.out.println("\tCr�ditos: <" + a.getCreditos() + ">");
		System.out.println("\tTipo: <" + a.getTipo() + ">");
		System.out.println("\tCurso: <" + a.getCurso() + ">");
	}
}