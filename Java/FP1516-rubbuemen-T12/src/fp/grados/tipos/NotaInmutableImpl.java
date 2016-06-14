package fp.grados.tipos;

import fp.grados.excepciones.ExcepcionNotaNoValida;

public final class NotaInmutableImpl implements Nota {
	private final Asignatura asignatura;
	private final Integer cursoAcademico;
	private final Convocatoria convocatoria;
	private final Double valor;
	private final Boolean mencionHonor;
	
	public NotaInmutableImpl(Asignatura asignatura, Integer cursoAcademico, Convocatoria convocatoria, Double valor, Boolean mencionHonor){
		checkValor(valor);
		checkMencionHonor(valor, mencionHonor);
		this.asignatura = copia(asignatura);
		this.cursoAcademico = cursoAcademico;
		this.convocatoria = convocatoria;
		this.valor = valor;
		this.mencionHonor = mencionHonor;
	}
	
	public NotaInmutableImpl(Asignatura asignatura, Integer cursoAcademico, Convocatoria convocatoria, Double valor){
		checkValor(valor);
		this.asignatura = copia(asignatura);
		this.cursoAcademico = cursoAcademico;
		this.convocatoria = convocatoria;
		this.valor = valor;
		this.mencionHonor = false;
	}
	
	public NotaInmutableImpl(String nota){
		String[] campos = nota.split(";");
		if(campos.length != 5){
			throw new IllegalArgumentException("El formato de la cadena no es válido");
		}
		Double valor = new Double(campos[3].trim());
		Boolean mencionHonor = new Boolean(campos[4].trim());
		checkValor(valor);
		checkMencionHonor(valor, mencionHonor);
		this.asignatura = new AsignaturaImpl(campos[0].trim());
		this.cursoAcademico = new Integer(campos[1].trim());
		this.convocatoria = Convocatoria.valueOf(campos[2].trim());
		this.valor = valor;
		this.mencionHonor = mencionHonor;
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
	
	private Asignatura copia(Asignatura asignatura){
		return new AsignaturaImpl(asignatura.getNombre(), asignatura.getCodigo(), asignatura.getCreditos(), asignatura.getTipo(), asignatura.getCurso(), asignatura.getDepartamento());
	}

	public Asignatura getAsignatura() {
		return copia(asignatura);
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
	
	public boolean equals(Object o){
		boolean res = false;
		if (o instanceof Nota){
			Nota n = (Nota) o;
			res = this.getCursoAcademico().equals(n.getCursoAcademico()) && this.getAsignatura().equals(n.getAsignatura()) && this.getConvocatoria().equals(n.getConvocatoria());
		}
		return res;
	}
	
	public int hashCode(){
		return this.getCursoAcademico().hashCode() + this.getAsignatura().hashCode() * 31 + this.getConvocatoria().hashCode() * 31 * 31;
	}
	
	public int compareTo(Nota n){
		int res = this.getCursoAcademico().compareTo(n.getCursoAcademico());
		if (res == 0){
			res = this.getAsignatura().compareTo(n.getAsignatura());
			if (res == 0){
				res = this.getConvocatoria().compareTo(n.getConvocatoria());
			}
		}
		return res;
	}
	
	public String toString() {
		String s = getAsignatura() + ", " + getCursoAcademico() + "-" + Integer.toString(getCursoAcademico()+1).substring(2,4) + ", " + getConvocatoria() + ", " + getValor() + ", " + getCalificacion();
		return s;
	}
}