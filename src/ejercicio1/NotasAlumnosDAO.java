package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NotasAlumnosDAO {

	private Connection conexion;

	public NotasAlumnosDAO(Connection conexion) throws SQLException, ClassNotFoundException {
		this.conexion = conexion;
		
	}

	public void restarNotaPorFaltas() throws SQLException {
		String dni;
		ResultSet resultAlumnos;
		Statement sentenciaAlumnos,  sentenciaActualizar;

		sentenciaAlumnos = conexion.createStatement();
		sentenciaActualizar = conexion.createStatement();
		
		resultAlumnos = sentenciaAlumnos.executeQuery("select * from alumnos where faltas > 20");

		while (resultAlumnos.next()) {
			dni = resultAlumnos.getString("dni");

			sentenciaActualizar.executeUpdate(
					"update notas set nota = nota-1 where dni = '" + dni + 
					"' and nota > 0");
		}

		sentenciaAlumnos.close();
		sentenciaActualizar.close();
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


}
