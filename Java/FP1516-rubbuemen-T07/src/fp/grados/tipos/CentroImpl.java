package fp.grados.tipos;

import java.util.HashSet;
import java.util.Set;

import fp.grados.excepciones.ExcepcionCentroNoValido;
import fp.grados.excepciones.ExcepcionCentroOperacionNoPermitida;

public class CentroImpl implements Centro {
	private String nombre;
	private String direccion;
	private Integer numeroPlantas;
	private Integer numeroSotanos;
	private Set<Espacio> espacios;
	
	public CentroImpl(String nombre, String direccion, Integer numeroPlantas, Integer numeroSotanos){
		checkPlantas(numeroPlantas);
		checkSotanos(numeroSotanos);
		this.nombre = nombre;
		this.direccion = direccion;
		this.numeroPlantas = numeroPlantas;
		this.numeroSotanos = numeroSotanos;
		this.espacios = new HashSet<>();
	}
	
	private void checkPlantas(Integer numeroPlantas) {
		if (!(numeroPlantas >= 1)) {
			throw new ExcepcionCentroNoValido("Un centro debe tener al menos una planta.");
		}
	}
	
	private void checkSotanos(Integer numeroSotanos) {
		if (!(numeroSotanos >= 0)) {
			throw new ExcepcionCentroNoValido("Un centro debe tener cero o más sotanos.");
		}
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}

	public Integer getNumeroPlantas() {
		return numeroPlantas;
	}

	public Integer getNumeroSotanos() {
		return numeroSotanos;
	}

	public Set<Espacio> getEspacios() {
		return new HashSet<>(espacios);
	}

	
	public void nuevoEspacio(Espacio e) {
		Integer p = getNumeroPlantas();
		Integer s = getNumeroSotanos();
		if(e.getPlanta() >= -s && e.getPlanta() <= p - 1){
			espacios.add(e);
		}
		else{
			throw new ExcepcionCentroOperacionNoPermitida("La planta debe corresponder al intervalo [-s,p-1].");
		}
	}

	public void eliminaEspacio(Espacio e) {
		espacios.remove(e);
	}

	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Centro) {
			Centro c = (Centro) o;
			res = this.getNombre().equals(c.getNombre());
		}
		return res;
	}

	public int hashCode() {
		return this.getNombre().hashCode();
	}

	public int compareTo(Centro c) {
		return this.getNombre().compareTo(c.getNombre());
	}
	
	public String toString() {
		return getNombre();
	}
}