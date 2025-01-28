package prColecciones;

import java.util.HashMap;
import java.util.Map;

public class EjemploMap {

	public static void main(String[] args) {
		 // Crear un mapa de estudiantes y sus calificaciones
        Map<String, Integer> notas = new HashMap<>();

        // Añadir pares clave-valor al mapa
        notas.put("Juan", 85);
        notas.put("María", 92);
        notas.put("Pedro", 78);

        // Obtener la calificación de un estudiante
        int notaMaria = notas.get("María");

        // Mostrar la calificación de María
        System.out.println("La nota de María es: " + notaMaria);

        // Eliminar a un estudiante
        notas.remove("Pedro");

        // Mostrar las notas restantes
        System.out.println("Notas restantes: " + notas);

	}

}
