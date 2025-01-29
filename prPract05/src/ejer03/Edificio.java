package ejer03;

public class Edificio {

// Variables de instancia
	private Direccion dirEdif;
	private short numHab;
	private byte numPlantas;
	private float area;
	
// Constructores
	public Edificio(Direccion dirEdif, short numHab, byte numPlantas, float area) {
		this.dirEdif = dirEdif;
		this.numHab = numHab;
		this.numPlantas = numPlantas;
		this.area = area;
	}
	
	public Edificio(String nomCalle, int numero, String codPostal, short numHab, byte numPlantas, float area) {
		this(new Direccion(nomCalle, numero, codPostal), numHab, numPlantas, area);
	}

// Métodos públicos
	/**
	 * Método para calcular el ibi de un edificio
	 * Formula: Area x 1.2 + NºPlantas x 100
	 * @return
	 */
	public float calculaIbi() {
		return this.area * 1.2f + this.numPlantas * 100;
	}
	
// toString
	@Override
	public String toString() {
		return "Objeto tipo " + this.getClass().getSimpleName().toUpperCase() + ": "
				+ "\n\tDirección: " + this.dirEdif
				+ "\n\tNúmero plantas: " + this.numPlantas
				+ "\n\tNúmero habitaciones: " + this.numHab
				+ "\n\tArea: " + this.area
				+ "\n\tIBI: " + this.calculaIbi();
	}
	
	
	
	
	
// Getters
	public Direccion getDirEdif() {return dirEdif;}
	public short getNumHab() {return numHab;}
	public byte getNumPlantas() {return numPlantas;}
	public float getArea() {return area;}

// Setters
	public void setDirEdif(Direccion dirEdif) {this.dirEdif = dirEdif;}
	public void setNumHab(short numHab) {this.numHab = numHab;}
	public void setNumPlantas(byte numPlantas) {this.numPlantas = numPlantas;}
	public void setArea(float area) {this.area = area;}
}
