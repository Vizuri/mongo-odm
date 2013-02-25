package com.vizuri.mongo.odm.hibernateogm.util;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;

public class Resources {
	@PersistenceContext(unitName = "vizuri-mongo-ogm")
	EntityManager em;
	
	@Produces
	public FullTextEntityManager getFTEM() {
		return Search.getFullTextEntityManager(em);
	}
	
	@Produces
    public Logger produceLog(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass());
    }
}
