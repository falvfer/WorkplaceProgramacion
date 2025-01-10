package ejer16v2;

import java.util.Scanner;

public class Ejercicio16 {

	/*
	 * Utilizar una matriz de 4 x 10 elementos para representar una baraja con
	 * cuatro palos que contenga cada uno las cartas del 1 al 7 y la Sota, el
	 * Caballo y el Rey. Utilizando dicha matriz implementar el juego de las 7 y
	 * media con dos jugadores (usuario y ordenador como banca).
	 */

	private static void sleep(int milliseconds) {
		System.out.println();
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
		}
	}

	public static boolean turnoJugador(Scanner sc) {

		// Sacar primera carta y pedir apuesta
		totalJugador += baraja.sacaCarta();
		System.out.println("Carta sacada: " + baraja.getUltimaCartaSacada());
		sleep(400);
		pedirApuesta(sc);

		// Bucle hasta que el jugador se planta o se pasa de 7.5
		while (totalJugador <= 7.5f && !plantar(sc)) {
			sleep(400);
			totalJugador += baraja.sacaCarta();
			System.out.println("Carta sacada: " + baraja.getUltimaCartaSacada());
			System.out.println("Valor total de su mano de cartas: " + totalJugador);
			sleep(400);
		}

		return totalJugador <= 7.5f;
	}

	public static void turnoCPU() {
		// Sacar primera carta
		totalCPU += baraja.sacaCarta();
		System.out.println("Carta sacada: " + baraja.getUltimaCartaSacada());
		sleep(800);

		// La CPU procede a decidir si plantarse o seguir sacando cartas en base a su
		// dificultad
		if (dificultad == 1) { // Dificultad normal
			while (totalCPU < 5f) {
				totalCPU += baraja.sacaCarta();
				System.out.println("Carta sacada: " + baraja.getUltimaCartaSacada());
				System.out.println("Valor total actual de la CPU: " + totalCPU);
				sleep(1600);
			}
		} else { // Dificultad dificil
			float cartaSacada = baraja.sacaCarta();
			while (totalCPU + cartaSacada <= 7.5f) {
				totalCPU += cartaSacada;
				System.out.println("Carta sacada: " + baraja.getUltimaCartaSacada());
				cartaSacada = baraja.sacaCarta();
				System.out.println("Valor total actual de la CPU: " + totalCPU);
				sleep(1600);
			}
		}
	}

	public static boolean plantar(Scanner sc) {
		System.out.print("Desea plantarse? [N/s]: ");
		return (Character.toUpperCase(sc.nextLine().charAt(0)) == 'S');
	}

	public static void pedirApuesta(Scanner sc) {
		System.out.println("Sueldo total: " + sueldo);
		System.out.print("Escriba su apuesta: ");
		apuesta = sc.nextInt();
		sc.nextLine();

		while (apuesta > sueldo || apuesta <= 0) {
			sleep(400);
			System.out.println("Apuesta no válida, no puedes apostar más dinero del que tienes, ni dinero negativo, ni no apostar.");
			sleep(800);
			System.out.print("Escriba su apuesta: ");
			apuesta = sc.nextInt();
			sc.nextLine();
		}
	}

	public static void actualizarEstadisticas(int accionPartida) {
		turnosJugados++;

		if (accionPartida == 1) {
			System.out.println("¡Felicidades! Has ganado la apuesta, has duplicado el dinero apostado.");
			sueldo += apuesta;
			dineroGanado += apuesta;
		} else if (accionPartida == 2) {
			System.out.println("Has perdido la apuesta junto al dinero apostado.");
			sueldo -= apuesta;
			dineroPerdido += apuesta;
		} else {
			System.out.println("Empate, se te ha devuelto el dinero apostado.");
		}

		sleep(800);
	}

	public static void reiniciar() {
		baraja.barajar();
		totalCPU = 0;
		totalJugador = 0;
		apuesta = 0;
		sleep(800);
	}

	public static void mostrarEstadisticas() {
		sleep(800);
		System.out.println("Estadísticas de la partida: ");
		System.out.println("\tDificultad de la CPU: " + (dificultad == 1 ? "Normal" : "Difícil"));
		System.out.println("\tSueldo inicial: " + sueldoBase + "€");
		System.out.println("\tSueldo final: " + (sueldo <= 0 ? "Banca rota" : sueldo + "€"));
		System.out.println("\tTurnos jugados: " + turnosJugados);
		System.out.println("\tDinero ganado: " + dineroGanado + "€");
		System.out.println("\tDinero perdido: " + dineroPerdido + "€");
	}

	public static void main(String[] args) {
		Baraja7YMedio baraja = new Baraja7YMedio();
		boolean terminarPartida = false;
		int turnosJugados = 0, dineroPerdido, dineroGanado;
		final int sueldoBase = 100;
		Scanner sc = new Scanner(System.in);
		
		// Inscribir al jugador
		System.out.print("Escriba su nombre: ");
		Jugador jugador = new Jugador(sc.nextLine());

		// Elegir la dificultad que desea el jugador e inscribir a la CPU
		System.out.println("Cual dificultad de CPU prefiere?");
		System.out.println("1. Normal");
		System.out.println("2. Dificil");
		JugadorCPU cpu = new JugadorCPU(sc.nextByte());

		while (cpu.getDificultad() != 1 && cpu.getDificultad() != 2) {
			System.out.print("Dificultad no válida, vuelve a elegir una: ");
			cpu.setDificultad(sc.nextByte());
		}

		sleep(800);

		do {
			System.out.println("-------------------------------------- TURNO " + (turnosJugados + 1) + " ----------");
			
			// Turno del jugador
			System.out.println("----- TURNO DE " + jugador.getNombre().toUpperCase() + " -----");
			
			
			
			
			
			turnosJugados++;
		} while (!terminarPartida && jugador.getSueldo() > 0);

		mostrarEstadisticas();
	}

}
