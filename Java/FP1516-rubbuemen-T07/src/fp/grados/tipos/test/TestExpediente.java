package fp.grados.tipos.test;

import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Convocatoria;
import fp.grados.tipos.Expediente;
import fp.grados.tipos.ExpedienteImpl;
import fp.grados.tipos.Nota;
import fp.grados.tipos.NotaImpl;
import fp.grados.tipos.TipoAsignatura;

public class TestExpediente {
	public static void main(String[] args) {
		testConstructor();
		
		testNuevaNota1();
		testNuevaNota2();
		
		testIgualdad();
	}

	private static void testConstructor() {
		System.out.println("========Probando el constructor======================================================================================");
		Expediente ex = new ExpedienteImpl();
		mostrarExpediente(ex);
	}
	
	private static void testNuevaNota1(){
		System.out.println("\n========Probando nuevaNota sin ninguna nota creada======================================================================================");
		Expediente ex = new ExpedienteImpl();
		Asignatura a = new AsignaturaImpl("Fundamentos de Programación", "0000230", 10.0, TipoAsignatura.ANUAL, 1);
		Nota n = new NotaImpl(a, 2015, Convocatoria.PRIMERA, 9.5, true);
		testNuevaNota(n, ex);
	}
	
	private static void testNuevaNota2(){
		System.out.println("\n========Probando nuevaNota con una nota ya creada======================================================================================");
		Expediente ex = new ExpedienteImpl();
		Asignatura a = new AsignaturaImpl("Fundamentos de Programación", "0000230", 10.0, TipoAsignatura.ANUAL, 1);
		Nota n1 = new NotaImpl(a, 2015, Convocatoria.PRIMERA, 9.5, true);
		Nota n2 = new NotaImpl(a, 2015, Convocatoria.PRIMERA, 4.5, false);
		ex.nuevaNota(n1);
		testNuevaNota(n2, ex);
	}
	
	private static void testIgualdad() {
		System.out.println("\n========Probando igualdad con dos objetos iguales======================================================================================");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programación", "0000230", 10.0, TipoAsignatura.ANUAL, 1);
		Nota n1 = new NotaImpl(asig, 2015, Convocatoria.PRIMERA, 9.5, true);
		Nota n2 = new NotaImpl(asig, 2015, Convocatoria.PRIMERA, 9.5, true);
		Nota n3 = new NotaImpl(asig, 2015, Convocatoria.TERCERA, 4.5, false);
		Nota n4 = new NotaImpl(asig, 2015, Convocatoria.SEGUNDA, 8.5, false);
		Expediente ex1 = new ExpedienteImpl();
		Expediente ex2 = new ExpedienteImpl();
		Expediente ex3 = new ExpedienteImpl();
		Expediente ex4 = new ExpedienteImpl();
		ex1.nuevaNota(n1);
		ex2.nuevaNota(n2);
		ex3.nuevaNota(n3);
		ex4.nuevaNota(n4);
		System.out.println("Código hash del objeto ex1 (" + ex1 + "): " + ex1.hashCode());
		System.out.println("Código hash del objeto ex2 (" + ex2 + "): " + ex2.hashCode());
		System.out.println("Código hash del objeto ex3 (" + ex3 + "): " + ex3.hashCode());
		System.out.println("Código hash del objeto ex4 (" + ex4 + "): " + ex4.hashCode());
		System.out.println("¿Es ex1 igual a ex2? (debe ser true): " + ex1.equals(ex2));
		System.out.println("¿Es ex1 distinto de ex3? (debe ser true): " + !ex1.equals(ex3));
		System.out.println("¿Es ex1 distinto de ex4? (debe ser true): " + !ex1.equals(ex4));
	}


	
	//////////////////////////////////////////////////
	//Métodos auxiliares
	
	private static void testNuevaNota(Nota n, Expediente ex) {
		System.out.println("El expediente antes de la operación es: " + ex.getNotas());
		System.out.println("Nueva nota a añadir: " + n);
		ex.nuevaNota(n);
		System.out.println("El expediente después de la operación es: " + ex.getNotas());
	}

	private static void mostrarExpediente(Expediente ex) {
		System.out.println("Expediente--> <" + ex + ">");
		System.out.println("Notas: <" + ex.getNotas() + ">");
	}
}