package fp.grados.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.NoSuchElementException;

import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.utiles.Grados;

public class TestDepartamento {
	public static void main(String[] args) {
		testConstructor();
		
		testMetodoCreacionalParametros();

		testRelacionBidireccionalAsignaturas();
		testRelacionBidireccionalProfesores();
		
		testBorraTutorias();
		
		testBorraTutoriasCategoria();
		
		testExisteProfesorAsignado();
		
		testEstanTodasAsignaturasAsignadas();
		
		testEliminaAsignacionProfesoradoAsignatura();
		
		testGetProfesoresPorAsignatura();
		
		testGetTutoriasPorProfesor();

		testIgualdad();
		testOrden();
		
		testMetodosPoblacionales();
		
		testGetProfesorMaximaDedicacionMediaPorAsignaturaNormal();
		testGetProfesorMaximaDedicacionMediaPorAsignaturaExcepcion1();
		testGetProfesorMaximaDedicacionMediaPorAsignaturaExcepcion2();
	}

	private static void testConstructor() {
		System.out.println("========Probando el constructor======================================================================================");
		Departamento dep = new DepartamentoImpl("Lenguajes y Sistemas Inform�ticos");
		mostrarDepartamento(dep);
	}
	
	private static void testMetodoCreacionalParametros() {
		System.out.println("\n========Probando m�todo creacional por par�metros======================================================================================");
		testMetodoCreacionalParametros("Lenguajes y Sistemas Inform�ticos");
	}

	private static void testRelacionBidireccionalAsignaturas() {
		System.out.println("\n========Probando la relaci�n bidireccional entre Departamento y Asignatura======================================================================================");
		Departamento lsi = new DepartamentoImpl("Lenguajes y Sistemas Inform�ticos");
		Departamento ccia = new DepartamentoImpl("Ciencias de la Computaci�n e Inteligencia Artificial");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programaci�n", "2050001", 12.0, TipoAsignatura.ANUAL, 1, lsi);
		System.out.println("- Mostramos el departamento LSI y CCIA y la asignatura FP para ver sus estados actuales:");
		mostrarDepartamento(lsi);
		mostrarDepartamento(ccia);
		mostrarAsignatura(fp);
		System.out.println("- A�adimos la asignatura FP al departamento CCIA, mediante la operaci�n nuevaAsignatura del tipo Departamento, y volvemos a ver sus estados actuales:");
		ccia.nuevaAsignatura(fp);
		mostrarDepartamento(lsi);
		mostrarDepartamento(ccia);
		mostrarAsignatura(fp);
		System.out.println("- Cambiamos al departamento LSI la asignatura FP, mediante la operaci�n setDepartamento del tipo Asignatura, y volvemos a ver sus estados actuales:");
		fp.setDepartamento(lsi);
		mostrarDepartamento(lsi);
		mostrarDepartamento(ccia);
		mostrarAsignatura(fp);
		System.out.println("- Eliminamos del departamento LSI la asignatura FP, mediante la operaci�n eliminaAsignatura del tipo Departamento, y volvemos a ver sus estados actuales:");
		lsi.eliminaAsignatura(fp);
		mostrarDepartamento(lsi);
		mostrarDepartamento(ccia);
		mostrarAsignatura(fp);
	}
	
	private static void testRelacionBidireccionalProfesores() {
		System.out.println("\n========Probando la relaci�n bidireccional entre Departamento y Profesor======================================================================================");
		Departamento lsi = new DepartamentoImpl("Lenguajes y Sistemas Inform�ticos");
		Departamento ccia = new DepartamentoImpl("Ciencias de la Computaci�n e Inteligencia Artificial");
		Profesor juan = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@gmail.es", Categoria.TITULAR, lsi);
		System.out.println("- Mostramos el departamento LSI y CCIA y el profesor Juan para ver sus estados actuales:");
		mostrarDepartamento(lsi);
		mostrarDepartamento(ccia);
		mostrarProfesor(juan);
		System.out.println("- A�adimos el profesor Juan al departamento CCIA, mediante la operaci�n nuevoProfesor del tipo Departamento, y volvemos a ver sus estados actuales:");
		ccia.nuevoProfesor(juan);
		mostrarDepartamento(lsi);
		mostrarDepartamento(ccia);
		mostrarProfesor(juan);
		System.out.println("- Cambiamos al departamento LSI el profesor Juan, mediante la operaci�n setDepartamento del tipo Profesor, y volvemos a ver sus estados actuales:");
		juan.setDepartamento(lsi);
		mostrarDepartamento(lsi);
		mostrarDepartamento(ccia);
		mostrarProfesor(juan);
		System.out.println("- Eliminamos del departamento LSI el profesor Juan, mediante la operaci�n eliminaProfesor del tipo Departamento, y volvemos a ver sus estados actuales:");
		lsi.eliminaProfesor(juan);
		mostrarDepartamento(lsi);
		mostrarDepartamento(ccia);
		mostrarProfesor(juan);
	}
	
