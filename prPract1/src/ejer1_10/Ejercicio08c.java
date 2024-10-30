package ejer1_10;

public class Ejercicio08c {

	public static void main(String[] args) {
		// El siguiente programa convierte los días terrestres en años del planeta Júpiter.
		// Puede que tenga algún error, si ese es el caso, corrígelo y haz que funcione.
		
		// Crea la variable diasTerrestres
		int diasTerrestres;
		
		// Guarda el primer argumento especificado en diasTerrestres
		diasTerrestres = Integer.parseInt(args[0]);
		
		// Imprime por pantalla el número de años de Júpiter
		System.out.println("El número de años de Jupiter sería " + (diasTerrestres)/(365*12.0));
		
		// Este imprime por pantalla lo mismo que antes pero sin decimales,
		// ya que trabaja con "int", así que es muy inexacto.
		System.out.println("El número de años de Jupiter sería " + (diasTerrestres)/(365*12));

	}

}
