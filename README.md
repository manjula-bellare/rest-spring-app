# rest-spring-app

# About
rest-mysql codebase walks you through creating RESTful web service, connect and create persistent models in the MySQL database.

# Setup MySQL Database
Assumption: Docker environment is available locally.
- docker compose up

# Build
- ./gradlew clean build

# Run the application
- ./gradlew bootRun

# Test the application

``curl http://localhost:8080/api/resources/upload -F name=@/{relative filePath}/``

``curl http://localhost:8080/api/resources/user?id={persisted userId}``

# Create Docker Image
- ./gradlew bootBuildImage

# Run the application in Docker
- docker run --network container:{MySQL_Container} {ImageName}
