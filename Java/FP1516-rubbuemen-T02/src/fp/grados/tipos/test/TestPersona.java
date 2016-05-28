package fp.grados.tipos.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import fp.grados.tipos.Persona;
import fp.grados.tipos.PersonaImpl;

public class TestPersona {
	public static void main(String[] args) {
		testConstructor1();
		testConstructor2();
	}

	private static void testConstructor1() {
		System.out.println("========Probando el primer constructor======================================================================================");
		Persona p = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		mostrarPersona(p);
	}

	private static void testConstructor2() {
		System.out.println("\n========Probando el segundo constructor======================================================================================");
		Persona p = new PersonaImpl("12345678Z", "Juana", "Nadie Nadie", LocalDate.of(1980, 7, 13));
		mostrarPersona(p);
	}

	private static void mostrarPersona(Persona p) {
		System.out.println("Persona--> <" + p + ">");
		System.out.println("\tNombre: <" + p.getNombre() + ">");
		System.out.println("\tApellidos: <" + p.getApellidos() + ">");
		System.out.println("\tDNI: <" + p.getDNI() + ">");
		System.out.println("\tFecha Nacimiento: <" + p.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ">");
		System.out.println("\tEdad: <" + p.getEdad() + ">");
		System.out.println("\tEmail: <" + p.getEmail() + ">");
	}
}