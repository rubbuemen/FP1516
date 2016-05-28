package fp.grados.tipos.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fp.grados.excepciones.ExcepcionCentroNoValido;
import fp.grados.excepciones.ExcepcionCentroOperacionNoPermitida;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Centro;
import fp.grados.tipos.CentroImpl2;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Despacho;
import fp.grados.tipos.DespachoImpl;
import fp.grados.tipos.Espacio;
import fp.grados.tipos.EspacioImpl;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.TipoEspacio;
import fp.grados.utiles.Grados;

public class TestCentro2 {
	public static void main(String[] args) {
		testConstructorNormal();
		testConstructorExcepcional1();
		testConstructorExcepcional2();
		
		testMetodoCreacionalParametrosNormal();
		
		testMetodoCreacionalCopiaNormal();
			
		testGetEspacioMayorCapacidadNormal();
		testGetEspacioMayorCapacidadExcepcion();
		
		testGetConteosEspacios();
		
		testGetDespachos();
		
		testGetDespachosDepartamento();
		
		testGetProfesores();
		
		testGetProfesoresDepartamento();
		
		testGetDespachosPorProfesor();
		
		testMetodosPoblacionales();
	}

	private static void testConstructorNormal() {
		System.out.println("========Probando el constructor======================================================================================");
		testConstructor("Escuela T�cnica Superior de Ingenier�a Inform�tica", "Av. de Reina Mercedes s/n", 3, 1);
	}
	
	private static void testConstructorExcepcional1() {
		System.out.println("\n========Probando el constructor con un n�mero de plantas menor a 1======================================================================================");
		testConstructor("Escuela T�cnica Superior de Ingenier�a Inform�tica", "Av. Reina Mercedes s/n, Sevilla", 0, 1);
	}
	
	private static void testConstructorExcepcional2() {
		System.out.println("\n========Probando el constructor con un n�mero de sotanos negativo======================================================================================");
		testConstructor("Escuela T�cnica Superior de Ingenier�a Inform�tica", "Av. Reina Mercedes s/n, Sevilla", 2, -1);
	}
	
	private static void testMetodoCreacionalParametrosNormal() {
		System.out.println("\n========Probando m�todo creacional por par�metros======================================================================================");
		testMetodoCreacionalParametros("Escuela T�cnica Superior de Ingenier�a Inform�tica", "Av. de Reina Mercedes s/n", 3, 1);
		//Nota: para hacer saltar la excepci�n, habr�a que modificar los datos
	}
	
	private static void testMetodoCreacionalCopiaNormal() {
		System.out.println("\n========Probando m�todo creacional por copia======================================================================================");
		Espacio es = new EspacioImpl(TipoEspacio.LABORATORIO, "A3.10", 30, 1);
		Centro c = new CentroImpl2("Escuela T�cnica Superior de Ingenier�a", "Av. de Reina Mercedes s/n", 2, 5);
		testMetodoCreacionalCopia(c, es);
		//Nota: para hacer saltar la excepci�n, habr�a que modificar los datos
	}
	
	private static void testGetEspacioMayorCapacidadNormal(){
		System.out.println("\n========Probando getEspacioMayorCapacidad======================================================================================");
		Espacio es1 = new EspacioImpl(TipoEspacio.LABORATORIO, "A3.10", 30, 0);
		Espacio es2 = new EspacioImpl(TipoEspacio.LABORATORIO, "B4.10", 16, 1);
		Espacio es3 = new EspacioImpl(TipoEspacio.LABORATORIO, "C5.10", 45, 0);
		Centro c = new CentroImpl2("Escuela T�cnica Superior de Ingenier�a Inform�tica", "Av. Reina Mercedes s/n, Sevilla", 2, 0);
		c.nuevoEspacio(es1);
		c.nuevoEspacio(es2);
		c.nuevoEspacio(es3);
		testGetEspacioMayorCapacidad(c);
	}
	
	private static void testGetEspacioMayorCapacidadExcepcion(){
		System.out.println("\n========Probando getEspacioMayorCapacidad sin espacios======================================================================================");
		Centro c = new CentroImpl2("Escuela T�cnica Superior de Ingenier�a Inform�tica", "Av. Reina Mercedes s/n, Sevilla", 2, 0);
		testGetEspacioMayorCapacidad(c);
	}
	
