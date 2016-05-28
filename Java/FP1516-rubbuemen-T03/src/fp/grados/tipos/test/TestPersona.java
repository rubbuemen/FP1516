package fp.grados.tipos.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fp.grados.excepciones.ExcepcionPersonaNoValida;
import fp.grados.tipos.Persona;
import fp.grados.tipos.PersonaImpl;

public class TestPersona {
	public static void main(String[] args) {
		testConstructor1Normal();
		testConstructor1Excepcional1();
		testConstructor1Excepcional2();
		testConstructor1Excepcional3();
		testConstructor1Excepcional4();
		testConstructor1Excepcional5();
		
		testConstructor2Normal();
		testConstructor2Excepcional1();
		testConstructor2Excepcional2();
		testConstructor2Excepcional3();	
		
		testSetDNINormal();
		testSetDNIExcepcional1();
		testSetDNIExcepcional2();
		testSetDNIExcepcional3();
		
		testSetEmailNormal();
		testSetEmailExcepcional();
		
		testSetFechaNacimientoNormal();
		testSetFechaNacimientoExcepcional();
	}

	private static void testConstructor1Normal() {
		System.out.println("========Probando el primer constructor======================================================================================");
		testConstructor1("12345678Z", "Juan", "Nadie Nadie", 
		LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
	}

	private static void testConstructor1Excepcional1() {
		System.out.println("\n========Probando el primer constructor con dni sin letra======================================================================================");
		testConstructor1("123456789", "Juan", "Nadie Nadie", 
		LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
	}

	private static void testConstructor1Excepcional2() {
		System.out.println("\n========Probando el primer constructor con dni de longitud menor de la esperada======================================================================================");
		testConstructor1("1234567X", "Juan", "Nadie Nadie", 
		LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
	}

	private static void testConstructor1Excepcional3() {
		System.out.println("\n========Probando el primer constructor con letra en dni que no se corresponde a los dígitos======================================================================================");
		testConstructor1("12345678X", "Juan", "Nadie Nadie", 
		LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
	}

	private static void testConstructor1Excepcional4() {
		System.out.println("\n========Probando el primer constructor con email sin arroba======================================================================================");
		testConstructor1("12345678Z", "Juan", "Nadie Nadie", 
		LocalDate.of(1950, 3, 15), "juan.nadiegmail.com");
	}
	
	private static void testConstructor1Excepcional5() {
		System.out.println("\n========Probando el primer constructor con fecha de nacimiento posterior a la actual======================================================================================");
		testConstructor1("12345678Z", "Juan", "Nadie Nadie", 
		LocalDate.of(2030, 3, 15), "juan.nadie@gmail.com");
	}
	
	private static void testConstructor2Normal() {
		System.out.println("\n========Probando el segundo constructor======================================================================================");
		testConstructor2("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15));
	}
	
	private static void testConstructor2Excepcional1() {
		System.out.println("\n========Probando el segundo constructor con dni sin letra======================================================================================");
		testConstructor2("123456789", "Juan", "Nadie Nadie",	LocalDate.of(1950, 3, 15));
	}
	
	private static void testConstructor2Excepcional2() {
		System.out.println("\n========Probando el segundo constructor con dni de longitud menor de la esperada======================================================================================");
		testConstructor2("1234567X", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15));
	}
	
	private static void testConstructor2Excepcional3() {
		System.out.println("\n========Probando el segundo constructor con letra en dni que no se corresponde a los dígitos======================================================================================");
		testConstructor2("12345678X", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15));
	}
	
	private static void testSetDNINormal(){
		System.out.println("\n========Probando setDNI======================================================================================");
		Persona p = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", 
		LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		testSetDNI(p, "12345677J");	
	}
	
	private static void testSetDNIExcepcional1(){
		System.out.println("\n========Probando setDNI con dni sin letra======================================================================================");
		Persona p = new PersonaImpl("12345678Z","Juan", "Nadie Nadie", 
		LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		testSetDNI(p, "123456779");	
	}

	private static void testSetDNIExcepcional2(){
		System.out.println("\n========Probando setDNI con dni de longitud menor de la esperada======================================================================================");
		Persona p = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", 
		LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		testSetDNI(p, "12345677");	
	}
	

	private static void testSetDNIExcepcional3(){
		System.out.println("\n========Probando setDNI con letra en dni que no se corresponde a los dígitos======================================================================================");
		Persona p = new PersonaImpl( "12345678Z", "Juan", "Nadie Nadie",
		LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		testSetDNI(p, "12345677X");	
	}
	
	private static void testSetEmailNormal(){
		System.out.println("\n========Probando setEmail======================================================================================");
		Persona p = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", 
		LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		testSetEmail(p, "juan@us.es");	
	}

	private static void testSetEmailExcepcional(){
		System.out.println("\n========Probando setEmail con email sin arroba======================================================================================");
		Persona p = new PersonaImpl("12345678Z","Juan", "Nadie Nadie", 
		LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		testSetEmail(p, "juan.us.es");	
	}
	
	private static void testSetFechaNacimientoNormal(){
		System.out.println("\n========Probando setFechaNacimiento======================================================================================");
		Persona p = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15));
		testSetFechaNacimiento(p, LocalDate.of(1951, 3, 15));	
	}
	
	private static void testSetFechaNacimientoExcepcional(){
		System.out.println("\n========Probando setFechaNacimiento con una fecha después de la actual======================================================================================");
		Persona p = new PersonaImpl("12345678Z","Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15));
		testSetFechaNacimiento(p, LocalDate.of(2017, 3, 15));	
	}

	
	
	//////////////////////////////////////////////////
	//Métodos auxiliares
	
	private static void testConstructor1(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email) {
		try {
			Persona p = new PersonaImpl(dni, nombre, apellidos, fechaNacimiento, email);
			mostrarPersona(p);
		} catch (ExcepcionPersonaNoValida e) {
			System.out.println("Se ha capturado la excepción ExcepcionPersonaNoValida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción insesperada.");
		}
	}	
	
	private static void testConstructor2(String dni, String nombre, String apellidos, LocalDate fechaNacimiento) {
		try {
			Persona p = new PersonaImpl(dni, nombre, apellidos, fechaNacimiento);
			mostrarPersona(p);
		} catch (ExcepcionPersonaNoValida e) {
			System.out.println("Se ha capturado la excepción ExcepcionPersonaNoValida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción insesperada.");
		}
	}
	
	private static void testSetDNI(Persona p, String nuevoDNI) {
		try {
			System.out.println("El dni antes de la operación es: " + p.getDNI());
			System.out.println("El nuevo dni es: " + nuevoDNI);
			p.setDNI(nuevoDNI);
			System.out.println("El dni después de la operación es: " + p.getDNI());
		} catch (ExcepcionPersonaNoValida e) {
			System.out.println("Se ha capturado la excepción ExcepcionPersonaNoValida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción insesperada.");
		}
	}

	private static void testSetEmail(Persona p, String nuevoEmail) {
		try {
			System.out.println("El email antes de la operación es: " + p.getEmail());
			System.out.println("El nuevo email es: " + nuevoEmail);
			p.setEmail(nuevoEmail);
			System.out.println("El email después de la operación es: " + p.getEmail());
		} catch (ExcepcionPersonaNoValida e) {
			System.out.println("Se ha capturado la excepción ExcepcionPersonaNoValida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción insesperada.");
		}
	}
	
	private static void testSetFechaNacimiento(Persona p, LocalDate nuevaFecha) {
		try {
			System.out.println("La fecha de nacimiento antes de la operación es: " + p.getFechaNacimiento());
			System.out.println("La nueva fecha de nacimiento es: " + nuevaFecha);
			p.setFechaNacimiento(nuevaFecha);
			System.out.println("La fecha de nacimiento después de la operación es: " + p.getFechaNacimiento());
		} catch (ExcepcionPersonaNoValida e) {
			System.out.println("Se ha capturado la excepción ExcepcionPersonaNoValida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción insesperada.");
		}
	}

	private static void mostrarPersona(Persona p) {
		System.out.println("Persona --> <" + p + ">");
		System.out.println("\tDNI: <" + p.getDNI() + ">");
		System.out.println("\tNombre: <" + p.getNombre() + ">");
		System.out.println("\tApellidos: <" + p.getApellidos() + ">");
		System.out.println("\tFecha Nacimiento: <"+ p.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ">");
		System.out.println("\tEdad: <" + p.getEdad() + ">");
		System.out.println("\tEmail: <" + p.getEmail() + ">");
	}
}