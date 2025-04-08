package modelo;

public enum TipoPropiedad {
	LOCAL("Local comercial"),
	APARCAMIENTO("Plaza de aparcamiento"),
	VIVIENDA("Vivienda"),
	FINCA("Finca rústica"),
	SOLAR("Solar");
	
	private String nombre;
	
	private TipoPropiedad(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}
