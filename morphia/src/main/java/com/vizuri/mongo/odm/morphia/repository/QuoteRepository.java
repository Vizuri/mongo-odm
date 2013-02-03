package com.vizuri.mongo.odm.morphia.repository;

import java.util.Iterator;
import java.util.regex.Pattern;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.google.code.morphia.emul.org.bson.types.ObjectId;
import com.mongodb.Mongo;
import com.vizuri.mongo.odm.morphia.model.Quote;

public class QuoteRepository extends BasicDAO<Quote, ObjectId> {
	public QuoteRepository(Mongo mongo, Morphia morphia, String dbName) {
		super(mongo,morphia,dbName);
	}

	public Iterator<Quote> findByQuoteNumber(String quoteNumber) {
		Pattern regExp = Pattern.compile(quoteNumber + ".*", Pattern.CASE_INSENSITIVE);
        return ds.find(entityClazz).filter("quoteNumber", regExp).iterator();	
	}
}
