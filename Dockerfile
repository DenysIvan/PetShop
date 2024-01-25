FROM openjdk:17-jdk
CMD ["./gradlew", "clean", "build"]
WORKDIR /app
COPY build/libs/petshop-app.jar /app/petshop-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/petshop-app.jar"]
