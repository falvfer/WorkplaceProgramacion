package prColecciones;

import java.util.Comparator;

public class PruebaComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.length() - o2.length();
	}

	@Override
	public boolean equals(Object obj) {
		// Define la lógica para determinar si dos comparadores son iguales
		return obj instanceof PruebaComparator;
	}
}
