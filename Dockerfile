FROM openjdk:8
EXPOSE 8090
ADD target/project-dashboard.jar project-dashboard.jar
ENTRYPOINT ["java","-jar","/project-dashboard.jar"]