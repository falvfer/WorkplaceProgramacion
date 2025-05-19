import java.sql.*;

/**
 * Clase que muestra un ejemplo de como establecer la conexión 
 * con una base de datos
 * 
 * @author: Rosario Olmedo
 */

public class O1_EstablecerConexion {

	public static void main(String[] args) {
		
		Connection conexion = null;
		try {
			// Registrar la conexion / Levantar el JDBC
			
	//		String driver = "com.mysql.jdbc.Driver"; // Solo es necesario para versiones
			                                       // inferiores a la 4.0 Class.forName(driver);
	//		Class.forName(driver);
	//		System.out.println("Conexion registrada");
			
			
			// Establecer la conexion
			String url = "jdbc:mysql://localhost:3306/mibase";
			String usuario = "francisco";
			String clave   = "1234";
			conexion = DriverManager.getConnection(url, usuario, clave);
			   // localhost: direccion de la maquina donde reside la base de datos
			   // 3306: puerto donde escucha la BD
			   // mibase: es la BD a la que nos conectaremos
			   // "francisco" y "1234" son usuario y clave para conectarnos a la BD

			System.out.println("Conexion establecida");
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
	public static void printSQLException(SQLException ex) {
		
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
}
