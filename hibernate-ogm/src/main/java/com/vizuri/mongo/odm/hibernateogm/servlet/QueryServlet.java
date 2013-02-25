package com.vizuri.mongo.odm.hibernateogm.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.vizuri.mongo.odm.hibernateogm.model.Quote;
import com.vizuri.mongo.odm.hibernateogm.service.QuoteService;

@WebServlet(value = "/querytest")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private QuoteService quoteService;
	
	@Inject
	private Logger log;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Writer writer = resp.getWriter();
		writer.write("Hi there...");
		
		Quote quote = new Quote();
		quote.setQuoteNumber("1234-" + (new Date()).getTime());
		quote.setQuoteVers("V" + (new Date()).getTime());
		
		try {
			quote.setShipping("Shipping!");
			quoteService.createOrUpdate(quote);
			writer.write("Completed!");
		} catch (Exception ex) {
			writer.write("Barf! (" + ex.getMessage() + ")");
			log.error("Could not persist quote: ", ex);
		}
		
	}
	
	

}
