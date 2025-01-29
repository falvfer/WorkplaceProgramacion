package ejer01_Popurri;

import java.util.*;

public class ComparatorInteger implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2.compareTo(o1);
	}

}
