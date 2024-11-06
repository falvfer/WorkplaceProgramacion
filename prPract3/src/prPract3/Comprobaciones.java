package prPract3;

/**
 * Clase para testear el método que calcula el factorial de un número
 * 
 * @author Francisco Jesús Álvarez Fernández
 */
public class Comprobaciones {

	public static void main(String[] args) {
		
		int num1 = 284, num2 = 220;
		
		System.out.println("COMPROBAR PRIMO _____________________________________________________________________________");
		if (MiLibreria.isPrimo(num1))
			System.out.println(num1+" es primo");
		else
			System.out.println(num1+" no es primo");
		System.out.println();
		
		System.out.println("FACTORIAL DE UN NÚMERO ______________________________________________________________________");
		long fact = MiLibreria.factorial(num1);
		if (fact == -1)
			System.out.println("No se puede hacer el factorial de "+num1);
		else if (fact == -2)
			System.out.println("Es un número muy grande para el factorial, prueba con otro más pequeño.");
		else
			System.out.println("El factorial de "+num1+" es igual a: "+fact);
		System.out.println();
		
		System.out.println("COMBINATORIO DE DOS NÚMEROS _________________________________________________________________");
		float comb = MiLibreria.combinatorio(num1, num2);
		if (comb == -1)
			System.out.println("No se puede hacer el combinatorio de "+num1+" y "+num2+" porque uno de los números es negativo.");
		else if (comb == -2)
			System.out.println("Algun número es demasiado grande para el combinatorio, especifica números más pequeños.");
		else
			System.out.println("El combinatorio de "+num1+" y "+num2+" es igual a: "+comb);
		System.out.println();
		
		System.out.println("COMPROBAR SI UN NÚMERO ES PERFECTO __________________________________________________________");
		if (MiLibreria.isPerfecto(num1))
			System.out.println(num1+" es un número perfecto.");
		else
			System.out.println(num1+" no es un número perfecto.");
		System.out.println();
		
		System.out.println("COMPROBAR SI DOS NÚMEROS SON AMIGOS _________________________________________________________");
		if (MiLibreria.isAmigo(num1,num2))
			System.out.println(num1+" y "+num2+" son números amigos.");
		else
			System.out.println(num1+" y "+num2+" no son números amigos.");
		System.out.println();
		
		System.out.println(" _____________________________________________________________________________");
		System.out.println();
		
		System.out.println(" _____________________________________________________________________________");
		System.out.println();

	}

}
