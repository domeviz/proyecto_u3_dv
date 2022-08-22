package com.uce.edu.demo.supermaxi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.supermaxi.repository.modelo.ProductoS;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public ProductoS buscarProducto(String codigoBarras) {
		// TODO Auto-generated method stub
		TypedQuery<ProductoS> myQuery = this.entityManager
				.createQuery("SELECT p FROM Producto p WHERE p.codigoBarras= :datoCodigo", ProductoS.class);
		myQuery.setParameter("datoCodigo", codigoBarras);
		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public int actualizarStock(String codigoBarras) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager
				.createQuery("UPDATE Producto p SET p.stock=p.stock-1 WHERE p.codigoBarras= :datoCodigo");
		myQuery.setParameter("datoCodigo", codigoBarras);
		return myQuery.executeUpdate();
	}

}
