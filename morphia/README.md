# Morphia Example
This demonstrates retrieving and storing Quotes from a MongoDB datastore using the Morphia framework.

[Morphia](http://code.google.com/p/morphia/) is a lighter weight framework for mapping Java objects from / to [MongoDB](http://mongodb.org/).  Unlike [Spring Data](http://www.springsource.org/spring-data) and [Hibernate OGM](http://www.hibernate.org/subprojects/ogm.html), Morphia only works with Mongo.

Recently there have been a lot of presentations around the use of Morphia to manage POJOs with MongoDB.  Some good presentations by 10Gen to take a look at are:

[MongoDB on the JVM](http://www.slideshare.net/mongodb/webinar-mongodb-on-the-jvm)  
[Simplifying Persistence for Java and MongoDB](http://www.slideshare.net/mongodb/webinar-simplifying-persistence-for-java-and-mongodb)



## Running
For a MongoDB guide see http://www.mongodb.org/display/DOCS/Quickstart

Your MongoDB instance should be listening on the default port.

From the commandline run:

$ mvn clean package
