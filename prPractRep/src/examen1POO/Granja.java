package examen1POO;

public class Granja {
	
// Variables de instancia
	private String nombre;
	private boolean tieneOrigen;
	private float precioArroba;
	
// Getters y Setters
	public String getNombre() {return nombre;}
	public boolean isTieneOrigen() {return tieneOrigen;}
	public float getPrecioArroba() {return precioArroba;}

	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setTieneOrigen(boolean tieneOrigen) {this.tieneOrigen = tieneOrigen;}
	public void setPrecioArroba(float precioArroba) {this.precioArroba = precioArroba;}
	
// Constructores
	public Granja(String nombre, boolean tieneOrigen, float precioArroba) {
		this.nombre = nombre;
		this.tieneOrigen = tieneOrigen;
		this.precioArroba = precioArroba;
	}
	
	public Granja(String nombre) {
		this(nombre, false, 15f);
	}

// toString
	@Override
	public String toString() {
		// Los Jamoneros Andaluces, con denominación de origen - Precio base @: 20.0€
		// Hermanos García, S.L, sin denominación de origen - Precio base @: 17.0€
		
		return this.nombre + ", " + (this.tieneOrigen? "con": "sin")
				+ " denominación de origen - Precio base @: " + this.precioArroba;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
