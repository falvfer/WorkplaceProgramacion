package ejer7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class Ejer7 {
	
	final static int CESAR = 10;
	final static int TAM_BUFFER = 64;

	public static void main(String[] args) {
		int caracter;
		try (BufferedReader br = Files.newBufferedReader(Path.of("./recursos/censura.txt"));
				BufferedWriter bw = Files.newBufferedWriter(Path.of("./recursos/censurado.txt"))) {

			while ((caracter = (char)br.read()) != -1) {
				bw.write((char)(caracter+CESAR));
			}

		} catch (NoSuchFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (BufferedReader br = Files.newBufferedReader(Path.of("./recursos/censurado.txt"))) {
			
			while ((caracter = (char)br.read()) != -1) {
				System.out.println((char)(caracter-CESAR));
			}
			
		} catch (NoSuchFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void cifra(char[] caracteres) {
		for (int i = 0; i<caracteres.length; i++) {
			caracteres[i] = (char)(caracteres[i]+CESAR);
		}
	}
	
	public static void descifra(char[] caracteres) {
		for (int i = 0; i<caracteres.length; i++) {
			caracteres[i] = (char)(caracteres[i]-CESAR);
		}
	}

}