	private static void testBorraTutorias() {
		System.out.println("\n========Probando borraTutorias======================================================================================");
		Departamento dep = new DepartamentoImpl("Lenguajes y Sistemas Inform�ticos");
		Profesor pr1 = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@us.es", Categoria.AYUDANTE);
		Profesor pr2 = new ProfesorImpl("12345678Z", "Miguel", "Nadie Nadie", LocalDate.of(1950, 3, 15), "miguel.nadie@us.es", Categoria.CATEDRATICO);
		Profesor pr3 = new ProfesorImpl("12345678Z", "Luisa", "Nadie Nadie", LocalDate.of(1950, 3, 15), "luisa.nadie@us.es", Categoria.AYUDANTE);
		pr1.nuevaTutoria(LocalTime.of(10, 30), 60, DayOfWeek.MONDAY);
		pr2.nuevaTutoria(LocalTime.of(10, 30), 60, DayOfWeek.MONDAY);
		pr3.nuevaTutoria(LocalTime.of(10, 30), 60, DayOfWeek.MONDAY);
		dep.nuevoProfesor(pr1);
		dep.nuevoProfesor(pr2);
		dep.nuevoProfesor(pr3);
		testBorraTutorias(dep);
	}
	
	private static void testBorraTutoriasCategoria() {
		System.out.println("\n========Probando borraTutorias(Categoria)======================================================================================");
		Departamento dep = new DepartamentoImpl("Lenguajes y Sistemas Inform�ticos");
		Profesor pr1 = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@us.es", Categoria.AYUDANTE);
		Profesor pr2 = new ProfesorImpl("12345678Z", "Miguel", "Nadie Nadie", LocalDate.of(1950, 3, 15), "miguel.nadie@us.es", Categoria.CATEDRATICO);
		Profesor pr3 = new ProfesorImpl("12345678Z", "Luisa", "Nadie Nadie", LocalDate.of(1950, 3, 15), "luisa.nadie@us.es", Categoria.AYUDANTE);
		pr1.nuevaTutoria(LocalTime.of(10, 30), 60, DayOfWeek.MONDAY);
		pr2.nuevaTutoria(LocalTime.of(10, 30), 60, DayOfWeek.MONDAY);
		pr3.nuevaTutoria(LocalTime.of(10, 30), 60, DayOfWeek.MONDAY);
		dep.nuevoProfesor(pr1);
		dep.nuevoProfesor(pr2);
		dep.nuevoProfesor(pr3);
		testBorraTutoriasCategoria(dep, Categoria.AYUDANTE);
	}
	
	private static void testExisteProfesorAsignado() {
		System.out.println("\n========Probando existeProfesorAsignado======================================================================================");
		Departamento dep = new DepartamentoImpl("Lenguajes y Sistemas Inform�ticos");
		Profesor pr1 = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@us.es", Categoria.AYUDANTE);
		Profesor pr2 = new ProfesorImpl("12345678Z", "Miguel", "Nadie Nadie", LocalDate.of(1950, 3, 15), "miguel.nadie@us.es", Categoria.CATEDRATICO);
		Profesor pr3 = new ProfesorImpl("12345678Z", "Luisa", "Nadie Nadie", LocalDate.of(1950, 3, 15), "luisa.nadie@us.es", Categoria.AYUDANTE);
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Asignatura adda = new AsignaturaImpl("Analisis y Dise�o de Datos y Algoritmos", "2050010", 12.0, TipoAsignatura.ANUAL, 2);
		dep.nuevoProfesor(pr1);
		dep.nuevoProfesor(pr2);
		dep.nuevoProfesor(pr3);
		dep.nuevaAsignatura(fp);
		pr1.imparteAsignatura(fp, 3.0);
		testExisteProfesorAsignado(dep, fp);
		testExisteProfesorAsignado(dep, adda);
	}
	
