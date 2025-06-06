package modelo;

public enum SeccionExpediente {
	GOBIERNO("Gobierno"),
	ADMINISTRACION("Administración"),
	SERVICIOS("Servicios"),
	HACIENDA("Hacienda");
	
	private String nombre;
	
	private SeccionExpediente(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}
