package ejercicio4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	
	private static final String URL = "jdbc:mysql://localhost/academia";
	private static final String USER = "root";
	private static final String PWD = "";
	private static Connection conexion;
	
	private ConexionDB() throws SQLException {
		conexion = DriverManager.getConnection(URL, USER, PWD);
	}
	
	public static Connection getConection() throws SQLException {
		if (conexion==null)
			new ConexionDB();
		
		return conexion;
	}
	
	public static void cerrarConexion() {
		if (conexion != null) {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void hacerCommit() {
		try {
			if (conexion != null)
				conexion.commit();
		} catch (SQLException e) {
			System.err.println("No se ha podido insertar la transacción.");
		}
	}

	public static void hacerRollback() {
		System.out.println("No se ha podido hacer la transaccion");
		try {
			if (conexion != null)
				conexion.rollback();
		} catch (SQLException e1) {
			System.err.println("Error en el rollback");
		}
	}
	

}
