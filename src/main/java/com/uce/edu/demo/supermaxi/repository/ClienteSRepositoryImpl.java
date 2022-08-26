package com.uce.edu.demo.supermaxi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.supermaxi.repository.modelo.ClienteS;

@Repository
@Transactional
public class ClienteSRepositoryImpl implements IClienteSRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crear(ClienteS c) {
		// TODO Auto-generated method stub
		this.entityManager.persist(c);
	}

	@Override
	public ClienteS buscar(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<ClienteS> myQuery = this.entityManager
				.createQuery("SELECT c FROM ClienteS c WHERE c.cedula= :datoCedula", ClienteS.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}
}
