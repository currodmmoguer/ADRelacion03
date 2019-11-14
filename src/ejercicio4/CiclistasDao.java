package ejercicio4;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CiclistasDao {
	
	private static CiclistasDao dao;
	
	public CiclistasDao() {
		
	}
	
	public static CiclistasDao getDao() {
		if (dao==null)
			dao = new CiclistasDao();
		
		return dao;
	}
	
	public static double getEdadMedia() throws SQLException {
		double media;
		Statement sentencia = ConexionDB.getConexion().createStatement();
		ResultSet result = sentencia.executeQuery("select avg(edad) from ciclista");
		result.next();
		media = result.getDouble(0);
		sentencia.close();
		return media;
	}

}
