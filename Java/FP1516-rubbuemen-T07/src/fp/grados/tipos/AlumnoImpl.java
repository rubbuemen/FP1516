package fp.grados.tipos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fp.grados.excepciones.ExcepcionAlumnoNoValido;
import fp.grados.excepciones.ExcepcionAlumnoOperacionNoPermitida;

public class AlumnoImpl extends PersonaImpl implements Alumno {
	private Set<Asignatura> asignaturas;
	private Expediente expediente;
	
	public AlumnoImpl(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email){
		super(dni, nombre, apellidos, fechaNacimiento, email);
		checkEmailUniversidad(email);
		this.asignaturas = new HashSet<>();
		this.expediente = new ExpedienteImpl();
	}
	
	private void checkEmailUniversidad(String email) {
		if (!email.endsWith("@alum.us.es")) {
			throw new ExcepcionAlumnoNoValido("El email debe acabar en @alum.us.es.");
		}
	}
	
	public Set<Asignatura> getAsignaturas() {
		return new HashSet<>(asignaturas);
	}
	
	public Expediente getExpediente(){
		return expediente;
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
	
	public void evaluaAlumno(Asignatura asig, Integer curso, Convocatoria convocatoria, Double nota, Boolean mencionHonor){
		if(estaMatriculadoEn(asig)){
			Nota n = new NotaImpl(asig, curso, convocatoria, nota, mencionHonor);
			expediente.nuevaNota(n);
		}
		else{
			throw new ExcepcionAlumnoOperacionNoPermitida("El alumno no está matriculado en la asignatura.");
		}
	}
	
	public void evaluaAlumno(Asignatura asig, Integer curso, Convocatoria convocatoria, Double nota){
		if(estaMatriculadoEn(asig)){
			Nota n = new NotaImpl(asig, curso, convocatoria, nota);
			expediente.nuevaNota(n);
		}
		else{
			throw new ExcepcionAlumnoOperacionNoPermitida("El alumno no está matriculado en la asignatura.");
		}
	}
	
	public String toString() {
		//TODO: usar propiedad curso cuando se implemente
		return "(º?) " + super.toString();
	}
}