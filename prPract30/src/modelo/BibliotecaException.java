package modelo;
/**
* Clase propia de manejo de excepciones
*/
public class BibliotecaException extends Exception {
	
	private static final long serialVersionUID = -6101008773430474914L;
	
	/**
	* Constructor por defecto
	*/
	public BibliotecaException() {super();}
	
	/**
	* Constructor con mensaje personalizado
	* @param msg
	*/
	public BibliotecaException(String msg) {super(msg);}
}
