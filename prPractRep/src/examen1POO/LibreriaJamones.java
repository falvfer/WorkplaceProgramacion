package examen1POO;

public class LibreriaJamones {

	private static final double conversion = 11.339;
	
	public static String desglosar(float cantidad) {
		int euros = (int)cantidad, centimos = (int)(cantidad * 100) - euros * 100;
		return (euros>0?euros + " euros": "") + (centimos>0? " y " + centimos + " céntimos": "");
	}

	public static double aKilos(double arrobas) {
		return arrobas*conversion;
	}

	public static double aArrobas(double kilos) {
		return kilos/conversion;
	}
	
	public static float aPrecioArroba(float precioKilo) {
		return (float)(precioKilo*conversion);
	}
	
	public static float aPrecioKilo(float precioArroba) {
		return (float)(precioArroba/conversion);
	}
}
