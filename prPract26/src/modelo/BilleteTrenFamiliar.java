package modelo;

public class BilleteTrenFamiliar extends BilleteTren{
	
// Variables de instancia
	private String nombre;
	
// Getters y Setters
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	@Override
	public String getDescuento() {return (super.getTipoDescuento().getPorcentaje()+25)+"%";}
	
// Constructor
	public BilleteTrenFamiliar(Punto origen, Punto destino, EnumDescuentos tipoDescuento, String nombre) {
		super(origen, destino, tipoDescuento);
		this.nombre = nombre;
	}
	
// Métodos públicos
	public double calculaPrecio() {
		return super.calculaPrecio() * 0.75;
	}
	
// toString
	@Override
	public String toString() {
		return super.toString()
				+ "\n\tDescuento extra por familiar: 25%"
				+ "\n\tFamiliar: " + nombre;
	}
	
}
