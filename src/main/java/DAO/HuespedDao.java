package DAO;

import javax.persistence.EntityManager;

import models.Huesped;

public class HuespedDao {

	private EntityManager em;
	
	public HuespedDao(EntityManager em) {
		this.em = em;
	}
	
	public void guardarHuesped(Huesped huesped) {
		this.em.persist(huesped);
	}
	
}
