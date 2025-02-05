package propiedades;

public class FincaRustica extends Propiedad {

// Variables
	private TipoTerreno tipoTerr;
	private boolean luz, agua, vivienda;
	private final double PORCENTAJE_BENEFICIO_EXTRA = 0.005;
	
// Getters y Setters
	public TipoTerreno getTipoTerr() {return tipoTerr;}
	public boolean isLuz() {return luz;}
	public boolean isAgua() {return agua;}
	public boolean isVivienda() {return vivienda;}

	public void setTipoTerr(TipoTerreno tipoTerr) {this.tipoTerr = tipoTerr;}
	public void setLuz(boolean luz) {this.luz = luz;}
	public void setAgua(boolean agua) {this.agua = agua;}
	public void setVivienda(boolean vivienda) {this.vivienda = vivienda;}
	
// Constructores
	public FincaRustica(int codigo, String direccion, String descripcion,
							int metrosCuadrados, double precio,	TipoTerreno tipoTerr, boolean luz,
							boolean agua, boolean vivienda) {
		super(codigo, direccion, descripcion, TipoPropiedad.FINCA, metrosCuadrados, precio);
		this.tipoTerr = tipoTerr;
		this.luz = luz;
		this.agua = agua;
		this.vivienda = vivienda;
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
				+ "\n\tTipo de Terreno: " + this.tipoTerr
				+ "\n\t" + (this.luz?"Tiene luz":"No tiene luz")
				+ "\n\t" + (this.agua?"Tiene agua":"No tiene agua")
				+ "\n\t" + (this.vivienda?"Tiene vivienda":"No tiene vivienda");
	}
	
}
