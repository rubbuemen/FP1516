package fp.grados.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import fp.grados.excepciones.ExcepcionTutoriaNoValida;
import fp.grados.tipos.Tutoria;
import fp.grados.tipos.TutoriaImpl;
import fp.grados.utiles.Grados;

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
		
		testConstructorStringNormal();
		
		testIgualdad();
		testOrden();
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
	
	private static void testConstructorStringNormal(){
		System.out.println("\n========Probando el constructor con String======================================================================================");
		List<Tutoria> tutorias = Grados.leeFichero("res/tutorias.txt", s -> new TutoriaImpl(s));
		testConstructorString(tutorias);
		//Nota: para hacer saltar una excepción, habría que modificar el fichero de texto
	}
	
	private static void testIgualdad() {
		System.out.println("\n========Probando igualdad con dos objetos iguales======================================================================================");
		Tutoria t1 = new TutoriaImpl(DayOfWeek.of(1), LocalTime.of(10, 30), LocalTime.of(12, 30));
		Tutoria t2 = new TutoriaImpl(DayOfWeek.of(1), LocalTime.of(10, 30), LocalTime.of(12, 30));
		Tutoria t3 = new TutoriaImpl(DayOfWeek.of(1), LocalTime.of(11, 30), LocalTime.of(12, 30));
		Tutoria t4 = new TutoriaImpl(DayOfWeek.of(3), LocalTime.of(12, 30), LocalTime.of(14, 30));
		System.out.println("Código hash del objeto n1 (" + t1 + "): " + t1.hashCode());
		System.out.println("Código hash del objeto n2 (" + t2 + "): " + t2.hashCode());
		System.out.println("Código hash del objeto n3 (" + t3 + "): " + t3.hashCode());
		System.out.println("Código hash del objeto n4 (" + t4 + "): " + t4.hashCode());
		System.out.println("¿Es t1 igual a t2? (debe ser true): " + t1.equals(t2));
		System.out.println("¿Es t1 distinto de t3? (debe ser true): " + !t1.equals(t3));
		System.out.println("¿Es t1 distinto de t4? (debe ser true): " + !t1.equals(t4));
	}

	private static void testOrden() {
		System.out.println("\n========Probando orden natural======================================================================================");
		Tutoria menor = new TutoriaImpl(DayOfWeek.of(1), LocalTime.of(10, 30), LocalTime.of(12, 30));
		Tutoria igual1 = new TutoriaImpl(DayOfWeek.of(1), LocalTime.of(11, 30), LocalTime.of(12, 30));
		Tutoria igual2 = new TutoriaImpl(DayOfWeek.of(1), LocalTime.of(11, 30), LocalTime.of(12, 30));
		Tutoria mayor = new TutoriaImpl(DayOfWeek.of(4), LocalTime.of(10, 30), LocalTime.of(12, 30));
		System.out.println("- Debe ser ANTES: ");
		compara(menor, igual1);
		System.out.println("- Debe ser MISMA POSICIÓN: ");
		compara(igual1, igual2);
		System.out.println("- Debe ser DESPUÉS: ");
		compara(mayor, igual2);
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
	
	private static void testConstructorString(List<Tutoria> tutorias){
		for (Tutoria t: tutorias) {
			try {
				mostrarTutoria(t);
			} catch (ExcepcionTutoriaNoValida e) {
				System.out.println("Se ha capturado la excepción ExcepcionTutoriaNoValida: \n\t" + e.getMessage());
			} catch (Exception e) {
				System.out.println("Se ha capturado una excepción inesperada.");
			}
		}
	}
	
	private static void compara(Tutoria t1, Tutoria t2) {
		System.out.print("El objeto <" + t1 + ">");
		if (t1.compareTo(t2) < 0) {
			System.out.print(" va ANTES que el objeto ");
		} else if (t1.compareTo(t2) > 0) {
			System.out.print(" va DESPUÉS que el objeto ");
		} else {
			System.out.print(" va en la MISMA POSICIÓN que el objeto ");
		}
		System.out.println("<" + t2 + ">");
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