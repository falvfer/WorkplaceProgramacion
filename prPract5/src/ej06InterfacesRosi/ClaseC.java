package ej06InterfacesRosi;


public class ClaseC extends ClaseB implements InterfazD{

	/**
	 * Métodos redefinidos de la InterfazB
	 */
	public void metodoInterfazB1() {
		System.out.println("Redefinición del método de la interfazB-1");
	}

	public void metodoInterfazB2() {
		System.out.println("Redefinición del método de la interfazB-21");
	}

	/**
	 * Métodos redefinidos de la InterfazC
	 */
	public void metodoInterfazC() {
		System.out.println("Redefinición del método de la interfazC");
	}

	/**
	 * M�todos redefinidos de la InterfazD
	 */
	public void metodoInterfazD() {
		System.out.println("Redefinición del método de la interfazD");
	}

	/**
	 * Método propio de esta clase
	 */
	public void metodoClaseC()
	{
		System.out.println("Método de la clase C");
	}
	
}
