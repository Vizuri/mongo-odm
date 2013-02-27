package com.vizuri.mongo.odm.hibernateogm.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.vizuri.mongo.odm.hibernateogm.model.Product;

@Stateless
public class ProductService {
	@Inject
	private Logger log;

	@PersistenceContext(unitName = "vizuri-mongo-ogm")
	private EntityManager em;
	
	public void saveProduct(Product product) {
		em.persist(product);
	}
	
	public Product findById(String id) {
		try {
			return em.find(Product.class, id);
		} catch (Exception ex) {
			log.error("Could not find product with id: "  + id + "; " + ex.getMessage());
		}
		return null;
	}
}
