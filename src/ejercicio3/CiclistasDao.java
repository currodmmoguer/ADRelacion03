package ejercicio3;

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
		media = result.getDouble(1);
		sentencia.close();
		return media;
	}
	
	public static void ciclistasMayoresMedia() throws SQLException {
		Statement sentencia = ConexionDB.getConexion().createStatement();
		ResultSet result = sentencia.executeQuery("SELECT `nombre`, `edad`, `nomeq` FROM `ciclista` WHERE `edad` > (SELECT AVG(edad) FROM `ciclista`)");
		
		while (result.next()) {
			System.out.println(result.getString(1) + "\t\t\t" + result.getInt(2));
		}
		
		sentencia.close();
	}

}
