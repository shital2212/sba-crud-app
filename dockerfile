FROM openjdk:17               
ADD SpringBootAppWithMySqlDB1-1-0.0.1-SNAPSHOT.jar SpringBootAppWithMySqlDB1-1-0.0.1-SNAPSHOT.jar 
ENTRYPOINT ["java","-jar","SpringBootAppWithMySqlDB1-1-0.0.1-SNAPSHOT.jar"]   
EXPOSE 8080      