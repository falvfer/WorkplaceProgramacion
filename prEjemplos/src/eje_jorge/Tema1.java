package eje_jorge;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Tema1 {

	public static void main(String[] args) {
		int num = 1;
		int num2, num3;

		num2 = num++;
		System.out.println(num);
		num3 = (num2==num ? num : num2) / num * 4;
		
		float pito = 3.2f;

		System.out.println(num2);
		System.out.println(num3);
	}

	public static void main3(String[] args) {
		Random rdn = new Random();

		boolean a = rdn.nextBoolean();

		if (a)
			System.out.println("Explosion");
		else
			System.out.println("Peter");

		System.out.println("El texto es: " + (a ? "Explosion" : "Peter"));

	}

	public static void main2(String[] args) {
		boolean continuar = true;
		char respuesta;
		int num1 = 0, num2 = 0, num3 = 0;
		char orden;
		Scanner scanner = new Scanner(System.in);

		do {
			try {

				while (continuar) {

					System.out.println("Especifica los 3 números.");
					// Pedir los numeros los números
					num1 = scanner.nextInt();
					num2 = scanner.nextInt();
					num3 = scanner.nextInt();
					scanner.nextLine();

					// Pedir al usuario como quiere ordenar los numeros
					System.out.println("¿Cómo quieres ordenar los números? [a/d]");
					orden = scanner.nextLine().charAt(0);
					if (orden != 'a' && orden != 'd')
						System.out.println("Se han introducido datos incorrectos Por favor, escribe 'ascendente' o 'descendente' para poder ordenar los numeros.\n");
					 else {

						// Ordenar y mostrar los números ordenados
						System.out.println("Los números ordenados son:");
						if (orden == 'a') {
							if (num1 <= num2 && num1 <= num3) {
								if (num2 <= num3) {
									System.out.println(num1 + " " + num2 + " " + num3);
								} else {
									System.out.println(num1 + " " + num3 + " " + num2);
								}
							} else if (num2 <= num1 && num2 <= num3) {
								if (num1 <= num3) {
									System.out.println(num2 + " " + num1 + " " + num3);
								} else {
									System.out.println(num2 + " " + num3 + " " + num1);
								}
							} else {
								if (num1 <= num2) {
									System.out.println(num3 + " " + num1 + " " + num2);
								} else {
									System.out.println(num3 + " " + num2 + " " + num1);
								}
							}
						} else {
							if (num1 >= num2 && num1 >= num3) {
								if (num2 >= num3) {
									System.out.println(num1 + " " + num2 + " " + num3);
								} else {
									System.out.println(num1 + " " + num3 + " " + num2);
								}
							} else if (num2 >= num1 && num2 >= num3) {
								if (num1 >= num3) {
									System.out.println(num2 + " " + num1 + " " + num3);
								} else {
									System.out.println(num2 + " " + num3 + " " + num1);
								}
							} else {
								if (num1 >= num2) {
									System.out.println(num3 + " " + num1 + " " + num2);
								} else {
									System.out.println(num3 + " " + num2 + " " + num1);
								}
							}
						}

						// Preguntar si quiere volver a usar el programa
						System.out.println(
								"¿Quieres usar el programa otra vez? Escribe 'si' para continuar o cualquier otra cosa para terminar");
						respuesta = scanner.nextLine().charAt(0);
						if (respuesta != 's') {
							continuar = false;
							System.out.println("Gracias por usar el programa");
						}
					}
				}

			} catch (InputMismatchException e) {
				System.out.println("¡Entrada no válida! Por favor, introduce un número entero.\n");
				scanner.nextLine();
			}

		} while (continuar);

		scanner.close();
	}

	public static void peter() {

		Scanner sc = new Scanner(System.in);

		System.out.println(Math.pow(2, 2));
		int a = 3, b;
		System.out.print("Especifica el segundo número: ");
		b = sc.nextInt();
		System.out.println(suma(a, b));

		int num = 1;
		for (int i = 1; i <= 2; i++) {
			num = num + i;
			System.out.println(num);
		}
		sc.close();

	}

	private static int suma(int a, int b) {
		return a + b;
	}
}
