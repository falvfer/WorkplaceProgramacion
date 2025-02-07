package prColecciones;

import java.util.ArrayList;
import java.util.List;

public class EjemploList {

	public static void main(String[] args) {
	       // Crear una lista de números
        List<Integer> numeros = new ArrayList<>();

        // Añadir elementos a la lista
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        
        numeros.forEach(System.out::println);
        

        // Acceder a un elemento por su índice
        int segundoElemento = numeros.get(1); // Retorna 20

        // Mostrar el segundo elemento
        System.out.println("Segundo elemento: " + segundoElemento);

        // Eliminar un elemento por su índice
        numeros.remove(0); // Elimina el primer elemento

        // Mostrar los elementos restantes en la lista
        System.out.println("Elementos restantes: " + numeros);

	}

}
