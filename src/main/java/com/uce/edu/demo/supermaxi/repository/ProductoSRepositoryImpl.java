package com.uce.edu.demo.supermaxi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.supermaxi.repository.modelo.ProductoS;

@Repository
@Transactional
public class ProductoSRepositoryImpl implements IProductoSRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(ProductoS producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}

	@Override
	//EN REPOSITORY LA NOTACION DE LOS MÉTODOS DE LA TRANSACCION SIEMPRE ES MANDATORY
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(ProductoS producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}

	@Override
	public ProductoS buscar(String codigoBarras) {
		// TODO Auto-generated method stub
		TypedQuery<ProductoS>query=this.entityManager.createQuery("SELECT p FROM ProductoS p WHERE p.codigoBarras=: datoCodigoBarras", ProductoS.class);
		query.setParameter("datoCodigoBarras", codigoBarras);
		return query.getSingleResult();
	}
	
}
