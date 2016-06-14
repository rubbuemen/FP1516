package fp.grados.tipos;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class AlumnoImpl2 extends AlumnoImpl {
	public AlumnoImpl2(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email) {
		super(dni, nombre, apellidos, fechaNacimiento, email);
	}

	public AlumnoImpl2(String alumno) {
		super(alumno);
	}

	public Integer getCurso() {
		Integer res = 0;
		Optional<Asignatura> fujoAsigMaxCurso = getAsignaturas().stream().max(Comparator.comparing(Asignatura::getCurso));
		if (fujoAsigMaxCurso.isPresent()) {
			res = fujoAsigMaxCurso.get().getCurso();
		}
		return res;
	}

	public SortedMap<Asignatura, Calificacion> getCalificacionPorAsignatura() {
		return getExpediente().getNotas().stream().collect(Collectors.toMap(n -> n.getAsignatura(), n -> n.getCalificacion(), (c1, c2) -> calificacionMaxima(c1, c2), TreeMap::new));
	}

	private Calificacion calificacionMaxima(Calificacion c1, Calificacion c2) {
		Calificacion res;
		if (c1.compareTo(c2) >= 0) {
			res = c1;
		} else {
			res = c2;
		}
		return res;
	}
}