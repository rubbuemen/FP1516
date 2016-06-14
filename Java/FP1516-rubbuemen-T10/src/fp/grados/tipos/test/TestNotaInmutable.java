package fp.grados.tipos.test;

import java.util.List;

import fp.grados.excepciones.ExcepcionNotaNoValida;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Convocatoria;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Nota;
import fp.grados.tipos.NotaImpl;
import fp.grados.tipos.NotaInmutableImpl;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.utiles.Grados;

public class TestNotaInmutable {
	public static void main(String[] args) {
		testConstructor1Normal();
		testConstructor1Excepcional1();
		testConstructor1Excepcional2();
		
		testConstructor2Normal();
		testConstructor2Excepcional();
		
		testConstructorStringNormal();
		
		testIgualdad();
		testOrden();
		
		testInmutabilidad();
	}
	
	private static void testConstructor1Normal() {
		System.out.println("========Probando el primer constructor======================================================================================");
		Asignatura a = new AsignaturaImpl("Fundamentos de Programación", "0000230", 10.0, TipoAsignatura.ANUAL, 1);
		testConstructor1(a, 2015, Convocatoria.PRIMERA, 9.5, true);
	}
	
	private static void testConstructor1Excepcional1() {
		System.out.println("\n========Probando el primer constructor con un valor fuera del rango======================================================================================");
		Asignatura a = new AsignaturaImpl("Fundamentos de Programación", "0000230", 10.0, TipoAsignatura.ANUAL, 1);
		testConstructor1(a, 2015, Convocatoria.PRIMERA, 12.5, true);
	}
	
	private static void testConstructor1Excepcional2() {
		System.out.println("\n========Probando el primer constructor con una mención de honor que no puede ser======================================================================================");
		Asignatura a = new AsignaturaImpl("Fundamentos de Programación", "0000230", 10.0, TipoAsignatura.ANUAL, 1);
		testConstructor1(a, 2015, Convocatoria.PRIMERA, 6.4, true);
	}

	private static void testConstructor2Normal() {
		System.out.println("\n========Probando el segundo constructor======================================================================================");
		Asignatura a = new AsignaturaImpl("Fundamentos de Programación", "0000230", 10.0, TipoAsignatura.ANUAL, 1);
		Nota n = new NotaImpl(a, 2015, Convocatoria.SEGUNDA, 6.5);
		mostrarNota(n);
	}
	
	private static void testConstructor2Excepcional() {
		System.out.println("\n========Probando el segundo constructor con un valor fuera del rango======================================================================================");
		Asignatura a = new AsignaturaImpl("Fundamentos de Programación", "0000230", 10.0, TipoAsignatura.ANUAL, 1);
		testConstructor2(a, 2015, Convocatoria.SEGUNDA, 12.5);
	}
	
	private static void testConstructorStringNormal(){
		System.out.println("\n========Probando el constructor con String======================================================================================");
		List<Nota> notas = Grados.leeFichero("res/notas.txt", s -> new NotaImpl(s));
		testConstructorString(notas);
		//Nota: para hacer saltar una excepción, habría que modificar el fichero de texto
	}
	
	private static void testIgualdad() {
		System.out.println("\n========Probando igualdad con dos objetos iguales======================================================================================");
		Asignatura a1 = new AsignaturaImpl("Fundamentos de Programación", "0000230", 10.0, TipoAsignatura.ANUAL, 1);
		Asignatura a2 = new AsignaturaImpl("Álgebra Lineal", "0000730", 10.0, TipoAsignatura.ANUAL, 1);
		Nota n1 = new NotaInmutableImpl(a1, 2015, Convocatoria.SEGUNDA, 9.4, true);
		Nota n2 = new NotaInmutableImpl(a1, 2015, Convocatoria.SEGUNDA, 9.4, true);
		Nota n3 = new NotaInmutableImpl(a1, 2014, Convocatoria.SEGUNDA, 9.4, true);
		Nota n4 = new NotaInmutableImpl(a2, 2015, Convocatoria.SEGUNDA, 9.4, true);
		Nota n5 = new NotaInmutableImpl(a1, 2015, Convocatoria.PRIMERA, 9.4, true);
		System.out.println("Código hash del objeto n1 (" + n1 + "): " + n1.hashCode());
		System.out.println("Código hash del objeto n2 (" + n2 + "): " + n2.hashCode());
		System.out.println("Código hash del objeto n3 (" + n3 + "): " + n3.hashCode());
		System.out.println("Código hash del objeto n4 (" + n4 + "): " + n4.hashCode());
		System.out.println("Código hash del objeto n5 (" + n5 + "): " + n5.hashCode());
		System.out.println("¿Es n1 igual a n2? (debe ser true): " + n1.equals(n2));
		System.out.println("¿Es n1 distinto de n3? (debe ser true): " + !n1.equals(n3));
		System.out.println("¿Es n1 distinto de n4? (debe ser true): " + !n1.equals(n4));
		System.out.println("¿Es n1 distinto de n5? (debe ser true): " + !n1.equals(n5));
	}

