package ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MaillotDao {
	
	private Connection conexion;
	private static MaillotDao dao;
	
	private MaillotDao() throws SQLException {
		conexion = ConexionDB.getConexion();
	}
	
	public static MaillotDao getMaillotDao() throws SQLException {
		if (dao == null)
			dao = new MaillotDao();
		
		return dao;
	}

}
