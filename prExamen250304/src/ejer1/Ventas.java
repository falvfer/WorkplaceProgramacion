package ejer1;

import java.util.Random;

public class Ventas {
	
// Variables
	private Juego[][] ventas;
	private String[] nombreJuegos;
	private static Random rdn = new Random();
	
// Getters y Setters
	public Juego[][] getPosiblesVentas() {return ventas;}
	public String[] getNombreJuegos() {return nombreJuegos;}
	
	public void setPosiblesVentas(Juego[][] posiblesVentas) {this.ventas = posiblesVentas;}
	public void setNombreJuegos(String[] nombreJuegos) {this.nombreJuegos = nombreJuegos;}
	
// Constructores
	public Ventas(String[] nombreJuegos) {
		this.nombreJuegos = nombreJuegos;
		
		this.ventas = new Juego[nombreJuegos.length][Plataforma.values().length];
		for (int y = 0; y < this.ventas.length; y++)
			for (int x = 0; x < this.ventas[y].length; x++)
				this.ventas[y][x] = new Juego(this.nombreJuegos[y], Plataforma.values()[x]);
		
		this.rellenarVentas();
	}
	
// Métodos públicos
	public void rellenarVentas() {
		for (int y = 0; y < this.ventas.length; y++)
			for (int x = 0; x < this.ventas[y].length; x++)
				this.ventas[y][x].setUdVendidas(rdn.nextInt(0,50));
	}
	
	public int[] getTotalVentasJuego() {
		int[] total = new int[this.nombreJuegos.length];
		
		for (int y = 0; y < this.ventas.length; y++)
			for (int x = 0; x < this.ventas[y].length; x++)
				total[y] += this.ventas[y][x].getUdVendidas();
		
		return total;
	}
	
	public int[] getTotalVentasPlataforma() {
		int[] total = new int[Plataforma.values().length];
		
		for (int x = 0; x < Plataforma.values().length; x++)
			for (int y = 0; y < this.ventas.length; y++)
				total[x] += this.ventas[y][x].getUdVendidas();
		
		return total;
	}
	
	public int getVentas(String juego, Plataforma plat) {
		Juego j = buscarJuego(juego, plat);
		
		if (j == null)
			return -1;
		
		return j.getUdVendidas();
	}
	
	public int getVentas(String juego, String plat) {
		Plataforma p;
		try {
			p = Plataforma.valueOf(plat);
		} catch (Exception e) {
			return -2;
		}
		return getVentas(juego, p);
	}
	
	public Juego[] getJuegosMasVendidos(int num) {
		if (num > this.ventas.length*this.ventas[0].length)
			return null;
		
		// Hacer una copia de ventas para evitar modificaciones
		Juego[][] juegos = new Juego[this.ventas.length][this.ventas[0].length];
		for (int y = 0; y < this.ventas.length; y++)
			for (int x = 0; x < this.ventas[y].length; x++)
				juegos[y][x] = this.ventas[y][x];
		
		Juego[] top = new Juego[num];
		
		for (int i = 0; i < num; i++) {
			int[] posJuego = getPosMayor(juegos);
			top[i] = juegos[posJuego[0]][posJuego[1]];
			juegos[posJuego[0]][posJuego[1]] = null;
		}
		
		return top;
	}
	
// Métodos privados
	private Juego buscarJuego(String juego, Plataforma plat) {
		boolean salir = false;
		int y = 0;
		
		for (int i = 0; i < this.nombreJuegos.length && !salir; i++) {
			if (this.nombreJuegos[i] == juego) {
				y = i;
				salir = true;
			}
		}
		
		if (salir == false)
			return null;
		
		return this.ventas[y][plat.ordinal()];
	}
	
	public static int[] getPosMayor(Juego[][] juegos) {
		int[] mayor = {0,0};
		
		for (int y = 0; y < juegos.length; y++)
			for (int x = 0; x < juegos[y].length; x++)
				if (juegos[y][x] != null && juegos[y][x].getUdVendidas() > juegos[mayor[0]][mayor[1]].getUdVendidas()) {
					mayor[0] = y;
					mayor[1] = x;
				}
		
		return mayor;
	}
	
// toStrings
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("SIMULACION VENTAS MENSUALES\n");
		
		// Plataformas
		for (int i = 0; i < Plataforma.values().length; i++) {
			String plat = Plataforma.values()[i].toString();
			if (plat.length() > 7)
				str.append(plat + "\t");
			else
				str.append(plat + "\t\t");
		}
		
		// Ventas de juegos
		for (int y = 0; y < this.ventas.length; y++) {
			str.append("\n");
			for (int x = 0; x < this.ventas[y].length; x++) {
				str.append(this.ventas[y][x].getUdVendidas() + "\t\t");
			}
			str.append("("+this.nombreJuegos[y]+")");
		}
		
		return str.toString();
	}
	
	public String toStringVentasJuego() {
		int[] totales = this.getTotalVentasJuego();
		StringBuffer str = new StringBuffer("Ventas totales por juego en las diferentes plataformas");
		
		for (int i = 0; i < totales.length; i++)
			str.append("\n\t" + this.nombreJuegos[i] + ": " + totales[i]);
		
		return str.toString();
	}
	
	public String toStringVentasPlataforma() {
		int[] totales = this.getTotalVentasPlataforma();
		StringBuffer str = new StringBuffer("Ventas totales de juegos por plataformas");
		
		for (int i = 0; i < totales.length; i++)
			str.append("\n\t" + Plataforma.values()[i] + ": " + totales[i] + " unidades vendidas");
		
		return str.toString();
	}
	
	

}
