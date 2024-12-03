package examen1POO;

public class Cerdo {
	
// Variables de instancia
	private String numIdentificativo;
	private Granja procedencia;
	private double peso; // En @
	private boolean iberico; // TRUE -> Iberica, FALSE -> Blanca
	private char sexo; // 'M' -> macho, 'H' -> hembra
	private String tipo; // SOLO si es raza==true, en caso contrario se deja en blanco
	
// Getters y Setters
	public String getNumIdentificativo() {return numIdentificativo;}
	public Granja getProcedencia() {return procedencia;}
	public double getPeso() {return peso;}
	public boolean isIberico() {return iberico;}
	public char getSexo() {return sexo;}
	public String getTipo() {return tipo;}
	
	public void setNumIdentificativo(String numIdentificativo) {this.numIdentificativo = numIdentificativo;}
	public void setProcedencia(Granja procedencia) {this.procedencia = procedencia;}
	public void setPeso(double peso) {this.peso = peso;}
	public void setIberico(boolean raza) {this.iberico = raza;}
	public void setSexo(char sexo) {this.sexo = Character.toUpperCase(sexo);}
	public void setTipo(String tipo) {this.tipo = tipo;}
	
// Constructores
	public Cerdo(String numIdentificativo, Granja procedencia, double peso, boolean iberico, String tipo, char sexo) {
		this.numIdentificativo = numIdentificativo;
		this.procedencia = procedencia;
		this.peso = peso;
		this.iberico = iberico;
		this.tipo = tipo;
		this.sexo = sexo;
	}
	
	public Cerdo(String numIdentificativo, Granja procedencia, double peso, boolean iberico, char sexo) {
		this.numIdentificativo = numIdentificativo;
		this.procedencia = procedencia;
		this.peso = peso;
		this.iberico = iberico;
		this.sexo = sexo;
	}
	
// Métodos públicos
	public float precioArroba() { // Precio por arroba
		double procedencia = this.procedencia.getPrecioArroba(),
				SexoYOrigen = (this.sexo == 'h'? 2:0) + (this.procedencia.isTieneOrigen()?7:0),
				iberico = 0;
		if (this.iberico) {
			switch (tipo) {
				case "Cebo" -> iberico = 5;
				case "Cebo campo" -> iberico = 10;
				case "Recebo" -> iberico = 15;
				case "Bellota" -> iberico = 20;
			}
		}
		return (float)(procedencia + SexoYOrigen + iberico);
	}
	
// toString, equals
	@Override
	public String toString() {
		return "Datos " + this.getClass().getSimpleName().toLowerCase() + ":"
				+ "\n\tIdentificación: " + this.numIdentificativo
				+ "\n\tProcedencia: " + this.procedencia
				+ "\n\tPeso: " + this.peso
				+ "\n\tPrecio por arroba: " + this.precioArroba()
				+ "\n\tSexo: " + this.sexo
				+ "\n\tRaza: " + (this.iberico?"Ibérico":"Blanco")
				+ (this.iberico?"\n\tTipo de Ibérico: " + this.tipo:"");
	}
	
	public boolean equals(Object ob) {
		Cerdo other = (Cerdo)ob;
		return this.numIdentificativo.equals(other.numIdentificativo)
			&& this.sexo == other.sexo;
	}
	
}
