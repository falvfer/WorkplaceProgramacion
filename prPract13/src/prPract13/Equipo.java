package prPract13;

import java.util.Objects;

public class Equipo implements Comparable<Equipo> {
	
// Variables
	private String nombre;
	private int pGanados, pEmpatados, pPerdidos, golesFavor, golesContra;
	
// Getters y Setters
	public String getNombre() {return nombre;}
	public int getpGanados() {return pGanados;}
	public int getpEmpatados() {return pEmpatados;}
	public int getpPerdidos() {return pPerdidos;}
	public int getGolesFavor() {return golesFavor;}
	public int getGolesContra() {return golesContra;}
	
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setpGanados(int pGanados) {this.pGanados = pGanados;}
	public void setpEmpatados(int pEmpatados) {this.pEmpatados = pEmpatados;}
	public void setpPerdidos(int pPerdidos) {this.pPerdidos = pPerdidos;}
	public void setGolesFavor(int golesFavor) {this.golesFavor = golesFavor;}
	public void setGolesContra(int golesContra) {this.golesContra = golesContra;}
	
// Constructor
	public Equipo(String nombre, int pGanados, int pEmpatados, int pPerdidos, int golesFavor, int golesContra) {
		this.nombre = nombre;
		this.pGanados = pGanados;
		this.pEmpatados = pEmpatados;
		this.pPerdidos = pPerdidos;
		this.golesFavor = golesFavor;
		this.golesContra = golesContra;
	}
	
	public Equipo(String nombre) {
		this(nombre, 0, 0, 0, 0, 0);
	}
	
// Métodos
	public int getPartidosJugados() {
		return this.pGanados + this.pPerdidos + this.pEmpatados;
	}
	
	public int getPuntosTotales() {
		return this.pGanados * 3 + this.pEmpatados;
	}

	public void addGanado(int num) {this.pGanados += num;}
	public void addGanado() {addGanado(1);}

	public void addEmpatado(int num) {this.pEmpatados += num;}
	public void addEmpatado() {addEmpatado(1);}

	public void addPerdido(int num) {this.pPerdidos += num;}
	public void addPerdido() {addPerdido(1);}
	
	public void addGolesFavor(int num) {this.golesFavor += num;}
	public void addGolesFavor() {addGolesFavor(1);}
	
	public void addGolesContra(int num) {this.golesContra += num;}
	public void addGolesContra() {addGolesContra(1);}
	
// toString y toStringLineal
	@Override
	public String toString() {
		return nombre.toUpperCase()
				+ "\n\tPartidos Jugados: " + this.getPartidosJugados()
				+ "\n\tPartidos Ganados: " + this.getpGanados()
				+ "\n\tPartidos Empatados: " + this.getpEmpatados()
				+ "\n\tPartidos Perdidos: " + this.getpPerdidos()
				+ "\n\tGoles a favor: " + this.getGolesFavor()
				+ "\n\tGoles en contra: " + this.getGolesContra()
				+ "\n\tPuntos totales: " + this.getPuntosTotales();
	}
	
	public String toStringLineal() {
		return 	 this.getPartidosJugados()  + "\t" + this.getpGanados()
		+ "\t" + this.getpEmpatados() 		+ "\t" + this.getpPerdidos() 
		+ "\t" + this.getGolesFavor() 		+ "\t" + this.getGolesContra()
		+ "\t" + this.getPuntosTotales()	+ "\t" + nombre.toUpperCase();
	}
	
// hashCode, equals, comparable
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	
	// Método de objeto para comparar si dos equipos son iguales, el de clase es Objects.equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return nombre.equalsIgnoreCase(other.nombre);
	}
	
	@Override
	public int compareTo(Equipo o) {
		return this.nombre.compareTo(o.nombre);
	}

}
