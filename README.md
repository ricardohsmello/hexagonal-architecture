![Stars](https://img.shields.io/github/stars/ricardohsmello/ricas-financas)
[![Build Status](https://travis-ci.org/ricardohsmello/ricas-financas.svg?branch=main)](https://travis-ci.org/ricardohsmello/ricas-financas)
[![Coverage Status](https://coveralls.io/repos/github/ricardohsmello/ricas-financas/badge.svg?branch=main)](https://coveralls.io/github/ricardohsmello/ricas-financas?branch=main)

# Ricas Finanças

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
