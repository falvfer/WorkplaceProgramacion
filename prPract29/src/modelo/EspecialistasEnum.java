package modelo;

public enum EspecialistasEnum {

	MEDICINA_GENERAL("Medicina general"),
	CARDIOLOGIA("Cardiología"),
	MEDICINA_INTERNA("Medicina interna"),
	NEUMOLOGIA("Neumología"),
	GASTROENTEROLOGIA("Gastroenterología"),
	ENDOCRINOLOGIA("Endocrinología"),
	NEFROLOGIA("Nefrología"),
	HEMATOLOGIA("Hematología"),
	ONCOLOGIA("Oncología"),
	REUMATOLOGIA("Reumatología"),
	NEUROLOGIA("Neurología"),
	TRAUMATOLOGIA("Traumatología");
	
	private String descripcion;
	public String getDescripcion() {return descripcion;}
	
	private EspecialistasEnum(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return descripcion;
	}
	
}
