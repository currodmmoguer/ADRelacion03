package ejercicio4;

import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) {
		try {
			System.out.println("Edad media de los ciclistas: " + CiclistasDao.getEdadMedia());
			System.out.println("Ciclistas con edades supetiores a la media");
			System.out.println("Nombre ciclista\t\t\tEdad");
			CiclistasDao.ciclistasMayoresMedia();
			System.out.println();
			EtapaDao.ciclistasGanadores();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
