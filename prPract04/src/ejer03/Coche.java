package ejer03;

public class Coche {

// Variables de instancia
	private String modelo, fabricante;
	private float precioBruto;
	public byte iva;
	
// Constructores
	public Coche(String modelo, String fabricante, float precioBruto, byte iva) {
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.precioBruto = precioBruto;
		this.iva = iva;
	}
	
	public Coche(String modelo, String fabricante, float precioBruto) {
		this(modelo, fabricante, precioBruto, (byte)0);
	}
	
	public Coche() {
		this("", "", 0f, (byte)0);
	}
	
// Métodos
	private float precioReal() {
		return this.precioBruto * (this.iva + 100) / 100;
	}
	
	public void consulta() {
		System.out.println("Modelo: "+this.modelo);
		System.out.println("Precio: "+this.precioReal());
	}
	
	public void actualizarPrecio(byte porcentaje) {
		this.iva += porcentaje;
	}
	
// Overrides
	@Override
	public String toString() {
		return "Objeto de clase Coche:"
				+ "\n\tFabricante: " + this.fabricante
				+ "\n\tModelo: " + this.modelo
				+ "\n\tPrecio en bruto: " + this.precioBruto
				+ "\n\tIVA: " + this.iva
				+ "\n\tPrecio real: " + this.precioReal();
	}
	
	@Override
	public boolean equals(Object ob) {
		Coche otroCoche = (Coche)ob;
		return this.modelo.equals(otroCoche.getModelo())
			&& this.fabricante.equals(otroCoche.getFabricante());
	}

// Getters
	public String getModelo() {
		return modelo;
	}
	public String getFabricante() {
		return fabricante;
	}
	public float getPrecioBruto() {
		return precioBruto;
	}
	public byte getIva() {
		return iva;
	}

// Setters
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public void setPrecioBruto(float precioBruto) {
		this.precioBruto = precioBruto;
	}
	public void setIva(byte iva) {
		this.iva = iva;
	}
	
	
	
	
}
