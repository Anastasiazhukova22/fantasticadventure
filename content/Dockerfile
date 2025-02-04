FROM openjdk:21
COPY ./content/target/content-3.3.2.jar app.jar
#app.jar - название нашего файла, которое будет в докере (можем назвать как хотим)
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8081
