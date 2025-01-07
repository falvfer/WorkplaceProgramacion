package ejer11_18;

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
		LibreriaMatriz.enumerar(baraja);
		this.pos = 1;
		ultimaCartaSacada = "";
	}

	// Métodos públicos
	public void desordenar() {
		LibreriaMatriz.desordenar(baraja);
		this.pos = 1;
		ultimaCartaSacada = "";
	}
	
	public float sacaCarta() {
		
		if (pos > 40) return -1;
		
		float valor = LibreriaMatriz.buscarNum(this.baraja, this.pos)[1];
		cambiaUltimaCarta();
		
		if (valor >= 7) valor = 0.5f;
		else valor++;
		
		this.pos++;
		
		return valor;
	}
	
	// Métodos privados
	private void cambiaUltimaCarta() {
		int[] posicion = LibreriaMatriz.buscarNum(this.baraja, this.pos);

		switch (posicion[1]) {
		case 7 -> ultimaCartaSacada = "Sota de ";
		case 8 -> ultimaCartaSacada = "Caballo de ";
		case 9 -> ultimaCartaSacada = "Rey de ";
		default -> ultimaCartaSacada = posicion[1]+1 + " de ";
		}
		
		switch (posicion[0]) {
		case 0 -> ultimaCartaSacada += "Espadas";
		case 1 -> ultimaCartaSacada += "Monedas";
		case 2 -> ultimaCartaSacada += "Bastos";
		default -> ultimaCartaSacada += "Copas";
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
