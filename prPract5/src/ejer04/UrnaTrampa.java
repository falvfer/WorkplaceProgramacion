package ejer04;

import java.util.Random;

public class UrnaTrampa extends Urna {
	
// Variables de clase
	private final static float probabilidadCambiar = 0.2f; // En porcentaje: 0.2 == 0.2%
	
// Constructores
	public UrnaTrampa(int b, int n) {
		super(b, n);
	}
	
	public UrnaTrampa(int bolas, char color) {
		super((color == 'b' ? bolas : 0), (color == 'n' ? 0 : bolas));
	}
	
	public UrnaTrampa() {
		super(0,0);
	}
	
// Metodos publicos
	@Override
	public char sacaBola() throws Exception {
		Random rdn = new Random();
		char bola = super.sacaBola();
		boolean cambColor = (rdn.nextInt(0,(int)(1/(probabilidadCambiar/100))) == 0);
		
		if (cambColor && this.getB() > 0 && this.getN() > 0) {
			char bolaCambiar = super.sacaBola();
			
			if (bolaCambiar == 'b')
				this.meteBola('n');
			else
				this.meteBola('b');
		}
		return bola;
	}
	
}
