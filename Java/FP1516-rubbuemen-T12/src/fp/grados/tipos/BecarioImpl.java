package fp.grados.tipos;

import java.time.LocalDate;

import fp.grados.excepciones.ExcepcionBecarioNoValido;

public class BecarioImpl extends AlumnoImpl implements Becario{
	private Beca beca;
	private LocalDate fechaComienzo;
	
	public BecarioImpl(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email, Beca beca, LocalDate fechaComienzo){
		super(dni, nombre, apellidos, fechaNacimiento, email);
		checkFechaComienzo(fechaComienzo);
		this.beca = beca;
		this.fechaComienzo = fechaComienzo;
	}
	
	public BecarioImpl(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email, String codigo, Double cuantia, Integer duracion, TipoBeca tipo, LocalDate fechaComienzo){
		super(dni, nombre, apellidos, fechaNacimiento, email);
		checkFechaComienzo(fechaComienzo);
		this.beca = new BecaImpl(codigo, cuantia, duracion, tipo);
		this.fechaComienzo = fechaComienzo;
	}
	
	private void checkFechaComienzo(LocalDate fechaComienzo){
		if(!fechaComienzo.isAfter(LocalDate.now())){
			throw new ExcepcionBecarioNoValido("La fecha de comienzo de la beca debe ser posterior a la fecha actual.");
		}
	}
	
	public Beca getBeca(){
		return beca;
	}
	
	public LocalDate getFechaComienzo(){
		return fechaComienzo;
	}
	
	public LocalDate getFechaFin(){
		return getFechaComienzo().plusMonths(getBeca().getDuracion());
	}
	
	public void setFechaComienzo(LocalDate fechaComienzo){
		checkFechaComienzo(fechaComienzo);
		this.fechaComienzo = fechaComienzo;
	}
	
	public void setEmail(String email){
		throw new UnsupportedOperationException("No se permite cambiar el email de un becario.");
	}
	
	public String toString(){
		return super.toString() + " " + getBeca();
	}
}