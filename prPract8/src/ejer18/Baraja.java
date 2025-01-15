package ejer18;

import java.util.Random;

public class Baraja {

// Variables
	private Carta[] baraja;
	private int posicionActual;
	
// Getters y Setters
	public Carta[] getBaraja() {return baraja;}
	public int getPosicionActual() {return posicionActual;}

	public void setBaraja(Carta[] baraja) {this.baraja = baraja;}
	public void setPosicionActual(int posicionActual) {this.posicionActual = posicionActual;}
	
// Constructores
	/**
	 * Constructor principal de la clase Baraja
	 * @param clase -> Baraja espannola (1) o Baraja inglesa (2)
	 */
	public Baraja(int clase) {
		switch (clase) {
		case 1 -> { // Caso de baraja espannola
			this.baraja = new CartaEspannola[40]; 
			for (int i = 0; i < this.baraja.length; i++)
				this.baraja[i] = new CartaEspannola((byte)(((i)/10)+1), (byte)(((i+1)%10)+1));
		}
		case 2 -> { // Caso de baraja inglesa
			this.baraja = new CartaInglesa[52];
			for (int i = 0; i < this.baraja.length; i++)
				this.baraja[i] = new CartaInglesa((byte)(((i)/13)+1), (byte)(((i+1)%13)+1));
		}
		} // Enumerar las posiciones
		this.posicionActual = 0;
	}
	
	/**
	 * Constructor por defecto, crea una baraja española.
	 */
	public Baraja() {
		this(1);
	}
	
// Métodos para ordenar y desordenar
	public void ordenar() {
		Carta aux;
		byte palo, valor,
			cartasPorPalo = (byte)(this.baraja.length / 4),
			parar = (byte)(this.baraja.length - 1);
		
		for (int i = 0; i < parar; i++) {
			valor = (byte)(i % cartasPorPalo);
			palo = (byte)(i / (cartasPorPalo - valor));
			if (!this.baraja[i].isEqualTo(palo, valor)) {
				for (int k = i+1; i < parar+1; k++) {
					if (this.baraja[i].equals(this.baraja[k])) {
						aux = this.baraja[i];
						this.baraja[i] = this.baraja[k];
						this.baraja[k] = aux;
					}
				}
			}
		}
	}
	
	public void barajar() {
		Random rdn = new Random();
		int posMax = this.baraja.length;
		int posI, posK;
		Carta aux;
		
		for (int i = 0; i < 100; i++) {
			posI = rdn.nextInt(0, posMax);
			posK = rdn.nextInt(0, posMax);
			
			if (posI != posK) {
				aux = this.baraja[posI];
				this.baraja[posI] = this.baraja[posK];
				this.baraja[posK] = aux;
			}
		}
		
		this.posicionActual = 0;
	}
	
// Método para la CPU para "espiar" la baraja
	public int valorCarta(int posicion) {return this.baraja[this.posicionActual + posicion].getValor();}

// Métodos para conseguir información de la carta actual
	public int valorCartaActual() {return valorCarta(0);}
	public int paloCartaActual() {return this.baraja[this.posicionActual].getPalo();}
	
// Métodos para conseguir información como String
	public String valorCartaActualToString() {return this.baraja[this.posicionActual].valorToString();}
	public String paloCartaActualToString() {return this.baraja[this.posicionActual].paloToString();}
	public String cartaActualToString() {return this.baraja[this.posicionActual].toString();}
	
// Método para cambiar la posición del mazo
	public void siguienteCarta() {this.posicionActual++;}
	
// Método debug para imprimir la baraja
	public String debugPosiciones() {
		String resultado = "";
		
		for (int i = 0; i < this.baraja.length; i++)
			resultado += this.baraja[i].valorToString() + "/" + this.baraja[i].paloToString() + " ";
		
		return resultado;
	}
	
	
	
	
	
	
}
