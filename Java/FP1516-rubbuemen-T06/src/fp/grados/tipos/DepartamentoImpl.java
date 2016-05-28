package fp.grados.tipos;

import java.util.HashSet;
import java.util.Set;

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