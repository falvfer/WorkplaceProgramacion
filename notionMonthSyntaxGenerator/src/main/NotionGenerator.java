package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

public class NotionGenerator {
	
// Variables
	public static LocalDate startingDate = LocalDate.now();
	public static Scanner sc = new Scanner(System.in);
	
// Métodos
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
	
// MAIN
	public static void main(String[] args) {
		// Preguntar por la fecha inicial
		System.out.print("Say the starting date with a format like this \"31/01/2025\": ");
		String userDate = sc.nextLine();
		if (LibreriaFechasJavaTime.isFechaCorrecta(userDate)) {
			startingDate = LibreriaFechasJavaTime.convierteStringToLocalDate(userDate);
			System.out.println("Correct date.");
		} else
			System.out.println("Date not valid, using current date instead...");
		
		System.out.println();
		
		// Preguntar por la cantidad de meses a generar
		byte monthAmmount = 1;
		try {
			System.out.print("How many months do you want to generate? ");
			monthAmmount = sc.nextByte();
			if (monthAmmount < 0) {
				monthAmmount = 1;
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Ammount not valid, generating only one month...");
		}
		
		System.out.println("\n-------------------------------------------------------------------------");
		if (monthAmmount == 1) {
			System.out.println("Generating the month of "+ startingDate.format(DateTimeFormatter.ofPattern("MMMM")));
		} else {
			System.out.println("Generating " + monthAmmount + " months, from "
					+ startingDate.format(DateTimeFormatter.ofPattern("MMMM"))
					+ " to the end of "
					+ startingDate.plusMonths(monthAmmount-1).format(DateTimeFormatter.ofPattern("MMMM")));
		}
		System.out.println("-------------------------------------------------------------------------\n");
		
		// Generar el texto a copiar para Notion
		for (int i = 1; i <= monthAmmount; i++) {
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
		
		System.out.print("Press Enter to exit... ");
		sc.nextLine();
		sc.nextLine();
		
	}
}