	private static void testEstanTodasAsignaturasAsignadas() {
		System.out.println("\n========Probando estanTodasAsignaturasAsignadas======================================================================================");
		Departamento dep = new DepartamentoImpl("Lenguajes y Sistemas Inform�ticos");
		Profesor pr1 = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@us.es", Categoria.AYUDANTE);
		Profesor pr2 = new ProfesorImpl("12345678Z", "Miguel", "Nadie Nadie", LocalDate.of(1950, 3, 15), "miguel.nadie@us.es", Categoria.CATEDRATICO);
		Profesor pr3 = new ProfesorImpl("12345678Z", "Luisa", "Nadie Nadie", LocalDate.of(1950, 3, 15), "luisa.nadie@us.es", Categoria.AYUDANTE);
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Asignatura adda = new AsignaturaImpl("Analisis y Dise�o de Datos y Algoritmos", "2050010", 12.0, TipoAsignatura.ANUAL, 2);
		Asignatura ir = new AsignaturaImpl("Ingenier�a de Requisitos", "2050020", 6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 3);
		Asignatura so = new AsignaturaImpl("Sistemas Operativos", "2050014", 6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 2);
		dep.nuevoProfesor(pr1);
		dep.nuevoProfesor(pr2);
		dep.nuevoProfesor(pr3);
		dep.nuevaAsignatura(fp);
		dep.nuevaAsignatura(adda);
		dep.nuevaAsignatura(ir);
		dep.nuevaAsignatura(so);
		pr1.imparteAsignatura(ir, 1.0);
		pr1.imparteAsignatura(so, 3.5);
		pr2.imparteAsignatura(so, 3.0);
		pr2.imparteAsignatura(adda, 3.0);
		pr3.imparteAsignatura(ir, 2.0);
		pr3.imparteAsignatura(fp, 3.0);
		testEstanTodasAsignaturasAsignadas(dep);
		pr2.eliminaAsignatura(adda);
		testEstanTodasAsignaturasAsignadas(dep);
	}
	
	private static void testEliminaAsignacionProfesoradoAsignatura() {
		System.out.println("\n========Probando eliminaAsignacionProfesoradoAsignatura======================================================================================");
		Departamento dep = new DepartamentoImpl("Lenguajes y Sistemas Inform�ticos");
		Profesor pr1 = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@us.es", Categoria.AYUDANTE);
		Profesor pr2 = new ProfesorImpl("12345678Z", "Miguel", "Nadie Nadie", LocalDate.of(1950, 3, 15), "miguel.nadie@us.es", Categoria.CATEDRATICO);
		Profesor pr3 = new ProfesorImpl("12345678Z", "Luisa", "Nadie Nadie", LocalDate.of(1950, 3, 15), "luisa.nadie@us.es", Categoria.AYUDANTE);
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Asignatura adda = new AsignaturaImpl("Analisis y Dise�o de Datos y Algoritmos", "2050010", 12.0, TipoAsignatura.ANUAL, 2);
		Asignatura ir = new AsignaturaImpl("Ingenier�a de Requisitos", "2050020", 6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 3);
		Asignatura so = new AsignaturaImpl("Sistemas Operativos", "2050014", 6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 2);
		dep.nuevoProfesor(pr1);
		dep.nuevoProfesor(pr2);
		dep.nuevoProfesor(pr3);
		dep.nuevaAsignatura(fp);
		dep.nuevaAsignatura(adda);
		dep.nuevaAsignatura(ir);
		dep.nuevaAsignatura(so);
		pr1.imparteAsignatura(ir, 1.0);
		pr1.imparteAsignatura(so, 3.5);
		pr2.imparteAsignatura(so, 3.0);
		pr2.imparteAsignatura(adda, 3.0);
		pr3.imparteAsignatura(ir, 2.0);
		pr3.imparteAsignatura(fp, 3.0);
		testEliminaAsignacionProfesoradoAsignatura(dep, so);
	}
	
