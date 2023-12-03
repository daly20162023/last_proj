FROM openjdk:8
EXPOSE 8089
WORKDIR /DevOps_Project
COPY target/devops-integration.jar /DevOps_Project/
ENTRYPOINT ["java", "-jar", "devops-integration.jar"]