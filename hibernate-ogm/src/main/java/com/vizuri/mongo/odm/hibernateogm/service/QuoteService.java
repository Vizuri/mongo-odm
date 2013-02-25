package com.vizuri.mongo.odm.hibernateogm.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.query.DatabaseRetrievalMethod;
import org.hibernate.search.query.ObjectLookupMethod;
import org.hibernate.search.query.dsl.QueryBuilder;

import com.vizuri.mongo.odm.hibernateogm.model.Potential;
import com.vizuri.mongo.odm.hibernateogm.model.Quote;

@Stateless
public class QuoteService {
	@Inject
	private Logger log;

	@PersistenceContext(unitName = "vizuri-mongo-ogm")
	private EntityManager em;
	
	@Inject
	private Provider<FullTextEntityManager> lazyFEM;
	
	public void createOrUpdate(Quote quote) throws Exception {
		log.info( "Updating 1234-" + quote.getQuoteNumber() + " version " + quote.getQuoteVers() + " for potential: " + quote.getPotentialId());
		String modifiedQuoteNumber = "1234-" + quote.getQuoteNumber(); // So we can fake a search for all
		quote.setQuoteNumber(modifiedQuoteNumber);
		em.persist( quote );
	}
	
	@SuppressWarnings("unchecked")
	public List<Quote> findQuotesByPotential(Potential potential) {
		log.info("Looking up quotes by: " + potential);
		try {
			return em.createQuery("select q from Quote q where q.potentialId = :potentialName")
							.setParameter("potentialId", potential.getPotentialName())
							.getResultList();
		} catch (Exception ex) {
			log.error("Thar she blows", ex);
		}
		return null;
	}
	
	public List<Quote> findQuotesByCriteria(String criteria) {
		try {
			SearchCriteria searchCriteria = new SearchCriteria();
			searchCriteria.setQuery(criteria);
			return findQuotesByCriteria(searchCriteria);
		} catch (EntityNotFoundException enfe) {
			log.info("Look ma, no results for: " + criteria);
		}
		return Collections.emptyList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Quote> findQuotesByCriteria(final SearchCriteria criteria) {
	    FullTextEntityManager em = lazyFEM.get();
	    List<Quote> quotes = new ArrayList<Quote>();
	 
	    final QueryBuilder builder = em.getSearchFactory().buildQueryBuilder()
	            .forEntity(Quote.class).get();
	 
	    final Query luceneQuery = 
	    		builder.keyword()
	    			.onField("quoteNumber")
	    			.matching(criteria.getSearchPattern())
	    			.createQuery();
	 
	    log.debug("Lucene query: " + luceneQuery.toString());
	 
	    final FullTextQuery query = em.createFullTextQuery(luceneQuery, Quote.class);
	    query.initializeObjectsWith(ObjectLookupMethod.SKIP,
	            DatabaseRetrievalMethod.FIND_BY_ID);
	 
	    final List<Quote> results = query
	            .setFirstResult(criteria.getFetchOffset())
	            .setMaxResults(criteria.getFetchSize()).getResultList();
	 
	    boolean nextPageAvailable = results.size() > criteria.getPageSize();
	    if (nextPageAvailable) {
	        // NOTE create new ArrayList since subList creates unserializable list
	        quotes = new ArrayList<Quote>(results.subList(0, criteria.getPageSize()));
	    } else {
	        quotes = results;
	    }
	    
	    return quotes;
	}

}
