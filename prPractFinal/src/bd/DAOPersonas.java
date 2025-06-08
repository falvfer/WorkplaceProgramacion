package bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.SortedSet;
import java.util.TreeSet;

import modelo.MiExcepcion;
import modelo.Persona;

public class DAOPersonas {

	public static void actualizarPersonas() throws MiExcepcion { // Método para controlar el tamaño de la tabla de personas.
		try (Connection c = BDConnection.getConnection()) {
			
			// Crear los objetos statement
			Statement st = c.createStatement();
			Statement st2 = c.createStatement();
			
			// Buscar las personas que no tengan relaciones con Expedientes para borrarlas
			ResultSet rs = st.executeQuery("SELECT * FROM PERSONAS"
					+ " LEFT JOIN REL_EXP_PERS USING(id_persona)"
					+ " WHERE id_expediente IS NULL;");
			
			boolean borrado = false; 
			
			// Borrar las personas
			while (rs.next()) {
				st2.executeUpdate("DELETE FROM PERSONAS"
						+ " WHERE id_persona = "+rs.getInt("id_persona"));
				
				System.out.println("Borrada la persona "+rs.getString("nombre")
						+ " porque no tiene relaciones con ningún expedientes.");
				borrado = true;
			}
			
			// Poner una linea vacia en la consola si se ha borrado 1 o más personas
			if (borrado) System.out.println();
			
		} catch (ClassNotFoundException e) {
			throw new MiExcepcion("No se ha encontrado la clase");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MiExcepcion("No se ha encontrado ninguna Persona");
		}
	}
	
	public static void crearPersona(Persona p) throws MiExcepcion {
		
		try (Connection c = BDConnection.getConnection()) {
			
			// Creamos el objeto para enviar sentencias SQL
			Statement st = c.createStatement();
			
			// Añadimos la persona
			st.executeUpdate("INSERT INTO PERSONAS(nombre) VALUES('"+p.getNombre()+"');");
			
		} catch (ClassNotFoundException e) {
			throw new MiExcepcion("No se ha encontrado la clase");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MiExcepcion("No se ha podido añadir la persona.");
		}
	}
	
	public void crearPersona(String nombre) throws MiExcepcion {
		crearPersona(new Persona(nombre));
	}
	
}
