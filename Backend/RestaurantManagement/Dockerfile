FROM openjdk:latest
VOLUME /tmp
ADD /target/RestaurantManagement-1.0.jar appbk.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/appbk.jar"]