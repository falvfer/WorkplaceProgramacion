package modelo;

import java.io.Serializable;

public enum TemporadasEnum implements Serializable {
	BAJA("Baja"), MEDIA("Media"), ALTA("Alta");
	
	private String descripcion;
	
	private TemporadasEnum(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override 
	public String toString() {
		return descripcion;
	}
}
