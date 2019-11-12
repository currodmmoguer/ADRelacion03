package ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MaillotDao {
	
	private static MaillotDao dao;
	
	private MaillotDao() throws SQLException {
	}
	
	public static MaillotDao getMaillotDao() throws SQLException {
		if (dao == null)
			dao = new MaillotDao();
		
		return dao;
	}
	
	public static void insertarMaillotMontanna(String nombreMaillot, int netapa) throws SQLException {
		PreparedStatement sentenciaInsertar = ConexionDB.getConexion().prepareStatement("insert into llevar values (?, ?, ?)");
		sentenciaInsertar.setInt(1, CiclistaDao.obtenerDorsal(nombreMaillot));
		sentenciaInsertar.setInt(2, netapa);
		sentenciaInsertar.setString(3, "MMO");
		sentenciaInsertar.executeUpdate();
		sentenciaInsertar.close();
		
		
	}
	


}
