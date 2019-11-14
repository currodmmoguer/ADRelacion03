package ejercicio4;

public class EtapaDao {
	
	private static EtapaDao dao;
	
	public EtapaDao() {
		
	}
	
	public static EtapaDao getDao() {
		if (dao == null) 
			dao = new EtapaDao();
		
		return dao;
	}

}