	private static void testGetConteosEspacios() {
		System.out.println("\n========Probando getConteosEspacios======================================================================================");
		Centro etsii = new CentroImpl2("Escuela T�cnica Superior de Ingenier�a Inform�tica", "Av. Reina Mercedes s/n, Sevilla", 4, 1);
		etsii.nuevoEspacio(new EspacioImpl(TipoEspacio.TEORIA, "A0.10", 50, 0));
		etsii.nuevoEspacio(new EspacioImpl(TipoEspacio.TEORIA, "A1.10", 50, 1));
		etsii.nuevoEspacio(new EspacioImpl(TipoEspacio.TEORIA, "A2.10", 50, 2));
		etsii.nuevoEspacio(new EspacioImpl(TipoEspacio.EXAMEN, "A3.10", 150, 3));
		etsii.nuevoEspacio(new EspacioImpl(TipoEspacio.EXAMEN, "A3.11", 150, 3));
		etsii.nuevoEspacio(new EspacioImpl(TipoEspacio.LABORATORIO, "F1.30", 30, 1));
		etsii.nuevoEspacio(new EspacioImpl(TipoEspacio.LABORATORIO, "F1.31", 30, 1));
		etsii.nuevoEspacio(new EspacioImpl(TipoEspacio.LABORATORIO, "F1.32", 30, 1));
		etsii.nuevoEspacio(new EspacioImpl(TipoEspacio.LABORATORIO, "F1.33", 30, 1));
		etsii.nuevoEspacio(new EspacioImpl(TipoEspacio.SEMINARIO, "Sal�n de Grados", 60, 1));
		etsii.nuevoEspacio(new DespachoImpl("F0.20", 1, 0));
		etsii.nuevoEspacio(new DespachoImpl("F0.21", 3, 0));
		etsii.nuevoEspacio(new DespachoImpl("F0.22", 2, 0));
		mostrarEspaciosCentro(etsii);
		testGetConteosEspacios(etsii);
	}
	
	private static void testGetDespachos() {
		System.out.println("\n========Probando getDespachos======================================================================================");
		Centro etsii = new CentroImpl2("Escuela T�cnica Superior de Ingenier�a Inform�tica", "Av. Reina Mercedes s/n, Sevilla", 4, 1);
		Despacho d1 = new DespachoImpl("F0.20", 1, 0);
		Despacho d2 = new DespachoImpl("F0.21", 1, 0);
		Despacho d3 = new DespachoImpl("F0.22", 1, 0);
		etsii.nuevoEspacio(d1);
		etsii.nuevoEspacio(d2);
		etsii.nuevoEspacio(d3);
		testGetDespachos(etsii);
	}
	
	private static void testGetDespachosDepartamento() {
		System.out.println("\n========Probando getDespachos(Departamento)======================================================================================");
		Centro etsii = new CentroImpl2("Escuela T�cnica Superior de Ingenier�a Inform�tica", "Av. Reina Mercedes s/n, Sevilla", 4, 1);
		Profesor p1 = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@us.es", Categoria.AYUDANTE);
		Profesor p2 = new ProfesorImpl("12345678Z", "Miguel", "Nadie Nadie", LocalDate.of(1950, 3, 15),	"miguel.nadie@us.es", Categoria.CATEDRATICO);
		Profesor p3 = new ProfesorImpl("12345678Z", "Luisa", "Nadie Nadie", LocalDate.of(1950, 3, 15), "luisa.nadie@us.es", Categoria.AYUDANTE);
		Despacho d1 = new DespachoImpl("F0.20", 1, 0, p1);
		Despacho d2 = new DespachoImpl("F0.21", 2, 0, p2);
		Despacho d3 = new DespachoImpl("F0.22", 1, 0, p3);
		Departamento lsi = new DepartamentoImpl("Lenguajes y Sistemas Inform�ticos");
		Departamento ccia = new DepartamentoImpl("Ciencias de la Computaci�n e Inteligencia Artificial");
		lsi.nuevoProfesor(p1);
		lsi.nuevoProfesor(p2);
		ccia.nuevoProfesor(p3);
		etsii.nuevoEspacio(d1);
		etsii.nuevoEspacio(d2);
		etsii.nuevoEspacio(d3);
		testGetDespachosDepartamento(etsii, lsi);
	}
	
