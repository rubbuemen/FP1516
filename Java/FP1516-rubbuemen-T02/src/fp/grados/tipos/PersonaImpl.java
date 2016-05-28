package fp.grados.tipos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class PersonaImpl implements Persona {
	private String nombre;
	private String apellidos;
	private String dni;
	private LocalDate fechaNacimiento;
	private String email;

	public PersonaImpl(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
	}

	public PersonaImpl(String dni, String nombre, String apellidos, LocalDate fechaNacimiento) {
		this(dni, nombre, apellidos, fechaNacimiento, "");
	}

	public String getNombre(){
		return nombre;
	}

	public String getApellidos(){
		return apellidos;
	}

	public String getDNI(){
		return dni;
	}

	public LocalDate getFechaNacimiento(){
		return fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public Integer getEdad() {
		Integer edad = (int) getFechaNacimiento().until(LocalDate.now(), ChronoUnit.YEARS);
		return edad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setDNI(String dni) {
		this.dni = dni;
	}

	public void setFechaNacimiento(LocalDate fecha) {
		this.fechaNacimiento = fecha;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString(){
		String s = getDNI() + " - " + getApellidos() + ", " + getNombre() + " - " + getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return s;
	}
}