	private static void testGetProfesoresPorAsignatura() {
		System.out.println("\n========Probando el m�todo getProfesoresPorAsignatura()======================================================================================");
		Departamento dep = new DepartamentoImpl("Lenguajes y Sistemas Inform�ticos");
		Profesor pr1 = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@us.es", Categoria.AYUDANTE);
		Profesor pr2 = new ProfesorImpl("12345678Z", "Miguel", "Nadie Nadie", LocalDate.of(1950, 3, 15), "miguel.nadie@us.es", Categoria.CATEDRATICO);
		Profesor pr3 = new ProfesorImpl("12345678Z", "Luisa", "Nadie Nadie", LocalDate.of(1950, 3, 15), "luisa.nadie@us.es", Categoria.AYUDANTE);
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Asignatura adda = new AsignaturaImpl("Analisis y Dise�o de Datos y Algoritmos", "2050010", 12.0, TipoAsignatura.ANUAL, 2);
		Asignatura ir = new AsignaturaImpl("Ingenier�a de Requisitos", "2050020", 6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 3);
		Asignatura so = new AsignaturaImpl("Sistemas Operativos", "2050014", 6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 2);
		dep.nuevoProfesor(pr1);
		dep.nuevoProfesor(pr2);
		dep.nuevoProfesor(pr3);
		dep.nuevaAsignatura(fp);
		dep.nuevaAsignatura(adda);
		dep.nuevaAsignatura(ir);
		dep.nuevaAsignatura(so);
		pr1.imparteAsignatura(ir, 1.0);
		pr1.imparteAsignatura(so, 3.5);
		pr2.imparteAsignatura(so, 3.0);
		pr2.imparteAsignatura(adda, 3.0);
		pr3.imparteAsignatura(ir, 2.0);
		pr3.imparteAsignatura(fp, 3.0);
		testGetProfesoresPorAsignatura(dep);
	}
	
	private static void testGetTutoriasPorProfesor() {
		System.out.println("\n========Probando el m�todo getTutoriasPorProfesor()======================================================================================");
		Departamento dep = new DepartamentoImpl("Lenguajes y Sistemas Inform�ticos");
		Profesor pr1 = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@us.es", Categoria.AYUDANTE);
		Profesor pr2 = new ProfesorImpl("12345678Z", "Miguel", "Nadie Nadie", LocalDate.of(1950, 3, 15), "miguel.nadie@us.es", Categoria.CATEDRATICO);
		Profesor pr3 = new ProfesorImpl("12345678Z", "Luisa", "Nadie Nadie", LocalDate.of(1950, 3, 15), "luisa.nadie@us.es", Categoria.AYUDANTE);
		pr1.nuevaTutoria(LocalTime.of(10, 30), 30, DayOfWeek.FRIDAY);
		pr2.nuevaTutoria(LocalTime.of(11, 30), 40, DayOfWeek.MONDAY);
		pr1.nuevaTutoria(LocalTime.of(14, 30), 60, DayOfWeek.TUESDAY);
		pr3.nuevaTutoria(LocalTime.of(16, 30), 60, DayOfWeek.THURSDAY);
		pr1.nuevaTutoria(LocalTime.of(11, 30), 120, DayOfWeek.FRIDAY);
		pr2.nuevaTutoria(LocalTime.of(12, 30), 60, DayOfWeek.WEDNESDAY);
		pr2.nuevaTutoria(LocalTime.of(9, 30), 60, DayOfWeek.MONDAY);
		pr1.nuevaTutoria(LocalTime.of(9, 30), 60, DayOfWeek.MONDAY);
		pr3.nuevaTutoria(LocalTime.of(9, 30), 60, DayOfWeek.MONDAY);
		pr3.nuevaTutoria(LocalTime.of(14, 30), 60, DayOfWeek.MONDAY);
		dep.nuevoProfesor(pr1);
		dep.nuevoProfesor(pr2);
		dep.nuevoProfesor(pr3);
		testGetTutoriasPorProfesor(dep);
	}

