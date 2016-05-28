package fp.grados.tipos;

import fp.grados.excepciones.ExcepcionBecaNoValida;

public class BecaImpl implements Beca {
	private static final Double CUANTIA_MINIMA = 1500.0;
	private String codigo;
	private Double cuantiaTotal;
	private Integer duracion;
	private TipoBeca tipo;

	public BecaImpl(String codigo, TipoBeca tipo) {
		checkCodigo(codigo);
		this.codigo = codigo;
		this.tipo = tipo;
		this.duracion = 1;
		this.cuantiaTotal = CUANTIA_MINIMA;
	}

	public BecaImpl(String codigo, Double cuantia, Integer duracion, TipoBeca tipo) {
		checkCodigo(codigo);
		checkCuantiaTotal(cuantia);
		checkDuracion(duracion);
		this.codigo = codigo;
		this.cuantiaTotal = cuantia;
		this.duracion = duracion;
		this.tipo = tipo;
	}

	private void checkCodigo(String codigo) {
		boolean esCorrecto = codigo.length() == 7 && 
				Character.isLetter(codigo.charAt(0))
				&& Character.isLetter(codigo.charAt(1)) 
				&& Character.isLetter(codigo.charAt(2))
				&& Character.isDigit(codigo.charAt(3))
				&& Character.isDigit(codigo.charAt(4))
				&& Character.isDigit(codigo.charAt(5)) 
				&& Character.isDigit(codigo.charAt(6));
		if (!esCorrecto) {
			throw new ExcepcionBecaNoValida("El código debe estar formado por 3 letras y 4 dígitos.");
		}
	}

	private void checkDuracion(Integer duracion) {
		if (duracion < 1) {
			throw new ExcepcionBecaNoValida("La duración debe ser de al menos un mes.");
		}
	}
	
	private void checkCuantiaTotal(Double cuantiaTotal) {
		if (cuantiaTotal < CUANTIA_MINIMA) {
			throw new ExcepcionBecaNoValida("La cuantía total debe ser como mínimo " + CUANTIA_MINIMA + " euros.");
		}
	}

	public String getCodigo() {
		return codigo;
	}

	public Double getCuantiaTotal() {
		return cuantiaTotal;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public TipoBeca getTipo() {
		return tipo;
	}

	public Double getCuantiaMensual() {
		Double cuantiaMensual = getCuantiaTotal() / getDuracion();
		return cuantiaMensual;
	}
	
	public void setCuantiaTotal(Double cuantia) {
		checkCuantiaTotal(cuantia);
		this.cuantiaTotal = cuantia;
	}

	public void setDuracion(Integer duracion) {
		checkDuracion(duracion);
		this.duracion = duracion;
	}

	public String toString() {
		String s = "[" + getCodigo() + ", " + getTipo() + "]";
		return s;
	}
}