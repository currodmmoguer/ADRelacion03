package ejercicio1;

import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) {
		
		try {
			NotasAlumnosDAO dao = new NotasAlumnosDAO();
			System.out.println(dao.mostrarNotas());
			dao.restarNotaPorFaltas();
			System.out.println();
			System.out.println(dao.mostrarNotas());
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
