package fp.grados.tipos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.SortedSet;
import java.util.TreeSet;

import fp.grados.excepciones.ExcepcionProfesorNoValido;

public class ProfesorImpl extends PersonaImpl implements Profesor{
	private Categoria categoria;
	private SortedSet<Tutoria> tutorias;
	
	public ProfesorImpl(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email, Categoria categoria){
		super(dni, nombre, apellidos, fechaNacimiento, email);
		checkEdadProfesor(fechaNacimiento);
		this.categoria = categoria;
		this.tutorias = new TreeSet<>();
	}
	
	private void checkEdadProfesor(LocalDate fechaNacimiento) {
		Integer edad = (int) fechaNacimiento.until(LocalDate.now(), ChronoUnit.YEARS);
		if (edad < 18) {
			throw new ExcepcionProfesorNoValido("El profesor debe ser mayor de edad.");
		}
	}
	
	public Categoria getCategoria(){
		return categoria;
	}
	
	public SortedSet<Tutoria> getTutorias() {
		return new TreeSet<>(tutorias);
	}
	
	public void setFechaNacimiento(LocalDate fecha) {
		checkEdadProfesor(fecha);
		super.setFechaNacimiento(fecha);
	}
	
	public void setCategoria(Categoria categoria){
		this.categoria = categoria;
	}
	
	public void nuevaTutoria(LocalTime horaComienzo, Integer duracionMinutos, DayOfWeek dia){
		Tutoria t = new TutoriaImpl(dia, horaComienzo, duracionMinutos);
		tutorias.add(t);
	}
	
	public void borraTutoria(LocalTime horaComienzo, DayOfWeek dia){
		Tutoria t = new TutoriaImpl(dia, horaComienzo, 60);
		tutorias.remove(t);
	}
	
	public void borraTutorias(){
		tutorias.clear();
	}
	
	public String toString() {
		return super.toString() + " (" + getCategoria() + ")";
	}
}