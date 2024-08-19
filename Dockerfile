FROM openjdk:17-jdk-slim
COPY ./build/libs/sasha_birthday_social_network-0.0.1-SNAPSHOT.jar /opt/service.jar
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://dpg-cr1cmbrqf0us73fll1mg-a:5432/greetings_8z8k
ENV POSTGRES_USER=greetings_8z8k_user
ENV POSTGRES_PASSWORD=8dscDoSEle05Gd2o4BSKOjXdQrmNI2NH
EXPOSE 8080
CMD java -jar /opt/service.jar