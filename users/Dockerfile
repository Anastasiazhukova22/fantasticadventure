FROM openjdk:21
EXPOSE 8081
RUN pwd
COPY /target/users-3.3.2.jar users.jar
ENTRYPOINT ["java","-jar","/users.jar"]
