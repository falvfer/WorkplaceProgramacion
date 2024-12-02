package ejer04;

import java.util.Random;

public class UrnaDeTresColores extends Urna {

// Variables de instancia
	private int r;

// Variables de clase
	

// Getters y Setters
	public int getR() {return r;}
	public void setR(int r) {this.r = r;}

// Constructores
	public UrnaDeTresColores(int b, int n, int r) {
		super(b, n);
		this.r = r;
	}
	
	public UrnaDeTresColores(int b, int n) {
		this(b, n, 0);
	}
	
	public UrnaDeTresColores(int bolas, char color) {
		this((color == 'b' ? bolas : 0), (color == 'n' ? 0 : bolas), (color == 'r' ? 0 : bolas));
	}
	
	public UrnaDeTresColores() {
		this(0,0,0);
	}

// Metodos públicos
	
	@Override
	public char sacaBola() throws Exception {
		char bola = this.elegirBolaAleatoria();
		
		if (bola == 'b') this.setB(getB()-1);
		else if (bola == 'n') this.setN(getN()-1);
		else this.r--;
		
		return bola;
	}
	
	@Override
	public void meteBola(char color) throws Exception {
		if (color == 'r') this.r++;
		else super.meteBola(color);
	}
	
	@Override
	public boolean quedanBolas() {
		return (this.totalBolas() > 0);
	}
	
	@Override
	public boolean quedaMasDeUnaBola() {
		return (this.totalBolas() > 1);
	}

// Metodos privados
	private int totalBolas() {
		return getB() + getN() + this.r;
	}
	
	private char elegirBolaAleatoria() throws Exception {
		int numBolas = totalBolas();
		if (numBolas == 0) throw new Exception("Error: No quedan bolas");
		
		Random rdn = new Random();
		char color;
		int bolaAleatoria;
		
		if (numBolas == 1) bolaAleatoria = 1;
		else bolaAleatoria = rdn.nextInt(1,numBolas);

		if (bolaAleatoria <= this.getB())
			color = 'b';
		else {
			numBolas -= this.getB();
			if (bolaAleatoria <= this.getN())
				color = 'n';
			else color = 'r';
		}
		
		return color;
	}

// toString, equals, hash
	@Override
	public String toString() {
		return super.toString()
				+ "\n\tBolas rojas: " + this.r;
	}
	
}
