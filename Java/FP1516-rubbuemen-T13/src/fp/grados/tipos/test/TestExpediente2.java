package fp.grados.tipos.test;

import fp.grados.excepciones.ExcepcionExpedienteOperacionNoPermitida;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Convocatoria;
import fp.grados.tipos.Expediente;
import fp.grados.tipos.ExpedienteImpl2;
import fp.grados.tipos.Nota;
import fp.grados.tipos.NotaImpl;
import fp.grados.tipos.TipoAsignatura;

public class TestExpediente2 {
	public static void main(String[] args) {
		testConstructor();
		
		testGetNotaMedia1();
		testGetNotaMedia2();
	}

	private static void testConstructor() {
		System.out.println("========Probando el constructor======================================================================================");
		Expediente ex = new ExpedienteImpl2();
		mostrarExpediente(ex);
	}
	
	private static void testGetNotaMedia1(){
		System.out.println("\n========Probando el método getNotaMedia para un expedientes con notas mayores o iguales a 5======================================================================================");
		Expediente ex = new ExpedienteImpl2();
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Asignatura adda = new AsignaturaImpl("Analisis y Diseño de Datos y Algoritmos", "2050010", 12.0, TipoAsignatura.ANUAL, 2);
		Nota n1 = new NotaImpl(fp, 2015, Convocatoria.PRIMERA, 9.0, true);
		Nota n2 = new NotaImpl(adda, 2015, Convocatoria.PRIMERA, 5.0, false);
		testNuevaNota(n1, ex);
		testNuevaNota(n2, ex);
		testGetNotaMedia(ex);
	}
	
	private static void testGetNotaMedia2(){
		System.out.println("\n========Probando el método getNotaMedia para un expedientes sin notas mayores o iguales a 5======================================================================================");
		Expediente ex = new ExpedienteImpl2();
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Asignatura adda = new AsignaturaImpl("Analisis y Diseño de Datos y Algoritmos", "2050010", 12.0, TipoAsignatura.ANUAL, 2);
		Nota n1 = new NotaImpl(fp, 2015, Convocatoria.PRIMERA, 3.0, false);
		Nota n2 = new NotaImpl(adda, 2015, Convocatoria.PRIMERA, 4.0, false);
		testNuevaNota(n1, ex);
		testNuevaNota(n2, ex);
		testGetNotaMedia(ex);
	}


	
	//////////////////////////////////////////////////
	//Métodos auxiliares
	
	private static void testGetNotaMedia(Expediente ex){
		System.out.println("La nota media del expediente es: " + ex.getNotaMedia());
	}
	
	private static void testNuevaNota(Nota n, Expediente ex) {
		try{
			System.out.println("El expediente antes de la operación es: " + ex.getNotas());
			System.out.println("Nueva nota a añadir: " + n);
			ex.nuevaNota(n);
			System.out.println("El expediente después de la operación es: " + ex.getNotas());
		} catch (ExcepcionExpedienteOperacionNoPermitida e) {
			System.out.println("Se ha capturado la excepción ExcepcionExpedienteOperacionNoPermitida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción inesperada.");
		}
	}

	private static void mostrarExpediente(Expediente ex) {
		System.out.println("Expediente--> <" + ex + ">");
		System.out.println("Notas: <" + ex.getNotas() + ">");
	}
}