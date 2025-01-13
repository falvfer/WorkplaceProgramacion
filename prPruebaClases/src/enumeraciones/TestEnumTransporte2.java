package enumeraciones;

public class TestEnumTransporte2 {
	public static void main(String[] args) {
		
		//Mostrar la velocidad de un avi�n
		System.out.println("La velocidad tipica para un avion es: "
				+ Transporte2.AVION.getVelocidad()+ " millas por hora.\n");
		
		//Mostrar todas las velocidades y transportes
		System.out.println("Todas las velocidades de transporte: ");
		for (Transporte2 tra:Transporte2.values())
			System.out.println("\t"+tra+ ": velocidad t�pica es "
					+tra.getVelocidad()+" millas por hora.");
	}
}
