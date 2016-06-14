package fp.ventanas.utiles.test;

import fp.ventanas.utiles.UtilesVentanas;

public class EjemploUtilesVentanas {
	private static final String TITULO = "UtilesVentanas";
	
	public static void main(String[] args) {
		String realStr = UtilesVentanas.leerDato (TITULO, "Introduzca un número real: ");
		Double real = new Double(realStr);
		String mensaje = "La raiz cuadrada del número introducido es: " + Math.sqrt(real) + "\n";
		UtilesVentanas.mostrarMensaje(TITULO, mensaje);
	}

}
