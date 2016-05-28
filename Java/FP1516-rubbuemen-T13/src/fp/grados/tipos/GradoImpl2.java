package fp.grados.tipos;

import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GradoImpl2 extends GradoImpl{
	public GradoImpl2(String nombre, Set<Asignatura> asignaturasObligatorias, Set<Asignatura> asignaturasOptativas, Double numeroMinimoCreditosOptativas){
		super(nombre, asignaturasObligatorias, asignaturasOptativas, numeroMinimoCreditosOptativas);
	}
	
	public Double getNumeroTotalCreditos(){
		return getNumeroMinimoCreditosOptativas() + getAsignaturasObligatorias().stream().mapToDouble(asig -> asig.getCreditos()).sum();
	}
	
	public Set<Asignatura> getAsignaturas(Integer curso){
		return Stream.concat(getAsignaturasObligatorias().stream(), getAsignaturasOptativas().stream()).filter(asig -> asig.getCurso().equals(curso)).collect(Collectors.toSet());
	}
	
	public Asignatura getAsignatura(String codigo){
		return Stream.concat(getAsignaturasObligatorias().stream(), getAsignaturasOptativas().stream()).filter(asig -> asig.getCodigo().equals(codigo)).findFirst().orElse(null);
	}
	
	public Set<Departamento> getDepartamentos(){
		return Stream.concat(getAsignaturasObligatorias().stream(), getAsignaturasOptativas().stream()).map(asig -> asig.getDepartamento()).collect(Collectors.toSet());
	}
	
	public Set<Profesor> getProfesores(){
		return getDepartamentos().stream().flatMap(dep -> dep.getProfesores().stream()).collect(Collectors.toSet());
	}
	
	public SortedMap<Asignatura, Double> getCreditosPorAsignatura(){
		return Stream.concat(getAsignaturasObligatorias().stream(), getAsignaturasOptativas().stream()).collect(Collectors.toMap(asig -> asig, asig -> asig.getCreditos(), (asig1, asig2) -> asig1, TreeMap::new));
	}
}