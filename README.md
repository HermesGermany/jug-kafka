# jug-kafka

This sample project was created for the JavaUserGroup Meetup on 28.03.2019 at Hermes.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

In order to run the examples you will need:

* Java 8
* Maven
* Docker and docker-compose

### Installing

After cloning this project you have to create a runnable jar for:
* SpringKafkaConsumer
* SpringKafkaProducer

To do so run the following command for each application:
```
mvn package
```

After the jars are created, you can run the whole project with:
```
docker-compose up
```

After docker-compose is finished with creating the containers and ready to run them, you will have:
* One ZooKeeper-Server running at: localhost:2181
* One Kafka-Server running at: localhost:9092
* One Producer-Service running at: localhost:9090
* One Consumer-Service running at: localhost: 9091
* One Webfrontend for producing messages at: localhost:8080
* One Webfrontend for consuming messages at: localhost:8081

## Author

Flah-Uddin Ahmad - [Xing](https://www.xing.com/profile/FlahUddin_Ahmad2)
