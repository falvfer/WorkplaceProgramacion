package prExamen241204;

public class UtilidadesVehiculos {

	private static final double conversion = 1.60934;
	
	public static double kmAMillas(double km) {
		return km / conversion;
	}
	
	public static double millasAKm(double millas) {
		return millas * conversion;
	}
	
	public static float costeCombustible(double kmRecorridos, double consumoLitroPorKm,
									double precioCombustiblePorLitro) {
		return (float) (precioCombustiblePorLitro * consumoLitroPorKm * kmRecorridos);
	}
	
}
