package fp.grados.tipos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import fp.grados.excepciones.ExcepcionPersonaNoValida;

public class PersonaImpl implements Persona {
	private String nombre;
	private String apellidos;
	private String dni;
	private LocalDate fechaNacimiento;
	private String email;

	public PersonaImpl(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email) {
		checkDni(dni);
		checkEmail(email);
		checkFechaNacimiento(fechaNacimiento);
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
	}

	public PersonaImpl(String dni, String nombre, String apellidos, LocalDate fechaNacimiento) {
		this(dni, nombre, apellidos, fechaNacimiento, "");
	}
	
	public PersonaImpl(String persona){
		String[] campos = persona.split(",");
		if(campos.length != 5){
			throw new IllegalArgumentException("El formato de la cadena no es válido");
		}
		String dni = campos[0].trim();
		LocalDate fechaNacimiento = LocalDate.parse(campos[3].trim(), DateTimeFormatter.ofPattern("d/M/y"));
		String email = campos[4].trim();
		checkDni(dni);
		checkEmail(email);
		checkFechaNacimiento(fechaNacimiento);
		this.dni = dni;
		this.nombre = campos[1].trim();
		this.apellidos = campos[2].trim();
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
	}

	private void checkDni(String dni) {
		boolean esDniCorrecto = checkDniTipoCaracteres(dni) && checkDniLetra(dni);
		if (!esDniCorrecto) {
			throw new ExcepcionPersonaNoValida("DNI incorrecto.");
		}
	}

	private Boolean checkDniTipoCaracteres(String dni) {
		return dni.length() == 9 
				&& Character.isDigit(dni.charAt(0)) 
				&& Character.isDigit(dni.charAt(1))
				&& Character.isDigit(dni.charAt(2)) 
				&& Character.isDigit(dni.charAt(3))
				&& Character.isDigit(dni.charAt(4)) 
				&& Character.isDigit(dni.charAt(5))
				&& Character.isDigit(dni.charAt(6)) 
				&& Character.isDigit(dni.charAt(7))
				&& Character.isLetter(dni.charAt(8));
	}

	private Boolean checkDniLetra(String dni) {
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		Integer numeroDni = new Integer(dni.substring(0,8));
		return dni.charAt(8) == letras.charAt(numeroDni % 23);
	}

	private void checkEmail(String email) {
		if (!(email.isEmpty() || email.contains("@"))) {
			throw new ExcepcionPersonaNoValida("El email debe contener el usuario, una arroba y el servidor.");
		}
	}

	private void checkFechaNacimiento(LocalDate fechaNacimiento) {
		if (!fechaNacimiento.isBefore(LocalDate.now())) {
			throw new ExcepcionPersonaNoValida("La fecha de nacimiento de una persona debe ser anterior a la fecha actual del sistema.");
		}
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDNI() {
		return dni;
	}

	public LocalDate getFechaNacimiento() {
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
		checkDni(dni);
		this.dni = dni;		
	}

	public void setFechaNacimiento(LocalDate fecha) {
		checkFechaNacimiento(fecha);
		this.fechaNacimiento = fecha;
	}

	public void setEmail(String email) {
		checkEmail(email);
		this.email = email;
	}
	
	public boolean equals(Object o){
		boolean res = false;
		if (o instanceof Persona){
			Persona p = (Persona) o;
			res = this.getDNI().equals(p.getDNI()) && this.getNombre().equals(p.getNombre()) && this.getApellidos().equals(p.getApellidos());
		}
		return res;
	}
	
	public int hashCode(){
		return this.getDNI().hashCode() + this.getNombre().hashCode() * 31 + this.getApellidos().hashCode() * 31 * 31;
	}
	
	public int compareTo(Persona p){
		int res = this.getApellidos().compareTo(p.getApellidos());
		if (res == 0){
			res = this.getNombre().compareTo(p.getNombre());
			if (res == 0){
				res = this.getDNI().compareTo(p.getDNI());
			}
		}
		return res;
	}
	
	public String toString() {
		String s = getDNI() + " - " + getApellidos() + ", " + getNombre() + " - " + getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return s;
	}
}