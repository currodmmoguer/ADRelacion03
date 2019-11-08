package ejercicio2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class EtapaDao {
	
	private Connection conexion;
	private static EtapaDao dao;
	
	private EtapaDao() throws SQLException {
		conexion = ConexionDB.getConexion();
	}
	
	public static EtapaDao getEtapaDao() throws SQLException {
		if (dao == null)
			dao = new EtapaDao();
		
		return dao;
	}
	
	public boolean nuevaEtapa(int kms, String salida, String llegada, String ganador) throws SQLException {
		boolean insertado = true;
		
		PreparedStatement sentenciaInsertar = conexion.prepareStatement("insert into etapa values (?, ?, ?, ?, ?)");
		
		
		sentenciaInsertar.setInt(1, obtenerUltimaEtapa() + 1);
		sentenciaInsertar.setInt(2, kms);
		sentenciaInsertar.setString(3, salida);
		sentenciaInsertar.setString(4, llegada);
		sentenciaInsertar.setInt(5, obtenerDorsal(ganador));

		sentenciaInsertar.executeUpdate();
		
		sentenciaInsertar.close();
		
		return insertado;
	}
	
	private int obtenerDorsal(String nombre) throws SQLException {
		Statement sentenciaDorsal = conexion.createStatement();
		ResultSet resultDorsal = sentenciaDorsal.executeQuery("select * from ciclista where nombre='" + nombre + "'");
		resultDorsal.next();
		int dorsal = resultDorsal.getInt("dorsal");
		sentenciaDorsal.close();

		return dorsal;
	}
	
	private int obtenerUltimaEtapa() throws SQLException {
		Statement sentencia = conexion.createStatement();
		ResultSet result = sentencia.executeQuery("select max(netapa) from etapa");
		
		result.next();
		
		return result.getInt(1);
		
	}

}
