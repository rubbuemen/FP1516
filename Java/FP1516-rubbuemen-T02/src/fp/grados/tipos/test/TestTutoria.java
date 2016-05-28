package fp.grados.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.Locale;

import fp.grados.tipos.Tutoria;
import fp.grados.tipos.TutoriaImpl;

public class TestTutoria {
	public static void main(String[] args) {
		testConstructor1();
		testConstructor2();
	}

	private static void testConstructor1() {
		System.out.println("========Probando el primer constructor======================================================================================");
		Tutoria t = new TutoriaImpl(DayOfWeek.of(1), LocalTime.of(10, 30), LocalTime.of(12, 30));
		mostrarTutoria(t);
	}

	private static void testConstructor2() {
		System.out.println("\n========Probando el segundo constructor======================================================================================");
		Tutoria t = new TutoriaImpl(DayOfWeek.of(2), LocalTime.of(10, 30), 60);
		mostrarTutoria(t);
	}
	
	private static void mostrarTutoria(Tutoria t) {
		System.out.println("Tutoria--> <" + t + ">");
		System.out.println("\tDia de la semana: <" + t.getDiaSemana().getDisplayName(TextStyle.FULL, locale).toUpperCase().substring(0,1)+t.getDiaSemana().getDisplayName(TextStyle.FULL, locale).substring(1)+ ">");
		System.out.println("\tHora de comienzo: <" + t.getHoraComienzo() + ">");
		System.out.println("\tHora de fin: <" + t.getHoraFin() + ">");
		System.out.println("\tDuración: <" + t.getDuracion() + " minutos>");
	}

	public static Locale locale = Locale.forLanguageTag("es-ES");
}