package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NotasAlumnosDAO {

	private static final String URL = "jdbc:sqlite:db/Ejercicio1/DBEjercicio1.db";
	private static final String DRIVER = "org.sqlite.JDBC";
	private Connection conexion;
	
	public NotasAlumnosDAO() throws SQLException, ClassNotFoundException {
		Class.forName(DRIVER);
		conexion = DriverManager.getConnection(URL);
		
	}
	
	public void restarNotaPorFaltas() {
		
	}
	
	public String mostrarNotas() {
		
		
		
		
		return null;
		
	}
	
	public void cerrarConexion() throws SQLException {
		if (conexion != null)
			conexion.close();
	}
}
