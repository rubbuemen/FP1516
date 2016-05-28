package fp.grados.tipos;

import fp.grados.excepciones.ExcepcionAsignaturaNoValida;

public class AsignaturaImpl implements Asignatura {
	private String nombre;
	private String codigo;
	private Double creditos;
	private TipoAsignatura tipo;
	private Integer curso;
	// TODO: private Departamento departamento;

	// TODO: añadir parámatro para la propiedad departamento.
	public AsignaturaImpl(String nombre, String codigo, Double creditos, TipoAsignatura tipo, Integer curso) {
		checkCodigo(codigo);
		checkCreditos(creditos);
		checkCurso(curso);
		this.nombre = nombre;
		this.codigo = codigo;
		this.creditos = creditos;
		this.tipo = tipo;
		this.curso = curso;
		// TODO: Inicializar atributo departamento.
	}

	private void checkCodigo(String codigo) {
		Boolean esCorrecto = codigo.length() == 7 
				&& Character.isDigit(codigo.charAt(0))
				&& Character.isDigit(codigo.charAt(1)) 
				&& Character.isDigit(codigo.charAt(2))
				&& Character.isDigit(codigo.charAt(3)) 
				&& Character.isDigit(codigo.charAt(4))
				&& Character.isDigit(codigo.charAt(5)) 
				&& Character.isDigit(codigo.charAt(6));
		if (!esCorrecto) {
			throw new ExcepcionAsignaturaNoValida("El código debe estar formado por 7 dígitos.");
		}
	}

	private void checkCreditos(Double creditos) {
		if (creditos <= 0) {
			throw new ExcepcionAsignaturaNoValida("Los créditos deben ser un número positivo distinto de 0.");
		}
	}

	private void checkCurso(Integer curso) {
		if (curso < 1 || curso > 4) {
			throw new ExcepcionAsignaturaNoValida("El curso debe estar comprendido entre 1 y 4.");
		}
	}

	public String getNombre() {
		return nombre;
	}

	// TODO Implementar esta propiedad derivada
	public String getAcronimo() {
		return null;
	}

	public String getCodigo() {
		return codigo;
	}

	public Double getCreditos() {
		return creditos;
	}

	public TipoAsignatura getTipo() {
		return tipo;
	}

	public Integer getCurso() {
		return curso;
	}
	
	public boolean equals(Object o){
		boolean res = false;
		if (o instanceof Asignatura){
			Asignatura a = (Asignatura) o;
			res = this.getCodigo().equals(a.getCodigo());
		}
		return res;
	}
	
	public int hashCode(){
		return this.getCodigo().hashCode();
	}
	
	public int compareTo(Asignatura a){
		return this.getCodigo().compareTo(a.getCodigo());
	}
	
	public String toString() {
		String s = "(" + getCodigo() + ") " + getNombre();
		return s;
	}
}