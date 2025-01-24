package desdeJava8;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Ejemplo5Duration {

	public static void main(String[] args) {
		// ------------------------------------------------------------------------------
		// Calculo de la duraci�n entre dos objetos LocalTime
		// ------------------------------------------------------------------------------
		LocalTime localTime1 = LocalTime.of(12, 25);
		LocalTime localTime2 = LocalTime.of(17, 35);
		Duration duration = Duration.between(localTime1, localTime2);
		System.out.println(duration);  
		   // Mostrar� PT5H10M, que corresponde a 5 horas y 10 minutos

		
		// ------------------------------------------------------------------------------
		// Calculo de la duraci�n entre dos objetos LocalDateTime
		// ------------------------------------------------------------------------------
		LocalDateTime localDateTime1 = LocalDateTime.of(2016, Month.JULY, 18, 14, 13);
		LocalDateTime localDateTime2 = LocalDateTime.of(2016, Month.JULY, 20, 12, 25);
		Duration duration2 = Duration.between(localDateTime1, localDateTime2);
		System.out.println(duration2);
		
		
		// ------------------------------------------------------------------------------
		// Tambi�n, se puede crear una duraci�n basada en el 
		// m�todo of(long amount, TemporalUnit unit). 
		// En el siguiente ejemplo, se muestra como crear un Duration de un d�a.
		// ------------------------------------------------------------------------------
		Duration oneDayDuration = Duration.of(1, ChronoUnit.DAYS);
		System.out.println(oneDayDuration);
				// Se puede apreciar el uso del enum ChronoUnit, la cual es una 
		        // implementaci�n de TemporalUnit y nos brinda una serie de unidades
		        // de per�odos de tiempo como ERAS, MILLENNIA, CENTURIES, DECADES, 
		        // YEARS, MONTHS, WEEKS, etc.
		
		
		// ------------------------------------------------------------------------------
		// Tambi�n, se puede crear Duration basado en los m�todos ofDays(long days), 
		// ofHours(long hours), ofMilis(long milis), ofMinutes(long minutes), 
		// ofNanos(long nanos), ofSeconds(long seconds). El ejemplo anterior puede
		// ser reemplazado por la siguiente l�nea:
		// ------------------------------------------------------------------------------
		Duration oneDayDuration2 = Duration.ofDays(3);
		System.out.println(oneDayDuration2);
	}

}
