/**
 * Ejemplo que muestra información sobre las tablas que hay en la Base de Datos
 * 
 * @author Rosario Olmedo
 */

import java.sql.*;
import java.util.Properties;

public class O6_ConsultaTablas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Connection con = null;
		
		// Usamos un objeto de properties para pasar de una manera 
		// más fácil el user, password
		Properties props = new Properties();		
		props.put("user", "rosi");
		props.put("password", "1234");

		try {
			// Obtenemos la conexion a partir de la URL jdbc correspondiente
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mibase", props);

			// Creamos el objeto para enviar sentencias SQL
			Statement st = con.createStatement();

			// Enviamos una sentencia especial, para listar las tablas disponibles en la BD
			// Almacenamos el resultado para recorrerlo despues
			ResultSet rs = st.executeQuery("SHOW TABLES");

			// De esta forma vamos a saber si hay tablas o no
			boolean hayFilas = false;
			while(rs.next()) {
				hayFilas = true;
				System.out.println(rs.getString(1));
			}
			if (!hayFilas) {
				System.out.println("No hay resultados que mostrar");
			}

			// Cerramos ResultSet y Statement
			rs.close();
			st.close();

		} 
		catch (SQLException e) {			
			e.printStackTrace();
		} 
		finally {
			if (con != null)
				try {
					con.close();
				} 
			catch (SQLException e) {					
				e.printStackTrace();
			}
		}
	}
}
