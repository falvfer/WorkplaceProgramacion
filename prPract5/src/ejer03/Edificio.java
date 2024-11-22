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
