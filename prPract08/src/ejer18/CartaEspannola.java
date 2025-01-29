package ejer18;

public class CartaEspannola extends Carta {
	/* Baraja española clásica
	 *  - Palo
	 *     - 1: Bastos
	 *     - 2: Espadas
	 *     - 3: Copas
	 *     - 4: Monedas / Oros
	 *  - Valor: 1-7, 8 Sota, 9 Caballo, 10 Rey
	 */
	
	// Constructor
	public CartaEspannola(byte palo, byte valor) {
		super(palo, valor);
	}

	// Métodos toString
	
	@Override
	public String claseToString() {
		return "Carta de baraja Española";
	}

	@Override
	public String paloToString() {
		return switch (this.getPalo()) {
		case 1 -> "Bastos";
		case 2 -> "Espadas";
		case 3 -> "Copas";
		case 4 -> "Monedas";
		default -> "Desconocido";
		};
	}

	@Override
	public String valorToString() {
		return switch (this.getValor()) {
		case 1,2,3,4,5,6,7 -> this.getValor() + "";
		case 8 -> "Sota";
		case 9 -> "Caballo";
		case 10 -> "Rey";
		default -> "Desconocido";
		};
	}
}
