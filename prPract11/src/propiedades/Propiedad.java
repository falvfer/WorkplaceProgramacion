package propiedades;

import java.util.Objects;

public class Propiedad implements Comparable<Propiedad>{
	
// Variables
	private int codigo;
	private String direccion, descripcion;
	private TipoPropiedad tipoProp;
	private int metrosCuadrados;
	private double precio;
	private final int GASTOS_GESTION = 150;
	private final double PORCENTAJE_BENEFICIO = 0.0075;
	
// Getters y Setters
	public int getCodigo() {return codigo;}
	public String getDireccion() {return direccion;}
	public String getDescripcion() {return descripcion;}
	public TipoPropiedad getTipoProp() {return tipoProp;}
	public int getMetrosCuadrados() {return metrosCuadrados;}
	public double getPrecio() {return precio;}
	
	public void setCodigo(int codigo) {this.codigo = codigo;}
	public void setDireccion(String direccion) {this.direccion = direccion;}
	public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
	public void setTipoProp(TipoPropiedad tipoProp) {this.tipoProp = tipoProp;}
	public void setMetrosCuadrados(int metrosCuadrados) {this.metrosCuadrados = metrosCuadrados;}
	public void setPrecio(double precio) {this.precio = precio;}
	

// Constructor
	public Propiedad(int codigo, String direccion, String descripcion, TipoPropiedad tipoProp,
						int metrosCuadrados, double precio) {
		this.codigo = codigo;
		this.direccion = direccion;
		this.descripcion = descripcion;
		this.tipoProp = tipoProp;
		this.metrosCuadrados = metrosCuadrados;
		this.precio = precio;
	}
	
	public double beneficio() {
		return precio * PORCENTAJE_BENEFICIO + GASTOS_GESTION;
	}
	
// toString, hashCode, equals, comparable
	@Override
	public String toString() {
		return this.tipoProp.toString().toUpperCase()
				+ "\n\tBeneficio obtenido: " + this.beneficio() + "€"
				+ "\n\tCódigo: " + this.codigo
				+ "\n\tSuperficie: " + this.metrosCuadrados + " metros cuadrados"
				+ "\n\tDescripción: " + this.descripcion
				+ "\n\tDirección: " + this.direccion
				+ "\n\tPrecio: " + this.precio + " €";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Propiedad other = (Propiedad) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	@Override
	public int compareTo(Propiedad o) {
		return this.codigo - o.codigo;
	}
	
}
