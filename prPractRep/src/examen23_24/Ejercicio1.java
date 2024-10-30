package examen23_24;

/* 
 * Apuntes para el ejercicio:
 * 
 *  Generar 3 numeros entre 1 y 1000: 237 381 12 (por ejemplo)
 *  
 *  Comprobar que sea par par impar (num1%2==0, num2%2==0, num3%2==1)
 *  Sumar a cont++;
 *  Repetir hasta que se de el caso.
 *  
 *  Mostrar todos los intentos y el numero total de intentos.
 */
public class Ejercicio1 {

	public static void main(String[] args) {

		int num1, num2, num3, cont=0;
		boolean salir = false;
		
		do {
			num1 = (int)(Math.random()*1000+1);
			num2 = (int)(Math.random()*1000+1);
			num3 = (int)(Math.random()*1000+1);

			cont++;
			
			System.out.println("Intento "+cont+": "+num1+", "+num2+" y "+num3);
			
			if (num1%2==0 && num2%2==0 && num3%2==1)
				salir = true;
			
		} while (salir == false);
		
		System.out.println("Se han realizado "+cont+" intentos hasta obtener par, par, impar");
	}

}
