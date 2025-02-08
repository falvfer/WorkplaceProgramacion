package mis_programas;

import librerias.LibreriaFechasJavaTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

public class NotionGenerator {
	
	public static LocalDate startingDate = LocalDate.now();
	public static Scanner sc = new Scanner(System.in);
	
	public static String day() {
		String str = "### L" + startingDate.format(DateTimeFormatter.ofPattern("yyMMdd - EEEE"))
		 + "\n\nlll\n\n" + "---";
		
		startingDate = startingDate.plusDays(1);
		
		return str;
	}
	
	public static String week() {
		return "## Week " + startingDate.format(DateTimeFormatter.ofPattern("w"));
	}
	
	public static String month() {
		return "# " + startingDate.format(DateTimeFormatter.ofPattern("MMMM yyy"));
	}
	
	public static void main(String[] args) {
		System.out.print("Say the starting date like this \"31/01/2025\": ");
		String userDate = sc.nextLine();
		if (LibreriaFechasJavaTime.isFechaCorrecta(userDate))
			startingDate = LibreriaFechasJavaTime.convierteStringToLocalDate(userDate);
		
		for (int i = 1; i <= 2; i++) {
			int month = startingDate.getMonthValue();
			
			System.out.println(month() + "\n");
			
			while (startingDate.getMonthValue() == month) {
				
				int week = startingDate.get(WeekFields.of(Locale.getDefault()).weekOfYear());
				
				System.out.println(week() + "\n");
				
				while (startingDate.get(WeekFields.ISO.weekOfYear()) == week && startingDate.getMonthValue() == month) {
					System.out.println(day() + "\n");
				}
				
			}
			
		}
		
	}
}
