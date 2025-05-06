package test;

import java.util.ArrayList;
import java.util.List;

import modelo.BilleteTren;
import modelo.BilleteTrenFamiliar;
import modelo.EnumDescuentos;
import modelo.Punto;

public class Test {

	public static void main(String[] args) {
		List<BilleteTren> billetes = new ArrayList<>();
		billetes.add(new BilleteTren(new Punto(), new Punto(30, 13), EnumDescuentos.MENOR_7));
		billetes.add(new BilleteTren(new Punto(), new Punto(20, 10), EnumDescuentos.MENOR_18));
		billetes.add(new BilleteTrenFamiliar(new Punto(100,100), new Punto(200,200), EnumDescuentos.UNIVERSITARIO, "Juanito"));
		billetes.add(new BilleteTren(new Punto(), new Punto(-23, 5), EnumDescuentos.UNIVERSITARIO));
		
		for (BilleteTren b: billetes) {
			System.out.println(b);
		}
	}
}
