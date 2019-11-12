package ejercicio2;

import java.sql.SQLException;
import java.util.Scanner;

public class Principal {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			ConexionDB.getConexion().setAutoCommit(false);
			addNuevaEtapa();
			ConexionDB.hacerCommit();
			ConexionDB.getConexion().close();
		} catch (SQLException e) {
			ConexionDB.hacerRollback();
		}

	}

	private static void addNuevaEtapa() throws SQLException {
		int kms, netapa;
		String salida, llegada, nombre, nombreMaillot;
		try {
			
			System.out.println("Introduce los kilómetros de la etapa");
			kms = Integer.parseInt(teclado.nextLine());

			System.out.println("Introduce la salida de la etapa:");
			salida = teclado.nextLine();

			System.out.println("Introduce la llegada de la etapa:");
			llegada = teclado.nextLine();

			System.out.println("Introduce el nombre del ciclista ganador:");
			nombre = teclado.nextLine();
			
			

			netapa = EtapaDao.nuevaEtapa(kms, salida, llegada, nombre);

			System.out.println("¿Cuál ciclista ha llevado el maillot de montaña (MMO)?");
			nombreMaillot = teclado.nextLine();

			MaillotDao.insertarMaillotMontanna(nombreMaillot, netapa);
			
			

		} catch (NumberFormatException e) {
			System.err.println("Formato incorrecto");
		}
	}

}
