package ejer04;

import java.util.Random;

public class Urna {

// Variables de instancia
	private int blanc, neg;

// Getters y Setters
	public int getBlanc() {return blanc;}
	public int getNeg() {return neg;}

	public void setBlanc(int blanc) {this.blanc = blanc;}
	public void setNeg(int neg) {this.neg = neg;}

// Constructores
	public Urna(int blanc, int neg) {
		this.blanc = blanc;
		this.neg = neg;
	}
	
	public Urna(int bolas, char color) {
		this((color == 'b' ? bolas : 0), (color == 'n' ? 0 : bolas));
	}
	
	public Urna() {
		this(0,0);
	}

// Metodos publicos
	public char sacaBola() throws Exception {
		if (this.blanc == 0) {
			if (this.neg == 0)
				throw new Exception("Error: No quedan bolas");
			else {
				this.neg--;
				return 'n';
			}
		} else {
			if (this.neg == 0) {
				this.blanc--;
				return 'b';
			} else {
				Random rdn = new Random();
				boolean color = (rdn.nextInt(1,this.totalBolas()) <= this.blanc);
				
				if (color) this.blanc--;
				else this.neg--;
				
				return (color?'b':'n');
			}
		}
	}
	
	public void meteBola(char color) throws Exception {
		if (color == 'b') this.blanc++;
		else if (color == 'n') this.neg++;
		else throw new Exception("Error: Color no válido");
	}
	
	public boolean quedanBolas() {
		return (this.totalBolas() > 0);
	}
	
	public boolean quedaMasDeUnaBola() {
		return (this.totalBolas() > 1);
	}

// Metodos privados
	private int totalBolas() {
		return this.blanc + this.neg;
	}

// toString, equals, hash
	@Override
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase()
				+ "\n\tBolas blancas: " + this.blanc
				+ "\n\tBolas negras: " + this.neg;
	}
	
}
