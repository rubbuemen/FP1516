package fp.grados.tipos.test;

import java.util.List;

import fp.grados.excepciones.ExcepcionAsignaturaNoValida;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.utiles.Grados;

public class TestAsignatura {
	public static void main(String[] args) {
		testConstructor1Normal();
		testConstructor1Excepcion1();
		testConstructor1Excepcion2();
		testConstructor1Excepcion3();
		testConstructor1Excepcion4();
		testConstructor1Excepcion5();
		testConstructor1Excepcion6();
		testConstructor1Excepcion7();
		
		testConstructor2Normal();
		testConstructor2Excepcion1();
		testConstructor2Excepcion2();
		testConstructor2Excepcion3();
		testConstructor2Excepcion4();
		testConstructor2Excepcion5();
		testConstructor2Excepcion6();
		testConstructor2Excepcion7();
		
		testConstructorStringNormal();
		
		testMetodoCreacionalParametrosNormal();
				
		testMetodoCreacionalStringNormal();
		
		testMetodoCreacionalFicheroNormal();
		
		testSetDepartamento();
		
		testGetAcronimo();

		testIgualdad();
		testOrden();
		
		testMetodosPoblacionales();
	}

	private static void testConstructor1Normal() {
		System.out.println("========Probando el primer constructor======================================================================================");
		testConstructor1("Fundamentos de Programación", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
	}

	private static void testConstructor1Excepcion1() {
		System.out.println("\n========Probando el primer constructor, código de asignatura más largo======================================================================================");
		testConstructor1("Fundamentos de Programación", "20500010", 12.0, TipoAsignatura.ANUAL, 1);
	}

	private static void testConstructor1Excepcion2() {
		System.out.println("\n========Probando el primer constructor, código de asignatura más corto======================================================================================");
		testConstructor1("Fundamentos de Programación", "205000", 12.0, TipoAsignatura.ANUAL, 1);
	}

	private static void testConstructor1Excepcion3() {
		System.out.println("\n========Probando el primer constructor, código de asignatura no numérico======================================================================================");
		testConstructor1("Fundamentos de Programación", "2A50001", 12.0, TipoAsignatura.ANUAL, 1);
	}

	private static void testConstructor1Excepcion4() {
		System.out.println("\n========Probando el primer constructor, créditos incorrectos (0.0)======================================================================================");
		testConstructor1("Fundamentos de Programación", "2050001", 0.0, TipoAsignatura.ANUAL, 1);
	}

	private static void testConstructor1Excepcion5() {
		System.out.println("\n========Probando el primer constructor, créditos incorrectos (-1.0)======================================================================================");
		testConstructor1("Fundamentos de Programación", "2050001", -1.0, TipoAsignatura.ANUAL, 1);
	}

	private static void testConstructor1Excepcion6() {
		System.out.println("\n========Probando el primer constructor, curso menor de 1======================================================================================");
		testConstructor1("Fundamentos de Programación", "2050001", 12.0, TipoAsignatura.ANUAL, -2);
	}

	private static void testConstructor1Excepcion7() {
		System.out.println("\n========Probando el primer constructor, curso mayor de 4======================================================================================");
		testConstructor1("Fundamentos de Programación", "2050001", 12.0, TipoAsignatura.ANUAL, 5);
	}
	
	private static void testConstructor2Normal() {
		System.out.println("\n========Probando el segundo constructor======================================================================================");
		Departamento dep = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		testConstructor2("Fundamentos de Programación", "2050001", 12.0, TipoAsignatura.ANUAL, 1, dep);
	}

	private static void testConstructor2Excepcion1() {
		System.out.println("\n========Probando el segundo constructor, código de asignatura más largo======================================================================================");
		Departamento dep = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		testConstructor2("Fundamentos de Programación", "20500010", 12.0, TipoAsignatura.ANUAL, 1, dep);
	}

	private static void testConstructor2Excepcion2() {
		System.out.println("\n========Probando el segundo constructor, código de asignatura más corto======================================================================================");
		Departamento dep = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		testConstructor2("Fundamentos de Programación", "205000", 12.0, TipoAsignatura.ANUAL, 1, dep);
	}

	private static void testConstructor2Excepcion3() {
		System.out.println("\n========Probando el segundo constructor, código de asignatura no numérico======================================================================================");
		Departamento dep = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		testConstructor2("Fundamentos de Programación", "2A50001", 12.0, TipoAsignatura.ANUAL, 1, dep);
	}

	private static void testConstructor2Excepcion4() {
		System.out.println("\n========Probando el segundo constructor, créditos incorrectos (0.0)======================================================================================");
		Departamento dep = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		testConstructor2("Fundamentos de Programación", "2050001", 0.0, TipoAsignatura.ANUAL, 1, dep);
	}

	private static void testConstructor2Excepcion5() {
		System.out.println("\n========Probando el segundo constructor, créditos incorrectos (-1.0)======================================================================================");
		Departamento dep = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		testConstructor2("Fundamentos de Programación", "2050001", -1.0, TipoAsignatura.ANUAL, 1, dep);
	}

	private static void testConstructor2Excepcion6() {
		System.out.println("\n========Probando el segundo constructor, curso menor de 1======================================================================================");
		Departamento dep = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		testConstructor2("Fundamentos de Programación", "2050001", 12.0, TipoAsignatura.ANUAL, -2, dep);
	}

	private static void testConstructor2Excepcion7() {
		System.out.println("\n========Probando el segundo constructor, curso mayor de 4======================================================================================");
		Departamento dep = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		testConstructor2("Fundamentos de Programación", "2050001", 12.0, TipoAsignatura.ANUAL, 5, dep);
	}
	
	private static void testConstructorStringNormal(){
		System.out.println("\n========Probando el constructor con String======================================================================================");
		List<Asignatura> asignaturas = Grados.leeFichero("res/asignaturas.txt", s -> new AsignaturaImpl(s));
		testConstructorString(asignaturas);
		//Nota: para hacer saltar una excepción, habría que modificar el fichero de texto
	}
	
	private static void testMetodoCreacionalParametrosNormal() {
		System.out.println("\n========Probando método creacional por parámetros======================================================================================");
		Departamento lsi = new DepartamentoImpl("LSI");
		testMetodoCreacionalParametros("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1, lsi);
		//Nota: para hacer saltar la excepción, habría que modificar los datos
	}
	
	private static void testMetodoCreacionalStringNormal() {
		System.out.println("\n========Probando método creacional por string======================================================================================");
		testMetodoCreacionalString("Fundamentos de Programacion#1234567#12.0#ANUAL#1");
		//Nota: para hacer saltar la excepción, habría que modificar los datos
	}

	private static void testMetodoCreacionalFicheroNormal(){
		System.out.println("\n========Probando método creacional con fichero======================================================================================");
		testMetodoCreacionalFichero("res/asignaturas.txt");
		//Nota: para hacer saltar una excepción, habría que modificar el fichero de texto
	}
	
	private static void testSetDepartamento() {
		System.out.println("\n========Probando setDepartamento======================================================================================");
		Departamento dep = new DepartamentoImpl("Lenguajes y Sistemas Informáticos");
		Departamento dep2 = new DepartamentoImpl("Ingeniería de sistemas y automática");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programación", "2050001", 12.0, TipoAsignatura.ANUAL, 1, dep);
		testSetDepartamento(asig, dep2);
	}
	
	private static void testGetAcronimo() {
		System.out.println("\n========Probando getAcronimo======================================================================================");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programación", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		testGetAcronimo(asig);
	}
	
	private static void testIgualdad() {
		System.out.println("\n========Probando igualdad======================================================================================");
		Asignatura asig1 = new AsignaturaImpl("Fundamentos de Programación", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Asignatura asig2 = new AsignaturaImpl("Fundamentos de Programación", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Asignatura asig3 = new AsignaturaImpl("Estructura de Computadores", "2050009", 6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1);
		System.out.println("Código hash del objeto a1 (" + asig1 + "): " + asig1.hashCode());
		System.out.println("Código hash del objeto a2 (" + asig2 + "): " + asig2.hashCode());
		System.out.println("Código hash del objeto a3 (" + asig3 + "): " + asig3.hashCode());
		System.out.println("¿Es a1 igual a a2? (debe ser true): " + asig1.equals(asig2));
		System.out.println("¿Es a1 distinto de a3? (debe ser true): " + !asig1.equals(asig3));
	}
	
	private static void testOrden() {
		System.out.println("\n========Probando orden natural======================================================================================");
		Asignatura menor = new AsignaturaImpl("Fundamentos de Programación", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Asignatura igual1 = new AsignaturaImpl("Estructura de Computadores", "2050009", 6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1);
		Asignatura igual2 = new AsignaturaImpl("Estructura de Computadores", "2050009", 6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1);
		Asignatura mayor = new AsignaturaImpl("Ingeniería de Requisitos", "2050020", 6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 3);
		System.out.println("- Debe ser ANTES: ");
		compara(menor, igual1);
		System.out.println("- Debe ser MISMA POSICIÓN: ");
		compara(igual1, igual2);
		System.out.println("- Debe ser DESPUÉS: ");
		compara(mayor, igual2);
	}
	
	private static void testMetodosPoblacionales() {
		System.out.println("\n========Probando métodos poblacionales======================================================================================");
		System.out.println("Número de asignaturas creadas: " + Grados.getNumAsignaturasCreadas());
		System.out.println("Asignaturas creadas: " + Grados.getAsignaturasCreadas());
		System.out.println("Códigos de las asignaturas creadas: " + Grados.getCodigosAsignaturasCreadas());
		System.out.println("Asignatura con un determinado código: " + Grados.getAsignaturaCreada("2050001"));
	}


	
	//////////////////////////////////////////////////
	//Métodos auxiliares
	
	private static void testConstructor1(String nombre, String codigo, Double creditos, TipoAsignatura tipo, Integer curso) {
		try {
			Asignatura asig = new AsignaturaImpl(nombre, codigo, creditos, tipo, curso);
			mostrarAsignatura(asig);
		} catch (ExcepcionAsignaturaNoValida e) {
			System.out.println("Se ha capturado la excepción ExcepcionAsignaturaNoValida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción insesperada.");
		}
	}
	
	private static void testConstructor2(String nombre, String codigo, Double creditos, TipoAsignatura tipo, Integer curso, Departamento dep) {
		try {
			Asignatura a = new AsignaturaImpl(nombre, codigo, creditos, tipo, curso, dep);
			mostrarAsignatura(a);
		} catch (ExcepcionAsignaturaNoValida e) {
			System.out.println("Se ha capturado la excepción ExcepcionAsignaturaNoValida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción insesperada.");
		}
	}
	
	private static void testConstructorString(List<Asignatura> asignaturas){
		for (Asignatura asig : asignaturas) {
			try {
				mostrarAsignatura(asig);
			} catch (ExcepcionAsignaturaNoValida e) {
				System.out.println("Se ha capturado la excepción ExcepcionAsignaturaNoValida \n\t" + e.getMessage());
			} catch (Exception e) {
				System.out.println("Se ha capturado una excepción inesperada.");
			}
		}
	}
	
	private static void testMetodoCreacionalParametros(String nombre, String codigo, Double creditos, TipoAsignatura tipo, Integer curso, Departamento departamento) {
		try {
			Asignatura asig = Grados.createAsignatura(nombre, codigo, creditos, tipo, curso, departamento);
			mostrarAsignatura(asig);
		} catch (ExcepcionAsignaturaNoValida e) {
			System.out.println("Se ha capturado la excepción ExcepcionAsignaturaNoValida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción inesperada.");
		}
	}
	
	private static void testMetodoCreacionalString(String asig) {
		try {
			Asignatura res= Grados.createAsignatura(asig);
			mostrarAsignatura(res);
		} catch (ExcepcionAsignaturaNoValida e) {
			System.out.println("Se ha capturado la excepción ExcepcionAsignaturaNoValida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepción inesperada.");
		}
	}
	
	private static void testMetodoCreacionalFichero(String fichero) {
		List<Asignatura> asignaturas = Grados.createAsignaturas(fichero);
		for (Asignatura asig : asignaturas) {
			mostrarAsignatura(asig);
		}
	}
	
	private static void testSetDepartamento(Asignatura asig, Departamento dep) {
		System.out.println("El departamento de la asignatura antes de la operación es: " + asig.getDepartamento());
		System.out.println("El nuevo departamento es: " + dep);
		asig.setDepartamento(dep);
		System.out.println("El departamento de la asignatura después de la operación es: " + asig.getDepartamento());
	}
	
	private static void testGetAcronimo(Asignatura asig){
		System.out.println("El acrónimo para la asignatura '" + asig + "' es: " + asig.getAcronimo());
	}
	
	private static void compara(Asignatura asig1, Asignatura asig2) {
		System.out.print("El objeto <" + asig1 + ">");
		if (asig1.compareTo(asig2) < 0) {
			System.out.print(" va ANTES que el objeto ");
		} else if (asig1.compareTo(asig2) > 0) {
			System.out.print(" va DESPUÉS que el objeto ");
		} else {
			System.out.print(" va en la MISMA POSICIÓN que el objeto ");
		}
		System.out.println("<" + asig2 + ">");
	}

	private static void mostrarAsignatura(Asignatura asig) {
		System.out.println("Asignatura --> <" + asig + ">");
		System.out.println("\tNombre: <" + asig.getNombre() + ">");
		System.out.println("\tAcrónimo: <" + asig.getAcronimo() + ">");
		System.out.println("\tCódigo: <" + asig.getCodigo() + ">");
		System.out.println("\tCréditos: <" + asig.getCreditos() + ">");
		System.out.println("\tTipo: <" + asig.getTipo() + ">");
		System.out.println("\tCurso: <" + asig.getCurso() + ">");
		System.out.println("\tDepartamento: <" + asig.getDepartamento() + ">");
	}
}