package fp.grados.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl2;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.utiles.Grados;

public class TestDepartamento2 {
	public static void main(String[] args) {
		testConstructor();
		
		testMetodoCreacionalParametros();
		
		testBorraTutorias();
		
		testBorraTutoriasCategoria();
		
		testExisteProfesorAsignado();
		
		testEstanTodasAsignaturasAsignadas();
		
		testEliminaAsignacionProfesoradoAsignatura();
		
		testGetTutoriasPorProfesor();
		
		testMetodosPoblacionales();
	}

	private static void testConstructor() {
		System.out.println("========Probando el constructor======================================================================================");
		Departamento dep = new DepartamentoImpl2("Lenguajes y Sistemas Informáticos");
		mostrarDepartamento(dep);
	}
	
	private static void testMetodoCreacionalParametros() {
		System.out.println("\n========Probando método creacional por parámetros======================================================================================");
		testMetodoCreacionalParametros("Lenguajes y Sistemas Informáticos");
	}
	
	private static void testBorraTutorias() {
		System.out.println("\n========Probando borraTutorias======================================================================================");
		Departamento dep = new DepartamentoImpl2("Lenguajes y Sistemas Informáticos");
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
		Departamento dep = new DepartamentoImpl2("Lenguajes y Sistemas Informáticos");
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
		Departamento dep = new DepartamentoImpl2("Lenguajes y Sistemas Informáticos");
		Profesor pr1 = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@us.es", Categoria.AYUDANTE);
		Profesor pr2 = new ProfesorImpl("12345678Z", "Miguel", "Nadie Nadie", LocalDate.of(1950, 3, 15), "miguel.nadie@us.es", Categoria.CATEDRATICO);
		Profesor pr3 = new ProfesorImpl("12345678Z", "Luisa", "Nadie Nadie", LocalDate.of(1950, 3, 15), "luisa.nadie@us.es", Categoria.AYUDANTE);
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Asignatura adda = new AsignaturaImpl("Analisis y Diseño de Datos y Algoritmos", "2050010", 12.0, TipoAsignatura.ANUAL, 2);
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
		Departamento dep = new DepartamentoImpl2("Lenguajes y Sistemas Informáticos");
		Profesor pr1 = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@us.es", Categoria.AYUDANTE);
		Profesor pr2 = new ProfesorImpl("12345678Z", "Miguel", "Nadie Nadie", LocalDate.of(1950, 3, 15), "miguel.nadie@us.es", Categoria.CATEDRATICO);
		Profesor pr3 = new ProfesorImpl("12345678Z", "Luisa", "Nadie Nadie", LocalDate.of(1950, 3, 15), "luisa.nadie@us.es", Categoria.AYUDANTE);
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Asignatura adda = new AsignaturaImpl("Analisis y Diseño de Datos y Algoritmos", "2050010", 12.0, TipoAsignatura.ANUAL, 2);
		Asignatura ir = new AsignaturaImpl("Ingeniería de Requisitos", "2050020", 6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 3);
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
		Departamento dep = new DepartamentoImpl2("Lenguajes y Sistemas Informáticos");
		Profesor pr1 = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1950, 3, 15), "juan.nadie@us.es", Categoria.AYUDANTE);
		Profesor pr2 = new ProfesorImpl("12345678Z", "Miguel", "Nadie Nadie", LocalDate.of(1950, 3, 15), "miguel.nadie@us.es", Categoria.CATEDRATICO);
		Profesor pr3 = new ProfesorImpl("12345678Z", "Luisa", "Nadie Nadie", LocalDate.of(1950, 3, 15), "luisa.nadie@us.es", Categoria.AYUDANTE);
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		Asignatura adda = new AsignaturaImpl("Analisis y Diseño de Datos y Algoritmos", "2050010", 12.0, TipoAsignatura.ANUAL, 2);
		Asignatura ir = new AsignaturaImpl("Ingeniería de Requisitos", "2050020", 6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 3);
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
	
	private static void testGetTutoriasPorProfesor() {
		System.out.println("\n========Probando el método getTutoriasPorProfesor()======================================================================================");
		Departamento dep = new DepartamentoImpl2("Lenguajes y Sistemas Informáticos");
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
	
	private static void testMetodosPoblacionales() {
		System.out.println("\n========Probando métodos poblacionales======================================================================================");
		System.out.println("Número de departamentos creados: " + Grados.getNumDepartamentosCreados());
		System.out.println("Departamentos creados: " + Grados.getDepartamentosCreados());
	}	
	
	
	
	//////////////////////////////////////////////////
	//Métodos auxiliares
	
	private static void testMetodoCreacionalParametros(String nombre) {
		Grados.setUsarJava8(true);
		Departamento dep = Grados.createDepartamento(nombre);
		mostrarDepartamento(dep);
	}
	
	private static void testBorraTutorias(Departamento dep){
		System.out.println("Las tutorias de los profesores del departamento " + dep + " antes de la operación son:");
		mostrarTutoriasDepartamento(dep);
		System.out.println("Tutorias a eliminar:");
		mostrarTutoriasDepartamento(dep);
		dep.borraTutorias();
		System.out.println("Las tutorias de los profesores del departamento " + dep + " después de la operación son:");
		mostrarTutoriasDepartamento(dep);
	}
	
	private static void testBorraTutoriasCategoria(Departamento dep, Categoria cat){
		System.out.println("Las tutorias de los profesores del departamento " + dep + " antes de la operación son:");
		mostrarTutoriasDepartamento(dep);
		System.out.println("Tutorias a eliminar:");
		for (Profesor pr : dep.getProfesores()) {
			if(pr.getCategoria() == cat){
				System.out.println("Profesor " + pr + ": " + pr.getTutorias());
			}
		}
		dep.borraTutorias(cat);
		System.out.println("Las tutorias de los profesores del departamento " + dep + " después de la operación son:");
		mostrarTutoriasDepartamento(dep);
	}
	
	private static void testExisteProfesorAsignado(Departamento dep, Asignatura asig){
		System.out.println("Los profesores del departamento " + dep + " imparten las siguientes asignaturas:");
		mostrarProfesoresDepartamento(dep);
		System.out.println("¿Existe algún profesor asignado a la asignatura " + asig + "?: " + dep.existeProfesorAsignado(asig));
	}
	
	private static void testEstanTodasAsignaturasAsignadas(Departamento dep){
		System.out.println("Las asignaturas del departamento " + dep + " son:");
		mostrarAsignaturasDepartamento(dep);
		System.out.println("Los profesores del departamento " + dep + " imparten las siguientes asignaturas:");
		mostrarProfesoresDepartamento(dep);
		System.out.println("¿Tienen todas las asignaturas asignado al menos un profesor?: " + dep.estanTodasAsignaturasAsignadas());
	}
	
	private static void testEliminaAsignacionProfesoradoAsignatura(Departamento dep, Asignatura asig){
		System.out.println("Los profesores del departamento " + dep + " imparten las siguientes asignaturas antes de la operación:");
		mostrarProfesoresDepartamento(dep);
		System.out.println("Asignatura a eliminar:" + asig);
		dep.eliminaAsignacionProfesorado(asig);
		System.out.println("Los profesores del departamento " + dep + " imparten las siguientes asignaturas después de la operación:");
		mostrarProfesoresDepartamento(dep);
	}
	
	private static void testGetTutoriasPorProfesor(Departamento dep){
		System.out.println("Los profesores del departamento " + dep + " con las tutorias que imparten son:");
		mostrarTutoriasDepartamento(dep);
		System.out.println("Las tutorias agrupadas por cada profesor del departamento son:" + dep.getTutoriasPorProfesor());
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
	
	private static void mostrarAsignaturasDepartamento(Departamento dep) {
		for (Asignatura asig : dep.getAsignaturas()) {
			System.out.println(asig);
		}
	}

	private static void mostrarDepartamento(Departamento dep) {
		System.out.println("Departamento --> <" + dep + ">");
		System.out.println("\tAsignaturas: <" + dep.getAsignaturas() + ">");
		System.out.println("\tProfesores: <" + dep.getProfesores() + ">");
	}
}