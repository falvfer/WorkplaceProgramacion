package ejer06;

import java.util.Collections;

public class Test {

	public static void main(String[] args) {
		Alumno[] alumnos = {
				new Alumno((byte)1,"María","García","García","27/02/1987","C/ Alameda, 23", "11111111"),
				new Alumno((byte)2,"Ana","García","García","12/05/2003","C/ Alameda, 23", "22222222"), 
				new Alumno((byte)3,"Juan","García","Blanco","21/09/1996","C/ La silla, 10", "343434334"), 
				new Alumno((byte)5,"María Isabel","López","Jiménez","01/03/2002","C/ El Plato, 12", "676754534"),
				new Alumno((byte)4,"José","García","Blanco","15/10/2003","Avda. Andalucía, s/n", "343423112"),
				new Alumno((byte)6,"Luis","González","Pozo","01/03/2000","C/ Nueva, 1", "12345678"),
				new Alumno((byte)7,"Francisco","Ruiz","Romero","29/02/2000","Carretera Los Prados, km 4", "98765433"),
				new Alumno((byte)8,"Carmen","Romero","Sierras","27/08/1987","C/ El duende, 10", "11223344"),
				new Alumno((byte)9,"Manuel","Romero","Blanco","18/01/1999","C/ Santa Clara, 18", "654332657"), 
				new Alumno((byte)10,"Manuel","Romero","Blanco","12/09/2003","Avda. La Constitución,2", "99999999")
		};
		
		// GrupoV1
		Grupo gr = new Grupo();
		for (Alumno a: alumnos)
			gr.añadeAlumno(a);
		
		System.out.println(gr);
		gr.ordenar();
		System.out.println("\n" + gr);

		// GrupoV2
		GrupoV2 gr2 = new GrupoV2();
		for (Alumno a: alumnos)
			gr2.add(a);
		
		System.out.println("\n" + gr2);
		Collections.sort(gr2);
		System.out.println("\n" + gr);
		
		gr2.sort( // Apellido -> DNI
			(o1, o2) -> {
				int comparacion = o1.getApellido1().compareTo(o2.getApellido1());
				return comparacion!=0?
							comparacion:
							o1.getDni().compareTo(o2.getDni());
			}
		);
		
		gr2.sort( // Nombre -> Fecha Nacimiento
			(o1, o2) -> {
				int comparacion = o1.getNombre().compareTo(o2.getNombre());
				return comparacion!=0?
							comparacion:
							o1.getFecNac2().compareTo(o2.getFecNac2());
			}
		);
		
	
	}
}
