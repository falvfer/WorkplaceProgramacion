package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import bd.BDConnection;
import bd.DAOExpedientes;
import bd.DAOPersonas;
import modelo.Expediente;
import modelo.MiExcepcion;
import modelo.Persona;
import modelo.SubseccionExpediente;

public class Crear {

	// IMPORTANTE: Este metodo solo se ejecuta una vez al crear la BBDD
	public static void actualizarSubsecciones() {
		
		try (Connection c = BDConnection.getConnection()){
			
			Statement st = c.createStatement();
			
			for (SubseccionExpediente s: SubseccionExpediente.values()) {
				st.executeUpdate("INSERT INTO SUBSECCIONES(seccion, subseccion)"
						+" VALUES('"+s.getSeccion().toString()+"', '"+s.toString()+"');");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (MiExcepcion e1) {
			e1.printStackTrace();
		}
		
	}

	public static void expedientes() {
		
		// Crear personas
		SortedSet<Persona> personas = new TreeSet<>();
		personas.add(new Persona("Juán Moreno García"));
		personas.add(new Persona("Maria Juán López Moro"));
		personas.add(new Persona("Júan Antonio Álvarez González"));
		
		// Iterador de personas
		Iterator<Persona> it = personas.iterator();
		Persona p = it.next();
		
		// Crear expedientes
		SortedSet<Expediente> expedientes = new TreeSet<>();
		expedientes.add(new Expediente(1, (short)1, (short)2024,
				SubseccionExpediente.ALCALDE, "Expediente de Alcaldía 1/2024", p, it.next()));
		expedientes.add(new Expediente(1, (short)2, (short)2024,
				SubseccionExpediente.FINANCIACION, "Expediente de Financiación 2/2024", p, it.next()));
		expedientes.add(new Expediente(2, (short)1, (short)2025,
				SubseccionExpediente.COMISIONES_GOBIERNO, "Expediente de Comisiones 1/2025"));
		
		// Añadir personas
		for (Persona p1: personas)
			try {
				DAOPersonas.crearPersona(p1);
				System.out.println("Persona "+p1+" agregada correctamente");
			} catch (MiExcepcion e) {
				System.out.println("La persona "+p1+" ya existe");
			}
		
		// Añadir expedientes
		for (Expediente e: expedientes)
			try {
			DAOExpedientes.crearExpediente(e);
				System.out.println("Expediente "+e+" agregado correctamente");
			} catch (MiExcepcion e1) {
				System.out.println("El expediente "+e+" ya existe");
			}
		
		
	}
	
}
