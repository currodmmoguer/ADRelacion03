package ejercicio4;

import java.sql.SQLException;
import java.sql.Statement;

public class PersonaDao {
	
	private static PersonaDao dao;
	
	private PersonaDao() {
		
	}
	
	public static PersonaDao getDao() {
		if (dao==null)
			dao = new PersonaDao();
		
		return dao;
	}
	
	public static void insertarColumna()  {
		
		try {
			ConexionDB.getConection().setAutoCommit(false);
			Statement sentencia = ConexionDB.getConection().createStatement();
			sentencia.executeUpdate("alter table persona add tipo varchar(1)");
			sentencia.executeUpdate("update persona set tipo='P' from persona inner join profesor on persona.dni=profesor.dni");
			sentencia.executeUpdate("update persona set tipo='A' from persona inner join alumno on persona.dni=alumno.dni");
			sentencia.close();
			ConexionDB.hacerCommit();
			ConexionDB.getConection().close();
			
			
			System.out.println("Transaccion realizada");
		} catch (SQLException e) {
			ConexionDB.hacerRollback();
		} finally {
			ConexionDB.cerrarConexion();
		}
		
		
		
		System.out.println("ok");
	}
	



}
