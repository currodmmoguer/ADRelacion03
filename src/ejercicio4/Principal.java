package ejercicio4;

import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) {
		
		//PersonaDao.insertarColumna();
		try {
			AsignaturaDao.mostrarAsignaturas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
