package ejer02;

import java.util.Comparator;

public class OrdenInversoCadena implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o2.compareTo(o1);
	}

}
