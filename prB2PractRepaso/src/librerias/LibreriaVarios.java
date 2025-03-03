package librerias;

public class LibreriaVarios {
	
	public static String tabular(int numero, int longitud) {
		String resultado = "";
		
		for (int i = longitud; i > calcularLongitud(numero) % longitud; i--)
			resultado += " ";
		
		return resultado;
	}
	
	public static String tabular(String cadena, int longitud) {
		if (cadena.equals("")) return tabular((int)Math.pow(10, longitud-1), longitud);
		return tabular((int)Math.pow(10, cadena.length()-1), longitud);
	}
	
	public static int calcularLongitud(int numero) {
		int resultado = 1;
		
		while (numero >= 10) {
			numero/=10;
			resultado++;
		}
		
		return resultado;
	}
	
	
	
	
}
