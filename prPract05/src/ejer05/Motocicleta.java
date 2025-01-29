package ejer05;

public class Motocicleta extends VehiculoAbstracto {
	// Variables de instancia
	private byte numOcupantes;
	
	/* Variables de la clase super
	 * 		private String color;
	 * 		private byte numRuedas;
	 * 		private short cilindros;
	 * 		private short potencia;
	 */
	
// Getters y Setters
	public byte getNumOcupantes() {return numOcupantes;}
	public void setNumOcupantes(byte numOcupantes) {this.numOcupantes = numOcupantes;}
	
// Constructores
	public Motocicleta(String color, byte numRuedas, short cilindros, short potencia, byte numOcupantes) {
		super(color, numRuedas, cilindros, potencia);
		this.numOcupantes = numOcupantes;
	}
	
	public Motocicleta() {
		super((byte)2);
		this.numOcupantes = 1;
	}
	
	public Motocicleta(byte numOcupantes) {
		super((byte)2);
		this.numOcupantes = numOcupantes;
	}
	
	public Motocicleta(String color) {
		super(color, (byte)2);
		this.numOcupantes = 1;
	}
	
	public Motocicleta(String color, short cilindros) {
		super(color, (byte)2, cilindros);
		this.numOcupantes = 1;
	}
	
	public Motocicleta(String color, short cilindros, short potencia) {
		super(color, (byte)2, cilindros, potencia);
		this.numOcupantes = 1;
	}

// Métodos públicos
	@Override
	public float impuesto() {
		return this.getCilindros()/30f + this.getPotencia()*30;
	}
	
// toString, equals, hashCode
	@Override
	public String toString() {
		return super.toString()
				+ "\n\tNúmero de Ocupantes: " + this.numOcupantes;
	}
}
