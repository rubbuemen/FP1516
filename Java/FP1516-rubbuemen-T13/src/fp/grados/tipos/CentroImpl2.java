package fp.grados.tipos;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import fp.grados.excepciones.ExcepcionCentroOperacionNoPermitida;

public class CentroImpl2 extends CentroImpl {
	public CentroImpl2(String nombre, String direccion, Integer numeroPlantas, Integer numeroSotanos) {
		super(nombre, direccion, numeroPlantas, numeroSotanos);
	}
	
	public Espacio getEspacioMayorCapacidad(){
		Optional<Espacio> res = getEspacios().stream().max(Comparator.comparing(Espacio::getCapacidad));
		if(!res.isPresent()){
			throw new ExcepcionCentroOperacionNoPermitida("No existe ningún espacio.");
		}
		return res.get();
	}
	
	public Integer[] getConteosEspacios(){
		Integer[] res = {0, 0, 0, 0, 0};
		getEspacios().stream().forEach(es -> res[es.getTipo().ordinal()]++);
		return res;
	}
	
	public Set<Despacho> getDespachos(){
		return getEspacios().stream().filter(es -> es instanceof Despacho).map(es -> (Despacho) es).collect(Collectors.toSet());
	}
	
	private Boolean	existeProfesorDepartamento(Set<Profesor> profesores, Departamento dep){
		return profesores.stream().anyMatch(pr -> pr.getDepartamento().equals(dep));
	}
	
	public Set<Despacho> getDespachos(Departamento dep){
		return getDespachos().stream().filter(desp -> existeProfesorDepartamento(desp.getProfesores(), dep)).collect(Collectors.toSet());
	}
	
	public Set<Profesor> getProfesores(){
		return getDespachos().stream().flatMap(desp -> desp.getProfesores().stream()).collect(Collectors.toSet());
	}
	
	public Set<Profesor> getProfesores(Departamento dep){
		return getProfesores().stream().filter(pr -> pr.getDepartamento().equals(dep)).collect(Collectors.toSet());
	}
	
	public SortedMap<String, Despacho> getDespachosPorProfesor(){
		return new TreeMap<>(getProfesores().stream().collect(Collectors.toMap(p -> p.toString(), p -> buscaDespacho(p))));
	}
	
	private Despacho buscaDespacho(Profesor pr){
		return getDespachos().stream().filter(desp -> desp.getProfesores().contains(pr)).findFirst().get();
	}
}