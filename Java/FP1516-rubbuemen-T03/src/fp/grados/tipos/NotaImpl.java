package fp.grados.tipos;

import fp.grados.excepciones.ExcepcionNotaNoValida;

public class NotaImpl implements Nota {
	private Asignatura asignatura;
	private Integer cursoAcademico;
	private Convocatoria convocatoria;
	private Double valor;
	private Boolean mencionHonor;
	
	public NotaImpl(Asignatura asignatura, Integer cursoAcademico, Convocatoria convocatoria, Double valor, Boolean mencionHonor){
		checkValor(valor);
		checkMencionHonor(valor, mencionHonor);
		this.asignatura = asignatura;
		this.cursoAcademico = cursoAcademico;
		this.convocatoria = convocatoria;
		this.valor = valor;
		this.mencionHonor = mencionHonor;
	}
	
	public NotaImpl(Asignatura asignatura, Integer cursoAcademico, Convocatoria convocatoria, Double valor){
		checkValor(valor);
		this.asignatura = asignatura;
		this.cursoAcademico = cursoAcademico;
		this.convocatoria = convocatoria;
		this.valor = valor;
		this.mencionHonor = false;
	}
	
	private void checkValor(Double valor) {
		if (!(valor >= 0 && valor <= 10)) {
			throw new ExcepcionNotaNoValida("Nota inválida.");
		}
	}
	
	private void checkMencionHonor(Double valor, Boolean mencionHonor) {
		if(valor < 9 && valor >= 0 && mencionHonor == true){
			throw new ExcepcionNotaNoValida("Sólo puede tener mención de honor si su valor numérico es igual o superior a 9.");
		}
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
		String s = getAsignatura()+ ", " + getCursoAcademico() + "-" + Integer.toString(getCursoAcademico()+1).substring(2,4) + ", " + getConvocatoria() + ", " + getValor() + ", " + getCalificacion();
		return s;
	}
}