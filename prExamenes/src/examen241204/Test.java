package examen241204;

public class Test {
	
	private static void divisor(String testClase) {
		System.out.println("\n---------------------------------------------------------------------------");
		System.out.println(testClase);
		System.out.println("---------------------------------------------------------------------------\n");
	}
	
	public static void main(String[] args) {
		
		divisor("TEST CLASE UtilidadesVehiculos");
		
		System.out.println("2km = " + UtilidadesVehiculos.kmAMillas(2) + " millas"
							+ "\n" + "2 millas = " + UtilidadesVehiculos.millasAKm(2) + "km"
							+ "\n" + "Coste de combustible consumido, 30 kilometros, 0.5L/km, 3.2€/L = "
								   + UtilidadesVehiculos.costeCombustible(30, 0.5, 3.2) + "€");
		
		divisor("TEST CLASE Cliente");
		
		Cliente c1 = new Cliente("Juan Pérez", "12345678A", 600123456);
		Cliente c2 = new Cliente("María López", "87654321B");
		Cliente c3 = new Cliente("Manuel García", "222333444X", 604987654);
		
		c3.setVip(true);
		
		System.out.println(c1 + "\n" + c2 + "\n" + c3);
		
		divisor("TEST CLASES Vehiculo, Turismo y Furgoneta");
		
		Turismo v1 = new Turismo("ABC1234", "Hyundai Tucson", (byte)5, 50f, 0.2, "SUV", true);
		Turismo v2 = new Turismo("DEF5678", "Ford Focus", (byte)7, 70f, 0.3, "Compacto", false);
		Furgoneta v3 = new Furgoneta("XYZ5678", "Renault Kangoo", (byte)3, 60f, 0.4, 6.0);
		
		System.out.println(v1 + "\n" + v2 + "\n" + v3 + "\n");
		
		System.out.println("CONSUMO A LOS 100 KM, PRECIO 5€/L: "
				+ "\n\tVehiculo 1 (0.2L/Km): " + v1.consumo100Km(5)
				+ "\n\tVehiculo 2 (0.3L/Km): " + v2.consumo100Km(5)
				+ "\n\tVehiculo 3 (0.4L/Km): " + v3.consumo100Km(5));
		
		divisor("TEST CLASE Reserva");
		
		Reserva r1 = new Reserva(c1, v1, (byte)3, true);
		Reserva r2 = new Reserva(c2, v3, (byte)2, false);
		Reserva r3 = new Reserva(c3, v3, (byte)2, false);
		
		System.out.println("--------- toSring ---------"
							+ "\n" + r1 + "\n" + r2 + "\n" + r3 + "\n");
		System.out.println("--------- toSringDetallado ---------"
							+ "\n" + r1.toStringDetallado() + "\n\n" + r2.toStringDetallado() + "\n\n" + r3.toStringDetallado());
		
	}
}
