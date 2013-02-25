package com.vizuri.mongo.odm.hibernateogm.service;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.exporter.ZipExporter;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.DependencyResolvers;
import org.jboss.shrinkwrap.resolver.api.maven.MavenDependencyResolver;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.vizuri.mongo.odm.hibernateogm.model.Quote;
import com.vizuri.mongo.odm.hibernateogm.util.Resources;

@RunWith(Arquillian.class)
public class QuoteServiceTest {
	@SuppressWarnings("deprecation")
	@Deployment
	public static WebArchive createTestArchive() {
	      WebArchive webArchive = ShrinkWrap.create(WebArchive.class, "hibernate-ogm-test.war")
				.addPackage(Quote.class.getPackage())
				.addClass(QuoteService.class)
				.addClass(SearchCriteria.class)
				.addClass(Resources.class)
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
				.addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"), "beans.xml")
				.addAsLibraries(
	                  DependencyResolvers.use(MavenDependencyResolver.class)
	                        .loadReposFromPom("pom.xml")
	                        .artifacts("org.apache.avro:avro", "org.hibernate:hibernate-search",
	                        		"org.hibernate:hibernate-core", "org.hibernate.ogm:hibernate-ogm-core", 
	                        		"org.hibernate.ogm:hibernate-ogm-infinispan", "org.hibernate.ogm:hibernate-ogm-mongodb")
	                        .resolveAs(JavaArchive.class)
	            );
	      
	      webArchive.as(ZipExporter.class).exportTo(new File("target/hibernate-ogm-test.war"));
	      
	      return webArchive;
	}
	
	@EJB
	private QuoteService quoteService;
	
	@Inject
	private Logger log;
	
	@Test
	public void testQuotePersist() {
		Quote quote = new Quote();
		quote.setQuoteNumber("arquillian-1234-" + (new Date()).getTime());
		quote.setQuoteVers("V" + (new Date()).getTime());
		
		try {
			quote.setShipping("Shipping!");
			quoteService.createOrUpdate(quote);
		} catch (Exception ex) {
			log.error("Could not persist quote: ", ex);
		}
	}
	
	
	@Test
	public void testSearchQuotes() {
		List<Quote> results = quoteService.findQuotesByCriteria(new SearchCriteria());
		
		log.info("Found: " + results.size() + " quotes using blank search criteria.");
		
		for (Quote quote : results) { 
			log.info("Quote: " + quote.toString());
		}
		
	}
	
	// JPA type queries are not supported yet
	/*@Test
	public void testGetQuotes() {
		Potential potential = new Potential();
		potential.setAccntName("1234");
		potential.setContact(new Contact());
		potential.setPotentialOwner("Owner");
		List<Quote> quotes = quoteService.findQuotesByPotential(potential);
		log.info("Found: " + (quotes != null ? quotes.size() : 0) + " quotes.");
	}*/
	
}
