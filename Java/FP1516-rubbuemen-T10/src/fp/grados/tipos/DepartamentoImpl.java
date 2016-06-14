package fp.grados.tipos;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class DepartamentoImpl implements Departamento {
	private String nombre;
	private Set<Asignatura> asignaturas;
	private Set<Profesor> profesores;

	public DepartamentoImpl(String nombre) {
		this.nombre = nombre;
		this.asignaturas = new HashSet<>();
		this.profesores = new HashSet<>();
	}

	public String getNombre() {
		return nombre;
	}

	public Set<Asignatura> getAsignaturas() {
		return new HashSet<>(asignaturas);
	}
	
	public Set<Profesor> getProfesores() {
		return new HashSet<>(profesores);
	}

	public void nuevaAsignatura(Asignatura asig) {
		asignaturas.add(asig);
		asig.setDepartamento(this);
	}

	public void eliminaAsignatura(Asignatura asig) {
		if (asignaturas.contains(asig)){
			asignaturas.remove(asig);
			asig.setDepartamento(null);
		}
	}
	
	public void nuevoProfesor(Profesor pr) {
		profesores.add(pr);
		pr.setDepartamento(this);
	}

	public void eliminaProfesor(Profesor pr) {
		if (profesores.contains(pr)){
			profesores.remove(pr);
			pr.setDepartamento(null);
		}
	}
	
	
	public void borraTutorias(){
		for (Profesor pr : getProfesores()) {
			pr.borraTutorias();
		}
	}
	
	public void borraTutorias(Categoria c){
		for (Profesor pr : getProfesores()) {
			if(pr.getCategoria().equals(c)){
				pr.borraTutorias();
			}
		}
	}
	
	public Boolean existeProfesorAsignado(Asignatura asig){
		Boolean res = false;
		for (Profesor pr : getProfesores()) {
			if(pr.getAsignaturas().contains(asig)){
				res = true;
				break;
			}
		}
		return res;
	}
	
	public Boolean estanTodasAsignaturasAsignadas(){
		Boolean res = true;
		for (Asignatura asig : getAsignaturas()) {
			if(!existeProfesorAsignado(asig)){
				res = false;
				break;
			}
		}
		return res;
	}
	
	public void eliminaAsignacionProfesorado(Asignatura asig){
		for (Profesor pr : getProfesores()) {
			if(pr.getAsignaturas().contains(asig)){
				pr.eliminaAsignatura(asig);
			}
		}
	}
	
	public SortedMap<Asignatura, SortedSet<Profesor>> getProfesoresPorAsignatura() {
		SortedMap<Asignatura,SortedSet<Profesor>> res = new TreeMap<>();
		for (Profesor pr : getProfesores()) {
			anyadeAsignatura(pr, res);
		}
		return res;
	}
	
	private void anyadeAsignatura(Profesor pr, SortedMap<Asignatura,SortedSet<Profesor>> asignaturasConjuntoProfesores){
		for (Asignatura asig : pr.getAsignaturas()) {
			if(asignaturasConjuntoProfesores.containsKey(asig)){
				asignaturasConjuntoProfesores.get(asig).add(pr);
			}
			else{
				SortedSet<Profesor> profesores = new TreeSet<>();
				profesores.add(pr);
				asignaturasConjuntoProfesores.put(asig, profesores);
			}
		}
	}
	
	public SortedMap<String, SortedSet<Tutoria>> getTutoriasPorProfesor() {
		SortedMap<String, SortedSet<Tutoria>> res = new TreeMap<>();
		for (Profesor pr : getProfesores()) {
			res.put(pr.toString(), pr.getTutorias());
		}
		return res;
	}

	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Departamento) {
			Departamento d = (Departamento) o;
			res = this.getNombre().equals(d.getNombre());
		}
		return res;
	}

	public int hashCode() {
		return this.getNombre().hashCode();
	}
	
	public int compareTo(Departamento d) {
		return this.getNombre().compareTo(d.getNombre());
	}
	
	public String toString() {
		return getNombre();
	}
}