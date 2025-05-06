package modelo;

public enum EnumDescuentos {

	MENOR_7((byte)100, "Menor de 7 años"),
	MENOR_12((byte)50, "Menor de 12 años"),
	MENOR_18((byte)25, "Menor de 18 años"),
	UNIVERSITARIO((byte)40, "Universitario"),
	MAYOR_65((byte)25, "Mayor de 65 años"),
	DESEMPLEADO((byte)10, "Desempleado"),
	NINGUNO((byte)0, "Ningún descuento");
	
	EnumDescuentos(byte porcentaje, String descripcion) {
		this.porcentaje = porcentaje;
		this.descripcion = descripcion;
	}
	
// Variable
	private byte porcentaje;
	private String descripcion;
	
// Getter
	public byte getPorcentaje() {return this.porcentaje;}
	public String getDescripcion() {return this.descripcion;}
	

}
