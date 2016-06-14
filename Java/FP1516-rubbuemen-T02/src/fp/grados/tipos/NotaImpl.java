package fp.grados.tipos;

public class NotaImpl implements Nota {
	private Asignatura asignatura;
	private Integer cursoAcademico;
	private Convocatoria convocatoria;
	private Double valor;
	private Boolean mencionHonor;
	
	public NotaImpl(Asignatura asignatura, Integer cursoAcademico, Convocatoria convocatoria, Double valor, Boolean mencionHonor){
		this.asignatura = asignatura;
		this.cursoAcademico = cursoAcademico;
		this.convocatoria = convocatoria;
		this.valor = valor;
		this.mencionHonor = mencionHonor;
	}
	
	public NotaImpl(Asignatura asignatura, Integer cursoAcademico, Convocatoria convocatoria, Double valor){
		this.asignatura = asignatura;
		this.cursoAcademico = cursoAcademico;
		this.convocatoria = convocatoria;
		this.valor = valor;
		this.mencionHonor = false;
	}
	
	public Asignatura getAsignatura() {
		return asignatura;
	}

	public Integer getCursoAcademico() {
		return cursoAcademico;
	}

	public Convocatoria getConvocatoria() {
		return convocatoria;
	}

	public Double getValor() {
		return valor;
	}

	public Boolean getMencionHonor() {
		return mencionHonor;
	}

	public Calificacion getCalificacion() {
		Calificacion calificacion;
		if(getValor()<5){
			calificacion = Calificacion.SUSPENSO;
		}
		else {
			calificacion = Calificacion.APROBADO;
			if(getValor()>=7 && getValor()<9){
				calificacion = Calificacion.NOTABLE;
			}
			if(getValor()>=9 && getValor()<10){
				calificacion = Calificacion.SOBRESALIENTE;
			}
			if(getValor()==10){
				calificacion = Calificacion.MATRICULA_DE_HONOR;
			}
		}
		return calificacion;
	}

	public String toString() {
		String s = getAsignatura() + ", " + getCursoAcademico() + "-" + Integer.toString(getCursoAcademico()+1).substring(2,4) + ", " + getConvocatoria() + ", " + getValor() + ", " + getCalificacion();
		return s;
	}
}
