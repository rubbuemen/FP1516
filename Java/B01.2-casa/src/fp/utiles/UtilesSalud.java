package fp.utiles;

import fp.tipos.personas.EstadoNutricional;

public class UtilesSalud {
	public static Float calcularIMC(Float peso, Float altura){
		Float imc = peso / (altura * altura);
		return imc;
	}
	
	public static EstadoNutricional obtenerEstadoNutricional (Float peso, Float altura){
		Float imc = peso / (altura * altura);
		EstadoNutricional EstN = null;
		if (imc < 18.5){
			EstN = EstadoNutricional.INFRAPESO;
		}
		else if (imc >= 18.5 && imc < 25){
			EstN = EstadoNutricional.NORMAL;
		}
		else if (imc >= 25 && imc < 30){
			EstN = EstadoNutricional.SOBREPESO;
		}
		else if (imc >= 30){
			EstN = EstadoNutricional.OBESO;
		}
		return EstN;
	}
	
	public static String consejoSalud(EstadoNutricional en){
		String res = null;
		switch (en) {
		case INFRAPESO:
			res = "Está demasiado delgado/a. Consulte a su médico.";
			break;
		case NORMAL:
			res = "Está estupendo/a. Manténgase así.";
			break;
		case SOBREPESO:
			res = "Con un poco de esfuerzo puede conseguir ajustar su peso. Consulte a su médico.";
			break;
		case OBESO:
			res = "Bajar de peso, hacer ejercicio y alimentarse sanamente, son metas que puede conseguir. Consulte a su médico.";
			break;
		}
		return res;
	}
	
	
	
}
