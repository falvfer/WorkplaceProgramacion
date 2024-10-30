package ejer1_10;

public class Ejercicio10 {

	// NOTA: Daba error originalmente (por los "_" en los números) porque estaba en la version de java 1.4.
	//		 Para cambiar esto hay que darle click derecho a "Ejercicio10.java" e ir a "Properties",
	//		 entonces ir a la pestaña "Java Compiler" y activar "Enable project specific settings",
	//		 después cambiar la versión a la deseada (en este caso 22, la más reciente).
	
	public static void main(String[] args) {
		// Cuando se vaya a asignar a una variable de tipo long un valor grande habrá que ponerlo acabado en la
		// letra L, por ejemplo 5000000000L. Esta letra indica que el valor debe ser tomado como long antes de ser
		// asignado a la variable. Si no ponemos esta indicación, el valor numérico se toma como int (por defecto)
		// y el compilador muestra un error indicando que el número es demasiado grande para pertenecer a ese
		// tipo. También se pueden poner guiones bajos _, para facilitar la leyenda del número al escribirlo. Hacer
		// la prueba con el siguiente ejemplo:
		
		int habitantesEnMadrid = 4000000;
		System.out.println(habitantesEnMadrid);
		
		long habitantesEnElMundo = 5000000000L;
		System.out.println(habitantesEnElMundo);
		
		long otroLong = 123_456_789_123_456L; // Se pueden poner _ para clarificar
		System.out.println(otroLong);
	}
}
