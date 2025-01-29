package ejer16v1;

import MisLibrerias.LibreriaMatriz;

public class Baraja7YMedio {
	
	// Variables
	private int[][] baraja;
	private int pos;
	private String ultimaCartaSacada;
	
	// Getters y Setters
	public int[][] getBaraja() {return baraja;}
	public int getPos() {return pos;}
	public String getUltimaCartaSacada() {return ultimaCartaSacada;}

	public void setBaraja(int[][] baraja) {this.baraja = baraja;}
	public void setPos(int pos) {this.pos = pos;}
	public void setUltimaCartaSacada(String ultimaCartaSacada) {this.ultimaCartaSacada = ultimaCartaSacada;}

	// Constructor
	public Baraja7YMedio() {
		this.baraja = new int[4][10];
		LibreriaMatriz.enumerar(this.baraja);
		this.pos = 1;
		this.ultimaCartaSacada = "";
	}

	// Métodos públicos
	public void barajar() {
		LibreriaMatriz.desordenar(this.baraja);
		this.pos = 1;
		this.ultimaCartaSacada = "";
	}
	
	public float sacaCarta() {
		
		if (this.pos > 40) return -1;
		
		float valor = LibreriaMatriz.buscarNum(this.baraja, this.pos)[1];
		this.cambiaUltimaCarta();
		
		if (valor < 7) valor++;
		else valor = 0.5f;
		
		this.pos++;
		
		return valor;
	}
	
	// Métodos privados
	private void cambiaUltimaCarta() {
		int[] posicion = LibreriaMatriz.buscarNum(this.baraja, this.pos);

		switch (posicion[1]) {
		case 7 -> this.ultimaCartaSacada = "Sota de ";
		case 8 -> this.ultimaCartaSacada = "Caballo de ";
		case 9 -> this.ultimaCartaSacada = "Rey de ";
		default -> this.ultimaCartaSacada = (posicion[1]+1) + " de ";
		}
		
		switch (posicion[0]) {
		case 0 -> this.ultimaCartaSacada += "Espadas";
		case 1 -> this.ultimaCartaSacada += "Monedas";
		case 2 -> this.ultimaCartaSacada += "Bastos";
		default -> this.ultimaCartaSacada += "Copas";
		}
	}
	
	// toString
	@Override
	public String toString() {
		return "Baraja 7 y medio:"
				+ "\n\tCartas restantes: " + (41 - this.pos)
				+ "\n\tÚltima carta sacada: " + this.ultimaCartaSacada;
	}


	
}
