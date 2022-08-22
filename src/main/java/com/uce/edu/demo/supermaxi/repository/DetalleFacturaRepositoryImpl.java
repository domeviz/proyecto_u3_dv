package com.uce.edu.demo.supermaxi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.supermaxi.repository.modelo.DetalleFacturaS;

@Repository
@Transactional
public class DetalleFacturaRepositoryImpl implements IDetalleFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(DetalleFacturaS d) {
		// TODO Auto-generated method stub
		this.entityManager.persist(d);
	}
}
