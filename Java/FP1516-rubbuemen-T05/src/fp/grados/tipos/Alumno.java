package fp.grados.tipos;

import java.util.Set;

public interface Alumno extends Persona {
	Set<Asignatura> getAsignaturas();
	//TODO: Integer getCurso();
	
	void matriculaAsignatura(Asignatura asig);
	void eliminaAsignatura(Asignatura asig);
	Boolean estaMatriculadoEn(Asignatura asig);
}