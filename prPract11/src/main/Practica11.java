package main;

import inmobiliarias.*;
import propiedades.*;

public class Practica11 {

	public static void main(String[] args) {

		System.out.println("+---------------------------------------------------------------------------+"
					   + "\n|  1. Crear primera inmobiliaria y mostrarla por pantalla.                  |"
					   + "\n+---------------------------------------------------------------------------+");
		// Creación de la inmobiliaria
		Inmobiliaria in1 = new Inmobiliaria();
		
		// Añadir propiedades a la Inmobiliaria
		in1.añade(new Propiedad(5, "C\\ Solar 34, Málaga", "Un solar muy bonito a la venta",
				TipoPropiedad.SOLAR, 70, 60_000));
		in1.añade(new Propiedad(4, "C\\ Aparcamiento 1, Málaga", "Un aparcamiento en el centro de málaga para uso comercial",
				TipoPropiedad.APARCAMIENTO, 100, 110_000));
		in1.añade(new Propiedad(1, "C\\ Local 8, Málaga", "Local comercial a la venta",
				TipoPropiedad.LOCAL, 120, 360_000));
		
		// Añadir viviendas a la Inmobiliaria
		in1.añade(new Vivienda(3, "C\\ Casa 3, Málaga", "Casa con buenas vistas",
				70, 230000, TipoVivienda.CASA, 2, 3));
		in1.añade(new Vivienda(6, "C\\ Chalet 5, Málaga", "Chalet cerca de la playa",
				100, 345000, TipoVivienda.CHALET, 2, 4));
		
		// Añadir fincas rústicas a la Inmobiliaria
		in1.añade(new FincaRustica(2, "C\\ Olivos 12, Málaga", "Maravillosa finca con olivos",
				340, 760_000, TipoTerreno.OLIVOS, true, true, true));
		in1.añade(new FincaRustica(7, "C\\ Secano 17, Málaga", "Finca de secano para cultivar",
				230, 440_000, TipoTerreno.SECANO, false, true, false));

		// Mostrar la inmobiliaria
		System.out.println(in1);
		
		// Mostarla ordenada por el precio
		System.out.println("\n" + new Inmobiliaria(in1.getPropiedadesOrdenPrecio()));
		
		// Mostrarla con el formato de ordenPrecioString
		System.out.println("\n" + in1.getPropiedadesOrdenPrecioString() + "\n");

		System.out.println("+---------------------------------------------------------------------------+"
					   + "\n|  2. Prueba de buscar()                                                    |"
					   + "\n+---------------------------------------------------------------------------+");
		// Buscar la propiedad con código 2
		Propiedad prBuscar = in1.buscar(2);
		if (prBuscar != null)
			System.out.println(prBuscar);
		else
			System.out.println("Propiedad no encontrada");
		System.out.println();
		
		// Buscar la propiedad con código 23
		prBuscar = in1.buscar(23);
		if (prBuscar != null)
			System.out.println(prBuscar);
		else
			System.out.println("Propiedad con id 23 no encontrada");
		System.out.println();
		
		// Añadir la propiedad con id 23
		in1.añade(new Propiedad(23, "Su calle", "Es muy bonito, creeme",
				TipoPropiedad.LOCAL, 200, 1_000_000));
		
		// Volver a buscar la propiedad con código 23
		prBuscar = in1.buscar(23);
		if (prBuscar != null)
			System.out.println(prBuscar);
		else
			System.out.println("Propiedad con id 23 no encontrada");
		System.out.println();

		System.out.println("+---------------------------------------------------------------------------+"
					   + "\n|  3. Prueba de borrar()                                                    |"
					   + "\n+---------------------------------------------------------------------------+");
		// Hemos vendido la propiedad 3, así que ya no necesitamos tenerla registrada en nuestra inmobiliaria
		if (in1.borra(3))
			System.out.println("Se ha encontrado la propiedad con código \"3\" y se ha borrado correctamente.");
		else
			System.out.println("No se ha encontrado una propiedad con código \"3\".");
		System.out.println();
		
		// Intentar volverla a borrar para ver como da "false"
		if (in1.borra(3))
			System.out.println("Se ha encontrado la propiedad con código \"3\" y se ha borrado correctamente.");
		else
			System.out.println("No se ha encontrado una propiedad con código \"3\".");
		System.out.println();

		System.out.println("+---------------------------------------------------------------------------+"
					   + "\n|  4. Generar una inmobiliaria nueva a partir de propiedades de la          |"
					   + "\n|     anterior, y borrar esas propiedades                                   |"
					   + "\n+---------------------------------------------------------------------------+");
		
		// Nueva inmobiliaria vacía
		Inmobiliaria in2 = new Inmobiliaria();
		
		// Añadir varias de las propiedades de la inmobiliaria 1
		in2.añade(in1.buscar(2));
		in2.añade(in1.buscar(4));
		in2.añade(in1.buscar(7));
		
		// Borrar las propiedades (en inmobiliaria 1) que se han movido a inmobiliaria 2
		for (Propiedad p: in2.getListaPropiedades())
			in1.borra(p);
		
		// Mostrar ambas inmobiliarias
		System.out.println(in1);
		System.out.println("\n" + in2);
		
		
		
		
	}
	
}
