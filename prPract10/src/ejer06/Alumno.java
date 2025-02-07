package ejer06;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.time.LocalDate;
import librerias.LibFCalendar;
import librerias.LibFTime;

public class Alumno implements Comparable<Alumno>{

// Variables
	private byte numClase;
	private String nombre, apellido1, apellido2;
	private Calendar fecNac1;
	private LocalDate fecNac2;
	private String domicilio;
	private String dni;
	
// Getters y Setters
	public byte getNumClase() {return numClase;}
	public String getNombre() {return nombre;}
	public String getApellido1() {return apellido1;}
	public String getApellido2() {return apellido2;}
	public Calendar getFecNac1() {return fecNac1;}
	public LocalDate getFecNac2() {return fecNac2;}
	public String getDomicilio() {return domicilio;}
	public String getDni() {return dni;}
	
	public void setNumClase(byte numClase) {this.numClase = numClase;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setApellido1(String apellido1) {this.apellido1 = apellido1;}
	public void setApellido2(String apellido2) {this.apellido2 = apellido2;}
	public void setFecNac1(Calendar fecNac1) {this.fecNac1 = fecNac1;}
	public void setFecNac2(LocalDate fecNac2) {this.fecNac2 = fecNac2;}
	public void setDomicilio(String domicilio) {this.domicilio = domicilio;}
	public void setDni(String dni) {this.dni = dni;}
	
// Constructor
	public Alumno(byte numClase, String nombre, String apellido1, String apellido2,
					String fecNac, String domicilio, String dni) {
		this.numClase = numClase;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.domicilio = domicilio;
		this.dni = dni;
		
		// Vamos a validar la fecha
		if (LibFCalendar.esFechaCorrecta(fecNac)) {
			this.fecNac1 = LibFCalendar.convierteFechaStringACalendar(fecNac);
			this.fecNac2 = LibFTime.convierteStringToLocalDate(fecNac);
		} else {
			this.fecNac1 = GregorianCalendar.getInstance();
			this.fecNac2 = LocalDate.now();
		}
	}

// hashCode, equals y comparable
	@Override
	public int hashCode() {
		return Objects.hash(apellido1, apellido2, dni, nombre);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(apellido1, other.apellido1) && Objects.equals(apellido2, other.apellido2)
				&& Objects.equals(dni, other.dni) && Objects.equals(nombre, other.nombre);
	}
	
	@Override
	public int compareTo(Alumno o) {
		int comparacion = this.apellido1.compareTo(o.apellido1);
		
		if (comparacion == 0) {
			comparacion = this.apellido2.compareTo(o.apellido2);
			
			if (comparacion == 0) {
				comparacion = this.nombre.compareTo(o.nombre);
				
				if (comparacion == 0) {
					comparacion = this.dni.compareTo(o.dni);
				}
			}
		}
		
		return comparacion;
	}
	
	// toStrings
	@Override
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase()
				+ this.numClase + ": "
				+ this.apellido1 + " "
				+ this.apellido2 + ", "
				+ this.nombre
				+ " -- Edad: " + LibFCalendar.getEdad(fecNac1) + ","
							   + LibFTime.getEdad(fecNac2)
				+ " -- Domicilio: " + this.domicilio
				+ " -- DNI: " + this.dni;
	}
	
	public String toStringCompleto() {
		return "\nNúmero de clase: " + this.numClase +
			   "\nPrimer apellido: " + this.apellido1 +
			   "\nSegundo apellido: " + this.apellido2 +
			   "\nNombre: " + this.nombre +
			   "\nEdad: " +
			            LibFCalendar.getEdad(fecNac1) + "," +
			   			LibFTime.getEdad(fecNac2) + 
			   
			   "\nFecha de nacimiento (cualquier versi�n): " +
			                LibFCalendar.getFechaFull(fecNac1) + 
			   "\nFecha de nacimiento (versi�n 8): " + 
			   				LibFTime.getFechaFull(fecNac2) +
			   "\nDomicilio: " + this.domicilio +
			   "\nDNI: " + this.dni + "\n";
	}
	
	public String toStringFechaNombre() {
		return LibFTime.getFechaShort(fecNac2) + " "
				+ this.apellido1 + " " + this.apellido2 + ", " + this.nombre;
	}
	
	
	
	
}
