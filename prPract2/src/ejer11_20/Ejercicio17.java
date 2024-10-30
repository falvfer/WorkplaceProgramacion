package ejer11_20;

public class Ejercicio17 {

	public static void main(String[] args) {
		// ¿Cuál es el valor de la variable booleana test después de la ejecución de los siguientes bucles?
		boolean test;
		int n=0;
		
		// A) El valor final es TRUE
		test = true;
		for (int cont=1; cont<=10; cont++)
			test=!test;
		
		// B) Dependiendo del numero inicial de n: si es impar el valor final es TRUE, si es par es FALSE.
		if ((n%2)==0)
			test=false;
		else
			test=true;
		for (int cont=1; cont<=10; cont++)
			test=!test;

	}

}
