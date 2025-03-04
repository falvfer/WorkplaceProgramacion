package ejer2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Empresa {

// Variable
	SortedSet<Empleado> empleados;

// Get y Set
	public SortedSet<Empleado> getEmpleados() {return empleados;}
	public void setEmpleados(SortedSet<Empleado> empleados) {this.empleados = empleados;}
	
// Constructores
	public Empresa(SortedSet<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	public Empresa(Empleado[] empleados) {
		this.empleados = new TreeSet<>();
		for (Empleado e: empleados)
			this.empleados.add(e);
	}
	
	public Empresa() {
		this(new TreeSet<>());
	}

// Métodos públicos
	public boolean addEmpleado(Empleado e) {
		return this.empleados.add(e);
	}
	
	public boolean buscarEmpleado(Empleado e) {
		return this.empleados.contains(e);
	}
	
	public Empleado buscarEmpleado(String nombre, LocalDate nacimiento) {
		Empleado e = null;
		Empleado eBuscar = new Empleado(nombre, nacimiento);
		boolean encontrado = false;
		
		for (Iterator<Empleado> it = this.empleados.iterator(); it.hasNext() && !encontrado;) {
			e = it.next();
			if (e.equals(eBuscar))
				encontrado = true;
		}
		
		if (!encontrado)
			return null;
		
		return e;
	}
	
	public Empleado buscarEmpleado(String nombre, String nacimiento) {
		if (!LibJavaTime.isFechaCorrecta(nacimiento))
			return null;
		
		return buscarEmpleado(nombre, LibJavaTime.convierteStringToLocalDate(nacimiento));
	}
	
	public boolean borrarEmpleado(Empleado e) {
		return this.empleados.remove(e);
	}
	
	public boolean borrarEmpleado(String nombre, LocalDate nacimiento) {
		return borrarEmpleado(new Empleado(nombre, nacimiento));
	}
	
	public boolean borrarEmpleado(String nombre, String nacimiento) {
		return borrarEmpleado(new Empleado(nombre, nacimiento));
	}
	
	public List<Empleado> ordenaSalarioNeto() {
		List<Empleado> empleadosSalario = new ArrayList<>();
		
		empleadosSalario.addAll(empleados);
		empleadosSalario.sort(
				(o1, o2) -> Double.compare(o1.getSalarioNeto(), o2.getSalarioNeto()));
		
		return empleadosSalario;
	}
	
	public void agregarPlus(EnumPlus plus) {
		for (Empleado e: empleados)
			if (e instanceof EmpleadoCompleto)
				((EmpleadoCompleto) e).addPlus(plus);
	}
	
	public void convertirTodosEmpleadosACompletos() {
		Empleado e = null;
		List<Empleado> empleadosTransformar = new ArrayList<>();
		
		for (Iterator<Empleado> it = this.empleados.iterator(); it.hasNext();) {
			e = it.next();
			if (!(e instanceof EmpleadoCompleto)) {
				empleadosTransformar.add(e);
				it.remove();
			}
		}
		
		for (Empleado emp: empleadosTransformar)
			this.empleados.add(Empleado.convertirACompleto(emp));
	}
	
	public void convertirEmpleadoACompleto(Empleado e) {
		Empleado emp = null;
		boolean terminado = false;
		
		for (Iterator<Empleado> it = this.empleados.iterator(); it.hasNext() && !terminado;) {
			emp = it.next();
			if (emp.equals(e)) {
				if (!(emp instanceof EmpleadoCompleto))
					it.remove();
				terminado = true;
			}
		}
		
		if (terminado && !(emp instanceof EmpleadoCompleto))
			this.empleados.add(Empleado.convertirACompleto(emp));
			
	}
	
	public void convertirEmpleadoACompleto(String nombre, LocalDate nacimiento) {
		convertirEmpleadoACompleto(new Empleado(nombre, nacimiento));
	}
	
// toStrings
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("EMPLEADOS DE LA EMPRESA");
		for (Empleado e: this.empleados)
			str.append("\n\t" + e.toStringLineal());
		return str.toString();
	}
	
	public String toStringListaOrdenadaSalario() {
		List<Empleado> emp = ordenaSalarioNeto();
		StringBuilder str = new StringBuilder("EMPLEADOS DE LA EMPRESA");
		for (Empleado e: emp)
			str.append("\n\t" + e.toStringLineal());
		return str.toString();
	}
	
	
	
}
