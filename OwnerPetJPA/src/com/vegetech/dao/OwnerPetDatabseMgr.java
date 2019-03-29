package com.vegetech.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OwnerPetDatabseMgr {
	private OwnerPetDatabseMgr() {

	}
	private static EntityManagerFactory emFactory = null;
	private static EntityManager em = null;
	public final static EntityManager getJPAConnection() {
		if(em != null && em.isOpen()) {
			System.out.println("EntityManager is open so no need to create again");
		} else {
			emFactory = Persistence.createEntityManagerFactory("OwnerPetJPA");
			em = emFactory.createEntityManager();
		}
		System.out.println("em"+em);
		return em;
	}
}