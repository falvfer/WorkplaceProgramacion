package ejer18;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio18 {

	public static void main(String[] args) {
		// Preparación --------------------------------------------------------------------------
		Baraja baraja = new Baraja(1);
		baraja.barajar();
		boolean terminarJuego = false, isInicial = true;
		int partidasJugadas = 0, dineroPerdido = 0, dineroGanado = 0, resultadoPartida;
		final int sueldoBase = 100;
		Scanner sc = new Scanner(System.in);
		
		// Inscribir al jugador
		System.out.print("Escriba su nombre: ");
		Jugador jugador = new Jugador(sc.nextLine(), sueldoBase);

		// Elegir la dificultad que desea el jugador e inscribir a la CPU
		System.out.println("Cual dificultad de CPU prefiere?");
		System.out.println("1. Normal");
		System.out.println("2. Dificil");
		JugadorCPU cpu = new JugadorCPU(sc.nextByte());

		// Si no es una dificultad válida: seguir preguntando
		while (cpu.getDificultad() != 1 && cpu.getDificultad() != 2) {
			System.out.print("Dificultad no válida, vuelve a elegir una: ");
			cpu.setDificultad(sc.nextByte());
		}

		sleep(800);

		// Juego del 7 y medio --------------------------------------------------------------------------
		do {
			System.out.println("-------------------------------------- PARTIDA " + (partidasJugadas + 1) + " ----------");
			
			// -------------------------- Turnos de la partida
			while (!(jugador.isPlantado() && cpu.isPlantado())
					&& jugador.getTotalPuntos() <= 7.5f && cpu.getTotalPuntos() <= 7.5f) {

				if (!jugador.isPlantado()) {
					sleep(400);
					turnoJugador(sc, baraja, jugador, isInicial);
				}

				if (!cpu.isPlantado() && jugador.getTotalPuntos() <= 7.5f) {
					sleep(400);
					turnoCPU(baraja, cpu, jugador, isInicial);
				}
				
				isInicial = false;
			}
			// Sumar 1 al contador de partidas
			partidasJugadas++;
			sleep(400);

			// -------------------------- Mostrar los puntos totales y resultado
			System.out.println("----- RESULTADO DE LA PARTIDA " + partidasJugadas + " -----");
			sleep(100);
			System.out.println("Total de puntos de " + jugador.getNombre() + ": " + jugador.getTotalPuntos());
			System.out.println("Total de puntos de " + cpu.getNombre() + ": "
								+ (cpu.getTotalPuntos() - cpu.getPuntosOcultos())
								+ " + " + cpu.getPuntosOcultos()
								+ " = " + cpu.getTotalPuntos());
			sleep(800);
			
			// Devuelve la apuesta en positivo, negativo o "0" en base al resultado de la partida
			resultadoPartida = resultado(jugador, cpu);
			
			// Mostrar el resultado de la partida y actualizar sueldo
			if (resultadoPartida > 0) {
				System.out.println("¡Felicidades, has ganado! Has duplicado tu apuesta de "
									+ jugador.getApuesta() + "€");
				jugador.setSueldo(jugador.getSueldo() + jugador.getApuesta());
				dineroGanado += jugador.getApuesta();
				
			} else if (resultadoPartida < 0) {
				System.out.println("Lo siento. Has perdido tu apuesta de "
						+ jugador.getApuesta() + "€");
				jugador.setSueldo(jugador.getSueldo() - jugador.getApuesta());
				dineroPerdido += jugador.getApuesta();
				
			} else if (jugador.isPlantado()) {
				System.out.println("¡Empate! Se te ha devuelto tu apuesta de "
						+ jugador.getApuesta() + "€");
			} else {
				System.out.println("¡Ambos se han pasado de 7 y medio! Se te ha devuelto tu apuesta de "
						+ jugador.getApuesta() + "€");
			}
			
			// -------------------------- Reiniciar para la siguiente partida
			reiniciar(baraja, jugador, cpu);
			isInicial = true;
			
			// Preguntar si quiere volver a jugar, a menos que no tenga sueldo restante
			if (jugador.getSueldo() > 0) {
				System.out.print("¿Desea volver a jugar? [S/n]: ");
				terminarJuego = Character.toUpperCase(sc.nextLine().charAt(0)) == 'N';
				sleep(800);
			}
			
		} while (!terminarJuego && jugador.getSueldo() > 0);

		// Mostrar estadísticas una vez se haya terminado el juego --------------------------------------------------------------------------
		System.out.println("-------- ESTADÍSTICAS DE LA PARTIDA --------");
		System.out.println("Nombre del jugador: " + jugador.getNombre());
		System.out.println("Dificultad de la CPU: " + (cpu.getDificultad() == 1 ? "Normal" : "Difícil"));
		System.out.println("Sueldo inicial: " + sueldoBase + "€");
		System.out.println("Sueldo final: " + (jugador.getSueldo() <= 0 ? "Banca rota" : jugador.getSueldo() + "€"));
		System.out.println("Partidas jugadas: " + partidasJugadas);
		System.out.println("Dinero ganado: " + dineroGanado + "€");
		System.out.println("Dinero perdido: " + dineroPerdido + "€");
	}

	public static void turnoJugador(Scanner sc, Baraja baraja, Jugador jugador, boolean isInicial) {

		System.out.println("----- TURNO DE " + jugador.getNombre().toUpperCase() + " -----");
		jugador.setTotalPuntos(jugador.getTotalPuntos() + valorReal(baraja.valorCartaActual()));
		System.out.println("Carta sacada: " + baraja.cartaActualToString());
		System.out.println("Valor total actual: " + jugador.getTotalPuntos());
		baraja.siguienteCarta();

		// Pedir apuesta al jugador si es el primer turno
		if (isInicial) {
			pedirApuesta(sc, jugador);
		}
		
		// Preguntar si desea plantarse, en caso de que no se haya pasado
		if (jugador.getTotalPuntos() <= 7.5f) {
			System.out.print("Desea plantarse? [N/s]: ");
			jugador.setPlantado(Character.toUpperCase(sc.nextLine().charAt(0)) == 'S');
		}
	}

	public static void pedirApuesta(Scanner sc, Jugador jugador) {
		// Pedir apuesta inicialmente
		sleep(100);
		System.out.println("Sueldo total: " + jugador.getSueldo());
		System.out.print("Escriba su apuesta: ");
		jugador.setApuesta(sc.nextInt());

		// Pedir más veces si no es válida la apuesta
		while (jugador.getApuesta() > jugador.getSueldo() || jugador.getApuesta() <= 0) {
			sleep(400);
			System.out.println("Apuesta no válida, no puedes apostar más dinero del que tienes, ni dinero negativo, ni no apostar.");
			sleep(800);
			System.out.print("Escriba su apuesta: ");
			jugador.setApuesta(sc.nextInt());
		}

		// Limpiar buffer de teclado
		sc.nextLine();
	}

	public static void turnoCPU(Baraja baraja, JugadorCPU cpu, Jugador jugador, boolean isInicial) {
		System.out.println("----- TURNO DE " + cpu.getNombre().toUpperCase() + " -----");
		// Sacar primera carta
		cpu.setTotalPuntos(cpu.getTotalPuntos() + valorReal(baraja.valorCartaActual()));
		if (isInicial) {
			System.out.println("La CPU mantiene la primera carta oculta.");
			cpu.setPuntosOcultos(cpu.getTotalPuntos());
		} else {
			System.out.println("Carta sacada: " + baraja.cartaActualToString());
			System.out.println("Valor actual de la CPU: " + (cpu.getTotalPuntos() - cpu.getPuntosOcultos()) + " + ???");
		}

		// La CPU procede a decidir si plantarse o no en base a su dificultad, si no se ha pasado de 7.5
		if (cpu.getTotalPuntos() <= 7.5) {
			Random rdn = new Random();
			if (cpu.getDificultad() == 1) { // Dificultad normal
				if (cpu.getTotalPuntos() <= 4)
					cpu.setPlantado(rdn.nextInt(1,21) == 1);
				else if (cpu.getTotalPuntos() <= 5)
					cpu.setPlantado(rdn.nextInt(1,6) <= 2);
				else if (cpu.getTotalPuntos() <= 6)
					cpu.setPlantado(rdn.nextInt(1,11) <= 9);
				else
					cpu.setPlantado(true);
			} else { // Dificultad dificil
				float siguienteCarta = baraja.valorCarta(jugador.isPlantado()?1:2);
				if (cpu.getTotalPuntos() + siguienteCarta > 7.5f)
					cpu.setPlantado(true);
			}
		}
		
		// Poner el mensaje si se ha plantado
		if (cpu.isPlantado()) {
			sleep(800);
			System.out.println("La CPU se planta.");
		}

		baraja.siguienteCarta();
	}
	
	public static int resultado(Jugador jugador, JugadorCPU cpu) {
		int resultado;
		
		if (jugador.isPlantado()) {
			if (cpu.isPlantado()) {
				if (cpu.getTotalPuntos() < jugador.getTotalPuntos())
					resultado = jugador.getApuesta();
				else if (cpu.getTotalPuntos() > jugador.getTotalPuntos())
					resultado = -jugador.getApuesta();
				else
					resultado = 0;
			} else {
				resultado = jugador.getApuesta();
			}
		} else {
			if (cpu.isPlantado())
				resultado = -jugador.getApuesta();
			else if (cpu.getTotalPuntos() > 7.5f) {
				if (jugador.getTotalPuntos() > 7.5f)
					resultado = 0;
				else
					resultado = jugador.getApuesta();
			} else {
				if (jugador.getTotalPuntos() > 7.5f)
					resultado = -jugador.getApuesta();
				else
					resultado = 0;
			}
		}
		
		return resultado;
	}

	public static void reiniciar(Baraja baraja, Jugador jugador, JugadorCPU cpu) {
		baraja.barajar();
		cpu.setTotalPuntos(0);
		cpu.setPuntosOcultos(0);
		cpu.setPlantado(false);
		jugador.setTotalPuntos(0);
		jugador.setApuesta(0);
		jugador.setPlantado(false);
		sleep(800);
	}
	
	private static float valorReal(int valor) {
		return switch (valor) {
		case 8,9,10 -> 0.5f;
		default -> valor;
		};
	}

	private static void sleep(int milliseconds) {
		System.out.println();
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
		}
	}

}
