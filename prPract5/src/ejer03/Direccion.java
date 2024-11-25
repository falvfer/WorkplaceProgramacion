package ejer03;

public class Direccion {
	
// Variables de instancia
	private String nomCalle;
	private int numero;
	private String codPostal;
	
// Constructores
	public Direccion(String nomCalle, int numero, String codPostal) {
		this.nomCalle = nomCalle;
		this.numero = numero;
		this.codPostal = codPostal;
	}
	
// toString
	@Override
	public String toString() {
		return this.nomCalle + ", " + this.numero + ", " + this.codPostal;
	}
	
// Getters
	public String getNomCalle() {return nomCalle;}
	public int getNumero() {return numero;}
	public String getCodPostal() {return codPostal;}

// Setters
	public void setNomCalle(String nomCalle) {this.nomCalle = nomCalle;}
	public void setNumero(int numero) {this.numero = numero;}
	public void setCodPostal(String codPostal) {this.codPostal = codPostal;}
	
	
}
