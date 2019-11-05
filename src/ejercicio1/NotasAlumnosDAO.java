package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NotasAlumnosDAO {

	private static final String URL = "jdbc:sqlite:db/Ejercicio1/BDEjercicio1.db";
	private static final String DRIVER = "org.sqlite.JDBC";
	private Connection conexion;

	public NotasAlumnosDAO() throws SQLException, ClassNotFoundException {
		Class.forName(DRIVER);
		conexion = DriverManager.getConnection(URL);

	}

	public void restarNotaPorFaltas() throws SQLException {
		String dni, asignatura;
		int nota;
		ResultSet resultAlumnos, resultNotas;
		Statement sentenciaAlumnos, sentenciaNota, sentenciaActualizar;

		sentenciaAlumnos = conexion.createStatement();
		sentenciaNota = conexion.createStatement();
		sentenciaActualizar = conexion.createStatement();
		
		resultAlumnos = sentenciaAlumnos.executeQuery("select * from alumnos where faltas > 20");

		while (resultAlumnos.next()) {
			dni = resultAlumnos.getString("dni");
			

			resultNotas = sentenciaNota.executeQuery("select * from notas where dni = '" 
					+ dni + "'");

			while (resultNotas.next()) {

				nota = resultNotas.getInt("nota");
				asignatura = resultNotas.getString("asig");

				sentenciaActualizar.executeUpdate(
						"update notas set nota = " + (nota -1) + " where dni = '" + dni + 
						"' and nota > 0 and asig = '" + asignatura + "'");
			}

		}

		sentenciaAlumnos.close();
	}

	public String mostrarNotas() throws SQLException {
		StringBuilder datos = new StringBuilder();
		ResultSet result;

		Statement sentencia = conexion.createStatement();
		result = sentencia.executeQuery("select * from notas;");

		while (result.next()) {
			datos.append("Alumno: " + result.getString("dni") + "\tAsignatura: " + result.getString("asig")
					+ "\t\tNota: " + result.getInt("nota") + "\n");
		}

		sentencia.close();

		return datos.toString();

	}

	public void cerrarConexion() throws SQLException {
		if (conexion != null)
			conexion.close();
	}
}
