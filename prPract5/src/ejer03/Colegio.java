package ejer03;

public class Colegio extends Edificio {

// Variables de instancia
	private byte numClases, numOfic;
	
// Constructores
	public Colegio(Direccion dirEdif, short numHab, byte numPlantas, float area, byte numClases, byte numOfic) {
		super(dirEdif, numHab, numPlantas, area);
		this.numClases = numClases;
		this.numOfic = numOfic;
	}
	
	public Colegio(String nomCalle, int numero, String codPostal, short numHab, byte numPlantas, float area, byte numClases, byte numOfic) {
		this(new Direccion(nomCalle, numero, codPostal), numHab, numPlantas, area, numClases, numOfic);
	}
	
	public Colegio(Edificio edif, byte numClases, byte numOfic) {
		this(edif.getDirEdif(), edif.getNumHab(), edif.getNumPlantas(), edif.getArea(), numClases, numOfic);
	}
	
// Métodos públicos
	@Override
	public float calculaIbi() {
		float ibi = super.calculaIbi() - 500;
		return (ibi>0?ibi:0);
	}
	
// toString
	@Override
	public String toString() {
		return super.toString()
				+ "\n\tNúmero Clases: " + this.numClases
				+ "\n\tNúmero Oficinas: " + this.numOfic;
	}
	
// Getters y Setters
	public byte getNumClases() {return numClases;}
	public byte getNumOfic() {return numOfic;}

	public void setNumClases(byte numClases) {this.numClases = numClases;}
	public void setNumOfic(byte numOfic) {this.numOfic = numOfic;}
	
}
