package fp.grados.tipos.test;

import fp.grados.excepciones.ExcepcionBecaNoValida;
import fp.grados.tipos.Beca;
import fp.grados.tipos.BecaImpl;
import fp.grados.tipos.TipoBeca;

public class TestBeca {

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
		
		testSetCuantiaTotalNormal();
		testSetCuantiaTotalExcepcion();
		
		testSetDuracionNormal();
		testSetDuracionExcepcion();
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
	
	private static void testSetCuantiaTotalNormal(){
		System.out.println("\n========Probando setCuantiaTotal======================================================================================");
		Beca b = new BecaImpl("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		testSetCuantiaTotal(b, 12000.0);
	}
	
	private static void testSetCuantiaTotalExcepcion(){
		System.out.println("\n========Probando setCuantiaTotal con cuantía total menor a la mínima======================================================================================");
		Beca b = new BecaImpl("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		testSetCuantiaTotal(b, 120.0);
	}
	
	private static void testSetDuracionNormal(){
		System.out.println("\n========Probando setDuracion======================================================================================");
		Beca b = new BecaImpl("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		testSetDuracion(b, 12);
	}
	
	private static void testSetDuracionExcepcion(){
		System.out.println("\n========Probando setDuracion con duración menor a 1======================================================================================");
		Beca b = new BecaImpl("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		testSetDuracion(b, 0);
	}
	
	
	
	//////////////////////////////////////////////////
	//Métodos auxiliares
	
	private static void testConstructor1(String codigo, Double cuantiaTotal, Integer duracion, TipoBeca tipo) {
		try {
			Beca b = new BecaImpl(codigo, cuantiaTotal, duracion, tipo);
			mostrarBeca(b);
		} catch (ExcepcionBecaNoValida e) {
			System.out.println("Se ha capturado la excepción ExcepcionBecaNoValida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción insesperada.");
		}
	}

	private static void testConstructor2(String codigo, TipoBeca tipo) {
		try {
			Beca b = new BecaImpl(codigo, tipo);
			mostrarBeca(b);
		} catch (ExcepcionBecaNoValida e) {
			System.out.println("Se ha capturado la excepción ExcepcionBecaNoValida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción insesperada.");
		}
	}

	private static void testSetCuantiaTotal(Beca b, Double cuantiaTotal){
		try {
			System.out.println("La cuantía total antes de la operación es: " + b.getCuantiaTotal());
			System.out.println("El nuevo valor es: " +  cuantiaTotal);
			b.setCuantiaTotal(cuantiaTotal);
			System.out.println("La cuantía total después de la operación es: " + b.getCuantiaTotal());
		} catch (ExcepcionBecaNoValida e) {
			System.out.println("Se ha capturado la excepción ExcepcionBecaNoValida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción insesperada.");
		}
	}

	private static void testSetDuracion(Beca b, Integer duracion){
		try {
			System.out.println("La duración antes de la operación es: " + b.getDuracion());
			System.out.println("El nuevo valor es: " +  duracion);
			b.setDuracion(duracion);
			System.out.println("La duración después de la operación es: " + b.getDuracion());
		} catch (ExcepcionBecaNoValida e) {
			System.out.println("Se ha capturado la excepción ExcepcionBecaNoValida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción insesperada.");
		}
	}

	private static void mostrarBeca(Beca b) {
		System.out.println("Beca --> <" + b + ">");
		System.out.println("\tCódigo: <" + b.getCodigo() + ">");
		System.out.println("\tCuantía total: <" + b.getCuantiaTotal() + ">");
		System.out.println("\tDuración: <" + b.getDuracion() + ">");
		System.out.println("\tTipo: <" + b.getTipo() + ">");
		System.out.println("\tCuantía mensual: <" + b.getCuantiaMensual() + ">");
	}
}