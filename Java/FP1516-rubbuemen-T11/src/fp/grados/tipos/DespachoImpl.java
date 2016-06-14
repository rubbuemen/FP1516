package fp.grados.tipos;

import java.util.HashSet;
import java.util.Set;

import fp.grados.excepciones.ExcepcionDespachoNoValido;

public class DespachoImpl extends EspacioImpl implements Despacho{
	private Set<Profesor> profesores;
	
	public DespachoImpl(String nombre, Integer capacidad, Integer planta, Set<Profesor> profesores){
		super(TipoEspacio.OTRO, nombre, capacidad, planta);
		checkCapacidad(capacidad, profesores);
		this.profesores = new HashSet<>(profesores);
	}
	
	public DespachoImpl(String nombre, Integer capacidad, Integer planta, Profesor profesor){
		super(TipoEspacio.OTRO, nombre, capacidad, planta);
		this.profesores=new HashSet<>();
		profesores.add(profesor);
	}
	
	public DespachoImpl(String nombre, Integer capacidad, Integer planta){
		super(TipoEspacio.OTRO, nombre, capacidad, planta);
		this.profesores = new HashSet<>();
	}
	
	public DespachoImpl(String despacho){
		super(despacho + ",OTRO");
		this.profesores = new HashSet<>();
		
	}
	
	private void checkCapacidad(Integer capacidad, Set<Profesor> profesores) {
		if (capacidad < profesores.size()) {
			throw new ExcepcionDespachoNoValido("La capacidad debe ser mayor al número de profesores.");
		}
	}
	
	public Set<Profesor> getProfesores() {
		return new HashSet<>(profesores);
	}
	
	public void setProfesores(Set<Profesor> profesores){
		checkCapacidad(getCapacidad(),profesores);
		this.profesores = profesores;
	}
	
	public void setCapacidad(Integer capacidad) {
		checkCapacidad(capacidad, getProfesores());
		super.setCapacidad(capacidad);
	}
	
	public void setTipo(TipoEspacio espacio){
		throw new UnsupportedOperationException("El tipo de espacio asignado a un despacho siempre tiene que ser el correspondiente a 'otro tipo'.");
	}
	
	public String toString() {
		return super.toString() + getProfesores();
	}
}