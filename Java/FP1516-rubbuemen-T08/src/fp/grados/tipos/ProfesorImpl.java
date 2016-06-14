
package fp.grados.tipos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import fp.grados.excepciones.ExcepcionProfesorNoValido;
import fp.grados.excepciones.ExcepcionProfesorOperacionNoPermitida;

public class ProfesorImpl extends PersonaImpl implements Profesor{
	private static final Double CREDITOS_MAXIMOS_PROFESOR = 32.0;
	private static final Double CREDITOS_MAXIMOS_AYUDANTE = 6.0;
	private Categoria categoria;
	private SortedSet<Tutoria> tutorias;
	private Departamento departamento;
	private List<Asignatura> asignaturas;
	private List<Double> creditos;
	
	public ProfesorImpl(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email, Categoria categoria){
		super(dni, nombre, apellidos, fechaNacimiento, email);
		checkEdadProfesor(fechaNacimiento);
		this.categoria = categoria;
		this.tutorias = new TreeSet<>();
		this.departamento = null;
		this.asignaturas = new ArrayList<>();
		this.creditos = new ArrayList<>();
	}
		
	public ProfesorImpl(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email, Categoria categoria, Departamento departamento){
		super(dni, nombre, apellidos, fechaNacimiento, email);
		checkEdadProfesor(fechaNacimiento);
		this.categoria = categoria;
		this.tutorias = new TreeSet<>();
		setDepartamento(departamento);
		this.asignaturas = new ArrayList<>();
		this.creditos = new ArrayList<>();
	}
		
	private void checkEdadProfesor(LocalDate fechaNacimiento) {
		Integer edad = (int) fechaNacimiento.until(LocalDate.now(), ChronoUnit.YEARS);
		if (edad < 18) {
			throw new ExcepcionProfesorNoValido("El profesor debe ser mayor de edad.");
		}
	}
	
	private void checkAsignaturaDepartamento(Asignatura asig){
		if(getDepartamento() == null || !getDepartamento().getAsignaturas().contains(asig)){
			throw new ExcepcionProfesorOperacionNoPermitida("Un profesor no puede impartir una asignatura de otro departamento.");
		}
	}
	
	private void checkCreditosAsignatura(Asignatura asig, Double dedicacion){
		if(dedicacion <= 0 || dedicacion > asig.getCreditos()){
			throw new ExcepcionProfesorOperacionNoPermitida("La dedicación debe ser mayor que 0 y menor o igual que el número de créditos de la asignatura.");
		}
	}
	
	private void checkMaximoCreditos(Double dedicacion, Categoria categoria){
		if(dedicacion > CREDITOS_MAXIMOS_PROFESOR && !(categoria == Categoria.AYUDANTE)){
			throw new ExcepcionProfesorOperacionNoPermitida("Un profesor puede impartir un máximo de " + CREDITOS_MAXIMOS_PROFESOR + " créditos");
		}
		if(dedicacion > CREDITOS_MAXIMOS_AYUDANTE && categoria == Categoria.AYUDANTE){
			throw new ExcepcionProfesorOperacionNoPermitida("Un profesor de categoria ayudante puede impartir un máximo de " + CREDITOS_MAXIMOS_AYUDANTE + " créditos");
		}
	}
	
	public Categoria getCategoria(){
		return categoria;
	}
	
	public SortedSet<Tutoria> getTutorias() {
		return new TreeSet<>(tutorias);
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	
	public Double getDedicacionTotal(){
		Double res = 0.0;
		for (Double dedicacion : getCreditos()) {
			res = res + dedicacion;
		}
		return res;
	}
	
	public List<Asignatura> getAsignaturas(){
		return new ArrayList<>(asignaturas);
	}
	
	public List<Double> getCreditos(){
		return new ArrayList<>(creditos);
	}
	
	public void setFechaNacimiento(LocalDate fecha) {
		checkEdadProfesor(fecha);
		super.setFechaNacimiento(fecha);
	}
	
	public void setCategoria(Categoria categoria){
		checkMaximoCreditos(getDedicacionTotal(), categoria);
		this.categoria = categoria;
	}

	public void setDepartamento(Departamento nuevoDepartamento) {
		if (nuevoDepartamento != this.departamento) {
			Departamento antiguoDepartamento = this.departamento;
			this.departamento = nuevoDepartamento;
			if (antiguoDepartamento != null) {
				antiguoDepartamento.eliminaProfesor(this);
			}
			if (nuevoDepartamento != null) {
				nuevoDepartamento.nuevoProfesor(this);
			}
		}
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
	
	public void imparteAsignatura(Asignatura asig, Double dedicacion){
		checkAsignaturaDepartamento(asig);
		checkCreditosAsignatura(asig, dedicacion);
		if (asignaturas.contains(asig)){
			actualizaDedicacion(asig, dedicacion);
		}
		else {
			nuevaAsignatura(asig, dedicacion);
		}
	}
	
	public Double dedicacionAsignatura(Asignatura asig){
		Double res = 0.0;
		int posicionAsignatura = asignaturas.indexOf(asig);
		if(posicionAsignatura >= 0){
			res = creditos.get(posicionAsignatura);
		}
		return res;
	}
	
	public void eliminaAsignatura(Asignatura asig){
		int posicionAsignatura = asignaturas.indexOf(asig);
		if(posicionAsignatura >= 0){
			creditos.remove(posicionAsignatura);
			asignaturas.remove(posicionAsignatura);
		}
	}
	
	private void actualizaDedicacion(Asignatura asig, Double dedicacion){
		checkMaximoCreditos(getDedicacionTotal() + (dedicacion - dedicacionAsignatura(asig)), getCategoria());
		int posicionAsignatura = asignaturas.indexOf(asig);
		creditos.set(posicionAsignatura, dedicacion);
	}
	
	private void nuevaAsignatura(Asignatura asig, Double dedicacion){
		checkMaximoCreditos(getDedicacionTotal() + dedicacion, getCategoria());
		asignaturas.add(asig);
		creditos.add(dedicacion);
	}
	
	public String toString() {
		return super.toString() + " (" + getCategoria() + ")";
	}
}