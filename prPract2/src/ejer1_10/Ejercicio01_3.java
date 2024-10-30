package ejer1_10;

public class Ejercicio01_3 {

	public static void main(String[] args) {
		// Crear variables para evitar errores de Java
		int numero=0;
		boolean x=false;
		boolean b=false;
		byte edad=0;
		// Usar la variable "x" para evitar el aviso de que no se usa
		System.out.println(x);
		
		
		// 1. ¿Cómo se podría mejorar el siguiente fragmento de algoritmo?
			// si (numero > 0) entonces
			//     escribe(“Hola”)
			//     numero = numero + 1
			// si-no
			//     escribe(“Hola”)
			//     numero = numero - 1
			// fin-si
		System.out.println("Hola");
		numero = numero > 0 ? numero + 1 : numero - 1;
		
		// Otra forma de hacer la comparacion
		if (numero > 0)
			numero = numero + 1;
		else
			numero = numero - 1;

		
		// 2. ¿Cómo se podría mejorar el siguiente fragmento de algoritmo?
			// si b entonces
			//     x = verdadero
			// si-no
			//     x = falso
			// fin-si
		x=b;
		
		
		// 3. Simplificar el siguiente segmento de algoritmo de forma que
		//	  se necesiten menos comparaciones:
			// si (edad >=65) entonces
			//     escribir(“Jubilado”)
			// si-no
			//     si (edad < 18) entonces
			//         escribir(“Menor de edad”)
			//     si-no
			//         si ((edad >= 18) Y (edad < 65)) entonces
			//             escribir(“Activo”)
			//         fin-si
			//     fin-si
			// fin-si
		if ((edad>120) || (edad<1))
			System.out.println("Error: Edad no válida");
		else if (edad >= 65)
			System.out.println("Jubilado");
		else if (edad < 18)
			System.out.println("Menor de edad");
		else
			System.out.println("Activo");
		
			// Otra forma de hacer el 3 sin la comprobacion de fallo
		System.out.println(edad>=65?"Jubilado":edad<18?"Menor de edad":"Activo");
		
		
		// FIN DE CÓDIGO
	}
}
