package ejer11_18;

import java.util.Scanner;

public class Ejercicio16 {

	/*
	 * Utilizar una matriz de 4 x 10 elementos para representar una baraja con
	 * cuatro palos que contenga cada uno las cartas del 1 al 7 y la Sota, el
	 * Caballo y el Rey. Utilizando dicha matriz implementar el juego de las 7 y
	 * media con dos jugadores (usuario y ordenador como banca).
	 */
	
	private static Baraja7YMedio baraja;
	private static boolean terminar;
	private static float totalCPU, totalJugador;
	private static int sueldo, apuesta, turnosJugados, dineroPerdido, dineroGanado;
	private static byte dificultad;
	private final static int sueldoBase = 100;

	static {
		baraja = new Baraja7YMedio();
		terminar = false;
		totalCPU = 0;
		totalJugador = 0;
		sueldo = sueldoBase;
		apuesta = 0;
		turnosJugados = 0;
		dineroPerdido = 0;
		dineroGanado = 0;
		dificultad = 0;
	}

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
		baraja.desordenar();
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
		
		Scanner sc = new Scanner(System.in);
		
		baraja.desordenar();
		byte accionPartida = 0;
		/*
		 * GUIA DE VARIABLE "accionPartida": 0 = Empate entre la CPU y el jugador 1 = Ha
		 * ganado el jugador 2 = Ha perdido el jugador
		 */

		// Elegir la dificultad que desea el jugador
		System.out.println("Cual dificultad de CPU prefiere?");
		System.out.println("1. Normal");
		System.out.println("2. Dificil");
		dificultad = sc.nextByte();

		while (dificultad != 1 && dificultad != 2) {
			System.out.print("Dificultad no válida, vuelve a elegir una: ");
			dificultad = sc.nextByte();
		}

		sleep(800);

		do {
			System.out.println("-------------------------------------- TURNO " + (turnosJugados + 1) + " ----------");
			// Jugar el turno del jugador
			System.out.println("----- TURNO DEL JUGADOR -----");
			if (turnoJugador(sc)) { // Comprobar que el jugador se haya plantado
				sleep(800);
				System.out.println("----- TURNO DE LA CPU -----");
				turnoCPU();
				if (totalCPU <= 7.5f) { // Si Jugador y CPU se han plantado
					System.out.println("La CPU se planta.");
					sleep(800);
					System.out.println("----- RESULTADO -----");
					System.out.println("Valor total del mazo del Jugador: " + totalJugador);
					System.out.println("Valor total del mazo de la CPU: " + totalCPU);
					sleep(400);
					if (totalJugador > totalCPU)
						accionPartida = 1;
					else if (totalJugador == totalCPU)
						accionPartida = 0;
					else
						accionPartida = 2;
				} else { // La CPU se ha pasado de 7.5
					System.out.println("----- RESULTADO -----");
					System.out.print("La CPU se ha pasado de 7 y medio. ");
					accionPartida = 1;
				}
			} else { // El jugador se ha pasado de 7.5
				System.out.println("----- RESULTADO -----");
				System.out.print("Te has pasado de 7 y medio. ");
				accionPartida = 2;
			}

			actualizarEstadisticas(accionPartida);

			if (sueldo > 0) {
				System.out.print("Desea volver a jugar otro turno? [S/n]: ");
				if (Character.toUpperCase(sc.nextLine().charAt(0)) == 'N')
					terminar = true;
				else
					reiniciar();
			}

		} while (!terminar && sueldo > 0);

		mostrarEstadisticas();
	}

}
