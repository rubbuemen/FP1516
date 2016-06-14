package fp.grados.tipos;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

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
		
	private Boolean	existeProfesorDepartamento(Set<Profesor> profesores, Departamento dep){
		Boolean res = false;
		for (Profesor pr : profesores){
			if(pr.getDepartamento().equals(dep)){
				res = true;
			}
		}
		return res;
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
	
	public Espacio getEspacioMayorCapacidad(){
		Espacio res = null;
		Integer cap = 0;
		for (Espacio es : getEspacios()) {
			if (es.getCapacidad() > cap) {
				cap = es.getCapacidad();
				res = es;
			}
		}
		if (res == null){
			throw new ExcepcionCentroOperacionNoPermitida("No existe ningún espacio.");
		}
		return res;
	}
	
	public Set<Despacho> getDespachos(){
		Set<Despacho> res = new HashSet<>();
		for (Espacio es : getEspacios()) {
			if(es instanceof Despacho){
				res.add((Despacho) es);
			}
		}
		return res;
	}
	
	public Set<Despacho> getDespachos(Departamento dep){
		Set<Despacho> res = new HashSet<>();
		for (Despacho desp : getDespachos()) {
			if(existeProfesorDepartamento(desp.getProfesores(), dep)){
				res.add(desp);
			}
		}
		return res;
	}
	
	public Set<Profesor> getProfesores(){
		Set<Profesor> res = new HashSet<>();
		for (Despacho desp : getDespachos()) {
			res.addAll(desp.getProfesores());
		}
		return res;
	}
	
	public Set<Profesor> getProfesores(Departamento dep){
		Set<Profesor> res = new HashSet<>();
		for (Profesor pr: getProfesores()) {
			if(pr.getDepartamento().equals(dep)){
				res.add(pr);	
			}
		}
		return res;
	}
	
	public Integer[] getConteosEspacios(){
		Integer[] res = {0, 0, 0, 0, 0};
		for (Espacio es : getEspacios()) {
			switch (es.getTipo()) {
			case TEORIA:
				res[0]++;				
				break;
			case LABORATORIO:
				res[1]++;				
				break;
			case SEMINARIO:
				res[2]++;				
				break;
			case EXAMEN:
				res[3]++;				
				break;
			case OTRO:
				res[4]++;				
				break;	
			}
		}
		return res;
	}
	
	public SortedMap<String, Despacho> getDespachosPorProfesor() {
		SortedMap<String, Despacho> res = new TreeMap<>();
		for (Despacho desp : getDespachos()) {
			ayadeProfesores(desp, res);
		}
		return res;
	}

	private void ayadeProfesores(Despacho desp, SortedMap<String, Despacho> profesoresDespacho){
		for (Profesor pr : desp.getProfesores()) {
			profesoresDespacho.put(pr.toString(), desp);
		}
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