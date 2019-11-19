package ejercicio4;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AsignaturaDao {
	
	private static AsignaturaDao dao;
	
	private AsignaturaDao() {
		
	}
	
	public static AsignaturaDao getDao() {
		if (dao==null)
			dao = new AsignaturaDao();
		
		return dao;
	}
	
	public static void mostrarAsignaturas() throws SQLException {
		Statement sentencia = ConexionDB.getConection().createStatement();
		ResultSet result = sentencia.executeQuery("SELECT A.Idasignatura, A.Nombre, COUNT(AA.Idalumno) FROM asignatura AS A "
				+ "INNER JOIN alumno_asignatura AS AA on A.Idasignatura=AA.Idasignatura "
				+ "GROUP BY AA.Idasignatura ORDER BY COUNT(AA.Idalumno) DESC");
		ResultSet resultAlumnos;
		
		while (result.next()) {
			System.out.println("ID ASIGNATURA: " + result.getString(1) + "\tNOMBRE ASIG: " + result.getString(2) + "\tNº DE ALUMNOS: " + result.getInt(3));
			System.out.println("DNI\t\tApellidos\tNombre");
			
			resultAlumnos = sentencia.executeQuery("SELECT p.dni, p.apellido, p.nombre FROM persona AS p "
					+ "INNER JOIN alumno AS a ON p.dni=a.dni "
					+ "INNER JOIN alumno_asignatura AS aa ON aa.Idalumno=a.idalumno "
					+ "WHERE aa.Idasignatura = '" + result.getString(1) + "' "
					+ "ORDER BY p.Apellido");
			
			while (resultAlumnos.next()) {
				System.out.println(resultAlumnos.getString(1) + "\t" + resultAlumnos.getString(2) + "\t\t" + resultAlumnos.getString(3));
			}
			resultAlumnos.close();
		
		}
		result.close();
	}
	
	

}
