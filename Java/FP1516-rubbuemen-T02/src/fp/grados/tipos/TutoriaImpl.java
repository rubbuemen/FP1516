package fp.grados.tipos;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TutoriaImpl implements Tutoria {
	private DayOfWeek diaSemana;
	private LocalTime horaComienzo;
	private LocalTime horaFin;
	
	public TutoriaImpl (DayOfWeek diaSemana, LocalTime horaComienzo, LocalTime horaFin){
		this.diaSemana = diaSemana;
		this.horaComienzo = horaComienzo;
		this.horaFin = horaFin;
	}
	
	public TutoriaImpl (DayOfWeek diaSemana, LocalTime horaComienzo, Integer duracion){
		this.diaSemana = diaSemana;
		this.horaComienzo = horaComienzo;
		this.horaFin = horaComienzo.plusMinutes(duracion);		
	}

	public DayOfWeek getDiaSemana() {
		return diaSemana;
	}

	public LocalTime getHoraComienzo() {
		return horaComienzo;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}
	
	public Integer getDuracion() {
		Integer duracion = (int) getHoraComienzo().until(getHoraFin(), ChronoUnit.MINUTES);
		return duracion;
	}
	
	private String diaSemanaAbreviatura(){
		String res = null;
		switch (getDiaSemana()) {
		case MONDAY:
			res = "L";
			break;
		case TUESDAY:
			res = "M";
			break;
		case WEDNESDAY:
			res = "X";
			break;
		case THURSDAY:
			res = "J";
			break;
		case FRIDAY:
			res = "V";
			break;
		default:
			break;
		}
		return res;
	}
	
	public String toString(){
		String s = diaSemanaAbreviatura() + " " + getHoraComienzo() + "-" + getHoraFin();
		return s;
	}
}
