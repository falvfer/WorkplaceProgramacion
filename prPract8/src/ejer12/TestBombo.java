package ejer12;

public class TestBombo {

	public static void main(String[] args) {
		
		Bombo bombo = new Bombo(100);
		Carton cJug = new Carton(bombo.getNumBolas());
		Carton cCPU = new Carton(bombo.getNumBolas());
		int bola;
		
		System.out.print("Bolas extraidas: ");
		do {
			bola = bombo.extraeBola();
			cJug.compruebaNumero(bola);
			cCPU.compruebaNumero(bola);
			System.out.print(bola + " ");
		} while (cJug.quedanNumeros() && cCPU.quedanNumeros());
		
		System.out.println();
		
		if (cJug.quedanNumeros())
			System.out.println("Gana la CPU");
		else
			System.out.println("Gana el jugador");
		
	}
}
