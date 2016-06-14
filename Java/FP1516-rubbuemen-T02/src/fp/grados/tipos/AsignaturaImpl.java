package fp.grados.tipos;

public class AsignaturaImpl implements Asignatura {
	private String nombre;
	private String codigo;
	private Double creditos;
	private TipoAsignatura tipo;
	private Integer curso;
	//TODO: private Departamento departamento;
	
	//TODO: añadir parámatro para la propiedad departamento.
	public AsignaturaImpl(String nombre, String codigo, Double creditos, TipoAsignatura tipo, Integer curso){
		this.nombre = nombre;
		this.codigo = codigo;
		this.creditos = creditos;
		this.tipo = tipo;
		this.curso = curso;
		//TODO: Inicializar atributo departamento.
	}
	
	public String getNombre() {
		return nombre;
	}

	//TODO Implementar esta propiedad derivada
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
	
	public String toString() {
		String s = "(" + getCodigo() + ") " + getNombre();
		return s;
	}
}
