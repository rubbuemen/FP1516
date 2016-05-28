package fp.grados.tipos;

import java.util.Set;

public interface Departamento extends Comparable<Departamento> {
	String getNombre();
	Set<Asignatura> getAsignaturas();
	Set<Profesor> getProfesores();
	
	void nuevaAsignatura(Asignatura asig);
	void eliminaAsignatura(Asignatura asig);
	void nuevoProfesor(Profesor p);
	void eliminaProfesor(Profesor p);
}