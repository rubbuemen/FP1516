package fp.grados.tipos.test;

import fp.grados.tipos.Beca;
import fp.grados.tipos.BecaImpl;
import fp.grados.tipos.TipoBeca;

public class TestBeca {
	public static void main(String[] args) {
		testConstructor1();
		testConstructor2();
	}

	private static void testConstructor1() {
		System.out.println("========Probando el primer constructor======================================================================================");
		Beca b = new BecaImpl("ABB2024", TipoBeca.MOVILIDAD);
		mostrarBeca(b);
	}

	private static void testConstructor2() {
		System.out.println("\n========Probando el segundo constructor======================================================================================");
		Beca b = new BecaImpl("ABB2025", 1800.0, 6, TipoBeca.EMPRESA);
		mostrarBeca(b);
	}

	private static void mostrarBeca(Beca b) {
		System.out.println("Beca--> <" + b + ">");
		System.out.println("\tC�digo: <" + b.getCodigo() + ">");
		System.out.println("\tCuant�a Total: <" + b.getCuantiaTotal() + ">");
		System.out.println("\tDuraci�n: <" + b.getDuracion() + ">");
		System.out.println("\tTipo: <" + b.getTipo() + ">");
		System.out.println("\tCuant�a Mensual: <" + b.getCuantiaMensual() + ">");
	}
}