	private static void testIgualdad() {
		System.out.println("\n========Probando igualdad con dos objetos iguales======================================================================================");
		Departamento d1 = new DepartamentoImpl("Lenguajes y Sistemas Inform�ticos");
		Departamento d2 = new DepartamentoImpl("Lenguajes y Sistemas Inform�ticos");
		Departamento d3 = new DepartamentoImpl("Arquitectura y Tecnolog�a de Computadores");
		System.out.println("C�digo hash del objeto d1 (" + d1 + "): " + d1.hashCode());
		System.out.println("C�digo hash del objeto d2 (" + d2 + "): " + d2.hashCode());
		System.out.println("C�digo hash del objeto d3 (" + d3 + "): " + d3.hashCode());
		System.out.println("�Es d1 igual a d2? (debe ser true): " + d1.equals(d2));
		System.out.println("�Es d1 distinto de d3? (debe ser true): " + !d1.equals(d3));
	}

	private static void testOrden() {
		System.out.println("\n========Probando orden natural======================================================================================");
		Departamento menor = new DepartamentoImpl("Arquitectura y Tecnolog�a de Computadores");
		Departamento igual1 = new DepartamentoImpl("Lenguajes y Sistemas Inform�ticos");
		Departamento igual2 = new DepartamentoImpl("Lenguajes y Sistemas Inform�ticos");
		Departamento mayor = new DepartamentoImpl("Tecnolog�a Electr�nica");
		System.out.println("- Debe ser ANTES: ");
		compara(menor, igual1);
		System.out.println("- Debe ser MISMA POSICI�N: ");
		compara(igual1, igual2);
		System.out.println("- Debe ser DESPU�S: ");
		compara(mayor, igual2);
	}
	
	private static void testMetodosPoblacionales() {
		System.out.println("\n========Probando m�todos poblacionales======================================================================================");
		System.out.println("N�mero de departamentos creados: " + Grados.getNumDepartamentosCreados());
		System.out.println("Departamentos creados: " + Grados.getDepartamentosCreados());
	}
	
	private static void testGetProfesorMaximaDedicacionMediaPorAsignaturaNormal() {
		System.out.println("\n========Probando el m�todo getProfesorMaximaDedicacionMediaPorAsignatura======================================================================================");
		Departamento dep = new DepartamentoImpl("Lenguajes y Sistemas Inform�ticos");
		Profesor pr1 = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@us.es", Categoria.AYUDANTE);
		Profesor pr2 = new ProfesorImpl("12345678Z", "Miguel", "Nadie Nadie", LocalDate.of(1950, 3, 15), "miguel.nadie@us.es", Categoria.CATEDRATICO);
		Profesor pr3 = new ProfesorImpl("12345678Z", "Luisa", "Nadie Nadie", LocalDate.of(1950, 3, 15), "luisa.nadie@us.es", Categoria.AYUDANTE);
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Asignatura adda = new AsignaturaImpl("Analisis y Dise�o de Datos y Algoritmos", "2050010", 12.0, TipoAsignatura.ANUAL, 2);
		Asignatura ir = new AsignaturaImpl("Ingenier�a de Requisitos", "2050020", 6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 3);
		Asignatura so = new AsignaturaImpl("Sistemas Operativos", "2050014", 6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 2);
		dep.nuevoProfesor(pr1);
		dep.nuevoProfesor(pr2);
		dep.nuevoProfesor(pr3);
		dep.nuevaAsignatura(fp);
		dep.nuevaAsignatura(adda);
		dep.nuevaAsignatura(ir);
		dep.nuevaAsignatura(so);
		pr1.imparteAsignatura(ir, 1.0);
		pr1.imparteAsignatura(so, 3.5);
		pr2.imparteAsignatura(so, 3.0);
		pr2.imparteAsignatura(adda, 3.0);
		pr3.imparteAsignatura(ir, 2.0);
		pr3.imparteAsignatura(fp, 3.0);
		testGetProfesorMaximaDedicacionMediaPorAsignatura(dep);
	}
	
