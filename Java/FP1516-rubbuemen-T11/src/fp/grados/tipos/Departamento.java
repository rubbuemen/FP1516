package fp.grados.tipos;

import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public interface Departamento extends Comparable<Departamento> {
	String getNombre();
	Set<Asignatura> getAsignaturas();
	Set<Profesor> getProfesores();
	
	void nuevaAsignatura(Asignatura asig);
	void eliminaAsignatura(Asignatura asig);
	void nuevoProfesor(Profesor pr);
	void eliminaProfesor(Profesor pr);
	void borraTutorias();
	void borraTutorias(Categoria c);
	Boolean existeProfesorAsignado(Asignatura asig);
	Boolean estanTodasAsignaturasAsignadas();
	void eliminaAsignacionProfesorado(Asignatura asig);
	
	SortedMap<Asignatura, SortedSet<Profesor>> getProfesoresPorAsignatura();
	SortedMap<String, SortedSet<Tutoria>> getTutoriasPorProfesor();
}