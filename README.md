![Issues](https://img.shields.io/github/issues/ricardohsmello/ricas-financas) 
![Forks](https://img.shields.io/github/forks/ricardohsmello/ricas-financas) 
![Stars](https://img.shields.io/github/stars/ricardohsmello/ricas-financas) 
![Release Version](https://img.shields.io/github/release/ricardohsmello/ricas-financas)

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

## Endpoints
### GET api/finances/finance
- Response: Code 200
```
{
    "description": "Gasolina do carro x",
    "value": 128.90,
    "dateTime": "2020-11-27T16:22:42.138Z",
    "category": {             
        "type": 0,
        "name": "Combustível"
    } 
}
```

### GET api/finances/finance/findAllByType/{type}
- Response: Code 200
- Param
   - type: EXPENSE or REVENUE
- Body:
```json
[
    {
        "description": "Gasolina",
        "value": 128.9,
        "dateTime": "2020-11-27T00:00:00",
        "category": {
            "name": "Combustível",
            "type": 0,
            "uuid": "ffb822be-22f0-4793-9f4b-bcc3ad040043"
        },
        "uuid": "5c38ab57-cea6-4478-b11e-7637639092ed"
    },
    {
        "description": "Pizza dois irmaos",
        "value": 78.0,
        "dateTime": "2020-11-29T00:00:00",
        "category": {
            "name": "IFood",
            "type": 0,
            "uuid": "c9844b1f-046e-43de-9ffd-82136b51c9e0"
        },
        "uuid": "980b1fed-5bc3-457e-8b78-21a51d8a7e4a"
    }
]
```
### POST api/finances/finance
- Response: Code 201
```
{
    "description": "Primeira parcela décimo terceiro",
    "value": 1300,
    "dateTime": "2020-11-29T16:22:42.138Z",
    "category": {          
        "type": 1,
        "name": "13-salário"
    } 
}
```
