FROM openjdk:17-jdk-slim
COPY ./build/libs/sasha_birthday_social_network-0.0.1-SNAPSHOT.jar /opt/service.jar
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://dpg-cr1c183qf0us73flel0g-a:5432/greetings_006i
ENV POSTGRES_USER=pgreetings_006i_user
ENV POSTGRES_PASSWORD=0w3KpbWU691HEOZRxqaOb5l6Ypv92ssY
EXPOSE 8080
CMD java -jar /opt/service.jar