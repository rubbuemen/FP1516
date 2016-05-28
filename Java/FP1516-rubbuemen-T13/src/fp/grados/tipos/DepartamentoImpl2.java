package fp.grados.tipos;

import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class DepartamentoImpl2 extends DepartamentoImpl {
	public DepartamentoImpl2(String nombre) {
		super(nombre);
	}
	
	public void borraTutorias(){
		getProfesores().stream().forEach(pr -> pr.borraTutorias());
	}
	
	public void borraTutorias(Categoria c){
		getProfesores().stream().filter(pr -> pr.getCategoria().equals(c)).forEach(pr -> pr.borraTutorias());
	}
	
	public Boolean existeProfesorAsignado(Asignatura asig){
		return getProfesores().stream().anyMatch(pr -> pr.getAsignaturas().contains(asig));
	}
	
	public Boolean estanTodasAsignaturasAsignadas(){
		return getAsignaturas().stream().allMatch(asig -> existeProfesorAsignado(asig));
	}
	
	public void eliminaAsignacionProfesorado(Asignatura asig){
		getProfesores().stream().filter(pr -> pr.getAsignaturas().contains(asig)).forEach(pr -> pr.eliminaAsignatura(asig));
	}
	
	public SortedMap<String, SortedSet<Tutoria>> getTutoriasPorProfesor(){
		return new TreeMap<>(getProfesores().stream().collect(Collectors.toMap(pr -> pr.toString(), pr -> pr.getTutorias())));
	}
}