	private static void testGetProfesorMaximaDedicacionMediaPorAsignaturaExcepcion1() {
		System.out.println("\n========Probando el m�todo getProfesorMaximaDedicacionMediaPorAsignatura con un departamento sin profesores======================================================================================");
		Departamento dep = new DepartamentoImpl("Lenguajes y Sistemas Inform�ticos");
		testGetProfesorMaximaDedicacionMediaPorAsignatura(dep);
	}
	
	private static void testGetProfesorMaximaDedicacionMediaPorAsignaturaExcepcion2() {
		System.out.println("\n========Probando el m�todo getProfesorMaximaDedicacionMediaPorAsignatura con un departamento con profesores que no imparten ninguna asignatura======================================================================================");
		Departamento dep = new DepartamentoImpl("Lenguajes y Sistemas Inform�ticos");
		Profesor pr1 = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@us.es", Categoria.AYUDANTE);
		Profesor pr2 = new ProfesorImpl("12345678Z", "Miguel", "Nadie Nadie", LocalDate.of(1950, 3, 15), "miguel.nadie@us.es", Categoria.CATEDRATICO);
		Profesor pr3 = new ProfesorImpl("12345678Z", "Luisa", "Nadie Nadie", LocalDate.of(1950, 3, 15), "luisa.nadie@us.es", Categoria.AYUDANTE);
		dep.nuevoProfesor(pr1);
		dep.nuevoProfesor(pr2);
		dep.nuevoProfesor(pr3);
		testGetProfesorMaximaDedicacionMediaPorAsignatura(dep);
	}
	
	
	
	//////////////////////////////////////////////////
	//M�todos auxiliares
	
	private static void testMetodoCreacionalParametros(String nombre) {
		Departamento dep = Grados.createDepartamento(nombre);
		mostrarDepartamento(dep);
	}
	
	private static void compara(Departamento d1, Departamento d2) {
		System.out.print("El objeto <" + d1 + ">");
		if (d1.compareTo(d2) < 0) {
			System.out.print(" va ANTES que el objeto ");
		} else if (d1.compareTo(d2) > 0) {
			System.out.print(" va DESPU�S que el objeto ");
		} else {
			System.out.print(" va en la MISMA POSICI�N que el objeto ");
		}
		System.out.println("<" + d2 + ">");
	}
	
	private static void testBorraTutorias(Departamento dep){
		System.out.println("Las tutorias de los profesores del departamento " + dep + " antes de la operaci�n son:");
		mostrarTutoriasDepartamento(dep);
		System.out.println("Tutorias a eliminar:");
		mostrarTutoriasDepartamento(dep);
		dep.borraTutorias();
		System.out.println("Las tutorias de los profesores del departamento " + dep + " despu�s de la operaci�n son:");
		mostrarTutoriasDepartamento(dep);
	}
	
	private static void testBorraTutoriasCategoria(Departamento dep, Categoria cat){
		System.out.println("Las tutorias de los profesores del departamento " + dep + " antes de la operaci�n son:");
		mostrarTutoriasDepartamento(dep);
		System.out.println("Tutorias a eliminar:");
		for (Profesor pr : dep.getProfesores()) {
			if(pr.getCategoria() == cat){
				System.out.println("Profesor " + pr + ": " + pr.getTutorias());
			}
		}
		dep.borraTutorias(cat);
		System.out.println("Las tutorias de los profesores del departamento " + dep + " despu�s de la operaci�n son:");
		mostrarTutoriasDepartamento(dep);
	}
	
	private static void testExisteProfesorAsignado(Departamento dep, Asignatura asig){
		System.out.println("Los profesores del departamento " + dep + " imparten las siguientes asignaturas:");
		mostrarProfesoresDepartamento(dep);
		System.out.println("�Existe alg�n profesor asignado a la asignatura " + asig + "?: " + dep.existeProfesorAsignado(asig));
	}
	
