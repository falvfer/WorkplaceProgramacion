package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import modelo.Alojamiento;
import modelo.ApartamentoRural;
import modelo.CasaRural;
import modelo.GestorAlojamientos;
import modelo.MiExcepcion;
import modelo.Persona;
import modelo.Reserva;
import modelo.UbicacionesEnum;

public class TestModelo {

	public static void main(String[] args) {
		
		//----------------------------------------------------------------------------------
		titulo("TEST Alojamiento, CasaRural y ApartamentoRural");
		//----------------------------------------------------------------------------------
		List<Alojamiento> alojamientos = new ArrayList<>();
		try {
			// Casas rurales
			alojamientos.add(new CasaRural("Casa 1", UbicacionesEnum.ALMERÍA, 30, (byte)1));
			alojamientos.add(new CasaRural("Casa 2", UbicacionesEnum.CAZORLA, 50, (byte)2));
			alojamientos.add(new CasaRural("Casa 3", UbicacionesEnum.CÁDIZ, 20, (byte)1));
			
			// Apartamentos rurales
			alojamientos.add(new ApartamentoRural("Apartamento 1", UbicacionesEnum.CÓRDOBA, 20, true, false));
			alojamientos.add(new ApartamentoRural("Apartamento 2", UbicacionesEnum.GRANADA, 40, true, true));
			alojamientos.add(new ApartamentoRural("Apartamento 3", UbicacionesEnum.HUELVA, 15, false, false));
			
		} catch (MiExcepcion e) {e.printStackTrace();}
				
		for (Alojamiento a: alojamientos)
			System.out.println(a);
		
		//----------------------------------------------------------------------------------
		titulo("TEST Reserva");
		//----------------------------------------------------------------------------------
		SortedSet<Reserva> reservas = new TreeSet<>();
		try {
			reservas.add(new Reserva((Alojamiento)alojamientos.toArray()[0],
					"25/08/2025", (byte)8, "Paco", "12345678A", "666555444"));
			reservas.add(new Reserva((Alojamiento)alojamientos.toArray()[2],
					"16/05/2025", (byte)2, new Persona("María", "555444767")));
			reservas.add(new Reserva((Alojamiento)alojamientos.toArray()[5],
					"03/06/2025", (byte)4, "José", "662356774"));
			reservas.add(new Reserva((Alojamiento)alojamientos.toArray()[4],
					"05/07/2025", (byte)1, "Jorge", "662323234"));
		} catch (MiExcepcion e) {e.printStackTrace();}
		
		for (Reserva r: reservas)
			System.out.println(r);
		
		//----------------------------------------------------------------------------------
		titulo("TEST GestorAlojamientos");
		//----------------------------------------------------------------------------------
		try {
			GestorAlojamientos gestor = new GestorAlojamientos(new File("files/miACollection.dat"));
			
			System.out.println(gestor.buscarAlojamiento("Casa 1"));
			
			titulo("ALOJAMIENTOS");
			for (Alojamiento a: gestor.getAlojamientos())
				System.out.println(a);

			for (Reserva r: reservas)
				gestor.addReserva(r);
			
			titulo("RESERVAS");
			for (Reserva r: gestor.getReservas())
				System.out.println(r);
			
			
		} catch (MiExcepcion e) {
			e.printStackTrace();
		}
		
		
			
	}
	
	private static void titulo(String str) {
		System.out.println("----------------------------------------------------------------------------------"
				+ "\n"    + str
				+ "\n"    +"----------------------------------------------------------------------------------");
	}
}
