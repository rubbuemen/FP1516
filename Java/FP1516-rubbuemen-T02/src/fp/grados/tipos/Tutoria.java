package fp.grados.tipos;

import java.time.DayOfWeek;
import java.time.LocalTime;

public interface Tutoria {
	DayOfWeek getDiaSemana();
	LocalTime getHoraComienzo();
	LocalTime getHoraFin();
	Integer getDuracion();
}
