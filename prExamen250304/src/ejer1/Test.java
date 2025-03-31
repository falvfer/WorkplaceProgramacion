package ejer1;

public class Test {

	public static void main(String[] args) {
		
		String[] juegos = {"EA Sports FC", "Mario Kart", "Dragon Ball", "Super Mario Bros",
						   "Final Fantasy", "Sonic the Hedgehog", "Minecraft", "Fortnite",
						   "The Legend of Zelda"};
		
		Ventas v = new Ventas(juegos);
		
		System.out.println(v + "\n");
		
		System.out.println(v.toStringVentasJuego() + "\n");
		
		System.out.println(v.toStringVentasPlataforma() + "\n");
		
		System.out.println("Ventas de \"Dragon Ball\" en \"XBOX\": " + v.getVentas("Dragon Ball", "XBOX"));
		System.out.println("Ventas de \"Dragon Ball\" en \"Plataforma.XBOX\": " + v.getVentas("Dragon Ball", Plataforma.XBOX));
		System.out.println("Ventas de \"sgon Ball\" en \"XBOX\": " + v.getVentas("sgon Ball", "XBOX"));
		System.out.println("Ventas de \"Dragon Ball\" en \"SBOX\": " + v.getVentas("Dragon Ball", "SBOX"));
		System.out.println("Ventas de \"sgon Ball\" en \"SBOX\": " + v.getVentas("sgon Ball", "SBOX") + "\n");

		Juego[] top = v.getJuegosMasVendidos(5);
		
		System.out.println("Top 5 juegos más vendidos:");
		for (Juego j: top) {
			System.out.println("\t" + j);
		}
		
		System.out.println();
		top = v.getJuegosMasVendidos(3);
		
		System.out.println("Top 3 juegos más vendidos:");
		for (Juego j: top) {
			System.out.println("\t" + j);
		}
		
	}

}
