package prColecciones;

import java.util.ArrayDeque;
import java.util.Deque;

public class EjemploDeque {

	public static void main(String[] args) {
		 // Crear una Deque de cadenas
        Deque<String> deque = new ArrayDeque<>();

        // Añadir elementos al principio y al final
        deque.addFirst("Primero");
        deque.addLast("Segundo");
        deque.addFirst("Nuevo Primero");

        // Eliminar elementos del principio y del final
        String primerElemento = deque.removeFirst();
        String ultimoElemento = deque.removeLast();

        // Mostrar los elementos eliminados
        System.out.println("Primer elemento eliminado: " + primerElemento);
        System.out.println("Último elemento eliminado: " + ultimoElemento);

	}

}
