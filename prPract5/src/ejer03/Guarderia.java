package ejer03;

public class Guarderia extends Colegio {

// Variables de instancia
	private float areaJuegos;

// Constructores
	public Guarderia(Direccion dirEdif, short numHab, byte numPlantas, float area, byte numClases, byte numOfic,
			float areaJuegos) {
		super(dirEdif, numHab, numPlantas, area, numClases, numOfic);
		this.areaJuegos = areaJuegos;
	}
	
	public Guarderia(Colegio cole, float areaJuegos) {
		this(cole.getDirEdif(), cole.getNumHab(), cole.getNumPlantas(), cole.getArea(), cole.getNumClases(),
				cole.getNumOfic(), areaJuegos);
	}

// Métodos públicos
	@Override
	public float calculaIbi() {
		return 0;
	}
	
// Overrides
	public String toString() {
		return super.toString()
				+ "\n\tSuperficie area de juegos: " + this.areaJuegos; 
	}
	
// Getters y Setters
	public float getAreaJuegos() {return areaJuegos;}

	public void setAreaJuegos(float areaJuegos) {this.areaJuegos = areaJuegos;}
}
