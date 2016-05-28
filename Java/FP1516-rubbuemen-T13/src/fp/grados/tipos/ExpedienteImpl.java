package fp.grados.tipos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fp.grados.excepciones.ExcepcionExpedienteOperacionNoPermitida;

public class ExpedienteImpl implements Expediente {
	private List<Nota> notas;

	public ExpedienteImpl() {
		this.notas = new ArrayList<>();
	}

	private void checkExpedienteAlumno(Nota nota) {
		Integer i = 0;
		for (Nota n : getNotas()) {
			if (n.getAsignatura().equals(nota.getAsignatura())
					&& n.getCursoAcademico().equals(nota.getCursoAcademico())) {
				i++;
			}
		}
		if (i >= 2) {
			throw new ExcepcionExpedienteOperacionNoPermitida(
					"Un expediente no puede contener notas para más de dos convocatorias de una misma asignatura y curso.");
		}
	}

	public List<Nota> getNotas() {
		return new ArrayList<>(notas);
	}

	public Double getNotaMedia() {
		Double res = 0.0;
		Integer i = 0;
		for (Nota n : getNotas()) {
			if (n.getValor() >= 5) {
				res = res + n.getValor();
				i++;
			}
		}
		if (i != 0) {
			res = res / i;
		}
		return res;
	}

	public void nuevaNota(Nota n) {
		checkExpedienteAlumno(n);
		notas.remove(n);
		notas.add(n);
	}

	public List<Nota> getNotasOrdenadasPorAsignatura() {
		Comparator<Nota> cmp = Comparator.comparing(Nota::getAsignatura).thenComparing(Comparator.naturalOrder());
		List<Nota> res = getNotas();
		Collections.sort(res, cmp);
		return res;
	}

	public Nota getMejorNota() {
		Comparator<Nota> cmp1 = Comparator.comparing(Nota::getMencionHonor);
		Comparator<Nota> cmp2 = Comparator.comparing(Nota::getValor);
		Comparator<Nota> cmp3 = Comparator.comparing(Nota::getConvocatoria).thenComparing(Comparator.comparing(Nota::getCursoAcademico)).reversed();
		Comparator<Nota> cmp = cmp1.thenComparing(cmp2).thenComparing(cmp3);
		return getNotas().stream().max(cmp).get();
	}

	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Expediente) {
			Expediente ex = (Expediente) o;
			res = this.getNotas().equals(ex.getNotas());
		}
		return res;
	}

	public int hashCode() {
		return this.getNotas().hashCode();
	}

	public String toString() {
		return getNotas().toString();
	}
}