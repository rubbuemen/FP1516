package fp.grados.tipos.test;

import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Convocatoria;
import fp.grados.tipos.Nota;
import fp.grados.tipos.NotaImpl;
import fp.grados.tipos.TipoAsignatura;

public class TestNota {
	public static void main(String[] args) {
		testConstructor1();
		testConstructor2();
	}

	private static void testConstructor1() {
		System.out.println("========Probando el primer constructor======================================================================================");
		Asignatura a = new AsignaturaImpl("Fundamentos de Programación", "0000230", 10.0, TipoAsignatura.ANUAL, 1);
		Nota n = new NotaImpl(a, 2015, Convocatoria.PRIMERA, 9.5, true);
		mostrarNota(n);
	}

	private static void testConstructor2() {
		System.out.println("\n========Probando el segundo constructor======================================================================================");
		Asignatura a = new AsignaturaImpl("Fundamentos de Programación", "0000230", 10.0, TipoAsignatura.ANUAL, 1);
		Nota n = new NotaImpl(a, 2015, Convocatoria.SEGUNDA, 6.5);
		mostrarNota(n);
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