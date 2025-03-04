package ejer2;

public enum EnumPlus {
	
	ACTIVIDAD(50),
	ASISTENCIA(30),
	FLEXIBILIDAD(60), 
	BENEFICIOS_EXTRAS(100),
	FORMACION(80),
	RESIDENCIA(200),
	TRABAJO_FIN_DE_SEMANA(250),
	NOCTURNIDAD(100);

// Variable
	private int importe;
	
// Getter
	public int getImporte() {return this.importe;}
	
// Constructor
	private EnumPlus(int importe) {
		this.importe = importe;
	}
}
