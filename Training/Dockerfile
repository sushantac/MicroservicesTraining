FROM java:8
VOLUME /tmp
EXPOSE 8081
COPY ./target/training-1.0.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch training-1.0.jar'
ENTRYPOINT ["java","-jar","training-1.0.jar"]