	private static void testOrden() {
		System.out.println("\n========Probando orden natural======================================================================================");
		Asignatura a = new AsignaturaImpl("Fundamentos de Programación", "0000230", 10.0, TipoAsignatura.ANUAL, 1);
		Nota menor = new NotaInmutableImpl(a, 2014, Convocatoria.SEGUNDA, 9.4, true);
		Nota igual1 = new NotaInmutableImpl(a, 2015, Convocatoria.PRIMERA, 9.4, true);
		Nota igual2 = new NotaInmutableImpl(a, 2015, Convocatoria.PRIMERA, 9.4, true);
		Nota mayor = new NotaInmutableImpl(a, 2015, Convocatoria.SEGUNDA, 9.4, true);
		System.out.println("- Debe ser ANTES: ");
		compara(menor, igual1);
		System.out.println("- Debe ser MISMA POSICIÓN: ");
		compara(igual1, igual2);
		System.out.println("- Debe ser DESPUÉS: ");
		compara(mayor, igual2);
	}
	
	private static void testInmutabilidad() {
		System.out.println("\n========Probando inmutabilidad del tipo Nota======================================================================================");
		Departamento lsi = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		Departamento isa = new DepartamentoImpl("Ingeniería de sistemas y automática");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programación", "0000230", 10.0, TipoAsignatura.ANUAL, 1, lsi);
		testInmutabilidad(fp, 2015, Convocatoria.PRIMERA, 9.5, true, isa);
	}

	
	
	//////////////////////////////////////////////////
	//Métodos auxiliares
	
	private static void testConstructor1(Asignatura asignatura, Integer cursoAcademico, Convocatoria convocatoria, Double valor, Boolean mencionHonor) {
		try {
			Nota n = new NotaInmutableImpl(asignatura, cursoAcademico, convocatoria, valor, mencionHonor);
			mostrarNota(n);
		} catch (ExcepcionNotaNoValida e) {
			System.out.println("Se ha capturado la excepción ExcepcionNotaNoValida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción insesperada.");
		}
	}
	
	private static void testConstructor2(Asignatura asignatura, Integer cursoAcademico, Convocatoria convocatoria, Double valor) {
		try {
			Nota n = new NotaInmutableImpl(asignatura, cursoAcademico, convocatoria, valor);
			mostrarNota(n);
		} catch (ExcepcionNotaNoValida e) {
			System.out.println("Se ha capturado la excepción ExcepcionNotaNoValida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción insesperada.");
		}
	}
	
	private static void testConstructorString(List<Nota> notas){
		for (Nota n : notas) {
			try {
				mostrarNota(n);
			} catch (ExcepcionNotaNoValida e) {
				System.out.println("Se ha capturado la excepción ExcepcionNotaNoValida: \n\t" + e.getMessage());
			} catch (Exception e) {
				System.out.println("Se ha capturado una excepción inesperada.");
			}
		}
	}
	
	private static void compara(Nota n1, Nota n2) {
		System.out.print("El objeto <" + n1 + ">");
		if (n1.compareTo(n2) < 0) {
			System.out.print(" va ANTES que el objeto ");
		} else if (n1.compareTo(n2) > 0) {
			System.out.print(" va DESPUÉS que el objeto ");
		} else {
			System.out.print(" va en la MISMA POSICIÓN que el objeto ");
		}
		System.out.println("<" + n2 + ">");
	}
	
	private static void testInmutabilidad(Asignatura asignatura, Integer cursoAcademico, Convocatoria convocatoria, Double valor, Boolean mencionHonor, Departamento dep) {
		Nota n = new NotaInmutableImpl(asignatura, cursoAcademico, convocatoria, valor, mencionHonor);
		System.out.println("Departamento de la asignatura de la nota antes de intentar modificarlo: " + n.getAsignatura().getDepartamento());
		asignatura.setDepartamento(dep);
		System.out.println("Departamento de la asignatura de la nota después de modificarlo (debe haber permanecido igual): " + n.getAsignatura().getDepartamento());
	}
	
	private static void mostrarNota(Nota n) {
		System.out.println("Nota--> <" + n + ">");
		System.out.println("\tAsignatura: <" + n.getAsignatura() + ">");
		System.out.println("\tCurso academico: <" + n.getCursoAcademico() + "-" + Integer.toString(n.getCursoAcademico()+1).substring(2,4) + ">");
		System.out.println("\tConvocatoria: <" + n.getConvocatoria() + ">");
		System.out.println("\tValor: <" + n.getValor() + ">");
		System.out.println("\tMención de honor: <" + n.getMencionHonor() + ">");
		System.out.println("\tCalificación: <" + n.getCalificacion() + ">");
	}
}