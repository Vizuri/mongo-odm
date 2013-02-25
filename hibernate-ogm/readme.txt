** Note: this example requires a modified version of the application server
	Basically need to update the Hibernate to 4.1.8 or higher and add a module with the OGM dependencies
	Instructions here (with older version numbers mentioned): http://in.relation.to/Bloggers/UsingADifferentPersistenceProviderWithAS701

	Should see if this example could be reworked using this approach: https://openshift.redhat.com/community/blogs/configuring-hibernateogm-for-your-jboss-app-using-mongodb-on-openshift-paas


Only works in Arquillian test, the normal JUnit tests fail with class not found exceptions.

JPA QL type queries are not supported yet, it uses Lucene to search the collections, and these
will require a folder on the filesystem to generate these.  This is configured in the persistence.xml
and is currently set to: /tmp/.sat_lucenindexes

To run the example:

1. Start a mongod instance locally (or update persistence.xml to location of server)

2. Start a AS7/EAP6 instance running locally on standard ports (or update pom.xml for the arq-jbossas-remote profile.)

3. Run tests with: mvn -Parq-jbossas-remote clean test

4. Run "application" : mvn clean package jboss-as:deploy

   (a) Navigate to http://localhost:8080/sat-datastore-hibernate-ogm/querytest
   (b) Should insert a new row in Quote collection every time the page loads.
