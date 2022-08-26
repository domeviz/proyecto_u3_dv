package com.uce.edu.demo.supermaxi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.supermaxi.repository.modelo.FacturaElectronicaS;

@Repository
@Transactional
public class FacturaElectronicaSRepositoryImpl implements IFacturaElectronicaSRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	//EN REPOSITORY LA NOTACION DE LOS MÉTODOS DE LA TRANSACCION SIEMPRE ES MANDATORY
	@Transactional(value = TxType.MANDATORY)
	public void insertar(FacturaElectronicaS f) {
		// TODO Auto-generated method stub
		this.entityManager.persist(f);
	}
	
}
