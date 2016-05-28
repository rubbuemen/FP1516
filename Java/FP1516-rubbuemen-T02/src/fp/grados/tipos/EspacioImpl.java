package fp.grados.tipos;

public class EspacioImpl implements Espacio {
	private TipoEspacio tipo;
	private String nombre;
	private Integer capacidad;
	private Integer planta;
	
	public EspacioImpl(TipoEspacio tipo, String nombre, Integer capacidad, Integer planta){
		this.tipo = tipo;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.planta = planta;
	}

	public TipoEspacio getTipo() {
		return tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public Integer getPlanta() {
		return planta;
	}
	
	public void setTipo(TipoEspacio tipo) {
		this.tipo = tipo;	
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;	
	}
	
	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;	
	}
	
	public String toString() {
		String s = getNombre() + " (planta " + getPlanta() + ")";
		return s;
	}
}
