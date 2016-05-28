package fp.grados.tipos;

import java.util.Set;

public interface Centro extends Comparable<Centro> {
	String getNombre();
	String getDireccion();
	Integer getNumeroPlantas();
	Integer getNumeroSotanos();
	Set<Espacio> getEspacios();
	
	void nuevoEspacio(Espacio e);
	void eliminaEspacio(Espacio e);
}