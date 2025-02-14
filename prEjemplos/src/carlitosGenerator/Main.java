package carlitosGenerator;

import java.util.Random;

public class Main {
	
	private static void cargarPalabras(BucketList<String> bucket) {
		bucket.añadir("vale", 60);
		bucket.añadir("chicos", 30);
		bucket.añadir("programar", 10);
		bucket.añadir("programación", 5);
		bucket.añadir("programación funcional", 15);
		bucket.añadir("empresa", 30);
		bucket.añadir("push", 15);
		bucket.añadir("pop", 15);
		bucket.añadir("commit", 15);
		bucket.añadir("meet", 10);
		bucket.añadir("alligators", 3);
		bucket.añadir("rallarse", 2);
		bucket.añadir("rallar", 2);
		bucket.añadir("rallado", 2);
		bucket.añadir("classroom", 15);
		bucket.añadir("soy el mejor", 25);
		bucket.añadir("tengo muchos amigos", 15);
		bucket.añadir("pila", 30);
		bucket.añadir("comprad el libro", 20);
		bucket.añadir("entornos", 15);
		bucket.añadir("sostenibilidad", 15);
		bucket.añadir("digitalizacion", 15);
		bucket.añadir("sostenible", 10);
		bucket.añadir("digitalizado", 10);
		bucket.añadir("ER Master", 5);
		bucket.añadir("trabajo", 24);
		bucket.añadir("trabajo mucho", 6);
	}
	
	private static void cargarConectores(BucketList<String> bucket) {
		bucket.añadir("Y", 1);
		bucket.añadir("O", 1);
		bucket.añadir("Pero", 1);
		bucket.añadir("Porque", 1);
		bucket.añadir("Aunque", 1);
		bucket.añadir("Así que", 1);
		bucket.añadir("Entonces", 1);
		bucket.añadir("Por lo tanto", 1);
		bucket.añadir("Es decir", 1);
		bucket.añadir("Sin embargo", 1);
		bucket.añadir("Mientras", 1);
		bucket.añadir("Después", 1);
		bucket.añadir("Antes", 1);
		bucket.añadir("En cambio", 1);
		bucket.añadir("Además", 1);
		bucket.añadir("Por otro lado", 1);
		bucket.añadir("De hecho", 1);
		bucket.añadir("Yo", 1);
		bucket.añadir("Tú", 1);
		bucket.añadir("Él", 1);
		bucket.añadir("Ella", 1);
		bucket.añadir("Nosotros", 1);
		bucket.añadir("Nosotras", 1);
		bucket.añadir("Ustedes", 1);
		bucket.añadir("Ellos", 1);
		bucket.añadir("Ellas", 1);
		bucket.añadir("Un", 1);
		bucket.añadir("Una", 1);
		bucket.añadir("El", 1);
		bucket.añadir("La", 1);
		bucket.añadir("Los", 1);
		bucket.añadir("Las", 1);
		bucket.añadir("Aquí", 1);
		bucket.añadir("Allí", 1);
		bucket.añadir("Ahora", 1);
		bucket.añadir("Siempre", 1);
		bucket.añadir("Nunca", 1);
		bucket.añadir("Luego", 1);
		bucket.añadir("Antes", 1);
		bucket.añadir("Todavía", 1);
		bucket.añadir("Ya", 1);
		bucket.añadir("Solo", 1);
	}
	
	private static void cargarPuntuacion(BucketList<String> bucket) {
		bucket.añadir(",", 1);
		bucket.añadir(".", 1);
		bucket.añadir(";", 1);
		bucket.añadir(":", 1);
		bucket.añadir("?", 1);
		bucket.añadir("!", 1);
	}
	
	public static void main(String[] args) {
		Random rdn = new Random();
		int tipoPalabra;
		boolean puntuado = false;
		BucketList<String> palabrasComunes = new BucketList<>();
		cargarPalabras(palabrasComunes);
		
		BucketList<String> conectores = new BucketList<>();
		cargarConectores(conectores);
		
		BucketList<String> puntuacion = new BucketList<>();
		cargarPuntuacion(puntuacion);

		for (int i = 1; i <= 100; i++) {
			tipoPalabra = rdn.nextInt(1, 21);
			
			if (puntuado && tipoPalabra > 17) {
				tipoPalabra = rdn.nextInt(1, 18);
				puntuado = false;
			}
			
			if (tipoPalabra <= 17 && i%5 != 1)
				System.out.print(" ");
			
			if (tipoPalabra <= 12)
				System.out.print(palabrasComunes.elige());
			else if (tipoPalabra <= 17)
				System.out.print(conectores.elige());
			else if (i%5 != 1) {
				System.out.print(puntuacion.elige());
				i--;
				puntuado = true;
			}
			else
				System.out.print(palabrasComunes.elige());

			if (i%5 == 0)
				System.out.println();
		}
		
	}

}
