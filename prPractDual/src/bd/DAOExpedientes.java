package bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import modelo.Caja;
import modelo.Expediente;
import modelo.MiExcepcion;
import modelo.Persona;
import modelo.SubseccionExpediente;

public class DAOExpedientes {
		
	public static Expediente findExpediente(short numExpediente, short anno) throws MiExcepcion {
		
		try (Connection c = BDConnection.getConnection()) {
			// Creamos el objeto para enviar sentencias SQL
			Statement st = c.createStatement();
			Statement st2 = c.createStatement();
			
			// Buscar el Expediente
			ResultSet rsExpediente = getResultSetExpediente(c, numExpediente, anno);
			
			if (rsExpediente.next()) {
				// Buscar la Subseccion
				ResultSet rsSubseccion = st.executeQuery("SELECT * FROM SUBSECCIONES"
						+ " WHERE id_subseccion = "+rsExpediente.getInt("id_subseccion")+";");
				rsSubseccion.next();
				
				// Buscar las Personas
				ResultSet rsPersonas = st2.executeQuery("SELECT * FROM REL_EXP_PERS "
						+ "JOIN PERSONAS USING(id_persona)"
						+ "WHERE id_expediente = "+rsExpediente.getInt("id_expediente")+";");
				SortedSet<Persona> listaPersonas = new TreeSet<>();
				while (rsPersonas.next()) {
					listaPersonas.add(new Persona(rsPersonas.getString("nombre")));
				}
				
				// Crear el expediente y devolverlo
				return new Expediente(rsExpediente.getInt("caja"), numExpediente, anno,
						SubseccionExpediente.buscarPorNombre(rsSubseccion.getString("subseccion")),
						rsExpediente.getString("descripcion"), listaPersonas);
			} else
				throw new MiExcepcion("Expediente no encontrado");
			
		} catch (ClassNotFoundException e) {
			throw new MiExcepcion("No se ha encontrado la clase");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MiExcepcion("No se ha encontrado ningun expediente");
		}
	}
	
	public static boolean mueveExpediente(short numExp, short anno, int destino) throws MiExcepcion {
		try (Connection c = BDConnection.getConnection()) {
			// Creamos el objeto para enviar sentencias SQL
			Statement st = c.createStatement();
			
			// Actualizar el Expediente
			int colsUpdated = st.executeUpdate("UPDATE EXPEDIENTES"
					+ " SET caja = "+destino
					+ " WHERE num_expediente = "+numExp+" && anno_expediente = "+anno+";");
			
			return colsUpdated != 0;
		} catch (ClassNotFoundException e) {
			throw new MiExcepcion("No se ha encontrado la clase");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MiExcepcion("No se ha encontrado ningun expediente");
		}
	}
	
	public static void crearExpediente(int numCaja, short numExpediente, short anno, SubseccionExpediente subseccion,
									String descripcion, SortedSet<Persona> personas) throws MiExcepcion {
		try (Connection c = BDConnection.getConnection()) {
			// Creamos el objeto para enviar sentencias SQL
			Statement st = c.createStatement();
			Statement st2 = c.createStatement();
			
			ResultSet rsSubseccion = st.executeQuery("SELECT * FROM SUBSECCIONES WHERE subseccion = '"+subseccion.toString()+"';");
			rsSubseccion.next();
			
			// Insertar el expediente
			st2.executeUpdate("INSERT INTO EXPEDIENTES(anno_expediente, num_expediente, id_subseccion, caja, descripcion)"
					+ "VALUES("+anno+", "+numExpediente+", "+rsSubseccion.getInt("id_subseccion")+", "
					+ numCaja+", '"+descripcion+"');");
			
			ResultSet rsExpediente = getResultSetExpediente(c, numExpediente, anno);
			
			if (rsExpediente.next()) {
				
				for (Persona p: personas) {
					ResultSet rsPersona = st.executeQuery("SELECT * FROM PERSONAS "
							+ "WHERE nombre = '"+p.getNombre()+"';");
					
					if (!rsPersona.next()) {
						st.executeUpdate("INSERT INTO PERSONAS(nombre) VALUES('"+p.getNombre()+"');");
						rsPersona = st.executeQuery("SELECT * FROM PERSONAS "
								+ "WHERE nombre = '"+p.getNombre()+"';");
						rsPersona.next();
					}
					
					st.executeUpdate("INSERT INTO REL_EXP_PERS(id_expediente, id_persona)"
							+ "VALUES("+rsExpediente.getInt("id_expediente")+", "
							+ rsPersona.getInt("id_persona")+");");
				}
			}
			throw new MiExcepcion("No se ha podido encontrar el expediente recien añadido.");
			
		} catch (ClassNotFoundException e) {
			throw new MiExcepcion("No se ha encontrado la clase");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MiExcepcion("No se ha encontrado ningun expediente");
		}
	}
	
