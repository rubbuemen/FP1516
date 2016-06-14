package fp.grados.tipos;

import java.util.Comparator;
import java.util.Optional;

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
}