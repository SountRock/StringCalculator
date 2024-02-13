FROM openjdk:latest
WORKDIR /user/source/prog
COPY ./src/main/java .
RUN javac -sourcepath . -d out ./org/example/Main.java
WORKDIR /user/source/prog/out
#CMD java -classpath . org.example.Main
ENTRYPOINT ["java", "org.example.Main"]