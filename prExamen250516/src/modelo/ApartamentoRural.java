package modelo;

import java.io.Serializable;

public class ApartamentoRural extends Alojamiento implements Serializable {
	private static final long serialVersionUID = -15220105166254919L;
	
	// Variables
	private boolean cocina, parking;
	
// Getters y Setters
	public boolean isCocina() {return cocina;}
	public boolean isParking() {return parking;}

	public void setCocina(boolean cocina) {this.cocina = cocina;}
	public void setParking(boolean parking) {this.parking = parking;}
	
// Constructor
	public ApartamentoRural(String nombre, UbicacionesEnum ubicacion, double precioBase,
			boolean cocina, boolean parking) throws MiExcepcion {
		
		super(nombre, ubicacion, precioBase);
		this.cocina = cocina;
		this.parking = parking;
	}

// Métodos
	@Override
	double calculaPrecio(int numNoches) {
		if (numNoches <= 0) return -1;
		
		return (super.getPrecioBase() * numNoches) + (cocina?10:0) + (parking?10:0);
	}
	
	// toString
		@Override
		public String toString() {
			return super.toString()
					+ "\n\t" + (this.cocina?"Sí":"No") + " tiene cocina"
					+ "\n\t" + (this.parking?"Sí":"No") + " tiene parking";
		}

}
