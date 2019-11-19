package ejercicio3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EtapaDao {
	
	private static EtapaDao dao;
	
	public EtapaDao() {
		
	}
	
	public static EtapaDao getDao() {
		if (dao == null) 
			dao = new EtapaDao();
		
		return dao;
	}
	
	public static void ciclistasGanadores() throws SQLException {
		Statement sentencia = ConexionDB.getConexion().createStatement();
		ResultSet result = sentencia.executeQuery("SELECT COUNT(e.netapa), c.nombre, e.dorsal from etapa AS e INNER JOIN ciclista AS c ON c.dorsal=e.dorsal GROUP by e.dorsal");
		while (result.next()) {
			System.out.println("Nombre del ciclista: " + result.getString(2) + "\tTotal etapas ganadas: " + result.getInt(1));
			System.out.println("\tNº Etapa\tSalida\tLlegada");
			etapasGanador(result.getInt(3));
			System.out.println();
		}
		sentencia.close();
	}
	
	public static void etapasGanador(int dorsal) throws SQLException {
		Statement sentencia = ConexionDB.getConexion().createStatement();
		ResultSet result = sentencia.executeQuery("select netapa, salida, llegada from etapa where dorsal = " + dorsal);
		while (result.next()) {
			System.out.println("\t" + result.getInt(1) + "\t\t" + result.getString(2) + "\t" + result.getString(3));
		}
		sentencia.close();
	}

}
