package enumeraciones;

import java.util.Arrays;

public class TestEnumColor2 {

	public static void main(String[] args) {
		
		// Llamando a values()
		Color[] arr = Color.values();
		
		System.out.println(Arrays.toString(arr));
		
		// enum con bucle
		for (Color col : arr) 	{
			// Llamando a ordinal() para encontrar el indice de color.
			System.out.println(col + " en el indice " + col.ordinal());
		}
		
		System.out.println(Color.ROSA.ordinal());
		
		// Usando valueOf(). Devuelve un objeto de Color con la constante dada.
		// La segunda linea comentada causa la excepcion
		// IllegalArgumentException
		System.out.println(Color.valueOf("ROJO"));
		
		Color colorFavorito = Color.valueOf("AZUL");
		System.out.println(colorFavorito);
		
		 System.out.println(Color.valueOf("BLANCA"));
	}

}
