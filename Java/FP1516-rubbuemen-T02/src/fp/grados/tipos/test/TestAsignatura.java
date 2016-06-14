package fp.grados.tipos.test;

import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.TipoAsignatura;

public class TestAsignatura {
	public static void main(String[] args) {
		testConstructor();
	}

	private static void testConstructor() {
		System.out.println("========Probando el primer constructor======================================================================================");
		Asignatura a1 = new AsignaturaImpl("Fundamentos de Programación", "0000230", 12.0, TipoAsignatura.ANUAL, 1);
		mostrarAsignatura(a1);
	}

	private static void mostrarAsignatura(Asignatura a) {
		System.out.println("Asignatura--> <" + a + ">");
		System.out.println("\tNombre: <" + a.getNombre() + ">");
		System.out.println("\tAcrónimo: <" + a.getAcronimo() + ">");
		System.out.println("\tCódigo: <" + a.getCodigo() + ">");
		System.out.println("\tCréditos: <" + a.getCreditos() + ">");
		System.out.println("\tTipo: <" + a.getTipo() + ">");
		System.out.println("\tCurso: <" + a.getCurso() + ">");
	}
}