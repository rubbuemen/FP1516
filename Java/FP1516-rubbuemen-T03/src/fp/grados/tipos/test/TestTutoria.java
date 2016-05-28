package fp.grados.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.Locale;

import fp.grados.excepciones.ExcepcionTutoriaNoValida;
import fp.grados.tipos.Tutoria;
import fp.grados.tipos.TutoriaImpl;

public class TestTutoria {
	public static void main(String[] args) {
		testConstructor1Normal();
		testConstructor1Excepcion1();
		testConstructor1Excepcion2();
		testConstructor1Excepcion3();
		
		testConstructor2Normal();
		testConstructor2Excepcion1();
		testConstructor2Excepcion2();
		testConstructor2Excepcion3();
	}

	private static void testConstructor1Normal() {
		System.out.println("========Probando el primer constructor======================================================================================");
		testConstructor1(DayOfWeek.of(1), LocalTime.of(10, 30), LocalTime.of(12, 30));
	}
	
	private static void testConstructor1Excepcion1() {
		System.out.println("\n========Probando el primer constructor con un día de la semana inválido======================================================================================");
		testConstructor1(DayOfWeek.of(6), LocalTime.of(10, 30), LocalTime.of(12, 30));
	}
	
	private static void testConstructor1Excepcion2() {
		System.out.println("\n========Probando el primer constructor con un horario inválido======================================================================================");
		testConstructor1(DayOfWeek.of(1), LocalTime.of(9, 30), LocalTime.of(22, 30));
	}
	
	private static void testConstructor1Excepcion3() {
		System.out.println("\n========Probando el primer constructor con una duración inválida======================================================================================");
		testConstructor1(DayOfWeek.of(1), LocalTime.of(9, 30), LocalTime.of(9, 40));
	}
	
	private static void testConstructor2Normal() {
		System.out.println("\n========Probando el segundo constructor============================================================================================================================================================================");
		testConstructor2(DayOfWeek.of(1), LocalTime.of(10, 30), 60);
	}
	
	private static void testConstructor2Excepcion1() {
		System.out.println("\n========Probando el segundo constructor con un día de la semana inválido======================================================================================");
		testConstructor2(DayOfWeek.of(6), LocalTime.of(10, 30), 60);
	}
	
	private static void testConstructor2Excepcion2() {
		System.out.println("\n========Probando el segundo constructor con un horario inválido======================================================================================");
		testConstructor2(DayOfWeek.of(1), LocalTime.of(9, 30), 800);
	}
	
	private static void testConstructor2Excepcion3() {
		System.out.println("\n========Probando el segundo constructor con una duración inválida======================================================================================");
		testConstructor2(DayOfWeek.of(1), LocalTime.of(9, 30), 20);
	}

	
	
	//////////////////////////////////////////////////
	//Métodos auxiliares
	
	private static void testConstructor1(DayOfWeek diaSemana, LocalTime horaComienzo, LocalTime horaFin) {
		try {
			Tutoria t = new TutoriaImpl(diaSemana, horaComienzo, horaFin);
			mostrarTutoria(t);
		} catch (ExcepcionTutoriaNoValida e) {
			System.out.println("Se ha capturado la excepción ExcepcionTutoriaNoValida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción insesperada.");
		}
	}
	
	private static void testConstructor2(DayOfWeek diaSemana, LocalTime horaComienzo, Integer duracion) {
		try {
			Tutoria t = new TutoriaImpl(diaSemana, horaComienzo, duracion);
			mostrarTutoria(t);
		} catch (ExcepcionTutoriaNoValida e) {
			System.out.println("Se ha capturado la excepción ExcepcionTutoriaNoValida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción insesperada.");
		}
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