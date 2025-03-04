package ejer2;

public enum EnumCategoria {
	
// Enumeración
	PROGRAMADOR_JUNIOR(1500), 
	PROGRAMADOR_SENIOR(2000),
	JEFE_DE_EQUIPO(2500),
	ANALISTA(2800),
	JEFE_DE_PROYECTO(3500);
	
// Variable
	private int salario;
	
// Getter
	public int getSalario() {return this.salario;}
	
// Constructor
	private EnumCategoria(int salario) {
		this.salario = salario;
	}

}
