package fp.grados.tipos.test;

import java.util.List;

import fp.grados.excepciones.ExcepcionBecaNoValida;
import fp.grados.tipos.BecaInmutable;
import fp.grados.tipos.BecaInmutableImpl;
import fp.grados.tipos.TipoBeca;
import fp.grados.utiles.Grados;

public class TestBecaInmutable {
	public static void main(String[] args) {
		testConstructor1Normal();
		testConstructor1Excepcion1();
		testConstructor1Excepcion2();
		testConstructor1Excepcion3();
		testConstructor1Excepcion4();
		testConstructor1Excepcion5();
		testConstructor1Excepcion6();
		
		testConstructor2Normal();
		testConstructor2Excepcion1();
		testConstructor2Excepcion2();
		testConstructor2Excepcion3();
		testConstructor2Excepcion4();
		
		testConstructorStringNormal();
		
		testIgualdad();
		testOrden();
	}

	private static void testConstructor1Normal() {
		System.out.println("========Probando el primer constructor======================================================================================");
		testConstructor1("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
	}

	private static void testConstructor1Excepcion1() {
		System.out.println("\n========Probando el primer constructor, pocos caracteres en el código======================================================================================");
		testConstructor1("ABC12", 10000.0, 6, TipoBeca.ORDINARIA);
	}
	
	private static void testConstructor1Excepcion2() {
		System.out.println("\n========Probando el primer constructor, demasiados caracteres en el código======================================================================================");
		testConstructor1("ABC12345", 10000.0, 6, TipoBeca.ORDINARIA);
	}
	
	private static void testConstructor1Excepcion3() {
		System.out.println("\n========Probando el primer constructor, pocas letras en el código======================================================================================");
		testConstructor1("AB12345", 10000.0, 6, TipoBeca.ORDINARIA);
	}
	
	private static void testConstructor1Excepcion4() {
		System.out.println("\n========Probando el primer constructor, pocos dígitos en el código======================================================================================");
		testConstructor1("ABCD123", 10000.0, 6, TipoBeca.ORDINARIA);
	}
	
	private static void testConstructor1Excepcion5() {
		System.out.println("\n========Probando el primer constructor, cuantía total menor a la mínima======================================================================================");
		testConstructor1("ABC1234", 0.0, 6, TipoBeca.ORDINARIA);
	}
	
	private static void testConstructor1Excepcion6() {
		System.out.println("\n========Probando el primer constructor, duración menor a 1======================================================================================");
		testConstructor1("ABC1234", 10000.0, -1, TipoBeca.ORDINARIA);
	}

	private static void testConstructor2Normal() {
		System.out.println("\n========Probando el segundo constructor======================================================================================");
		testConstructor2("ABC1234", TipoBeca.ORDINARIA);
	}

	private static void testConstructor2Excepcion1() {
		System.out.println("\n========Probando el segundo constructor, pocos caracteres en el código======================================================================================");
		testConstructor2("ABC12", TipoBeca.ORDINARIA);
	}
	
	private static void testConstructor2Excepcion2() {
		System.out.println("\n========Probando el segundo constructor, demasiados caracteres en el código======================================================================================");
		testConstructor2("ABC12345", TipoBeca.ORDINARIA);
	}
	
	private static void testConstructor2Excepcion3() {
		System.out.println("\n========Probando el segundo constructor, pocas letras en el código======================================================================================");
		testConstructor2("AB12345", TipoBeca.ORDINARIA);
	}
	
	private static void testConstructor2Excepcion4() {
		System.out.println("\n========Probando el segundo constructor, pocos dígitos en el código======================================================================================");
		testConstructor2("ABCD123", TipoBeca.ORDINARIA);
	}
	
	private static void testConstructorStringNormal(){
		System.out.println("\n========Probando el constructor con String======================================================================================");
		List<BecaInmutable> becas = Grados.leeFichero("res/becas.txt", s -> new BecaInmutableImpl(s));
		testConstructorString(becas);
		//Nota: para hacer saltar una excepción, habría que modificar el fichero de texto
	}
	
	private static void testIgualdad() {
		System.out.println("\n========Probando igualdad======================================================================================");
		BecaInmutable b1 = new BecaInmutableImpl("ABC1234", 2000.0, 12, TipoBeca.EMPRESA);
		BecaInmutable b2 = new BecaInmutableImpl("ABC1234", 3000.0, 6, TipoBeca.EMPRESA);
		BecaInmutable b3 = new BecaInmutableImpl("ZWQ9877", 2000.0, 12, TipoBeca.EMPRESA);
		BecaInmutable b4 = new BecaInmutableImpl("ABC1234", 3000.0, 6, TipoBeca.MOVILIDAD);
		System.out.println("Código hash del objeto b1 (" + b1 + "): " + b1.hashCode());
		System.out.println("Código hash del objeto b2 (" + b2 + "): " + b2.hashCode());
		System.out.println("Código hash del objeto b3 (" + b3 + "): " + b3.hashCode());
		System.out.println("Código hash del objeto b4 (" + b4 + "): " + b4.hashCode());
		System.out.println("¿Es b1 igual a b2? (debe ser true): " + b1.equals(b2));
		System.out.println("¿Es b1 distinto de b3? (debe ser true): " + !b1.equals(b3));
		System.out.println("¿Es b1 distinto de b4? (debe ser true): " + !b1.equals(b4));
	}
	
	private static void testOrden() {
		System.out.println("\n========Probando orden natural======================================================================================");
		BecaInmutable menor = new BecaInmutableImpl("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		BecaInmutable igual1 = new BecaInmutableImpl("ABC1235", 10000.0, 6, TipoBeca.ORDINARIA);
		BecaInmutable igual2 = new BecaInmutableImpl("ABC1235", 10000.0, 6, TipoBeca.ORDINARIA);
		BecaInmutable mayor = new BecaInmutableImpl("ABC1235", 10000.0, 6, TipoBeca.EMPRESA);
		System.out.println("- Debe ser ANTES: ");
		compara(menor, igual1);
		System.out.println("- Debe ser MISMA POSICIÓN: ");
		compara(igual1, igual2);
		System.out.println("- Debe ser DESPUÉS: ");
		compara(mayor, igual2);
	}
	
	
	
	//////////////////////////////////////////////////
	//Métodos auxiliares
	
	private static void testConstructor1(String codigo, Double cuantiaTotal, Integer duracion, TipoBeca tipo) {
		try {
			BecaInmutable b = new BecaInmutableImpl(codigo, cuantiaTotal, duracion, tipo);
			mostrarBeca(b);
		} catch (ExcepcionBecaNoValida e) {
			System.out.println("Se ha capturado la excepción ExcepcionBecaNoValida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción insesperada.");
		}
	}

	private static void testConstructor2(String codigo, TipoBeca tipo) {
		try {
			BecaInmutable b = new BecaInmutableImpl(codigo, tipo);
			mostrarBeca(b);
		} catch (ExcepcionBecaNoValida e) {
			System.out.println("Se ha capturado la excepción ExcepcionBecaNoValida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción insesperada.");
		}
	}
	
	private static void testConstructorString(List<BecaInmutable> becas){
		for (BecaInmutable b : becas) {
			try {
				mostrarBeca(b);
			} catch (ExcepcionBecaNoValida e) {
				System.out.println("Se ha capturado la excepción ExcepcionBecaNoValida: \n\t" + e.getMessage());
			} catch (Exception e) {
				System.out.println("Se ha capturado una excepción inesperada.");
			}
		}
	}
	
	private static void compara(BecaInmutable b1, BecaInmutable b2) {
		System.out.print("El objeto <" + b1 + ">");
		if (b1.compareTo(b2) < 0) {
			System.out.print(" va ANTES que el objeto ");
		} else if (b1.compareTo(b2) > 0) {
			System.out.print(" va DESPUÉS que el objeto ");
		} else {
			System.out.print(" va en la MISMA POSICIÓN que el objeto ");
		}
		System.out.println("<" + b2 + ">");
	}

	private static void mostrarBeca(BecaInmutable b) {
		System.out.println("Beca --> <" + b + ">");
		System.out.println("\tCódigo: <" + b.getCodigo() + ">");
		System.out.println("\tCuantía total: <" + b.getCuantiaTotal() + ">");
		System.out.println("\tDuración: <" + b.getDuracion() + ">");
		System.out.println("\tTipo: <" + b.getTipo() + ">");
		System.out.println("\tCuantía mensual: <" + b.getCuantiaMensual() + ">");
	}
}