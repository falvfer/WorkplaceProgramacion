import java.io.*;
import java.sql.*;
import java.util.Scanner;

/**
 * Clase que muestra un ejemplo de como crear y cargar con datos desde un
 * fichero la tabla Banco
 * 
 * En esta versión la carga de datos se realiza de forma parametrizada
 * para evitar los ataques de hacker mediante "SQL INJECTION"
 * 
 * @author: Rosario Olmedo
 */

public class O4_OperacionesTablaBancoV2Parametrizada {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Connection conexion = null;
		try {
			String url      = "jdbc:mysql://localhost:3306/mibase";
  	        String login    = "rosi";
		    String password = "1234";
			
			conexion = DriverManager.getConnection(url, login, password);
			         
			System.out.println("Conexion establecida");
			creaTablaBanco(conexion, "mibase");  // Crea la tabla
			cargaTablaBanco(conexion, "mibase"); // Añade datos
			consultaBanco(conexion);             // Consulta los datos
			getMetaData(conexion);               // Obtiene la estructura de la tabla
		}
		
		catch (SQLException e2) {
			printSQLException(e2); 
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();;
			}
		}
	}
	
	/**
	 * 
	 * @param con: Conexion
	 * @param BDNombre: Nombre de la base de datos
	 * 
	 * Crea la tabla EQUIPOS
	 */
	public static void creaTablaBanco(Connection con, String BDNombre) throws SQLException
	{
  	    String creaTabla =
				 "create table " + BDNombre + ".BANCO " +
                 "(client VARCHAR(100) NOT NULL, "  +
                 "password VARCHAR(20) NOT NULL, " +
                 "balance INT NOT NULL, " +
                 " PRIMARY KEY(client))";
   	    
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(creaTabla);
			System.out.println("Tabla BANCO creada.");
		}
		catch(SQLException e) {
			printSQLException(e);
		}
		finally {
			stmt.close();
		}
	}

		
	/**
	 * @throws IOException  
	 * A�ade datos desde un fichero a la tabla BANCO
	 * @param con
	 * @param BDNombre
	 * @throws  
	 */
	public static void cargaTablaBanco(Connection con, String BDNombre) throws SQLException
	{
		String client, password;
		int balance;
		
		
		try (Scanner sc = new Scanner(new File("./datos.txt"))){
		  
		   do {
			   // Lee del fichero los datos de un cliente (nombre, clave, balance)
		       client = sc.nextLine();   
		       password = sc.nextLine();
		       balance = Integer.parseInt(sc.nextLine());        
	       
		       String sqlString = "INSERT INTO Banco VALUES (?,?,?)";
		       
		       PreparedStatement ps = con.prepareStatement(sqlString);
		       ps.setString(1,client);
		       ps.setString(2, password);
		       ps.setInt(3, balance);
		       
		       ps.executeUpdate();
		       ps.close();

		       sc.nextLine(); // Guiones "------"
		      }
	  	   while (sc.hasNextLine()); 
		} // end try 
		catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}
	}
	
	/**
	 * Realiza una consulta de todos los datos de la tabla BANCO
	 * @throws SQLException
	 */
	public static void consultaBanco(Connection con) throws SQLException 
	{

	 //    String sqlString = "SELECT client, password, balance FROM BANCO";
	     String sqlString = "SELECT * FROM BANCO";
	     Statement statement = con.createStatement();
	     ResultSet rs = statement.executeQuery(sqlString);

	     while (rs.next()) {
	         System.out.println(rs.getString("client") + " " + 
	                            rs.getString("password") + " " +
	                            rs.getInt("balance"));
	                           
	     
	         System.out.println(rs.getString(1) + " " + 
                     rs.getString(2) + " " +
                     rs.getInt(3));
	      }     
	     statement.close();
	}

	/**
	 * Muestra la estructura de la tabla banco
	 * @param con
	 * @throws SQLException
	 */
	public static void getMetaData(Connection con) throws SQLException {

	    String sqlString = "SELECT * FROM BANCO";
	    Statement statement = con.createStatement();
	    ResultSet rs = statement.executeQuery(sqlString); 
	    
	    ResultSetMetaData metaData = rs.getMetaData();
	    int noColumns = metaData.getColumnCount();
	    for (int i=1; i<=noColumns; i++) {
	        System.out.println(metaData.getColumnName(i) 
	                           + " " +
	                           metaData.getColumnType(i));
	    }
	    statement.close();
	}

	
	/**
	 * 
	 * Muestra informacion mas detallada sobre una excepcion tipo SQLException
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

	
}


 
	
   

