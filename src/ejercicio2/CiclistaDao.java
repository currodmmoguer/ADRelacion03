package ejercicio2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CiclistaDao {

	private static CiclistaDao dao;

	private CiclistaDao() throws SQLException {
		
	}

	public CiclistaDao getDao() throws SQLException {
		if (dao == null)
			dao = new CiclistaDao();

		return dao;
	}

	public static int obtenerDorsal(String nombre) throws SQLException {
		Statement sentenciaDorsal = ConexionDB.getConexion().createStatement();
		ResultSet resultDorsal = sentenciaDorsal.executeQuery("select * from ciclista where nombre='" + nombre + "'");
		resultDorsal.next();
		int dorsal = resultDorsal.getInt("dorsal");
		sentenciaDorsal.close();

		return dorsal;
	}

}
