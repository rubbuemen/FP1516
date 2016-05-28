package fp.grados.tipos.test;

import java.time.LocalDate;

import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.TipoAsignatura;

public class TestDepartamento {
	public static void main(String[] args) {
		testConstructor();

		testRelacionBidireccionalAsignaturas();
		testRelacionBidireccionalProfesores();

		testIgualdad();
		testOrden();
	}

	private static void testConstructor() {
		System.out.println("========Probando el constructor======================================================================================");
		Departamento dep = new DepartamentoImpl("Lenguajes y Sistemas Inform�ticos");
		mostrarDepartamento(dep);
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
	
	
	
	//////////////////////////////////////////////////
	//M�todos auxiliares
	
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