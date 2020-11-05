[![Build Status](https://travis-ci.org/ricardohsmello/ricas-financas.svg?branch=main)](https://travis-ci.org/ricardohsmello/ricas-financas)
[![Coverage Status](https://coveralls.io/repos/github/ricardohsmello/ricas-financas/badge.svg?branch=main)](https://coveralls.io/github/ricardohsmello/ricas-financas?branch=main)

# Ricas Finanças

## Built With

- [`Java 11`](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html/) - Language
- [`Spring-boot`](https://spring.io/projects/spring-boot) - Framework
- [`ArchUnit`](https://www.archunit.org) - Unit test your Java architecture 

 # Usage
## Cloning the repo

First of all we need clone the repo:
```
$ git clone https://github.com/ricardohsmello/ricas-financas.git
```
## Running sonarqube 

```
$ cd jacoco-sonarqube-spring-boot
$ docker-compose up -d
$ mvn sonar:sonar -Dsonar.projectKey=br.com.ricas:ricas-financas -Dsonar.host.url=http://localhost:7000
```

If everything its correct, the sonar will be available on: 

```
http://localhost:7000/
```

![Sonarqube](https://s1.imghub.io/9QW8d.png)

## Running Jacoco

```
$ mvn clean test
$ cd jacoco-sonarqube-spring-boot/target/site/jacoco

```

![Jacoco](https://s1.imghub.io/9lJvu.png)
