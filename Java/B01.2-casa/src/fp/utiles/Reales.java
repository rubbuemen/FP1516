package fp.utiles;

public class Reales {
	public static Boolean estaEnIntervalo(Double x){
		Boolean cierto;
		Double intervalo1A = 2.0;
		Double intervalo1B = 5.0;
		Double intervalo2A = 0.0;
		Double intervalo2B = 1.0;
		Double intervalo3A = -5.0;
		Double intervalo3B = -2.0;
		cierto = (x >= intervalo1A && x <= intervalo1B) || (x >= intervalo2A && x <= intervalo2B) || (x >= intervalo3A && x <= intervalo3B);
		return cierto;
	}
}
