package ejer18;

public class CartaInglesa extends Carta {
	/* Baraja inglesa / Poker
	 *  - Palo
	 *     - 1: Diamantes
	 *     - 2: Corazones
	 *     - 3: Picas
	 *     - 4: Treboles
	 *  - Valor: 1 As, 2-10, 11 Jota, 12 Reina, 13 Rey
	 */
	
	public CartaInglesa(byte palo, byte valor) {
		super(palo, valor);
	}
	
	@Override
	public String claseToString() {
		return "Carta de baraja Inglesa";
	}

	@Override
	public String paloToString() {
		return switch (this.getPalo()) {
		case 1 -> "Diamantes";
		case 2 -> "Corazones";
		case 3 -> "Picas";
		case 4 -> "Tréboles";
		default -> "Desconocido";
		};
	}
	
	@Override
	public String valorToString() {
		return switch (this.getValor()) {
		case 1 -> "As";
		case 2,3,4,5,6,7,8,9,10 -> this.getValor() + "";
		case 11 -> "Jota";
		case 12 -> "Reina";
		case 13 -> "Rey";
		default -> "Desconocido";
		};
	}
}
