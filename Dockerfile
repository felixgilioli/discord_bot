FROM openjdk:11.0.11-jre-slim-buster
ADD /build/libs/discordbot-1.0-SNAPSHOT.jar discordbot.jar
ENTRYPOINT ["java", "-jar", "discordbot.jar"]