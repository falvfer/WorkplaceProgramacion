package Ejercicio17;

public class Alumno {

	/*
	 * Crea una clase Alumno, con información sobre su nombre y su nota media.
	 * A continuación define un array de seis alumnos y rellénalo solicitando
	 * los datos por teclado. Por último, muestra los datos de los alumnos por
	 * pantalla, así como el nombre y la nota del alumno que tiene la nota media
	 * más alta.
	 */
	
// Variables
	private String nombre;
	private float notaMedia;
	
// Getters y Setters
	public String getNombre() {return nombre;}
	public float getNotaMedia() {return notaMedia;}
	
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setNotaMedia(float notaMedia) {this.notaMedia = notaMedia;}
	
// Constructor
	public Alumno(String nombre, float notaMedia) {
		this.nombre = nombre;
		this.notaMedia = notaMedia;
	}
	
// toString
	@Override
	public String toString() {
		return this.nombre + ": " + this.notaMedia;
	}
	
// Clase main para testear
	public static void main(String[] args) {
		
		Alumno[] alumnos = {
				new Alumno("Pepe", 9.89f),
				new Alumno("Mario", 6.2f),
				new Alumno("Alexis", 2.97f),
				new Alumno("Juana", 7.3f),
				new Alumno("Luis", 9f),
				new Alumno("María", 5.31f)
		};
		
		for (Alumno alum: alumnos)
			System.out.println(alum.toString());

	}
	
}
