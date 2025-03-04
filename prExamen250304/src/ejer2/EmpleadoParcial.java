package ejer2;

import java.time.LocalDate;

public class EmpleadoParcial extends Empleado {
	
// Variables
	private int numHoras;
	
	private final static int HORASESTIMADAS = 150;

// Getters y Setters
	public int getNumHoras() {return numHoras;}
	public void setNumHoras(int numHoras) {this.numHoras = numHoras;}
	
// Constructores
	public EmpleadoParcial(String nombre, LocalDate nacimiento, EnumCategoria categoria, int numHijos, int numHoras) {
		super(nombre, nacimiento, categoria, numHijos);
		this.numHoras = numHoras;
	}
	
	public EmpleadoParcial(String nombre, String nacimiento, EnumCategoria categoria, int numHijos, int numHoras) {
		super(nombre, nacimiento, categoria, numHijos);
		this.numHoras = numHoras;
	}
	
	public EmpleadoParcial(Empleado emp, int numHoras) {
		this(emp.getNombre(), emp.getNacimiento(), emp.getCategoria(), emp.getNumHijos(), numHoras);
	}
	
	// Métodos públicos
	@Override
	public double getSalarioBruto() {
		double salario = super.getSalarioBruto() / HORASESTIMADAS * this.numHoras;
		
		return salario;
	}
	
// toString
	@Override
	public String toString() {
		return super.toString()
				+ "\n\tEmpleado por horas: " + numHoras + " horas trabajadas";
	}

}
