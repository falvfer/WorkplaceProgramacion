package ejer02;

import java.util.Random;

/*
 * Hacer un programa para jugar con el ordenador a adivinar un número: el ordenador generará un
 * número entero aleatorio comprendido entre 1 y 100 y nosotros deberemos adivinarlo. Para ello
 * contaremos con un número máximo de 5 intentos. Cada vez que introduzcamos un número el
 * ordenador nos informará si el número introducido es mayor ó menor que el generado, ó si hemos
 * acertado, así como del intervalo actual. El proceso se podrá repetir cuantas veces se quiera. A modo de
 * ejemplo, se muestran los resultados tras dos ejecuciones del programa.
 * 
 * Método MAIN:
 * 	- Variables:
 * 	  - boolean salir = false, terminar = false;
 *  - Crear objeto AdivinarNumero, máximo de 5 intentos
 *  - Bucle while (variable terminar para terminar programa)
 *    - Pedir al usuario que lo adivine
 *    - Bucle while (variable salir para salir)
 *      - Si ha acertado: 
 *        - Felicitar 
 *        - "salir" a true
 *      - No ha acertado:
 *        - Restar un intento
 *        - Comprobar que haya intentos > 0
 *      	- Si no hay:
 *      	  - Decir que ha perdido
 *      	  - "salir" a true
 *      	- Si sí hay:
 *      	  - Ver si el número a adivinar es mayor o menor
 *      	  - Decirle que es mayor o menor y que intente adivinar otra vez
 *    - Preguntar si quiere repetir
 *      - Sí repetir: Generar nuevo número
 *      - No repetir: terminar a true
 * 
 * Clase AdivinarNumero
 *  - Variables:
 *    - int numero
 *    - int rangoMin
 *    - int rangoMax
 *    - int intentos
 *  - Métodos públicos
 *    - boolean adivinarNumero(int)
 *    - boolean quedanIntentos
 *    - String rango ("12..23") 
 */

public class AdivinarNumero {
	
// Variables de instancia
	int intentos, numero, rangoMin, rangoMax;
	
// Variables de clase
	Random rdn = new Random();
	
// Constructores
	public AdivinarNumero (int intentos, int rangoMax, int rangoMin) {
		this.intentos = intentos;
		this.rangoMax = rangoMax;
		this.rangoMin = rangoMin;
		this.numero = rdn.nextInt(rangoMin,rangoMax);
	}
	
	public AdivinarNumero (int intentos, int rangoMax) {
		this(intentos, rangoMax, 1);
	}
	
	public AdivinarNumero (int intentos) {
		this(intentos, 100, 1);
	}
	
// Métodos públicos
	public boolean adivinarNumero(int adivinacion) {
		boolean isNumero = (this.numero == adivinacion);
		
		if (!isNumero)
			if (adivinacion < this.numero)
				this.rangoMin = adivinacion+1;
			else
				this.rangoMax = adivinacion-1;
		
		this.intentos--;
		return isNumero;
	}
	
	public boolean quedanIntentos() {
		return (this.intentos > 0);
	}
	
	public String rango() {
		return "(" + this.rangoMin + ".." + this.rangoMax + ")";
	}
	
	
	
	
	
	
	
	
	
}