	private static void testGetProfesores() {
		System.out.println("\n========Probando getProfesores======================================================================================");
		Centro etsii = new CentroImpl2("Escuela T�cnica Superior de Ingenier�a Inform�tica", "Av. Reina Mercedes s/n, Sevilla", 4, 1);
		Profesor p1 = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@us.es", Categoria.AYUDANTE);
		Profesor p2 = new ProfesorImpl("12345678Z", "Miguel", "Nadie Nadie", LocalDate.of(1950, 3, 15),	"miguel.nadie@us.es", Categoria.CATEDRATICO);
		Despacho d1 = new DespachoImpl("F0.20", 1, 0, p1);
		Despacho d2 = new DespachoImpl("F0.21", 2, 0, p2);
		etsii.nuevoEspacio(d1);
		etsii.nuevoEspacio(d2);
		testGetProfesores(etsii);
	}
	
	private static void testGetProfesoresDepartamento() {
		System.out.println("\n========Probando getProfesores(Departamento)======================================================================================");
		Centro etsii = new CentroImpl2("Escuela T�cnica Superior de Ingenier�a Inform�tica", "Av. Reina Mercedes s/n, Sevilla", 4, 1);
		Profesor p1 = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@us.es", Categoria.AYUDANTE);
		Profesor p2 = new ProfesorImpl("12345678Z", "Miguel", "Nadie Nadie", LocalDate.of(1950, 3, 15),	"miguel.nadie@us.es", Categoria.CATEDRATICO);
		Despacho d1 = new DespachoImpl("F0.20", 1, 0, p1);
		Despacho d2 = new DespachoImpl("F0.21", 2, 0, p2);
		Departamento lsi = new DepartamentoImpl("Lenguajes y Sistemas Inform�ticos");
		lsi.nuevoProfesor(p1);
		lsi.nuevoProfesor(p2);
		etsii.nuevoEspacio(d1);
		etsii.nuevoEspacio(d2);
		testGetProfesoresDepartamento(etsii, lsi);
	}
	
	private static void testGetDespachosPorProfesor(){
		System.out.println("\n========Probando getDespachoPorProfesor======================================================================================");
		Centro etsii = new CentroImpl2("Escuela T�cnica Superior de Ingenier�a Inform�tica", "Av. Reina Mercedes s/n, Sevilla", 4, 1);
		Profesor p1 = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@us.es", Categoria.AYUDANTE);
		Profesor p2 = new ProfesorImpl("12345678Z", "Miguel", "Nadie Nadie", LocalDate.of(1950, 3, 15),	"miguel.nadie@us.es", Categoria.CATEDRATICO);
		Profesor p3 = new ProfesorImpl("12345678Z", "Pepe", "Nadie Nadie", LocalDate.of(1950, 3, 15),	"miguel.nadie@us.es", Categoria.CATEDRATICO);
		Set<Profesor> profesores = new HashSet<>();
		profesores.add(p2);
		profesores.add(p3);
		Despacho d1 = new DespachoImpl("F0.20", 1, 0, p1);
		Despacho d2 = new DespachoImpl("F0.21", 2, 0);
		d2.setProfesores(profesores);
		etsii.nuevoEspacio(d1);
		etsii.nuevoEspacio(d2);
		mostrarEspaciosCentro(etsii);
		testGetDespachoPorProfesor(etsii);
	}

	private static void testMetodosPoblacionales() {
		System.out.println("\n========Probando m�todos poblacionales======================================================================================");
		System.out.println("N�mero de centros creados: " + Grados.getNumCentrosCreados());
		System.out.println("Centros creados: " + Grados.getCentrosCreados());
		System.out.println("N�mero m�ximo de plantas: " + Grados.getMaxPlantas());
		System.out.println("N�mero m�ximo de sotanos: " + Grados.getMaxSotanos());
		System.out.println("N�mero medio de plantas: " + Grados.getMediaPlantas());
		System.out.println("N�mero medio de sotanos: " + Grados.getMediaSotanos());
	}
	
	
	
	//////////////////////////////////////////////////
	//M�todos auxiliares
	
