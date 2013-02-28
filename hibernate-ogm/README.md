## Hibernate OGM in Action
**NOTE:  For most of the code examples, we will only show relevant snippets. The complete project is available via the [Vizuri Mongo-ODM Github repository](https://github.com/Vizuri/mongo-odm).** 
### Prerequisites
The standard set of tools will be used as part of our evaluation:   
	* [Apache Maven](http://maven.apache.org)  
	* [Eclipse](http://www.eclipse.org) (or your favorite [I](http://www.jetbrains.com/idea/)  [D](http://netbeans.org/)  [E](http://www.gnu.org/software/emacs/))  
	* [MongoDB](http://www.mongodb.org) - Setup Instructions are available [here](http://docs.mongodb.org/manual/tutorial/)  

#### JBoss Configuration
In order to run our example, we need to run in a modfied version of JBoss Application Server.  There are already a few examples of doing this using OpenShift ([here](https://openshift.redhat.com/community/blogs/configuring-hibernateogm-for-your-jboss-app-using-mongodb-on-openshift-paas)) and another good example that has the user download the Hibernate OGM source ([here](https://community.jboss.org/wiki/PortingSeamHotelBookingExampleToOGM)).  The [official documentation](http://docs.jboss.org/hibernate/ogm/4.0/reference/en-US/html_single/) has and example that runs without a container.

 In the interest of showing another option, we are going to use the Beta2 version of Hibernate OGM which is available in a public repo, and includes a pre-configured module that can be simply dropped into a JBoss AS 7.1.1 instance.

We'll get setup using the following steps:

* Install a fresh JBoss AS 7.1.1 instance by [downloading](http://www.jboss.org/jbossas) and extracting the archive which will create a folder named 'jboss-as-7.1.1.Final'.   We will refer to the path to this folder as $JBOSS_HOME.
* Download the [Hibernate OGM Beta2 JBoss Module](https://repository.jboss.org/nexus/content/groups/public-jboss/org/hibernate/ogm/hibernate-ogm-modules/4.0.0.Beta2/) and extract this into the $JBOSS_HOME directory.   This archive will update the main hibernate module and create a new ogm hibernate module to support the framework.  Because of this, you should not use this modified version for other projects as this Hibernate module may cause you issues.
* We need to make a temporary directory for the Lucence indexes to work in, and this is currently set to '/tmp/.hibernate_ogm_demo_luceneindexes'.   This directory is set in the persistence.xml if you wish to use a different location.


### Running the Example
For the impatient, we can make a long story short (too late?) by first running through the example.  First we need to start JBoss and mongo:

**Mongo Server**

First of all, we need our Mongo server instance running, we will just run the instance without modification:

	* $MONGO_HOME/bin/mongod (*nix/mac)
	* %MONGO_HOME%\bin\mongod.bat (Windows)

**JBoss**

We will need a running instance of JBoss AS7 in order to run the examples, the Maven plugin allows us to run integration tests (Arquillian) and to deploy the application using Maven commands.  

	* $JBOSS_HOME/bin/standalone.sh (*nix/mac)
	* %JBOSS_HOME%\bin\standalone.bat (Windows)


**Mongo Shell**

In order to check our progress, we will connect to the Mongo shell as well:

	* $MONGO_HOME/bin/mongo (*nix/mac)
	* %MONGO_HOME%\bin\mongo (Windows)

The data created from this demonstration will be in the database called "hibernate-ogm-test".  We can see what databases are available in the Mongo shell using "show dbs".   Our test database shouldn't exist yet, this will be created after we run our test.

**Example Code**

Clone the project and switch over to the hibernate project:

	git clone https://github.com/Vizuri/mongo-odm.git
	cd mongo-odm/hibernate-ogm
	
	
**Run the Arquillian Test**

For no additional cost (this week only!), the example project features an [Arquillian](http://arquillian.org/) test to quickly see if we're on the right track.   Arquillian allows us to perform integration tests in the manner we are used to performing unit tests:

* The necessary components are packaged into a WAR in memory using ShrinkWrap
* This artifact is deployed to our running application server
* Our test code is executed with the pass fail semantics we are used to in either JUnit or TestNG
* The test application is undeployed

All of this happens very quickly and is every bit as slick as you are imagining.

To run the test:

	mvn -Parq-jbossas-remote clean test
	
We should be able to log into the Mongo shell and see that a test record was created:

	$mongo
	>use hibernate-ogm-test
	>db.Quote.find()
	
You should see some records similar to the following:

{ "_id" : "486d89ca-083e-4942-aae2-f0c53b954e30", "quoteNumber" : "arquillian-1234-1361724546806", "quoteVers" : "V1361724546806", "shipping" : "Shipping!" }

**Run the Application**

To deploy the actual web application, issue the following command (JBoss must be running to deploy, and Mongod must be running to test out the application):

	mvn clean jboss-as:deploy
	
You can insert another row into the collection by visiting:

	http://localhost:8080/hibernate-ogm/querytest
	
If that works well, open the default page:

	http://localhost:8080/hibernate-ogm/
	
To see a listing of the quotes and enter new quotes.
