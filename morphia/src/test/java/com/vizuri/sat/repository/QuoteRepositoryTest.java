package com.vizuri.sat.repository;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.vizuri.mongo.odm.morphia.model.Quote;
import com.vizuri.mongo.odm.morphia.repository.QuoteRepository;
import com.vizuri.mongo.odm.morphia.util.MongoHelper;

public class QuoteRepositoryTest {
	private final static Logger LOGGER = Logger
			.getLogger(QuoteRepositoryTest.class);
	private static final String DBNAME = "sat";
	private static final String QUOTE_NUMBER = "SomeNumberViaMorphia-001";

	private Mongo mongo;
	private Morphia morphia;
	private QuoteRepository quoteRepository;

	@Before
	public void init() {
		mongo = MongoHelper.initialize();
		morphia = new Morphia();
		morphia.map(Quote.class);
		quoteRepository = new QuoteRepository(mongo, morphia, DBNAME);
	}

	private void countRecords() {
		long counter = quoteRepository.count();
		LOGGER.debug("The count is [ " + counter + " ]");
	}
	
	@Test
	public void testFindByQuoteNumber() {
		Iterator<Quote> existingQuotes = quoteRepository.findByQuoteNumber(QUOTE_NUMBER);

		while( existingQuotes.hasNext()) {
			LOGGER.debug("Quote Found: " + existingQuotes.next().toString());
		}
	}

	@Test
	public void testSaveQuote() {
		countRecords();
		
		Quote quote = new Quote();
		quote.setQuoteNumber(QUOTE_NUMBER);

		quoteRepository.save(quote);

		countRecords();
	}

	@Test
	public void testDeleteQuote() {
		countRecords();
		Iterator<Quote> existingQuotes = quoteRepository.findByQuoteNumber(QUOTE_NUMBER);
		
		while (existingQuotes.hasNext()) {
			quoteRepository.delete(existingQuotes.next());
		}
		countRecords();
	}

}
