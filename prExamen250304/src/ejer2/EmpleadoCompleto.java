package ejer2;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class EmpleadoCompleto extends Empleado {
	
// Variables
	private int numTrienios;
	private Set<EnumPlus> pluses; // Dando por echo que cada plus solo se puede tener una única vez
	
	private final static int EXTRATRIENIO = 100;
	
// Getters y Setters
	public int getNumTrienios() {return numTrienios;}
	public Set<EnumPlus> getPluses() {return pluses;}
	
	public void setNumTrienios(int numTrienios) {this.numTrienios = numTrienios;}
	public void setPluses(Set<EnumPlus> pluses) {this.pluses = pluses;}

// Constructores
	public EmpleadoCompleto(String nombre, LocalDate nacimiento, EnumCategoria categoria, int numHijos, int numTrienios) {
		super(nombre, nacimiento, categoria, numHijos);
		this.numTrienios = numTrienios;
		this.pluses = new HashSet<>();
	}
	
	public EmpleadoCompleto(String nombre, String nacimiento, EnumCategoria categoria, int numHijos, int numTrienios) {
		super(nombre, nacimiento, categoria, numHijos);
		this.numTrienios = numTrienios;
		this.pluses = new HashSet<>();
	}
	
	public EmpleadoCompleto(Empleado emp, int numTrienios) {
		this(emp.getNombre(), emp.getNacimiento(), emp.getCategoria(), emp.getNumHijos(), numTrienios);
	}
	
// Métodos públicos
	@Override
	public double getSalarioBruto() {
		double salario = super.getSalarioBruto() + EXTRATRIENIO * this.numTrienios;
		
		for (EnumPlus plus: pluses)
			salario += plus.getImporte();
		
		return salario;
	}
	
	public boolean addPlus(EnumPlus plus) {
		return pluses.add(plus);
	}
	
	public boolean quitaPlus(EnumPlus plus) {
		return pluses.remove(plus);
	}
	
// toString
	@Override
	public String toString() {
		return super.toString()
				+ "\n\tEmpleado a tiempo completo"
				+ "\n\tNúmero de trienios: " + this.numTrienios
				+ "\n\tPlus: " + (this.pluses.size()>0?this.pluses.toString():"No tiene");
	}
	
	
}
