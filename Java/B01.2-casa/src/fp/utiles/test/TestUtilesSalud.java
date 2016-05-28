package fp.utiles.test;

import java.util.Scanner;

import fp.tipos.personas.EstadoNutricional;
import fp.utiles.UtilesSalud;

public class TestUtilesSalud {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca su peso (en kilos):");
		Float peso = sc.nextFloat();
		System.out.println("Introduzca su estatura (en metros):");
		Float altura = sc.nextFloat();
		Float imc = UtilesSalud.calcularIMC(peso, altura);
		System.out.println("Su IMC es: " + imc);
		EstadoNutricional EstN = UtilesSalud.obtenerEstadoNutricional(peso, altura);
		System.out.println("Su estado nutricional es: " + EstN);
		String en = UtilesSalud.consejoSalud(EstN);
		System.out.println(en);
		sc.close();
	}
}
