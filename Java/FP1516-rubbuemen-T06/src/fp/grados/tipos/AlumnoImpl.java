package fp.grados.tipos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fp.grados.excepciones.ExcepcionAlumnoNoValido;
import fp.grados.excepciones.ExcepcionAlumnoOperacionNoPermitida;

public class AlumnoImpl extends PersonaImpl implements Alumno {
	private Set<Asignatura> asignaturas;
	
	public AlumnoImpl(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email){
		super(dni, nombre, apellidos, fechaNacimiento, email);
		checkEmailUniversidad(email);
		this.asignaturas = new HashSet<>();
	}
	
	private void checkEmailUniversidad(String email) {
		if (!email.endsWith("@alum.us.es")) {
			throw new ExcepcionAlumnoNoValido("El email debe acabar en @alum.us.es.");
		}
	}
	
	public Set<Asignatura> getAsignaturas() {
		return new HashSet<>(asignaturas);
	}

	public void setEmail(String email) {
		checkEmailUniversidad(email);
		super.setEmail(email);
	}
	
	public Boolean estaMatriculadoEn(Asignatura asig){
		return asignaturas.contains(asig);
	}
	
	public void matriculaAsignatura(Asignatura asig){
		if (estaMatriculadoEn(asig)){
			throw new ExcepcionAlumnoOperacionNoPermitida("El alumno ya está matriculado en esta asignatura.");
		}
		asignaturas.add(asig);
	}
	
	public void eliminaAsignatura(Asignatura asig){
		if (!estaMatriculadoEn(asig)){
			throw new ExcepcionAlumnoOperacionNoPermitida("El alumno no está matriculado en esta asignatura.");
		}
		asignaturas.remove(asig);
	}
	
	public String toString() {
		//TODO: usar propiedad curso cuando se implemente
		return "(º?) " + super.toString();
	}
}