package ejer2;

public class Test {

	public static void main(String[] args) {
		
	// TEST EMPLEADOS --------------------------------------------------------
		Empleado[] empleados = {
				new Empleado("Pepe García", "29/04/1997", EnumCategoria.PROGRAMADOR_JUNIOR, 0),
				new EmpleadoCompleto("María Ríos", "18/09/1985", EnumCategoria.JEFE_DE_EQUIPO, 3, 3),
				new EmpleadoParcial("Luis González", "06/12/2000", EnumCategoria.PROGRAMADOR_SENIOR, 0, 12),
				new Empleado("Juan López", "16/07/1990", EnumCategoria.ANALISTA, 2),
				new EmpleadoCompleto("Lorena Montilla", "14/05/2000", EnumCategoria.PROGRAMADOR_JUNIOR, 0, 1),
				new EmpleadoParcial("Martín Luque", "16/10/1995", EnumCategoria.PROGRAMADOR_JUNIOR, 1, 120)
		};
		
		((EmpleadoCompleto)empleados[1]).addPlus(EnumPlus.BENEFICIOS_EXTRAS);
		((EmpleadoCompleto)empleados[1]).addPlus(EnumPlus.FORMACION);
		
		for (Empleado e: empleados)
			System.out.println(e + "\n");

		for (Empleado e: empleados)
			System.out.println(e.toStringLineal());
		
		System.out.println("\n\n\n");
		
	// TEST EMPRESA --------------------------------------------------------
		Empresa empresa = new Empresa(empleados);
		
		System.out.println(empresa + "\n");
		System.out.println(empresa.toStringListaOrdenadaSalario() + "\n");

		System.out.println(((EmpleadoCompleto)empleados[1]).getPluses());
		empresa.agregarPlus(EnumPlus.ASISTENCIA);
		System.out.println(((EmpleadoCompleto)empleados[1]).getPluses() + "\n");

		System.out.println(empresa.buscarEmpleado(empleados[0].getNombre(), empleados[0].getNacimiento()).toStringLineal() + "\n");
		empresa.convertirEmpleadoACompleto(empleados[0]);
		System.out.println(empresa.toString() + "\n");
		
		
		empresa.convertirTodosEmpleadosACompletos();
		System.out.println(empresa + "\n");
		
		
		
		
	}

}
