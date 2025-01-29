package ejer05;

public class Camion extends VehiculoAbstracto {

// Variables de instancia
	private byte numEjes;
	
/* Variables de la clase super
 * 		private String color;
 * 		private byte numRuedas;
 * 		private short cilindros;
 * 		private short potencia;
 */
	
// Getters y Setters
	public byte getNumEjes() {return numEjes;}
	public void setNumEjes(byte numEjes) {this.numEjes = numEjes;}
	
// Constructores
	public Camion(String color, byte numRuedas, short cilindros, short potencia, byte numEjes) {
		super(color, numRuedas, cilindros, potencia);
		this.numEjes = numEjes;
	}
	
	public Camion(String color, byte numRuedas, short cilindros, short potencia) {
		super(color, numRuedas, cilindros, potencia);
		this.numEjes = 0;
	}
	
	public Camion(String color, byte numRuedas, short cilindros) {
		super(color, numRuedas, cilindros);
		this.numEjes = 0;
	}
	
	public Camion(String color, byte numRuedas) {
		super(color, numRuedas);
		this.numEjes = 0;
	}
	
	public Camion(byte numRuedas) {
		super(numRuedas);
		this.numEjes = 0;
	}
	
	public Camion() {
		super();
		this.numEjes = 0;
	}

// Métodos públicos
	@Override
	public float impuesto() {
		return this.getCilindros()/30f + this.getPotencia()*20 + this.getNumRuedas()*20 + this.numEjes*50;
	}
	
// toString, equals, hashCode
	@Override
	public String toString() {
		return super.toString()
				+ "\n\tNúmero de ejes: " + this.numEjes;
	}



}
