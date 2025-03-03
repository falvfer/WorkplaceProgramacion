package pract3_Repaso;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PilotosF1 {
	
// Variables
	private List<Piloto> participantes;
	
// Getters y Setters
	public List<Piloto> getParticipantes() {return participantes;}
	public void setParticipantes(List<Piloto> participantes) {this.participantes = participantes;}

// Constructor
	public PilotosF1() {
		this.participantes = new ArrayList<>(22);
	}
	
// Métodos públicos de instancia
	public boolean addPiloto(Piloto p) {
		if (this.participantes.size()>= 22)
			return false;
		
		this.participantes.add(p);
		return true;
	}
	
	public boolean addCarreraPiloto(String nombre, int puesto) {
		Piloto p = getPiloto(nombre);
		
		if (p == null || puesto < 1 || puesto > 10)
			return false;
		
		p.addPuntos(obtenerPuntos(puesto));
		return true;
	}
	
	public void addGranPremio(String ganadores) {
		String[] nombresGanadores = ganadores.split(";");
		Piloto p;
		
		for (int i = 0; i < nombresGanadores.length && i < 10; i++) {
			p = getPiloto(nombresGanadores[i]);
			if (p != null) {
				p.addPuntos(obtenerPuntos(i+1));
			}
		}
	}
	
// Métodos públicos de clase
	public static int obtenerPuntos(int puesto) {
		return switch (puesto) {
			case 1 -> 25;
			case 2 -> 18;
			case 3 -> 15;
			case 4 -> 12;
			case 5 -> 10;
			case 6 -> 8;
			case 7 -> 6;
			case 8 -> 4;
			case 9 -> 2;
			case 10 -> 1;
			default -> -1;
		};
	}
	
// Métodos privados
	private Piloto getPiloto(String nombre) {
		boolean salir = false;
		Piloto p = null;
		
		for (Iterator<Piloto> it = this.participantes.iterator(); it.hasNext() && !salir;) {
			p = it.next();
			if (p.getNombre() == nombre)
				salir = true;
		}
		
		if (salir == false)
			p = null;
		
		return p;
	}
	
	private void ordena() {
		Collections.sort(this.participantes,
			(o1, o2) -> {
				int comparacion = Integer.compare(o2.getPuntosTotales(), (o1.getPuntosTotales()));
				if (comparacion == 0) comparacion = o1.getNombre().compareTo(o2.getNombre());
				return comparacion;
			}
		);
	}
	
// toString
	public String clasificacionPorPilotos() {
		ordena();
		StringBuilder str = new StringBuilder("Clasificación de pilotos:");
		
		for (Iterator<Piloto> it = this.participantes.iterator(); it.hasNext();)
			str.append("\n\t" + it.next());
		
		return str.toString();
	}
	
	

}
