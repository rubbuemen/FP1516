package fp.grados.tipos;

import java.util.List;

public interface Expediente {
	List<Nota> getNotas();
	//TODO Double getNotaMedia();
	
	void nuevaNota(Nota n);
}