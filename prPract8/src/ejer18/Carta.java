package ejer18;

public class Carta {
	
	// Variables
	private byte clase, palo, valor;
	/* Clase 
	 *  - 1: Baraja española
	 *  	  - Palo
	 *           - 1: Bastos
	 *           - 2: Espadas
	 *           - 3: Copas
	 *           - 4: Monedas / Oros
	 *        - Valor: 1-9, 10 Sota, 11 Caballo, 12 Rey
	 *  - 2: Baraja 7 y media
	 *  	  - Palo
	 *           - 1: Bastos
	 *           - 2: Espadas
	 *           - 3: Copas
	 *           - 4: Monedas / Oros
	 *        - Valor: 1-7, 8 Sota, 9 Caballo, 10 Rey
	 *  - 3: Baraja inglesa / Poker
	 *  	  - Palo
	 *           - 1: Diamantes
	 *           - 2: Corazones
	 *           - 3: Picas
	 *           - 4: Treboles
	 *        - Valor: 1 As, 2-10, 11 Jota, 12 Reina, 13 Rey
	 */
	
	// Getters y Setters
	public byte getClase() {return clase;}
	public byte getPalo() {return palo;}
	public byte getValor() {return valor;}

	public void setClase(byte clase) {this.clase = clase;}
	public void setPalo(byte palo) {this.palo = palo;}
	public void setValor(byte valor) {this.valor = valor;}
	
	// Constructores
	public Carta(byte clase, byte palo, byte valor) {
		this.clase = clase;
		this.palo = palo;
		this.valor = valor;
	}

	// Métodos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