	private static void testConstructor(String nombre, String direccion, Integer numeroPlantas, Integer numeroSotanos) {
		try {
			Centro c = new CentroImpl2(nombre, direccion, numeroPlantas, numeroSotanos);
			mostrarCentro(c);
		} catch (ExcepcionCentroNoValido e) {
			System.out.println("Se ha capturado la excepci�n ExcepcionCentroNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepci�n inesperada.");
		}
	}
	
	private static void testMetodoCreacionalParametros(String nombre, String direccion, Integer numeroPlantas, Integer numeroSotanos) {
		try {
			Grados.setUsarJava8(true);
			Centro c = Grados.createCentro(nombre, direccion, numeroPlantas, numeroSotanos);
			mostrarCentro(c);
		} catch (ExcepcionCentroNoValido e) {
			System.out.println("Se ha capturado la excepci�n ExcepcionCentroNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepci�n inesperada.");
		}
	}
	
	private static void testMetodoCreacionalCopia(Centro c, Espacio es) {
		try {
			Grados.setUsarJava8(true);
			c.nuevoEspacio(es);
			Centro res = Grados.createCentro(c);
			mostrarCentro(res);
		} catch (ExcepcionCentroNoValido e) {
			System.out.println("Se ha capturado la excepci�n ExcepcionCentroNoValido: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepci�n inesperada.");
		}
	}
	
	private static void testGetEspacioMayorCapacidad(Centro c){
		try{
			System.out.println("Espacios del centro " + c + " con su capacidad:");
			for (Espacio es : c.getEspacios()) {
				System.out.println(es + " <" + es.getCapacidad() + ">");
			}
			System.out.println("El espacio del centro " + c + " con mayor capacidad es: " + c.getEspacioMayorCapacidad());
		} catch (ExcepcionCentroOperacionNoPermitida e) {
			System.out.println("Se ha capturado la excepci�n ExcepcionCentroOperacionNoPermitida: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepci�n inesperada.");
		}
	}
	
	private static void testGetConteosEspacios(Centro c) {
		System.out.println("Conteo de tipos de espacios:");
		Integer[] conteos = c.getConteosEspacios();
		for (int i = 0; i < conteos.length; i++) {
			System.out.println("Espacios de tipo " + TipoEspacio.values()[i] + ": " + conteos[i]);
		}
	}
	
	private static void testGetDespachos(Centro c) {
		System.out.println("Despachos del centro " + c + ":");
		for (Despacho desp : c.getDespachos()) {
			System.out.println(desp);
		}
	}
	
	private static void testGetDespachosDepartamento(Centro c, Departamento dep) {
		System.out.println("Despachos del centro " + c + " con profesores del departamento " + dep);
		for (Despacho desp : c.getDespachos(dep)) {
			System.out.println(desp);
		}
	}
	
	private static void testGetProfesores(Centro c) {
		System.out.println("Profesores con despacho en el centro " + c + ":");
		for (Profesor pr : c.getProfesores()) {
			System.out.println(pr);
		}
	}
	
	private static void testGetProfesoresDepartamento(Centro c, Departamento dep) {
		System.out.println("Profesores con despacho en el centro " + c + " que pertenecen al departamento " + dep);
		for (Profesor pr : c.getProfesores()) {
			System.out.println(pr);
		}
	}
	
	private static void testGetDespachoPorProfesor(Centro c) {
		System.out.println("Las asociaciones de cada profesor con el despacho que ocupa en el centro: " + c.getDespachosPorProfesor());
	}
	
	private static void mostrarEspaciosCentro(Centro c) {
		System.out.println("Espacios del centro " + c + ":");
		for (Espacio es : c.getEspacios()) {
			System.out.println(es.getTipo() + ": " + es);
		}
	}

	private static void mostrarCentro(Centro c) {
		System.out.println("Centro--> <" + c + ">");
		System.out.println("Nombre: <" + c.getNombre() + ">");
		System.out.println("Direcci�n: <" + c.getDireccion() + ">");
		System.out.println("N�mero de plantas: <" + c.getNumeroPlantas() + ">");
		System.out.println("N�mero de sotanos: <" + c.getNumeroSotanos() + ">");
		System.out.println("Espacios: <" + c.getEspacios() + ">");
	}
}