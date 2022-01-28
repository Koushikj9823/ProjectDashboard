FROM openjdk:8
EXPOSE 8080
ADD target/project-task-tracker.jar project-task-tracker.jar
ENTRYPOINT ["java","-jar","/project-task-tracker.jar"]
