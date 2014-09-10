RESTful Java Client for <a href="http://votesmart.org">VoteSmart</a> API.
=========
This program is a RESTful Client API for the <a href="http://votesmart.org">VoteSmart.org Website.</a>
The <a href="http://api.votesmart.org/docs/">VoteSmart Documentation</a> site has 
additional information and terms of use.
The typical user will typically use the classes in the org.votesmart.classes package.
Java version 1.6 at a minimum is required. No additional jars are required.

Version 1.1.1 has been put in <a href="http://search.maven.org/#browse">The Central Repository</a>.

If you are using maven, then you can add this to your project .pom file to include this client:

    <dependency>
        <groupId>org.votesmart</groupId>
        <artifactId>votesmart-client</artifactId>
        <version>1.1.1</version>
    </dependency>

Otherwise, you can get everything from the <a href="https://github.com/karlnicholas/votesmart/releases">releases</a> tab above or go to <a href="http://search.maven.org/#browse">The Central Repository</a> website and download from there.

Examples
========
Examples are in the <a href="https://github.com/karlnicholas/votesmart/tree/master/src/main/java/examples">examples</a> directory.

    examples/Example.java
    examples/AllThingsCalifornia.java
    examples/AllThingsMissouri.java
    examples/PoliticalExperience.java
    examples/SalientTopics.java
