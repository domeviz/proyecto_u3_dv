package com.uce.edu.demo.supermaxi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.supermaxi.repository.modelo.FacturaS;

@Repository
@Transactional
public class FacturaSRepositoryImpl implements IFacturaSRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void crear(FacturaS f) {
		// TODO Auto-generated method stub
		this.entityManager.persist(f);
	}

	@Override
	public void actualizar(FacturaS f) {
		// TODO Auto-generated method stub
		this.entityManager.merge(f);
	}
}
