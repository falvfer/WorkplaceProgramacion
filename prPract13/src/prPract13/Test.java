package prPract13;

import java.util.Scanner;

import librerias.LibreriaFechasJavaTime;

public class Test {
	
	public static byte menu(Scanner sc) {
		System.out.println("Elija una opción:");
		System.out.println("\t1. Añadir un nuevo equipo");
		System.out.println("\t2. Añadir los resultados de un partido");
		System.out.println("\t3. Mostrar la clasificación");
		System.out.println("\t4. Mostrar los partidos jugados en una determinada fecha");
		System.out.println("\t5. Salir");
		try {
			return sc.nextByte();
		} catch (Exception e) {
			return -1;
		}
	}
	
	
	
	private static void addEquipo(Scanner sc, Clasificacion cl) {
		try {
			System.out.print("Indica el nombre del equipo: ");
			cl.addEquipo(sc.nextLine());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void addPartido(Scanner sc, Clasificacion cl) {
		Equipo anfitrion, visitante;
		String puntuacion, fecha;
		boolean hecho = false;
		
		for (int i = 1; i <= 5 && !hecho; i++)
		try {
			
			System.out.print("Indica el nombre del equipo anfitrión: ");
			anfitrion = cl.buscarEquipo(sc.nextLine());
			if (anfitrion == null)
				throw new Exception("Error: El equipo no existe");
			System.out.print("Indica el nombre del equipo visitante: ");
			visitante = cl.buscarEquipo(sc.nextLine());
			if (visitante == null)
				throw new Exception("Error: El equipo no existe");
			System.out.print("Indica la puntuación (con el formato \"0-2\"): ");
			puntuacion = sc.nextLine();
			System.out.print("Indica la fecha en formato \"DD/MM/YYYY\" (si no es válida se pondrá la de hoy): ");
			fecha = sc.nextLine();
			cl.addPartido(new Partido(anfitrion, visitante, fecha, puntuacion));
			
			if (LibreriaFechasJavaTime.isFechaCorrecta(fecha))
				System.out.println("Se ha añadido correctamente.");
			else
				System.out.println("Se ha añadido el partido correctamente con la fecha de hoy.");
			
			hecho = true;
			
		} catch (Exception e) {
			if (e.getMessage() == null)
				System.out.println("Error, vuelva a intentarlo.");
			else
				System.out.println(e.getMessage());
		}
	}
	
	private static void getClasificacion(Clasificacion cl) {
		System.out.println(cl);
	}
	
	private static void getPartidosFecha(Scanner sc, Clasificacion cl) {
		System.out.print("Indica la fecha en formato \"DD/MM/YYYY\" (si no es válida se pondrá la de hoy): ");
		System.out.println(cl.partidosEnFecha(sc.nextLine()));
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean terminar = false;
		byte opcion;
		Clasificacion cl = new Clasificacion();
		
		do {
			opcion = menu(sc);
			sc.nextLine();
			
			if (opcion<1 || opcion>5)
				System.out.println("Error: Opción no válida, vuelva a intentarlo.");
			else {
				
				switch (opcion) {
				case 1 -> addEquipo(sc, cl);
				case 2 -> addPartido(sc, cl);
				case 3 -> getClasificacion(cl);
				case 4 -> getPartidosFecha(sc, cl);
				case 5 -> terminar = true;
				}
				
			}
			
		} while(!terminar);
		
	}

}
