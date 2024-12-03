package examen1POO;

public class Jamon {

// Variables de instancia
	private Cerdo procedencia;
	private double pesoKilos;
	private short mesesCuracion;
	
// Getters y Setters
	public Cerdo getProcedencia() {return procedencia;}
	public double getPesoKilos() {return pesoKilos;}
	public short getMesesCuracion() {return mesesCuracion;}
	
	public void setProcedencia(Cerdo procedencia) {this.procedencia = procedencia;}
	public void setPesoKilos(double pesoKilos) {this.pesoKilos = pesoKilos;}
	public void setMesesCuracion(short mesesCuracion) {this.mesesCuracion = mesesCuracion;}
	
// Constructores
	public Jamon(Cerdo procedencia, double pesoKilos, short mesesCuracion) {
		this.procedencia = procedencia;
		this.pesoKilos = pesoKilos;
		this.mesesCuracion = mesesCuracion;
	}
	
	public Jamon (Cerdo procedencia, double pesoKilos) {
		this(procedencia, pesoKilos, (short)0);
	}
	
// Métodos públicos
	public String tipoJamon() {
		if (this.mesesCuracion > 15) return "Gran reserva";
		if (this.mesesCuracion > 12) return "Reserva";
		if (this.mesesCuracion > 9) return "Bodega";
		return "Insuficiente curación";
	}
	
	public float precioJamon() {
		double precioKiloCerdo = LibreriaJamones.aPrecioKilo(this.procedencia.precioArroba());
		
		String tipoDeJamon = this.tipoJamon();
		byte precioTipo;
		switch (tipoDeJamon) {
		case "Bodega" -> precioTipo = 10;
		case "Reserva" -> precioTipo = 20;
		case "Gran reserva" -> precioTipo = 30;
		default -> precioTipo = 0;
		}
		
		return (float)(precioKiloCerdo * this.pesoKilos + precioTipo);
	}
	
// toString
	public String toString() {
		return "Tipo de jamón: " + (this.procedencia.isIberico()?"Ibérico " + this.procedencia.getTipo():"Blanco")
				+ "\n\tPeso: " + this.pesoKilos
				+ "\n\tMeses de curación: " + this.mesesCuracion
				+ "\n\tPrecio jamón: " + this.precioJamon();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
