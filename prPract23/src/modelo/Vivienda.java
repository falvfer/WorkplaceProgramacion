package modelo;

public class Vivienda extends Propiedad {
	
// Variables
	private TipoVivienda tipoViv;
	private int bannos, dormitorios;
	private final double PORCENTAJE_BENEFICIO_EXTRA = 0.0025;
	
// Getters y Setters
	public TipoVivienda getTipoViv() {return tipoViv;}
	public int getBannos() {return bannos;}
	public int getDormitorios() {return dormitorios;}

	public void setTipoViv(TipoVivienda tipoViv) {this.tipoViv = tipoViv;}
	public void setBannos(int bannos) {this.bannos = bannos;}
	public void setDormitorios(int dormitorios) {this.dormitorios = dormitorios;}

// Constructores
	public Vivienda(int codigo, String direccion, String descripcion,
						int metrosCuadrados, double precio, TipoVivienda tipoViv, int bannos,
						int dormitorios) {
		super(codigo, direccion, descripcion,  TipoPropiedad.VIVIENDA, metrosCuadrados, precio);
		this.tipoViv = tipoViv;
		this.bannos = bannos;
		this.dormitorios = dormitorios;
	}

// Métodos
	@Override
	public double beneficio() {
		return super.beneficio() + this.getPrecio() * PORCENTAJE_BENEFICIO_EXTRA;
	}

// toString
	@Override
	public String toString() {
		return super.toString()
				+ "\n\tTipo de vivienda: " + this.tipoViv
				+ "\n\tBaños: " + this.bannos
				+ "\n\tDormitorios: " + this.dormitorios;
	}
}
