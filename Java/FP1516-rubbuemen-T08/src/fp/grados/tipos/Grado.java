package fp.grados.tipos;

import java.util.Set;

public interface Grado extends Comparable<Grado> {
	String getNombre();
	Set<Asignatura> getAsignaturasObligatorias();
	Set<Asignatura> getAsignaturasOptativas();
	Double getNumeroMinimoCreditosOptativas();
	Double getNumeroTotalCreditos();
	Set<Departamento> getDepartamentos();
	Set<Profesor> getProfesores();
	
	Set<Asignatura> getAsignaturas(Integer curso);
	Asignatura getAsignatura(String codigo);
}