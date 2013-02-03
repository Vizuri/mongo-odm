package com.vizuri.mongo.odm.morphia.util;

import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import com.mongodb.Mongo;

public class MongoHelper {
	private final static Logger LOGGER = Logger.getLogger(MongoHelper.class);

	private static final int port = 27017;
	private static final String host = "localhost";
	private static Mongo mongo = null;

	public static Mongo initialize() {
		if (mongo == null) {
			try {
				mongo = new Mongo(host, port);
				LOGGER.debug("New Mongo created with [" + host + "] and ["
						+ port + "]");
			} catch (UnknownHostException e) {
				LOGGER.error(e.getMessage());
			}
		}
		return mongo;
	}
}
