FROM openjdk:11
EXPOSE 8080
ADD target/midterm.jar midterm.jar
ENTRYPOINT ["java","-jar","/midterm.jar"]

