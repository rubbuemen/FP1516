package fp.grados.tipos;

import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public interface Centro extends Comparable<Centro> {
	String getNombre();
	String getDireccion();
	Integer getNumeroPlantas();
	Integer getNumeroSotanos();
	Set<Espacio> getEspacios();

	void nuevoEspacio(Espacio e);
	void eliminaEspacio(Espacio e);
	Espacio getEspacioMayorCapacidad();
	Set<Despacho> getDespachos();
	Set<Despacho> getDespachos(Departamento dep);
	Set<Profesor> getProfesores();
	Set<Profesor> getProfesores(Departamento dep);
	Integer[] getConteosEspacios();
	
	SortedMap<String, Despacho> getDespachosPorProfesor();
	
	SortedSet<Espacio> getEspaciosOrdenadosPorCapacidad();
}