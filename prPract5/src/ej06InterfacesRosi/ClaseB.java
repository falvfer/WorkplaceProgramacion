package ej06InterfacesRosi;


public class ClaseB extends ClaseA implements InterfazA {

	// Definición del método de la InterfazA
	@Override
	public void metodoInterfazA() {
		System.out.println("Esta es la definición del métodoInterfazA, en la clase B");
	}
	
	// Método propio de la ClaseB
	public void metodoClaseB() {
		System.out.println("Este metodo es de la claseB");
	}




}
