package ejercicio4;

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

	public static void hacerCommit() {
		try {
			if (conexion != null)
				conexion.commit();
		} catch (SQLException e) {
			System.err.println("No se ha podido insertar la transacción.");
		}
	}

	public static void hacerRollback() {
		try {
			if (conexion != null)
				conexion.rollback();
		} catch (SQLException e1) {
			System.err.println("Error");
		}
	}

}
