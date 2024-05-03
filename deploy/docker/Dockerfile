# Use an official Java runtime as a parent image
FROM openjdk:8-jre-alpine

# Set the working directory to /app
WORKDIR /app

ENV active_profile="QA"
# Copy the jar file into the container at /app
ADD coop-master-data-0.0.1.jar /app

# Run jar file when the container launches
CMD ["java", "-jar","-Durl.config-server=http://172.15.100.151:8888","-Dspring.profiles.active=${active_profile}","-XX:MinHeapFreeRatio=10","-XX:MaxHeapFreeRatio=70","-XX:CompressedClassSpaceSize=64m","-XX:ReservedCodeCacheSize=64m","-XX:MaxMetaspaceSize=256m","-Xms256m","-Xmx750m","coop-master-data-0.0.1.jar","--server.port=8080"]