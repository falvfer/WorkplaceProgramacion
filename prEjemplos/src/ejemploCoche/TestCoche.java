package ejemploCoche;

public class TestCoche {
	
	public static void main(String[] args) {
		// Creación de un objeto llamado miCoche de la clase Coche
		Coche miCoche = new Coche("Toyota", "Corolla", 2020, "Rojo");
		
		// Usamos el objeto para acceder a sus métodos
		miCoche.arrancar(); // Imprime: El coche está arrancando.
		miCoche.detener(); // Imprime: El coche se ha detenido.
		
		//También podemos acceder a sus atributos
		System.out.println("Marca: " + miCoche.marca); // Imprime: Marca: Toyota
		System.out.println("Modelo: " + miCoche.modelo); // Imprime: Modelo: Corolla
	}
}