package modelo;

import java.util.TreeSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.SortedSet;

public class Gestor {
	
// Listas
	private Set<Caja> cajas;
	private Set<Expediente> expedientes;
	private Connection c;
	
// Getters y Setters
	public Set<Caja> getCajas() {return cajas;}
	public Set<Expediente> getExpedientes() {return expedientes;}

	public void setExpedientes(Set<Expediente> expedientes) {this.expedientes = expedientes;}
	public void setCajas(Set<Caja> cajas) {this.cajas = cajas;}
	public void setConnection(Connection c) {this.c = c;}

// Constructor
	public Gestor() {
		cajas = new TreeSet<>();
		expedientes = new TreeSet<>();
	}
	
// Métodos públicos
	public Expediente findExpediente(short numExpediente, short anno) throws SQLException {
		
		// Creamos el objeto para enviar sentencias SQL
		Statement st = c.createStatement();
		
		// Buscar el Expediente
		ResultSet rsExpediente = getResultSetExpediente(numExpediente, anno);
		rsExpediente.next();
		
		// Buscar la Subseccion
		ResultSet rsSubseccion = st.executeQuery("SELECT * FROM SUBSECCIONES"
				+ " WHERE id_subsecciones = "+rsExpediente.getInt("id_subseccion")+";");
		rsSubseccion.next();
		
		// Buscar las Personas
		ResultSet rsPersonas = st.executeQuery("SELECT * FROM REL_EXP_PERS"
				+ "WHERE id_expediente = "+rsExpediente.getInt("id_expediente")+";");
		SortedSet<Persona> listaPersonas = new TreeSet<>();
		while (rsPersonas.next()) {
			ResultSet rsPersona = st.executeQuery("SELECT * FROM PERSONAS"
					+ " WHERE id_persona = "+rsPersonas.getInt("id_persona")+";");
			listaPersonas.add(new Persona(rsPersona.getString("nombre")));
		}
		
		// Crear el expediente y devolverlo
		return new Expediente(rsExpediente.getInt("caja"), numExpediente, anno,
				SeccionExpediente.valueOf(rsSubseccion.getString("seccion")),
				SubseccionExpediente.valueOf(rsSubseccion.getString("subseccion")),
				rsExpediente.getString("descripcion"), listaPersonas);
	}
	
	public boolean hasExpediente(Expediente expEncontrar) throws SQLException {
		ResultSet rsExpediente = getResultSetExpediente(expEncontrar.getNumExpediente(), expEncontrar.getAnno());
		return rsExpediente.next();
	}
	
	public boolean mueveExpediente(short numExp, short anno, int destino) throws SQLException {
		// Creamos el objeto para enviar sentencias SQL
		Statement st = c.createStatement();
		
		// Actualizar el Expediente
		int colsUpdated = st.executeUpdate("UPDATE EXPEDIENTES"
				+ " SET caja = "+destino
				+ " WHERE num_expediente = "+numExp+" && anno_expediente = "+anno+";");
		
		return colsUpdated != 0;
		
	}
	
	public boolean crearExpediente(int numCaja, short numExpediente, short anno,
						SubseccionExpediente subseccion, String descripcion, SortedSet<Persona> personas) throws SQLException {
		// Creamos el objeto para enviar sentencias SQL
		Statement st = c.createStatement();
		
		ResultSet rsSubseccion = st.executeQuery("SELECT * FROM SUBSECCIONES WHERE subseccion = "+subseccion.toString());
		
		// Insertar el expediente
		st.executeUpdate("INSERT INTO EXPEDIENTES(anno_expediente, num_expediente, id_subseccion, caja, descripcion)"
				+ "VALUES("+anno+", "+numExpediente+", "+rsSubseccion.getInt("id_subseccion")+", "
				+ numCaja+", "+"descripcion"+")");
		
		ResultSet rsExpediente = getResultSetExpediente(numExpediente, anno);
		
		if (rsExpediente.next()) {
			
			for (Persona p: personas) {
				ResultSet rsPersona = st.executeQuery("SELECT * FROM PERSONAS "
						+ "WHERE nombre = "+p.getNombre()+";");
				
				if (!rsPersona.next()) {
					st.executeUpdate("INSERT INTO PERSONAS(nombre) VALUES("+p.getNombre()+");");
					rsPersona = st.executeQuery("SELECT * FROM PERSONAS "
							+ "WHERE nombre = "+p.getNombre()+";");
					rsPersona.next();
				}
				
				st.executeUpdate("INSERT INTO REL_EXP_PERS(id_expediente, id_persona)"
						+ "VALUES("+rsExpediente.getInt("id_expediente")+", "
						+ rsPersona.getInt("id_persona")+");");
			}
			return true;
		}
		return false;
		
	}
	
	public Expediente quitaExpediente(short numExp, short anno) throws SQLException {
		// Creamos el objeto para enviar sentencias SQL
		Statement st = c.createStatement();
		
		// Buscar el expediente
		Expediente exp = findExpediente(numExp, anno);
		
		// Borrar el expediente
		if (exp instanceof Expediente)
			st.executeUpdate("DELETE FROM EXPEDIENTES"
					+ "WHERE num_expediente = "+numExp+" && anno_expediente = "+anno);
		
		return exp;
	}
	
	public SortedSet<Expediente> findCaja(int caja) throws SQLException {
		// TODO METODO SIN TERMINAR
		SortedSet<Expediente> expedientes = new TreeSet<>();
		
		// Creamos el objeto para enviar sentencias SQL
		Statement st = c.createStatement();
		
		// Buscar el Expediente
		ResultSet rsExpediente = st.executeQuery("SELECT * FROM EXPEDIENTES "
					+ "JOIN SUBSECCION USING(\"id_subseccion\")"
				+ "WHERE caja = "+caja);
		rsExpediente.next();
	}
	
	
// METODOS PRIVADOS
	private ResultSet getResultSetExpediente(short numExpediente, short anno) throws SQLException {
		// Creamos el objeto para enviar sentencias SQL
		Statement st = c.createStatement();
		
		// Buscar el Expediente
		ResultSet rsExpediente = st.executeQuery("SELECT * FROM EXPEDIENTES"
				+ " WHERE num_expediente = "+numExpediente+" && anno_expediente = "+anno+";");
		return rsExpediente;
	}
	
	
// toString
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		Statement st;
		
		try {
			st = c.createStatement();

			str.append("PERSONAS _______________________________________________________");
			ResultSet rs = st.executeQuery("SELECT * FROM PERSONAS;");
			while (rs.next())
				str.append("ID: "+rs.getInt("id_persona")+" - NOMBRE: "+rs.getString("nombre")+"\n");

			str.append("EXPEDIENTES ____________________________________________________");
			rs = st.executeQuery("SELECT * FROM EXPEDIENTES;");
			while (rs.next())
				str.append("Exp: "+rs.getInt("num_expediente")+"/"+rs.getInt("anno_expediente")
						+ ", C: " + rs.getInt("caja")+"\n");
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return str.toString();
	}
}
