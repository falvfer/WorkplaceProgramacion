package ejer05;

public abstract class VehiculoAbstracto {

// Variables de instancia
	private String color;
	private byte numRuedas;
	private short cilindros;
	private short potencia;
	
// Getters and Setters
	public String getColor() {return color;}
	public byte getNumRuedas() {return numRuedas;}
	public short getCilindros() {return cilindros;}
	public short getPotencia() {return potencia;}

	public void setColor(String color) {this.color = color;}
	public void setNumRuedas(byte numRuedas) {this.numRuedas = numRuedas;}
	public void setCilindros(short cilindros) {this.cilindros = cilindros;}
	public void setPotencia(short potencia) {this.potencia = potencia;}
	
// Constructores
	public VehiculoAbstracto(String color, byte numRuedas, short cilindros, short potencia) {
		this.color = color;
		this.numRuedas = numRuedas;
		this.cilindros = cilindros;
		this.potencia = potencia;
	}

	public VehiculoAbstracto(String color, byte numRuedas, short cilindros) {
		this(color, numRuedas, cilindros, (short)0);
	}
	
	public VehiculoAbstracto(String color, byte numRuedas) {
		this(color, numRuedas, (short)0, (short)0);
	}

	public VehiculoAbstracto(String color) {
		this(color, (byte)0, (short)0, (short)0);
	}
	
	public VehiculoAbstracto(byte numRuedas) {
		this("", numRuedas, (short)0, (short)0);
	}
	
	public VehiculoAbstracto(short cilindros) {
		this("", (byte)0, cilindros, (short)0);
	}
	
	public VehiculoAbstracto() {
		this("", (byte)0, (short)0, (short)0);
	}
	
// Métodos abstractos
	abstract public float impuesto();
	
// toString, equals, hashCode
	@Override
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase()
				+ "\n\tColor: " + this.color
				+ "\n\tNúmero de ruedas: " + this.numRuedas
				+ "\n\tCilindros: " + this.cilindros
				+ "\n\tPotencia: " + this.potencia;
	}
	
}
