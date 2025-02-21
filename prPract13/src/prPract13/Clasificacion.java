package prPract13;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import librerias.LibreriaFechasJavaTime;

public class Clasificacion {

// Variables
	private Set<Equipo> equipos;
	private List<Partido> partidos;

// Constructores
	public Clasificacion(Set<Equipo> equipos, List<Partido> partidos) {
		this.equipos = equipos;
		this.partidos = partidos;
	}
	
	public Clasificacion() {
		this(new HashSet<>(), new ArrayList<>());
	}
	
// Métodos
	public boolean addEquipo(Equipo e) {
		return this.equipos.add(e);
	}
	
	public boolean addEquipo(String nombre) throws ClasificacionException {
		if (!this.equipos.add(new Equipo(nombre)))
			throw new ClasificacionException("Error: El equipo ya está en la clasificatoria.");
		
		return true;
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
	
	public Equipo buscarEquipo(String nombre) {
		boolean encontrado = false;
		Equipo e = null;
		for (Iterator<Equipo> it = this.equipos.iterator(); it.hasNext() && !encontrado;) {
			e = it.next();
			if (e.getNombre().equalsIgnoreCase(nombre))
				encontrado = true;
		}
		
		if (!encontrado) return null;
		
		return e;
	}
	
// toString
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(this.getClass().getSimpleName().toUpperCase()
												+ "\n\tPJ\tPG\tPE\tPP\tGF\tGC\tPuntos\tEquipo");
		
		SortedSet<Equipo> equiposOrdenados = new TreeSet<>(
			(o1, o2) -> {
				if (Integer.compare(o2.getPuntosTotales(), o1.getPuntosTotales()) == 0)
					return o1.compareTo(o2);
				else
					return Integer.compare(o2.getPuntosTotales(), o1.getPuntosTotales());
			}
		);
		
		equiposOrdenados.addAll(this.equipos);
		
		for (Equipo e: equiposOrdenados)
			str.append("\n\t" + e.toStringLineal());
		
		return str.toString();
	}
	
	public String partidosEnFecha(String fecha) {
		LocalDate fe;
		if (LibreriaFechasJavaTime.isFechaCorrecta(fecha))
			fe = LibreriaFechasJavaTime.convierteStringToLocalDate(fecha);
		else
			fe = LocalDate.now();
		StringBuilder str = new StringBuilder("Partidos jugados el " + fecha);
		
		Partido p;
		for (Iterator<Partido> it = this.partidos.iterator(); it.hasNext();) {
			p = it.next();
			if (p.getDate().equals(fe))
				str.append("/n" + p.toString());
		}
		
		return str.toString();
	}
	
	
	

}
