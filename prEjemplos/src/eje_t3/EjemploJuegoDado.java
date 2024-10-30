package eje_t3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EjemploJuegoDado {
	
	public static void main(String[] args) {
		
		byte dadoAleatorio, dadoUsuario;
		
		try (Scanner sc = new Scanner(System.in)) {
			
			dadoAleatorio = (byte) (Math.random()*6+1);
			
			System.out.print("Especifique la predicción del dado: ");
			dadoUsuario = sc.nextByte();
			
			if (dadoUsuario < 1 || dadoUsuario > 6)
				throw new InputMismatchException();
			
			if (dadoUsuario == dadoAleatorio) 
				System.out.println("Felicidades, el número era: "+dadoAleatorio);
			else
				System.out.println("Lo siento, el número era: "+dadoAleatorio);
			
		} catch (InputMismatchException e) {
			System.out.println("Error: El número tiene que ser entero entre 1 y 6.");
		} // FIN TRY-CATCH
		
	} // FIN MAIN
}
