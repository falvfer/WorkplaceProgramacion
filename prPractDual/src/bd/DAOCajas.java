package bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.SortedSet;
import java.util.TreeSet;

import modelo.Expediente;
import modelo.MiExcepcion;
import modelo.Persona;
import modelo.SubseccionExpediente;

public class DAOCajas {

	public static SortedSet<Expediente> findCaja(int caja) throws MiExcepcion {
		try (Connection c = BDConnection.getConnection()) {
			// Crear el Set de expedientes
			SortedSet<Expediente> expedientes = new TreeSet<>();
			
			// Creamos el objeto para enviar sentencias SQL
			Statement st = c.createStatement();
			Statement st2 = c.createStatement();
			
			// Buscar los expedientes que pertenezcan a la caja
			ResultSet rsExpediente = st.executeQuery("SELECT * FROM EXPEDIENTES"
						+ " JOIN SUBSECCIONES USING(id_subseccion)"
					+ " WHERE caja = "+caja+";");
			
			// Por cada expediente encontrado
			while (rsExpediente.next()) {
				
				// Crear el objeto expediente
				Expediente e = new Expediente(rsExpediente.getInt("caja"),
						(short)rsExpediente.getInt("num_Expediente"),
						(short)rsExpediente.getInt("anno_expediente"),
						SubseccionExpediente.buscarPorNombre(rsExpediente.getString("subseccion")),
						rsExpediente.getString("descripcion"));
				
				// Buscar las personas relacionadas
				ResultSet rsPersonas = st2.executeQuery("SELECT * FROM PERSONAS "
					+ "JOIN REL_EXP_PERS USING(id_persona) "
					+ "WHERE id_expediente = "+rsExpediente.getInt("id_expediente")+";");
				
				// Añadir las personas al objeto Expediente
				while (rsPersonas.next())
					e.getPersonas().add(new Persona(rsPersonas.getString("nombre")));
				
				// Añadirlo al set de Expedientes
				expedientes.add(e);
			}
			
			// Devolver el expediente
			return expedientes;
			
		} catch (ClassNotFoundException e) {
			throw new MiExcepcion("No se ha encontrado la clase");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MiExcepcion("No se ha encontrado ninguna caja con ese número");
		}
	}
	
	
	
}
