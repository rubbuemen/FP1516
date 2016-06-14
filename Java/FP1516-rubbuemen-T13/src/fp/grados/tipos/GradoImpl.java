package fp.grados.tipos;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import fp.grados.excepciones.ExcepcionGradoNoValido;

public class GradoImpl implements Grado {
	private String nombre;
	private Set<Asignatura> asignaturasObligatorias;
	private Set<Asignatura> asignaturasOptativas;
	private Double numeroMinimoCreditosOptativas;
	
	public GradoImpl(String nombre, Set<Asignatura> asignaturasObligatorias, Set<Asignatura> asignaturasOptativas, Double numeroMinimoCreditosOptativas){
		checkAsignaturasOptativas(asignaturasOptativas);
		checkMinimoCreditosOptativas(asignaturasOptativas, numeroMinimoCreditosOptativas);
		this.nombre = nombre;
		this.asignaturasObligatorias = new HashSet<>(asignaturasObligatorias);
		this.asignaturasOptativas = new HashSet<>(asignaturasOptativas);
		this.numeroMinimoCreditosOptativas = numeroMinimoCreditosOptativas;
	}
	
	private void checkAsignaturasOptativas(Set<Asignatura> asignaturasOptativas){
		Double creditos = 0.0;
		Integer i = 0;
		for (Asignatura asig : asignaturasOptativas) {
			if(i == 0){
				creditos = asig.getCreditos();
			}
			i++;
			if(!(asig.getCreditos().equals(creditos))){
				throw new ExcepcionGradoNoValido("Todas las asignaturas optativas de un grado deben tener el mismo número de créditos.");
			}
			if(asig.getTipo().equals(TipoAsignatura.ANUAL)){
				throw new ExcepcionGradoNoValido("Las asignaturas deben ser cuatrimestrales.");
			}
		}
	}
	
	private void checkMinimoCreditosOptativas(Set<Asignatura> asignaturasOptativas, Double numeroMinimoCreditosOptativas){
		Double numeroTotalCreditosOptativas = 0.0;
		for (Asignatura asig : asignaturasOptativas) {
			numeroTotalCreditosOptativas = numeroTotalCreditosOptativas + asig.getCreditos();
		}
		if(numeroMinimoCreditosOptativas < 0 || numeroMinimoCreditosOptativas > numeroTotalCreditosOptativas){
			throw new ExcepcionGradoNoValido("El número mínimo de créditos de asignaturas optativas que debe cursar un alumno debe estar comprendido entre cero y " + numeroTotalCreditosOptativas + ".");
		}
	}

	public String getNombre() {
		return nombre;
	}

	public Set<Asignatura> getAsignaturasObligatorias() {
		return new HashSet<>(asignaturasObligatorias);
	}

	public Set<Asignatura> getAsignaturasOptativas() {
		return new HashSet<>(asignaturasOptativas);
	}

	public Double getNumeroMinimoCreditosOptativas() {
		return numeroMinimoCreditosOptativas;
	}
	
	public Double getNumeroTotalCreditos() {
		Double numeroTotalCreditosObligatorios = 0.0;
		for (Asignatura asig : getAsignaturasObligatorias()) {
			numeroTotalCreditosObligatorios = numeroTotalCreditosObligatorios + asig.getCreditos();
		}
		Double numeroTotalCreditos = numeroTotalCreditosObligatorios + getNumeroMinimoCreditosOptativas();
		return numeroTotalCreditos;
	}

	public Set<Departamento> getDepartamentos() {
		Set<Departamento> departamentos = new HashSet<>();
		for (Asignatura asig : getAsignaturasObligatorias()) {
			departamentos.add(asig.getDepartamento());
		}
		for (Asignatura asig : getAsignaturasOptativas()) {
			departamentos.add(asig.getDepartamento());
		}
		return departamentos;
	}

	public Set<Profesor> getProfesores() {
		Set<Profesor> profesores = new HashSet<>();
		for (Departamento dep : getDepartamentos()) {
			profesores.addAll(dep.getProfesores());
		}
		return profesores;
	}
	
	public Set<Asignatura> getAsignaturas(Integer curso){
		Set<Asignatura> asignaturas = new HashSet<>();
		for (Asignatura asig : getAsignaturas()) {
			if(asig.getCurso() == curso){
				asignaturas.add(asig);
			}
		}
		return asignaturas;
	}
	
	public Asignatura getAsignatura(String codigo){
		Asignatura res = null;
		for (Asignatura asig : getAsignaturas()) {
			if(asig.getCodigo().equals(codigo)){
				res = asig;
				break;
			}
		}
		return res;
	}
	
	private Set<Asignatura> getAsignaturas(){
		Set<Asignatura> asignaturas = new HashSet<>();
		for (Asignatura asig : getAsignaturasObligatorias()) {
			asignaturas.add(asig);
		}
		for (Asignatura asig : getAsignaturasOptativas()) {
			asignaturas.add(asig);
		}
		return asignaturas;
	}
	
	public SortedMap<Asignatura, Double> getCreditosPorAsignatura() {
		SortedMap<Asignatura, Double> res = new TreeMap<>();
		for (Asignatura asig : getAsignaturas()) {
			res.put(asig, asig.getCreditos());
		}
		return res;
	}
	
	public SortedSet<Departamento> getDepartamentosOrdenadosPorAsignaturas() {
		Comparator<Departamento> cmp = Comparator.comparing((Departamento d) -> d.getAsignaturas().size()).reversed().thenComparing(Comparator.naturalOrder());
		SortedSet<Departamento> res = new TreeSet<>(cmp);
		res.addAll(getDepartamentos());
		return res;
	}
	
	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Grado) {
			Grado g = (Grado) o;
			res = this.getNombre().equals(g.getNombre());
		}
		return res;
	}

	public int hashCode() {
		return this.getNombre().hashCode();
	}

	public int compareTo(Grado g) {
		return this.getNombre().compareTo(g.getNombre());
	}
	
	public String toString() {
		return getNombre();
	}
}