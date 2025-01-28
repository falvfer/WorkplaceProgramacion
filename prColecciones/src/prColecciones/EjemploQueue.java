package prColecciones;

import java.util.LinkedList;
import java.util.Queue;

public class EjemploQueue {

	public static void main(String[] args) {
		// Crear una cola de cadenas
        Queue<String> cola = new LinkedList<>();

        // Añadir elementos a la cola
        cola.offer("Primero");
        cola.offer("Segundo");
        cola.offer("Tercero");

        // Obtener el primer elemento y eliminarlo
        String primerElemento = cola.poll();



 // Mostrar el primer elemento
        System.out.println("Primer elemento eliminado: " + primerElemento);

        // Mostrar los elementos restantes en la cola
        System.out.println("Elementos restantes en la cola: " + cola);
	}

}
