package fp.grados.tipos;

public interface Nota {
	Asignatura getAsignatura();
	Integer getCursoAcademico();
	Convocatoria getConvocatoria();
	Double getValor();
	Boolean getMencionHonor();
	Calificacion getCalificacion();
}
