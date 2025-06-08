package bd;

//Importación de clases necesarias para manejar la conexión con la base de datos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.MiExcepcion;

public class BDConnection {

	 // URL que indica la ubicación de la base de datos MySQL (nombre: supermercado)
	 private static final String URL = "jdbc:mysql://localhost:3306/expedientes";
	
	 // Usuario con el que se accede a la base de datos
	 private static final String USER = "francisco";
	
	 // Contraseña del usuario para acceder a la base de datos
	 private static final String PASSWORD = "1234";
	
	 public static Connection getConnection() throws SQLException, ClassNotFoundException, MiExcepcion {
	     // Carga el driver JDBC de MySQL (solo necesario en algunas versiones de Java)
	     Class.forName("com.mysql.cj.jdbc.Driver");
	
	     try {
	         // Intenta establecer una conexión
	         Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
	         System.out.println("Se ha registrado una conexión."); // Mensaje de confirmación por consola
	         return conexion; // Devuelve la conexión abierta
	     } catch (Exception e) {
	         // Si falla la conexión, lanza una excepción personalizada con un mensaje
	         // amigable
	         throw new MiExcepcion("No se ha podido conectar a la base de datos.");
	     }
	 }
	 
	public static String mostrarBBDD() {
		
		// Cadena a devolver
		StringBuilder str = new StringBuilder();
		
		try (Connection c = getConnection()) {
			
			// Objeto statement para ejecutar las consultas
			Statement st = c.createStatement();

			str.append("\nPERSONAS _______________________________________________________\n");
			
			// Buscar todas las personas
			ResultSet rs = st.executeQuery("SELECT * FROM PERSONAS;");
			
			// Añadir cada persona a la cadena
			while (rs.next())
				str.append("ID: "+rs.getInt("id_persona")+" - NOMBRE: "+rs.getString("nombre")+"\n");

			str.append("\nEXPEDIENTES ____________________________________________________\n");
			
			// Buscar todos los expedientes
			rs = st.executeQuery("SELECT * FROM EXPEDIENTES;");
			
			// Añadir cada expediente a la cadena
			while (rs.next())
				str.append("Exp: "+rs.getInt("num_expediente")+"/"+rs.getInt("anno_expediente")
						+ ", C: " + rs.getInt("caja")+"\n");
				
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return "No se ha encontrado la clase";
		} catch (SQLException e) {
			e.printStackTrace();
			return e.getMessage();
		} catch (MiExcepcion e) {
			e.printStackTrace();
			return e.getMessage();
		}
		
		return str.toString();
	}
	
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