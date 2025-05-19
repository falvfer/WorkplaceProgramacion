import java.sql.*;

/**
 * Clase que muestra un ejemplo de como modificar datos de tablas, concretamente:
 *    -- Modifica el nombre de un equipo
 *    -- Modifica la edad de todos los jugadores
 *    -- Inserta un nuevo jugador
 * 
 * @author: Rosario Olmedo
 */

public class O5_ModificaTabla {
	public static void main(String[] args) {
		
		Connection conexion = null;
		try {
			
			// Establecer la conexion
			String url = "jdbc:mysql://localhost:3306/mibase";
			String usuario = "rosi";
			String clave   = "1234";
			conexion = DriverManager.getConnection(url, usuario, clave);

			System.out.println("Conexion establecida");
			
			// Metodo que modifica una columna en la tabla equipo
			modificaEquipo(conexion, "mibase");
			
			// Metodo que modifica la edad de los jugadores
			modificaEdadJugadores(conexion, "mibase", 2);
			
			// Metodo que inserta un nuevo jugador 
			insertaJugador(conexion, "mibase", 10, 2, "PABLO", 4, 25, "CORDOBA"); 
			
		}
		catch (SQLException e1) {
			printSQLException(e1);
		}
		catch (Exception e2) {
			e2.printStackTrace();
		}
		finally {
			try {
				conexion.close();
				System.out.println("Conexion cerrada");
			}
			catch (SQLException e) {
				printSQLException(e);
			}
		}
	}
	
	
	
	/**
	 * M�todo que muestra una descripcion completa de la excepcion
	 * que se ha producido
	 * @param ex -- Excepcion SQL generada
	 */
	public static void printSQLException(SQLException ex)
	{
		ex.printStackTrace(System.err);
		System.err.println("SQLState: "+ex.getSQLState());
		System.err.println("Error code: "+ex.getErrorCode());
		System.err.println("Message: "+ex.getMessage());
		Throwable t = ex.getCause();
		while (t!=null) {
			System.out.println("Cause: "+t);
			t = t.getCause();
		}
	}
	
	
	/**
	 * 
	 * @param con
	 * @param BDNombre
	 * @throws SQLException
	 */
	public static void modificaEquipo(Connection con, String BDNombre) 
			throws SQLException
	{
	  		Statement stmt = null;
			try {
				stmt = con.createStatement();
				stmt.executeUpdate("UPDATE " + BDNombre +
	                             ".EQUIPO SET ESTADIO='ALBORAN'" +
	                             " WHERE codEquipo = 1");
				System.out.println("Equipo actualizado");
			}
			catch(SQLException e) {
				printSQLException(e);
			}
			finally {
				stmt.close();
			}
	}

	/**
	 * Modifica la tabla JUGADORES, incrementando la edad de los jugadores en 
	 * lo que indique el par�metro "incremento", para ello utiliza ResultSet
	 * @param con
	 * @param BDNombre
	 * @param incremento
	 * @throws SQLException
	 */
	public static void modificaEdadJugadores(Connection con, String BDNombre, 
			 int incremento) throws SQLException
	{
		Statement stmt = null;
		try {
			stmt = con.createStatement(
					        ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = stmt.executeQuery(
					   "SELECT * FROM " + BDNombre + ".JUGADORES");

			while (rs.next()) {
				int i = rs.getInt("EDAD");
				rs.updateInt("EDAD", i+incremento);
				rs.updateRow();
			}
			System.out.println("Edades actualizadas");
		}
		catch(SQLException e) {
				printSQLException(e);
		}
		finally {
			stmt.close();
		}
	}
	
	/**
	 * Inserta un nuevo jugador en la Tabla Jugadores-
	 * Los datos del jugador nos llegan como par�metro.
	 * Utiliza para ello un ResultSet
	 * @param con
	 * @param BDNombre
	 * @param codJu
	 * @param codEq
	 * @param nombre
	 * @param dorsal
	 * @param edad
	 * @throws SQLException
	 */
	public static void insertaJugador(Connection con, String BDNombre, 
	          int codJu, int codEq, String nombre, int dorsal, int edad, String provin)
	        		  	throws SQLException
		{
	  		Statement stmt = null;
			try {
				stmt = con.createStatement(
						        ResultSet.TYPE_SCROLL_SENSITIVE,
								ResultSet.CONCUR_UPDATABLE);

				ResultSet rs = stmt.executeQuery(
				   "SELECT * FROM " + BDNombre + ".JUGADORES");

				rs.moveToInsertRow();
				rs.updateInt("codJugador", codJu);
				rs.updateInt("codEquipo", codEq);
				rs.updateString("nombre", nombre);
				rs.updateInt("dorsal", dorsal);
				rs.updateInt("edad", edad);
				rs.updateString("provincia", provin);
				rs.insertRow();
				rs.beforeFirst();
				System.out.println("Jugador añadido");
			}
			catch(SQLException e) {
				printSQLException(e);
			}
			finally {
				stmt.close();
			}
		}
}
