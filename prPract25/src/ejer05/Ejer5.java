package ejer5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

	/**
	 * Realizar un programa que nos permita el duplicado de un archivo que
	 * contenga una imagen. La copia debéis realizarla byte a byte con la
	 * ayuda de flujos BufferedInputStream y BufferedOutputStream, debéis
	 * utilizar un array de byte (buffer) para la lectura con un tamaño de 16K,
	 * y escribir en cada sentencia de escritura el mismo número de bytes
	 * que hayáis leído. El nombre/ruta del archivo a copiar debéis solicitarlo
	 * por teclado, y el nuevo archivo duplicado se llamará como el original.
	 * En esta práctica vamos a realizar una serie de ejercicios cortos,
	 * para familiarizarnos y comprender mejor la entrada/salida de datos
	 * tanto de teclado/consola como con archivos en disco.
	 */

public class Ejer5 {

	public static void main(String[] args) {
		
		final int tamBuffer = 16*1024;
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		
		File archivoOriginal = solicitudNombre(new Scanner(System.in));
		
		try {
			bin = new BufferedInputStream(new FileInputStream(archivoOriginal));
			bout = new BufferedOutputStream(new FileOutputStream(
					new File("./src/ejer5/Copia-"+archivoOriginal.getName())));
			
			int cantidadBytes = 0;
			byte[] buffer = new byte[tamBuffer];
			
			while ((cantidadBytes = bin.read(buffer, 0, tamBuffer)) != -1) {
				bout.write(buffer, 0, cantidadBytes);
				System.out.println("--");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bin instanceof BufferedInputStream)
					bin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (bout instanceof BufferedOutputStream)
					bout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static File solicitudNombre(Scanner sc) {
		
		System.out.print("Nombre del archivo a copiar: ");
		return new File(sc.nextLine());
	}
}
