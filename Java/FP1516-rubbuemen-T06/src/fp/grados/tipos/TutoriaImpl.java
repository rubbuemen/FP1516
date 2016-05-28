package fp.grados.tipos;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import fp.grados.excepciones.ExcepcionTutoriaNoValida;

public class TutoriaImpl implements Tutoria {
	private DayOfWeek diaSemana;
	private LocalTime horaComienzo;
	private LocalTime horaFin;
	
	public TutoriaImpl (DayOfWeek diaSemana, LocalTime horaComienzo, LocalTime horaFin){
		checkDiaSemana(diaSemana);
		checkHorario(horaComienzo, horaFin);
		checkDuracion(horaComienzo, horaFin);
		this.diaSemana = diaSemana;
		this.horaComienzo = horaComienzo;
		this.horaFin = horaFin;
	}
	
	public TutoriaImpl (DayOfWeek diaSemana, LocalTime horaComienzo, Integer duracion){
		checkDiaSemana(diaSemana);
		checkHorario(horaComienzo, horaComienzo.plusMinutes(duracion));
		checkDuracion(horaComienzo, horaComienzo.plusMinutes(duracion));
		this.diaSemana = diaSemana;
		this.horaComienzo = horaComienzo;
		this.horaFin = horaComienzo.plusMinutes(duracion);		
	}
	
	private void checkDiaSemana(DayOfWeek diaSemana) {
		if (diaSemana == DayOfWeek.of(6) || diaSemana == DayOfWeek.of(7)) {
			throw new ExcepcionTutoriaNoValida("El día de la semana sólo puede ser de lunes a viernes.");
		}
	}
	
	private void checkHorario(LocalTime horaComienzo, LocalTime horaFin) {
		Integer horaC = horaComienzo.getHour();
		Integer minutoC = horaComienzo.getMinute();
		Integer horaF = horaFin.getHour();
		Integer minutoF = horaFin.getMinute();
		if (horaC == 8 && minutoC < 30 || horaC < 8) {
			throw new ExcepcionTutoriaNoValida("El horario debe ser de 8:30 a 21:30.");
		}
		if(horaF == 21 && minutoF > 30 || horaF > 21){
			throw new ExcepcionTutoriaNoValida("El horario debe ser de 8:30 a 21:30.");
		}
	}

	private void checkDuracion(LocalTime horaComienzo, LocalTime horaFin){
		Integer duracion = (int) horaComienzo.until(horaFin, ChronoUnit.MINUTES);
		if (duracion < 30){
			throw new ExcepcionTutoriaNoValida("La duración debe ser al menos de 30 minutos.");
		}
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
	
	public boolean equals(Object o){
		boolean res = false;
		if (o instanceof Tutoria){
			Tutoria t = (Tutoria) o;
			res = this.getDiaSemana().equals(t.getDiaSemana()) && this.getHoraComienzo().equals(t.getHoraComienzo());
		}
		return res;
	}
	
	public int hashCode(){
		return this.getDiaSemana().hashCode() + this.getHoraComienzo().hashCode() * 31;
	}
	
	public int compareTo(Tutoria t){
		int res = this.getDiaSemana().compareTo(t.getDiaSemana());
		if (res == 0){
			res = this.getHoraComienzo().compareTo(t.getHoraComienzo());
		}
		return res;
	}
	
	public String toString(){
		String s = diaSemanaAbreviatura() + " " + getHoraComienzo() + "-" + getHoraFin();
		return s;
	}
}