	private static void testEstanTodasAsignaturasAsignadas(Departamento dep){
		System.out.println("Las asignaturas del departamento " + dep + " son:");
		mostrarAsignaturasDepartamento(dep);
		System.out.println("Los profesores del departamento " + dep + " imparten las siguientes asignaturas:");
		mostrarProfesoresDepartamento(dep);
		System.out.println("�Tienen todas las asignaturas asignado al menos un profesor?: " + dep.estanTodasAsignaturasAsignadas());
	}
	
	private static void testEliminaAsignacionProfesoradoAsignatura(Departamento dep, Asignatura asig){
		System.out.println("Los profesores del departamento " + dep + " imparten las siguientes asignaturas antes de la operaci�n:");
		mostrarProfesoresDepartamento(dep);
		System.out.println("Asignatura a eliminar:" + asig);
		dep.eliminaAsignacionProfesorado(asig);
		System.out.println("Los profesores del departamento " + dep + " imparten las siguientes asignaturas despu�s de la operaci�n:");
		mostrarProfesoresDepartamento(dep);
	}
	
	private static void testGetProfesoresPorAsignatura(Departamento dep){
		System.out.println("Las asignaturas del departamento " + dep + " son:");
		mostrarAsignaturasDepartamento(dep);
		System.out.println("Los profesores del departamento " + dep + " con las asignaturas que imparten son:");
		mostrarProfesoresDepartamento(dep);
		System.out.println("Los proferores agrupados por cada asignatura del departamento son:" + dep.getProfesoresPorAsignatura());
	}
	
	private static void testGetTutoriasPorProfesor(Departamento dep){
		System.out.println("Los profesores del departamento " + dep + " con las tutorias que imparten son:");
		mostrarTutoriasDepartamento(dep);
		System.out.println("Las tutorias agrupadas por cada profesor del departamento son:" + dep.getTutoriasPorProfesor());
	}
	
	private static void testGetProfesorMaximaDedicacionMediaPorAsignatura(Departamento dep) {
		try {
			System.out.println("Los profesores del departamento " + dep + " con las asignaturas que imparten son:");
			mostrarProfesoresDepartamento(dep);
			System.out.println("Los profesores del departamento " + dep + " con la m�xima dedicaci�n que imparten son:");
			mostrarProfesoresDedicacionDepartamento(dep);
			System.out.println("El profesor del departamento que tiene la mayor carga docente media por asignatura es: " + dep.getProfesorMaximaDedicacionMediaPorAsignatura());
		} catch (NoSuchElementException e) {
			System.out.println("Se ha capturado la excepci�n NoSuchElementException: \n\t" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha capturado una excepci�n inesperada.");
		}
	}
	
	private static void mostrarTutoriasDepartamento(Departamento dep) {
		for (Profesor pr : dep.getProfesores()) {
			System.out.println("Profesor " + pr + ": " + pr.getTutorias());
		}
	}
	
	private static void mostrarProfesoresDepartamento(Departamento dep) {
		for (Profesor pr : dep.getProfesores()) {
			System.out.println("Profesor " + pr + ": " + pr.getAsignaturas());
		}
	}
	
	private static void mostrarProfesoresDedicacionDepartamento(Departamento dep) {
		for (Profesor pr : dep.getProfesores()) {
			System.out.println("Profesor " + pr + ": " + pr.getDedicacionTotal());
		}
	}
	
	private static void mostrarAsignaturasDepartamento(Departamento dep) {
		for (Asignatura asig : dep.getAsignaturas()) {
			System.out.println(asig);
		}
	}
	
	private static void mostrarAsignatura(Asignatura asig) {
		System.out.println("Asignatura --> <" + asig + ">");
		System.out.println("\tDepartamento: <" + asig.getDepartamento() + ">");
	}
	
	private static void mostrarProfesor(Profesor pr) {
		System.out.println("Profesor --> <" + pr + ">");
		System.out.println("\tDepartamento: <" + pr.getDepartamento() + ">");
	}

	private static void mostrarDepartamento(Departamento dep) {
		System.out.println("Departamento --> <" + dep + ">");
		System.out.println("\tAsignaturas: <" + dep.getAsignaturas() + ">");
		System.out.println("\tProfesores: <" + dep.getProfesores() + ">");
	}
}