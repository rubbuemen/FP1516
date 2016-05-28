package fp.grados.tipos;

public class BecaImpl implements Beca {
	private static final Double CUANTIA_MINIMA = 1500.0;
	private String codigo;
	private Double cuantiaTotal;
	private Integer duracion;
	private TipoBeca tipo;

	public BecaImpl(String codigo, TipoBeca tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
		this.duracion = 1;
		this.cuantiaTotal = CUANTIA_MINIMA;
	}

	public BecaImpl(String codigo, Double cuantia, Integer duracion, TipoBeca tipo) {
		this.codigo = codigo;
		this.cuantiaTotal = cuantia;
		this.duracion = duracion;
		this.tipo = tipo;
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
		this.cuantiaTotal = cuantia;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public String toString() {
		String s = "[" + getCodigo() + ", " + getTipo() + "]";
		return s;
	}
}
