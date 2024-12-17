package ejer10_Libreria;

public class TestLibrerias {

	public static void main(String[] args) {
		
		LibreriaObjeto vector = new LibreriaObjeto(20);
		try {
			vector.cargarAleatorio(0, 100);
		} catch (Exception e) {}
		
		System.out.println(vector.toString());
		
		vector.ordenarSeleccion();
		
		System.out.println(vector.toString());
		
		int buscar23 = vector.buscarDic(23);
		System.out.println(buscar23==-1?"No se ha encontrado 23": "Está en la posición " + buscar23);
	}
	
}
