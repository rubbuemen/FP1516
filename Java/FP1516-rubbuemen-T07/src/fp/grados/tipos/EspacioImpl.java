package fp.grados.tipos;

import fp.grados.excepciones.ExcepcionEspacioNoValido;

public class EspacioImpl implements Espacio {
	private TipoEspacio tipo;
	private String nombre;
	private Integer capacidad;
	private Integer planta;
	
	public EspacioImpl(TipoEspacio tipo, String nombre, Integer capacidad, Integer planta){
		checkCapacidad(capacidad);
		this.tipo = tipo;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.planta = planta;
	}
	
	private void checkCapacidad(Integer capacidad) {
		if (!(capacidad > 0)) {
			throw new ExcepcionEspacioNoValido("La capacidad debe ser mayor que 0.");
		}
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
		checkCapacidad(capacidad);
		this.capacidad = capacidad;	
	}
	
	public boolean equals(Object o){
		boolean res = false;
		if (o instanceof Espacio){
			Espacio es = (Espacio) o;
			res = this.getNombre().equals(es.getNombre())&& this.getPlanta().equals(es.getPlanta());
		}
		return res;
	}
	
	public int hashCode(){
		return this.getNombre().hashCode() + this.getPlanta().hashCode() * 31;
	}
	
	public int compareTo(Espacio es){
		int res = this.getNombre().compareTo(es.getNombre());
		if (res == 0){
			res = this.getPlanta().compareTo(es.getPlanta());
		}
		return res;
	}
	
	public String toString() {
		String s = getNombre() + " (planta " + getPlanta() + ")";
		return s;
	}
}