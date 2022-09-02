## Spring Boot + Apache Kafka
1. Setup Apache Kafka
```
# Start the ZooKeeper service
# Note: Soon, ZooKeeper will no longer be required by Apache Kafka.
$ bin/zookeeper-server-start.sh config/zookeeper.properties
# Start the Kafka broker service
$ bin/kafka-server-start.sh config/server.properties
```
2. Create and Setup Spring Boot Project
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
		<groupId>org.springframework.kafka</groupId>
		<artifactId>spring-kafka</artifactId>
</dependency>
```
3. Configure Kafka Producer and Consumer
```
# Consumer
spring.kafka.consumer.bootstrap-servers: localhost:9092
spring.kafka.consumer.group-id: cGroup
spring.kafka.comsumer.auto-offset-rest: earlient
spring.kafka.comsumer.key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
#spring.kafka.comsumer.value-deserializer: org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.comsumer.value-deserializer: org.springframework.kafka.support.serializer.JsonDeserializer

# Producer
spring.kafka.producer.bootstrap-servers: localhost:9092
spring.kafka.producer.key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
#spring.kafka.producer.value-deserializer: org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.producer.value-deserializer: org.springframework.kafka.support.serializer.JsonDeserializer
```
4. Create Kafka Topic
5. Create Kafka Producer 
6. Create REST API to Send Message
7. READ THE EVENTS
```
bin/kafka-console-consumer.sh --topic name_of_topic --from-beginning --bootstrap-server localhost:9092
```
8.  Create Kafka Consumer
