package ejer01;

public class Semaforo {
	
	/**
	 * Variables de instancia
	 */
	private String colorSemaforo;
	
	/**
	 * Constructor
	 */
	
	public Semaforo (String color) {
		this.colorSemaforo = color;
	}
	
	public Semaforo () {
		this("Rojo");
	}
	
	/**
	 * Método get, para consultar el valor de la variable
	 */
	public String getColor() {
		return this.colorSemaforo;
	}
	
	/**
	 * Método set, para establecer el valor de la variable
	 */
	public void setColor(String nuevoColor) {
		this.colorSemaforo = nuevoColor;
	}
	
	/**
	 * Método que comprueba si un coche puede pasar o no
	 */
	public boolean puedoPasar() {
		return (this.colorSemaforo.equals("Verde"));
	}

	/**
	 * Redefinición de toString
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase()
				+ "\n\tColor del semaforo: " + colorSemaforo;
	}
	
	
	
}
