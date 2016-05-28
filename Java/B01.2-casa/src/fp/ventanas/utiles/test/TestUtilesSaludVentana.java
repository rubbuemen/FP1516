package fp.ventanas.utiles.test;

import fp.tipos.personas.EstadoNutricional;
import fp.utiles.UtilesSalud;
import fp.ventanas.utiles.UtilesVentanas;

public class TestUtilesSaludVentana {
	private static final String TITULO = "IMC";
	public static void main(String[] args) {
		String pesoStr = UtilesVentanas.leerDato (TITULO, "Introduzca su peso (en kilos):");
		Float peso = new Float(pesoStr);
		String alturaStr = UtilesVentanas.leerDato (TITULO, "Introduzca su estatura (en metros):");
		Float altura = new Float(alturaStr);
		Float imc = UtilesSalud.calcularIMC(peso, altura);
		EstadoNutricional EstN = UtilesSalud.obtenerEstadoNutricional(peso, altura);
		String en = UtilesSalud.consejoSalud(EstN);
		String mensaje = "Su IMC es: " + imc + "\n" + "Su estado nutricional es: " + EstN + "\n" + en;
		UtilesVentanas.mostrarMensaje(TITULO, mensaje);
	}

}
