package ejer1_10;

import java.util.Scanner;

public class Ejercicio07 {

	public static void main(String[] args) {
		// Un agricultor que se dedica al cultivo ecológico de naranjas y limones,
		// quiere calcular los beneficios que obtiene anualmente por la venta de los mismos.
		// Por este motivo vamos a diseñar una aplicación que solicite las ventas (en kilos)
		// de cada semestre para cada fruta. La aplicación mostrará el importe total sabiendo
		// que el precio del kilo de naranjas está fijado en 1.25€ y el kilo de limones en 1.90€
		
		// Crear Scanner, y las variables iniciandolas.
			// He elegido short ya que pienso que no va a introducir decimales en los kilos,
			// ya que un agricultor vende muchos kilos, es prácticamente lo mismo 200 kilos que 200.2 kilos.
			// En el caso que se quiera especificar los decimales se pone double o float en lugar de short.
			// Si se venden más de 32 toneladas en el semestre entonces se tiene que cambiar el tipo a int.
		Scanner sc = new Scanner(System.in);
		short ventasN=0;
		short ventasL=0;
		
		// Pedir los kilos al usuario.
		System.out.print("Especifique cuantos kilos de Naranjas se ha vendido en el semestre (sin decimales): ");
		ventasN=sc.nextShort();
		System.out.print("Especifique cuantos kilos de Limones se ha vendido en el semestre (sin decimales): ");
		ventasL=sc.nextShort();
		
		// Mostrar por pantalla las ventas totales.
		System.out.println("El importe total es de: "+(ventasN*1.25+ventasL*1.9)+"€");
		System.out.println("El total de solamente Naranjas: "+(ventasN*1.25)+"€");
		System.out.println("El total de solamente Limones: "+(ventasL*1.9)+"€");
		
		// Cerrar el objeto Scanner
		sc.close();
	}
}
