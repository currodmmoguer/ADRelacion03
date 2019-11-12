package ejercicio2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EtapaDao {

	private static EtapaDao dao;

	private EtapaDao() throws SQLException {
	}

	public static EtapaDao getEtapaDao() throws SQLException {
		if (dao == null)
			dao = new EtapaDao();

		return dao;
	}

	public static int nuevaEtapa(int kms, String salida, String llegada, String ganador) throws SQLException {

		PreparedStatement sentenciaInsertar = ConexionDB.getConexion()
				.prepareStatement("insert into etapa values (?, ?, ?, ?, ?)");

		sentenciaInsertar.setInt(1, obtenerUltimaEtapa() + 1);
		sentenciaInsertar.setInt(2, kms);
		sentenciaInsertar.setString(3, salida);
		sentenciaInsertar.setString(4, llegada);
		sentenciaInsertar.setInt(5, CiclistaDao.obtenerDorsal(ganador));

		sentenciaInsertar.executeUpdate();

		sentenciaInsertar.close();

		return obtenerUltimaEtapa();
	}

	private static int obtenerUltimaEtapa() throws SQLException {
		Statement sentencia;
		int netapa = -1;

		sentencia = ConexionDB.getConexion().createStatement();
		ResultSet result = sentencia.executeQuery("select max(netapa) from etapa");
		result.next();
		netapa = result.getInt(1);
		
		sentencia.close();

		return netapa;

	}

}
