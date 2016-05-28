package fp.grados.utiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Grados {
	public static <T> List<T> leeFichero(String nombreFichero, Function<String,T> funcion_deString_aT){
		List<T> res = null;
		try {
			res = Files.lines(Paths.get(nombreFichero)).map(funcion_deString_aT).collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println("Error en lectura del fichero: " + nombreFichero);
		}
		return res;
	}
}
