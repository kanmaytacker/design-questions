# Getting Started

## Creating a database

1. Connect to PSQL -
```
> psql

psql (14.4, server 14.5 (Homebrew))
Type "help" for help.

kingk=#
```
2. Create a database
```
kingk=# create database splitwise;
CREATE DATABASE
```

3. Create a role
```
kingk=# create user splitwise_user;
CREATE ROLE
```

4. Grant privileges
   Type "help" for help.
```
kingk=# grant all privileges on database splitwise to splitwise_user;
GRANT
```

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#using.devtools)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#appendix.configuration-metadata.annotation-processor)

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

