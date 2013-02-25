package com.vizuri.mongo.odm.hibernateogm.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.vizuri.mongo.odm.hibernateogm.model.Quote;
import com.vizuri.mongo.odm.hibernateogm.service.QuoteService;
import com.vizuri.mongo.odm.hibernateogm.service.SearchCriteria;

@Path("/quotes")
@Stateless
public class QuoteEndpoint {
	@Inject
	private Logger logger;

	@EJB
	private QuoteService service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/search/{criteria}")
	public Response searchQuotes(@PathParam(value = "criteria") String criteria){
		logger.info("Searching quotes with criteria: " + criteria);
		List<Quote> results = service.findQuotesByCriteria(criteria);
		logger.info("Found: " + (results == null ? "no" : String.valueOf(results.size())) + " results");
		return Response.ok(results).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAllQuotes() {
		logger.info("Listing all quotes");
		List<Quote> results = service.findQuotesByCriteria(new SearchCriteria());
		logger.info("I asked for all quotes and " + (results == null ? " all I got was a lousy null." : "I got " + results.size() + " results."));
		return Response.ok(results).build();
	}
	
	@PUT
	@Consumes("application/json")
	public Response createQuote(Quote quote) {
		try {
			service.createOrUpdate(quote);
			logger.info("Created new quote with id: " + quote.getId());
			return Response.ok(quote).build();
		} catch (Exception ex) {
			logger.error("Error saving quote: ", ex);
		}
		return Response.serverError().build();
	}
	
	@DELETE
	@Path("/{quoteId}")
	public Response removeQuote(@PathParam(value="quoteId") String quoteId) {
		logger.info("Received request to remove quote id: " +  quoteId);
		return Response.ok().build();
	}
}
