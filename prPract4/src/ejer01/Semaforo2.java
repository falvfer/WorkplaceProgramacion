package ejer01;

public class Semaforo2 {
	
	/**
	 * Variables de instancia
	 */
	private String colorSemaforo;
	
	/**
	 * Constructor 1, inicializa la variable de instancia con el valor recibido
	 */
	public Semaforo2(String colorSemaforo) {
		this.colorSemaforo = colorSemaforo;
	}
	
	/**
	 * Constructor por defecto, sin parámetros
	 */
	public Semaforo2() {
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
		
		String cadena;
		
		switch (this.colorSemaforo) {
		case "Rojo" -> cadena = "Atención, el semáforo está en Rojo";
		case "Amarillo" -> cadena = "Precaución, el semáforo está apunto de cambiar";
		case "Verde" -> cadena = "Puede pasar, el semáforo está en Verde";
		default -> cadena = "El semáforo está averiado";
		}
		
		return cadena;
	}
	
	/**
	 * Redefinición de equals
	 */
	@Override
	public boolean equals(Object ob) {
		
		Semaforo2 unSemaforo = (Semaforo2) ob; // Nuevo objecto de la clase "Semaforo2" llamado "unSemaforo" pillando el objeto
											   // genérico de entrada y haciendole casting a "Semaforo2"
		if (this.colorSemaforo.equals(unSemaforo.getColor()))
			return true;
		
		return false;
	}
}
