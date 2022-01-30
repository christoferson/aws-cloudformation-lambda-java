
Example Lambda Layer for Java 11

To package the jar to upload as Lambda Layer:
Create java/lib
Copy target/java-lambda-11-layer-0.0.1.jar to java/lib folder
Zip the java folder

To reference this Layer library from the application project, add the following dependency:
		<dependency>
			<groupId>demo</groupId>
			<artifactId>java-lambda-11-layer</artifactId>
			<version>0.0.1</version>
			<scope>provided</scope>
		</dependency>
Note that the scope is 'provided' as the dependency will be provided by the Layer registered in AWS.		