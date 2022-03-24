FROM openjdk:11
ADD target/person-example-0.0.1-SNAPSHOT.jar person-example-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "person-example-0.0.1-SNAPSHOT.jar"]

FROM mysql:5.8
RUN chown -R mysql:root /var/lib/mysql/

ARG MYSQL_DATABASE
ARG MYSQL_USER
ARG MYSQL_PASSWORD
ARG MYSQL_ROOT_PASSWORD

ENV MYSQL_DATABASE=testdb
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=root
ENV MYSQL_ROOT_PASSWORD=root

ADD person.sql /etc/mysql/person.sql
RUN sed -i 's/MYSQL_DATABASE/'$MYSQL_DATABASE'/g' /etc/mysql/person.sql
RUN cp /etc/mysql/person.sql /docker-entrypoint-initdb.d

EXPOSE 3306