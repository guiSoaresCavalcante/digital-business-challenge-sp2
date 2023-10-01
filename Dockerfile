FROM openjdk:17

COPY target/PLusoft-0.0.1-SNAPSHOT.jar /app/PLusoft.jar

CMD ["java", "-jar", "/app/PLusoft.jar"]

# porta que a aplicacao ira utilizar
EXPOSE 8383