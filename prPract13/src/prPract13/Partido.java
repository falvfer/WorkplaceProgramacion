package prPract13;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import librerias.LibreriaFechasJavaTime;

public class Partido {

// Variables
	private String[] equipos;
	private int[] goles;
	private LocalDate fecha;
	
// Getters
	public String getAnfitrion() {return equipos[0];}
	public String getVisitante() {return equipos[1];}
	
	public int getGolesAnfitrion() {return goles[0];}
	public int getGolesVisitante() {return goles[1];}
	public String getResultado() {return goles[0] + "-" + goles[1];}
	public String getResultadoQuiniela() {
		return goles[0]>goles[1]?
					"1":
					goles[1]>goles[0]?
						"2":
						"X";
	}
	
	public String getFecha() {
		return this.fecha.format(DateTimeFormatter.ofPattern("dd-mm-yy"));
	}
	
// Constructores
	public Partido(String anfitrion, String visitante, String fecha, String resultado) {
		this.equipos = new String[2];
		this.equipos[0] = anfitrion;
		this.equipos[1] = visitante;
		
		this.goles = new int[2];
		this.goles[0] = Integer.parseInt(resultado.split("-")[0]);
		this.goles[1] = Integer.parseInt(resultado.split("-")[1]);
		
		if (LibreriaFechasJavaTime.isFechaCorrecta(fecha))
			this.fecha = LibreriaFechasJavaTime.convierteStringToLocalDate(fecha);
		else
			this.fecha = LocalDate.now();
	}
	
	public Partido(Equipo e1, Equipo e2, String fecha, String resultado) {
		this(e1.getNombre(), e2.getNombre(), fecha, resultado);
	}
	
	public Partido(String e1, String e2) {
		this(e1, e2, "", "0-0");
	}
	
	public Partido(Equipo e1, Equipo e2) {
		this(e1.getNombre(), e2.getNombre(), "", "0-0");
	}
	
	// toString
	@Override
	public String toString() {
		return this.equipos[0].toUpperCase() + " " + this.goles[0] + ", "
			 + this.equipos[1].toUpperCase() + " " + this.goles[1];
	}
}
