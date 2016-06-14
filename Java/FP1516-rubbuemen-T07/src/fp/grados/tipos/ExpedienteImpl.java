package fp.grados.tipos;

import java.util.ArrayList;
import java.util.List;

public class ExpedienteImpl implements Expediente{
	private List<Nota> notas;
	
	public ExpedienteImpl (){
		this.notas = new ArrayList<>();
	}
	
	public List<Nota> getNotas(){
		return new ArrayList<>(notas);
	}
	
	public void nuevaNota(Nota n){
		notas.remove(n);
		notas.add(n);
	}
	
	public boolean equals(Object o){
		boolean res = false;
		if (o instanceof Expediente){
			Expediente ex = (Expediente) o;
			res = this.getNotas().equals(ex.getNotas());
		}
		return res;
	}
	
	public int hashCode(){
		return this.getNotas().hashCode();
	}
	
	public String toString() {
		return getNotas().toString();
	}
}