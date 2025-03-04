package ejer2;

import java.time.LocalDate;
import java.util.Objects;

public class Empleado implements Comparable<Empleado> {
	
// Variables
	private String nombre;
	private LocalDate nacimiento;
	private EnumCategoria categoria;
	private int numHijos;
	
	private final static int EXTRAHIJO = 50;
	private final static float SS = 0.04f;
	private final static int[] UMBRALES = {1500, 	2500, 	3500};
	private final static float[] IRPF =   {0.05f, 	0.1f, 	0.15f, 	0.2f};
	
// Getters y Setters
	public String getNombre() {return nombre;}
	public LocalDate getNacimiento() {return nacimiento;}
	public EnumCategoria getCategoria() {return categoria;}
	public int getNumHijos() {return numHijos;}

	public void setNombre(String nombre) {this.nombre = nombre;}
	public void setNacimiento(LocalDate nacimiento) {this.nacimiento = nacimiento;}
	public void setCategoria(EnumCategoria categoria) {this.categoria = categoria;}
	public void setNumHijos(int numHijos) {this.numHijos = numHijos;}
	
// Constructores
	public Empleado(String nombre, LocalDate nacimiento, EnumCategoria categoria, int numHijos) {
		this.nombre = nombre;
		this.nacimiento = nacimiento;
		this.categoria = categoria;
		this.numHijos = numHijos;
	}
	
	public Empleado(String nombre, LocalDate nacimiento) {
		this(nombre, nacimiento, EnumCategoria.PROGRAMADOR_JUNIOR, 0);
	}
	
	public Empleado(String nombre, String nacimiento, EnumCategoria categoria, int numHijos) {
		this(nombre, LocalDate.now(), categoria, numHijos);
		
		if (LibJavaTime.isFechaCorrecta(nacimiento))
			this.nacimiento = LibJavaTime.convierteStringToLocalDate(nacimiento);
		else
			this.nacimiento = null;
		// No voy a poner "LocalDate.now()" ya que sería una fecha válida, prefiero poner null
	}
	
	public Empleado(String nombre, String nacimiento) {
		this(nombre, nacimiento, EnumCategoria.PROGRAMADOR_JUNIOR, 0);
	}
	
// Métodos públicos
	public double getSalarioBruto() {
		return redondearDosCifras(this.categoria.getSalario() + EXTRAHIJO * this.numHijos);
	}
	
	public double getSalarioNeto() {
		final double bruto = this.getSalarioBruto();
		double neto = bruto - bruto*SS;
		
		boolean irpfAplicado = false;
		for (int i = 0; i < UMBRALES.length && !irpfAplicado; i++)
			if (bruto < UMBRALES[i]) {
				neto -= bruto*IRPF[i];
				irpfAplicado = true;
			}
		
		if (!irpfAplicado)
			neto -= bruto*IRPF[IRPF.length-1];
		
		return redondearDosCifras(neto);
	}
	
// Métodos estáticos
	public static EmpleadoCompleto convertirACompleto(Empleado e) {
		if (e instanceof EmpleadoCompleto)
			return null;
		
		return new EmpleadoCompleto(e, 0);
	}
	
// Método privado para redondear el salario
	private static double redondearDosCifras(double num) {
		return Math.round(num * 100)/100.0;
	}
	
// toString
	@Override
	public String toString() {
		return this.nombre + " - Categoría: " + this.categoria.toString()
				+ "\n\tFecha de nacimiento: " + LibJavaTime.getFechaShort(this.nacimiento)
						+ " (" + LibJavaTime.getEdad(nacimiento) + " años)"
				+ "\n\tSalario bruto: " + this.getSalarioBruto() + "€"
				+ "\n\tSalario neto: " + this.getSalarioNeto() + "€"
				+ "\n\tHijos: " + this.numHijos;
	}
	
	public String toStringLineal() {
		return LibJavaTime.getFechaShort(this.nacimiento) + " " + this.nombre
				+ " (Salario neto: " + this.getSalarioNeto() + "€) - " + this.getClass().getSimpleName();
	}
	
// hashCode, equals, compareTo
	@Override
	public int hashCode() {
		return Objects.hash(nacimiento, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(nacimiento, other.nacimiento) && Objects.equals(nombre, other.nombre);
	}
	
	@Override
	public int compareTo(Empleado o) {
		int comparacion = this.nacimiento.compareTo(o.nacimiento);
		if (comparacion == 0)
			comparacion = this.nombre.compareTo(o.nombre);
		
		return comparacion;
	}
	
}
