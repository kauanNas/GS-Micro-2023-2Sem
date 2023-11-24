FROM maven:3.6.3-openjdk-17-slim AS MAVEN_TOOL_CHAIN

WORKDIR /tmp/
COPY . .

RUN mvn clean install -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=MAVEN_TOOL_CHAIN /tmp/target/backend-0.0.1-SNAPSHOT.jar $CATALINA_HOME/webapps/backend-0.0.1-SNAPSHOT.jar
WORKDIR $CATALINA_HOME/webapps/
ENTRYPOINT [ "java","-jar", "backend-0.0.1-SNAPSHOT.jar"  ]
EXPOSE 80
