package pract3_Repaso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Fechas {

	/**
	 * Metodo que transforma una cadena "23/01/2024" a LocalDate.
	 * @param fechaStr
	 * @return LocalDate -> La fecha convertida; null -> Fecha no válida
	 */
	public static LocalDate toDate(String fechaStr) {
		LocalDate fecha;
		
		try {
			fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		} catch (Exception e) {
			return null;
		}
		return fecha;
	}
	
	/**
	 * Metodo para calcular el número de días entre dos fechas.
	 * @param f1 -> Fecha inicial (Más pequeña)
	 * @param f2 -> Fecha final (Más grande)
	 * @return long -> Negativo si f2 es menor que f1, 0 si son iguales, positivo si el resultado es correcto.
	 */
	public static long diasEntre(LocalDate f1, LocalDate f2) {
		return f2.toEpochDay() - f1.toEpochDay();
	}
	
	public static String toString(LocalDate fecha) {
		return fecha.format(DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy", Locale.of("es", "ES")));
	}
	
	public static int edad(LocalDate nacimiento) {
		return (int) ChronoUnit.YEARS.between(nacimiento, LocalDate.now());
	}
	
	public static void main(String[] args) {
		System.out.println("Días entre hoy y el siguiente año nuevo: "
				+ diasEntre(LocalDate.now(),
							toDate("01/01/" + (LocalDate.now().getYear()+1))));
		System.out.println("Hoy: " + toString(LocalDate.now()));
	}
	
}
