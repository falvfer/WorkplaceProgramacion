package ejer03;

public class Casa extends Edificio {

// Variables de instancia
	private byte numDorm, numBannos;


// Constructores
	public Casa(Direccion dirEdif, short numHab, byte numPlantas, float area, byte numDorm, byte numBannos) {
		super(dirEdif, numHab, numPlantas, area);
		this.numDorm = numDorm;
		this.numBannos = numBannos;
	}
	
	public Casa(String nomCalle, int numero, String codPostal, short numHab, byte numPlantas, float area, byte numDorm, byte numBannos) {
		this(new Direccion(nomCalle, numero, codPostal), numHab, numPlantas, area, numDorm, numBannos);
	}
	
	public Casa(Edificio edif, byte numDorm, byte numBannos) {
		this(edif.getDirEdif(), edif.getNumHab(), edif.getNumPlantas(), edif.getArea(), numDorm, numBannos);
	}
	
// Métodos públicos
	@Override
	public float calculaIbi() {
		return super.calculaIbi() + 10 * this.numBannos;
	}
	
// toString
	@Override
	public String toString() {
		return super.toString()
				+ "\n\tNúmero dormitorios: " + numDorm
				+ "\n\tNúmero baños: " + numBannos;
	}
	
// Getters y Setters
	public byte getNumDorm() {return numDorm;}
	public byte getNumBannos() {return numBannos;}

	public void setNumDorm(byte numDorm) {this.numDorm = numDorm;}
	public void setNumBannos(byte numBannos) {this.numBannos = numBannos;}
	
}
