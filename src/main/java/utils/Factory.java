package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Factory {

	private static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("bd_hotelAlura");
	
	public static EntityManager getEntityManager() {
		
		return FACTORY.createEntityManager();
		
	}
	
}
