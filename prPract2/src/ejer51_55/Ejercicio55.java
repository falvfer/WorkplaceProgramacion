package ejer51_55;

public class Ejercicio55 {

	public static void main(String[] args) {
		// Supongamos que una importante empresa de electrodomésticos nos contrata para
		//  resolver un problema de logística. El primer caso práctico que nos plantean
		//  es el siguiente:
		//		En las grandes ciudades el precio del suelo es muy caro, por lo que comprar o alquilar grandes
		//		  superficies de almacenamiento de electrodomésticos resulta prohibitivo en el centro de la ciudad.
		//		  La solución es alejarse del casco urbano, sin embargo, cuanto más nos alejamos, más nos cuesta el
		//		  precio de distribución que cada día hay que abonar a los transportistas que nos trasladan los
		//		  electrodomésticos de la periferia al centro (donde se realizan la mayoría de las compras).
		//		La estrategia que adoptaremos es la siguiente:
		//			a. Adquirir un almacén pequeño en el centro de la ciudad (para 200 electrodomésticos,
		//			   por termino medio).
		// 			b. Adquirir almacenes en anillos concéntricos de 5 km a partir del centro de
		// 			   la ciudad; cada almacén podrá contener un stock del doble de
		//			   electrodomésticos que el almacén anterior (es decir, de 400 electrodomésticos
		// 			   a 5 km del núcleo urbano de 800 electrodomésticos a 10 km, ...)
		// 		Se pide, indicar cuantos almacenes necesitaremos especificando a cuántos
		// 		  kilómetros estará cada uno, así como su capacidad, se requiere una capacidad
		// 		  total mínima de 100.000 electrodomésticos en stock. Los 100.000
		// 		  electrodomésticos estarán repartidos entre todos los almacenes adquiridos.
		
		int elecTotal = 0;
		
		for (int km = 0, elec = 200; elecTotal <= 100000; km+=5, elec *= 2) {
			System.out.println("Almacén a "+km+" kilómetros con capacidad para "+elec+" electrónicos.");
			elecTotal+=elec;
		}
		
		System.out.println("La capacidad total de los almacenes es de: "+elecTotal+" electrodomésticos.");
		
	}
}