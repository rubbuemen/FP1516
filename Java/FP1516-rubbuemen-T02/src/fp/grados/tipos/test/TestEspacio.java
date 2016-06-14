package fp.grados.tipos.test;

import fp.grados.tipos.Espacio;
import fp.grados.tipos.EspacioImpl;
import fp.grados.tipos.TipoEspacio;

public class TestEspacio {
	public static void main(String[] args) {
		testConstructor();
	}

	private static void testConstructor() {
		System.out.println("========Probando el primer constructor======================================================================================");
		Espacio e = new EspacioImpl(TipoEspacio.LABORATORIO, "A3.10", 30, 2);
		mostrarEspacio(e);
	}

	private static void mostrarEspacio(Espacio e) {
		System.out.println("Espacio--> <" + e + ">");
		System.out.println("\tTipo de espacio: <" + e.getTipo() + ">");
		System.out.println("\tNombre: <" + e.getNombre() + ">");
		System.out.println("\tCapacidad: <" + e.getCapacidad() + ">");
		System.out.println("\tPlanta: <" + e.getPlanta() + ">");
	}
}
