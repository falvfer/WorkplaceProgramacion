package modelo;

public class MiExcepcion extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7204538804220361255L;

	public MiExcepcion() {super();}
	
    public MiExcepcion(String mensaje) {
        super(mensaje);
    }
	
}
