package com.vegetech.process;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.vegetech.dao.OwnerPetDatabseMgr;
import com.vegetech.entity.Owner;
import com.vegetech.entity.Pet;

public class DBProcessor {

/*	public static void main(String args[]) {
		System.out.println("STart main");
		DBProcessor dba = new DBProcessor();
		dba.getOwners();
		dba.getPets();
	}*/

	public List<Owner> getOwners() {
		List<Owner> ownerDataList = null;
		EntityManager em = OwnerPetDatabseMgr.getJPAConnection();
		try {
			EntityTransaction txn = em.getTransaction();
			System.out.println("Txnn:" + txn);
			if (!txn.isActive())
				txn.begin();
			String query = "select o from Owner o";
			Query queryExe = em.createQuery(query);
			ownerDataList = queryExe.getResultList();
			em.getTransaction().commit();
			System.out.println("ownerDataList:" + ownerDataList.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return ownerDataList;
	}

	public List<Pet> getPets() {
		System.out.println("getPets enter");
		List<Pet> petDataList = null;
		EntityManager em = OwnerPetDatabseMgr.getJPAConnection();
		try {
			System.out.println("Check and perform");
			EntityTransaction txn = em.getTransaction();
			System.out.println("Txnn:" + txn);
			if (!txn.isActive())
				txn.begin();
			String query = "select o from Pet o";
			Query queryExe = em.createQuery(query);
			petDataList = queryExe.getResultList();
			em.getTransaction().commit();
			System.out.println("petDataList:" + petDataList.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return petDataList;
	}

	public boolean createNewPet(Pet petObj) {
		System.out.println("createNewPet Enter");
		boolean status = true;
		EntityManager em = OwnerPetDatabseMgr.getJPAConnection();
		try {
			if (!em.getTransaction().isActive())
				em.getTransaction().begin();
			em.persist(petObj);
			em.getTransaction().commit();
			System.out.println("Insert completed");
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		} finally {
			em.close();
		}
		System.out.println("createNewPet Exit");
		return status;
	}

	public BigDecimal getOwnerDetails(String ownerName) {
		System.out.println("getOwnerDetails Enter");
		System.out.println("ownerName:"+ownerName);
		BigDecimal ownerId = null;
		EntityManager em = OwnerPetDatabseMgr.getJPAConnection();
		try {
			if (!em.getTransaction().isActive())
				em.getTransaction().begin();
			Query qry = em.createQuery("select o.id from Owner o where o.first_name='"+ownerName+"'");
			List<BigDecimal> ownerIds = qry.getResultList();
			ownerId = ownerIds.get(0);
			em.getTransaction().commit();
			System.out.println("Retrieved ownerId is:"+ownerId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		System.out.println("getOwnerDetails Exit");
		return ownerId;
	}
	
	public BigDecimal generateNewPetId() {
		System.out.println("generateNewPetId Enter");
		BigDecimal petId = null;
		EntityManager em = OwnerPetDatabseMgr.getJPAConnection();
		try {
			if (!em.getTransaction().isActive())
				em.getTransaction().begin();
			Query qry = em.createQuery("select max(p.id) from Pet p");
			System.out.println("qry.getSingleResult().toString()"+qry.getSingleResult().toString());
			petId = new BigDecimal(qry.getSingleResult().toString()).add(new BigDecimal(1));
			em.getTransaction().commit();
			System.out.println("Retrieved petId is:"+petId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		System.out.println("generateNewPetId Exit");
		return petId;
	}
}