package ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	
	private static Connection conexion;
	
	private ConexionDB() throws SQLException {
		conexion = DriverManager.getConnection("jdbc:mysql://localhost/ciclistas", "root", "");
	}
	
	public static Connection getConexion() throws SQLException {
		if (conexion == null)
			new ConexionDB();
		
		return conexion;
	}

}
