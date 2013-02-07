package com.vizuri.mongo;


import java.net.UnknownHostException;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.vizuri.mongo.odm.morphia.model.Product;

public abstract class BasePersistenceTest {
	private static final transient Logger LOG = Logger.getLogger(BasePersistenceTest.class);
	private static final String TEST_DB = "odm";
	protected Datastore dataStore;
	protected Morphia morphia;
	protected Mongo mongo;
	
	@Before
	public void setup() {
		try {
			mongo = new Mongo();
			morphia = new Morphia();
			dataStore = morphia.createDatastore(mongo,TEST_DB);
			morphia.mapPackage(Product.class.getPackage().getName());
			dataStore.ensureIndexes();
		} catch (UnknownHostException e) {
			LOG.error("Could not connect to mongo instance: ", e);
		} catch (MongoException e) {
			LOG.error("Mongo error: ", e);
		}
	}
	
	@After
	public void testDown() {
		try {
			mongo.close();
		} catch (Exception e) {
			LOG.error("Could not tear down mongo connection: ", e);
		}
	}
	
}
