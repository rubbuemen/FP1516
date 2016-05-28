package fp.grados.tipos;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Optional;

public class AlumnoImpl2 extends AlumnoImpl {
	public AlumnoImpl2(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email){
		super(dni, nombre, apellidos, fechaNacimiento, email);
	}
	
	public AlumnoImpl2(String alumno){
		super(alumno);
	}
	
	public Integer getCurso(){
		Integer res = 0;
		Optional<Asignatura> fujoAsigMaxCurso = getAsignaturas().stream().max(Comparator.comparing(Asignatura::getCurso)); 
		if(fujoAsigMaxCurso.isPresent()){
			res = fujoAsigMaxCurso.get().getCurso();
		}
		return res;
	}
}