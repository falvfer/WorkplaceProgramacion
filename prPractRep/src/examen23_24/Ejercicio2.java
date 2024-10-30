package examen23_24;

import java.util.Locale;
import java.util.Scanner;

/* 
 * Apuntes para el ejercicio:
 * 
 *  IMC = peso [kg] / altura^2 [m]
 *  
 *  0.8m <= altura >= 2.5m
 *  20kg <= peso >= 600kg
 *  
 *     <16.00     Bajo peso: Delgadez Severa
 *  16.00 - 16.99 Bajo peso: Delgadez moderada
 *  17.00 - 18.49 Bajo peso: Delgadez aceptable
 *  18.50 - 24.99 Peso Normal
 *  25.00 - 29.99 Sobrepeso
 *  30.00 - 34.99 Obesidad: Tipo I
 *  35.00 - 40.00 Obesidad: Tipo II
 *     >40.00     Obesidad: Tipo III
 */
public class Ejercicio2 {

	public static void main(String[] args) {
		
		float altura, peso, imc;
		
		try (Scanner sc = new Scanner(System.in).useLocale(Locale.US)) {
			System.out.print("Especifique la altura (metros): ");
			altura = sc.nextFloat();
			if (altura > 2.5 || altura < 0.8)
				throw new Exception("Error: Altura no válida, tiene que estar entre 80 centímetros y 2.5 metros");
			
			System.out.print("Especifique el peso (Kilogramos): ");
			peso = sc.nextFloat();
			if (peso > 600 || peso < 20)
				throw new Exception("Error: Peso no válido, tiene que estar en el rango de 20 a 600 Kilogramos");
			
			imc = peso / (float)Math.pow(altura, 2);
			System.out.println("Tu índice de masa corporal es: "+imc);
			
			if (imc < 16)
				System.out.println("Bajo peso: Delgadez Severa");
			else if (imc < 17)
				System.out.println("Bajo peso: Delgadez Moderada");
			else if (imc < 18.5)
				System.out.println("Bajo peso: Delgadez Aceptable");
			else if (imc < 25)
				System.out.println("Peso normal");
			else if (imc < 30)
				System.out.println("Sobrepeso");
			else if (imc < 35)
				System.out.println("Obesidad: Tipo I");
			else if (imc < 40)
				System.out.println("Obesidad: Tipo II");
			else
				System.out.println("Obesidad: Tipo III");
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
