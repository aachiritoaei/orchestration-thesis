# Use java 8 container
FROM java:8

# Set our working directory
WORKDIR /

# Copy the application from its folder to our image
ADD /target/new-api-gateway-1.0-SNAPSHOT.jar /new-api-gateway-1.0-SNAPSHOT.jar

# Run the app when the container is executed.
CMD ["java", "-jar",  "new-api-gateway-1.0-SNAPSHOT.jar"]