	public static void crearExpediente(Expediente e) throws MiExcepcion {
		crearExpediente(e.getNumCaja(), e.getNumExpediente(), e.getAnno(),
						e.getSubseccion(), e.getDescripcion(), e.getPersonas());
	}
	
	public static void actualizarExpediente(Expediente oldExp, Expediente newExp) throws MiExcepcion {
		try (Connection c = BDConnection.getConnection()) {
			
			// Crear los Statements que se van a usar
			Statement st = c.createStatement();
			Statement st2 = c.createStatement();
			
			// Buscar la subseccion para usar su ID
			ResultSet subseccion = st.executeQuery("SELECT * FROM SUBSECCIONES "
					+ "WHERE subseccion = '" + newExp.getSubseccion().toString()+"';");
			subseccion.next();
			
			// Actualizar el expediente viejo con los datos del expediente nuevo
			st2.executeUpdate("UPDATE EXPEDIENTES SET"
					+ " anno_expediente = " + newExp.getAnno()
					+ ", num_expediente = " + newExp.getNumExpediente()
					+ ", id_subseccion = " + subseccion.getInt("id_subseccion")
					+ ", caja = " + newExp.getNumCaja()
					+ ", descripcion = '" + newExp.getDescripcion()
					+ "' WHERE anno_expediente = " + oldExp.getAnno()
					+ " && num_expediente = " + oldExp.getNumExpediente()+";");
			
			// Comprobar si las personas relacionadas son distintas
			if (!oldExp.getNombres().equals(newExp.getNombres())) {
				
				// Buscar el expediente nuevo para usar su ID
				ResultSet newExpBBDD = st.executeQuery("SELECT * FROM EXPEDIENTES"
						+ " WHERE anno_expediente = " + newExp.getAnno()
						+ " && num_expediente = " + newExp.getNumExpediente()+";");
				newExpBBDD.next();
				int id_expediente = newExpBBDD.getInt("id_expediente");
				
				// Borrar todas las relaciones de personas de ese expediente
				st2.executeUpdate("DELETE FROM REL_EXP_PERS"
						+ " WHERE id_expediente = "+id_expediente);
				
				// Añadir las relaciones nuevas
				for (Persona p: newExp.getPersonas()) {
					
					try { // Añadir cada persona, ignorando la excepcion ya que significa que ya existe la persona
						st2.executeUpdate("INSERT INTO PERSONAS(nombre) VALUES('"+p.getNombre()+"');");
					} catch(Exception e) {}
					
					// Buscar la persona existente o recien añadida para usar su ID
					ResultSet rs = st.executeQuery("SELECT * FROM PERSONAS WHERE nombre = '"+p.getNombre()+"';");
					rs.next();
					
					// Insertar la relacion de Expediente - Persona
					st2.executeUpdate("INSERT INTO REL_EXP_PERS(id_expediente, id_persona)"
							+ " VALUES('"+id_expediente+"', '"+rs.getInt("id_persona")+"')");
				}
			}
		
		} catch (ClassNotFoundException e) {
			throw new MiExcepcion("No se ha encontrado la clase");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MiExcepcion("No se ha encontrado el expediente viejo, esto no debería de pasar.");
		}
	}
	
	public static void borraExpediente(short numExp, short anno) throws MiExcepcion {
		try (Connection c = BDConnection.getConnection()) {
			
			// Creamos el objeto para enviar sentencias SQL
			Statement st = c.createStatement();
			
			// Buscar el expediente
			ResultSet rs = getResultSetExpediente(c, numExp, anno);
			
			// Borrar las relaciones de personas
			st.executeUpdate("DELETE FROM REL_EXP_PERS"
					+ "WHERE id_expediente = "+rs.getInt("id_expediente")+";");
			
			// Borrar el expediente
			st.executeUpdate("DELETE FROM EXPEDIENTES"
					+ "WHERE num_expediente = "+numExp+" && anno_expediente = "+anno+";");
			
		} catch (ClassNotFoundException e) {
			throw new MiExcepcion("No se ha encontrado la clase");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MiExcepcion("No se ha encontrado ningun expediente a quitar, esto no debería de pasar.");
		}
	}
	
	public static void borraExpediente(Expediente e) throws MiExcepcion {
		borraExpediente(e.getNumExpediente(), e.getAnno());
	}
	
// METODOS PRIVADOS
	private static ResultSet getResultSetExpediente(Connection c, short numExpediente, short anno) throws MiExcepcion {
		try { 
			// Creamos el objeto para enviar sentencias SQL
			Statement st = c.createStatement();
			
			// Buscar el Expediente
			ResultSet rsExpediente = st.executeQuery("SELECT * FROM EXPEDIENTES"
					+ " WHERE num_expediente = "+numExpediente+" && anno_expediente = "+anno+";");
			return rsExpediente;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MiExcepcion("No se ha encontrado ningun expediente");
		}
	}
}
