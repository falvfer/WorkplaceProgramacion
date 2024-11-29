package ejer04;

import java.util.Random;

public class Urna {

// Variables de instancia
	private int b, n;

// Getters y Setters
	public int getB() {return b;}
	public int getN() {return n;}

	public void setB(int b) {this.b = b;}
	public void setN(int n) {this.n = n;}

// Constructores
	public Urna(int b, int n) {
		this.b = b;
		this.n = n;
	}
	
	public Urna(int bolas, char color) {
		this((color == 'b' ? bolas : 0), (color == 'n' ? 0 : bolas));
	}
	
	public Urna() {
		this(0,0);
	}

// Metodos publicos
	public char sacaBola() throws Exception {
		char bola = elegirBolaAleatoria();
		
		if (bola == 'b') this.b--;
		else this.n--;
		
		return bola;
	}
	
	public void meteBola(char color) throws Exception {
		switch (color) {
		case 'b' -> this.b++;
		case 'n' -> this.n++;
		default -> throw new Exception("Error: Color no válido");
		}
	}
	
	public boolean quedanBolas() {
		return (this.totalBolas() > 0);
	}
	
	public boolean quedaMasDeUnaBola() {
		return (this.totalBolas() > 1);
	}

// Metodos privados
	private int totalBolas() {
		return this.b + this.n;
	}
	
	/**
	 * Método para elegir una bola aleatoria de la Urna basada en la cantidad de bolas que hay dentro
	 * @return char --> 'b', 'n', Exception
	 * @throws Exception ("Error: No quedan bolas")
	 */
	private char elegirBolaAleatoria() throws Exception {
		int numBolas = totalBolas();
		if (numBolas == 0) throw new Exception("Error: No quedan bolas");
		
		Random rdn = new Random();
		int bolaAleatoria;
		char color;
		
		if (numBolas == 1) bolaAleatoria = 1;
		else bolaAleatoria = rdn.nextInt(1,numBolas);
		
		
		if (bolaAleatoria <= this.b)
			color = 'b';
		else
			color = 'n';
		
		return color;
	}

// toString, equals, hash
	@Override
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase()
				+ "\n\tBolas blancas: " + this.b
				+ "\n\tBolas negras: " + this.n;
	}
	
}
