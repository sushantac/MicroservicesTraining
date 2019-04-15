FROM java:8
VOLUME /tmp
EXPOSE 8081
COPY ./target/planning-1.0.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch planning-1.0.jar'
ENTRYPOINT ["java","-jar","planning-1.0.jar"]