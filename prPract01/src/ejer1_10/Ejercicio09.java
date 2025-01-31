package ejer1_10;

public class Ejercicio09 {

	public static void main(String[] args) {
		// Observar el siguiente programa, que guarda en dos variables de tipo byte,
		// las edades de dos personas, y en otras dos de tipo short su sueldo base.

		// a) ¿Por qué aparecen warnings?
			// Es porque las variables edadJuan, edadPedro y complementos no se han usado.
	
		// b) Probar a cambiar los valores de inicialización, de forma que se pase del rango permitido,
		//    ¿qué ocurre?
			// Te da un error, ya que no puede convertir el número de int a byte o short,
			// esto se debe a que sobrepasa su límite.
	
		// c) Modificar el programa para que muestre por pantalla un mensaje similar al siguiente:
		//    El sueldo real del empleado de XX años es: XXXX euros.
		//    El sueldo real del empleado de XX años es: XXXX euros.
		//       Sabiendo que el sueldo real se obtiene de sumar al sueldo base los complementos,
		//       y 30 euros si su edad es inferior a 25, 60 euros si su edad es inferior a 35,
		//       y 100 euros si su edad es inferior o igual a 65, y después deducirle un 15% de IRPF
		//       y un 9% de Seguridad Social.
		
		// Variables por defecto del ejercicio
		byte edadJuan = 20;
		byte edadPedro = 42;
		short sueldoBase = 1980;
		short complementos = 400;
		
		// Variables añadidas para los calculos del sueldo
		double sueldo = 0;
		
		// Constantes de IRPF y Seguridad Social
		final int irpf = 15;
		final int ss = 9;
		
		// Calculos del sueldo en bruto de Juan en base a su edad
		sueldo=sueldoBase+complementos+(edadJuan<25?30:edadJuan<35?60:edadJuan<=65?100:0);
		// Calculos del sueldo final de Juan, añadiendo los impuestos
		sueldo=sueldo-sueldo*(irpf+ss)/100;
		
		// Mostrar por pantalla el sueldo final de Juan
		System.out.println("El sueldo real del empleado de "+edadJuan+" años es: "+sueldo+"€");
		
		// Calculos del sueldo en bruto de Pedro en base a su edad
		sueldo=sueldoBase+complementos+(edadPedro<25?30:edadPedro<35?60:edadPedro<=65?100:0);
		// Calculos del sueldo final de Pedro, añadiendo los impuestos
		sueldo=sueldo-sueldo*(irpf+ss)/100;
		
		// Mostrar por pantalla el sueldo final de Pedro
		System.out.println("El sueldo real del empleado de "+edadPedro+" años es: "+sueldo+"€");
		
	}
}
