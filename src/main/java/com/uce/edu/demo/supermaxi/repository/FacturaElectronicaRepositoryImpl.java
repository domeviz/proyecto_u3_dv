package com.uce.edu.demo.supermaxi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.supermaxi.repository.modelo.FacturaElectronicaS;

@Repository
@Transactional
public class FacturaElectronicaRepositoryImpl implements IFacturaElectronicaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void insertar(FacturaElectronicaS f) {
		// TODO Auto-generated method stub
		this.entityManager.persist(f);
	}
	
}
