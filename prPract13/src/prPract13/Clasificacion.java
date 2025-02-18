package prPract13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Clasificacion {

// Variables
	SortedSet<Equipo> equipos;
	List<Partido> partidos;

// Constructores
	public Clasificacion(SortedSet<Equipo> equipos, List<Partido> partidos) {
		this.equipos = equipos;
		this.partidos = partidos;
	}
	
	public Clasificacion() {
		this(new TreeSet<>(), new ArrayList<>());
	}
	
// Métodos
	public boolean addEquipo(Equipo e) {
		return this.equipos.add(e);
	}
	
	public boolean addPartido(Partido p) throws ClasificacionException {
		Equipo anfitrion = buscarEquipo(p.getAnfitrion());
		Equipo visitante = buscarEquipo(p.getVisitante());
		
		if (anfitrion == null)
			throw new ClasificacionException("Error: El Anfitrión no está en la clasificación.");
		if (visitante == null)
			throw new ClasificacionException("Error: El Visitante no está en la clasificación.");
		
		anfitrion.addGolesFavor(p.getGolesAnfitrion());
		anfitrion.addGolesContra(p.getGolesVisitante());
		visitante.addGolesFavor(p.getGolesVisitante());
		visitante.addGolesContra(p.getGolesAnfitrion());
		
		switch (p.getResultadoQuiniela()) {
			case "1" -> {
				anfitrion.addGanado();
				visitante.addPerdido();
			}
			case "X" -> {
				anfitrion.addEmpatado();
				visitante.addEmpatado();
			}
			case "2" -> {
				anfitrion.addPerdido();
				visitante.addGanado();
			}
		}
		
		return this.partidos.add(p);
	}
	
	private Equipo buscarEquipo(String nombre) {
		boolean encontrado = false;
		Equipo e = null;
		for (Iterator<Equipo> it = this.equipos.iterator(); it.hasNext() && !encontrado;) {
			e = it.next();
			if (e.getNombre() == nombre)
				encontrado = true;
		}
		
		if (!encontrado)
			e = null;
		
		return e;
	}
	
// toString
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(this.getClass().getSimpleName().toUpperCase()
												+ "\tPJ\tPG\tPE\tPP\tGF\tGC\tPuntos\tEquipo");
		for (Equipo e: this.equipos)
			str.append("\t" + e.toStringLineal());
		
		return str.toString();
	}
	
	public String partidosEnFecha(String fecha) {
		
	}
	
	
	

}
