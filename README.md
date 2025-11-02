## 📨 Spring Boot Kafka Message Passing

This is a simple **message-passing system** built using **Spring Boot** and **Apache Kafka** to demonstrate basic **producer-consumer communication**.

---

### 🔧 Overview

The project showcases how microservices (or individual applications) can communicate asynchronously using Kafka as the messaging broker.

* **Producer Application** sends messages to a Kafka topic.
* **Consumer Application** listens to the same topic and processes the incoming messages in real-time.

---

### 🧩 Tech Stack

* **Backend:** Spring Boot
* **Messaging Broker:** Apache Kafka
* **Build Tool:** Maven
* **Language:** Java
* **Containerization:** Docker

---

## ⚙️ Setup Instructions

### 1️⃣ Run Zookeeper and Kafka using Docker

Make sure Docker is installed and running on your system.

#### 🐘 Create and Run Zookeeper Container

```bash
docker run -d \
  --name zookeeper \
  -p 2181:2181 \
  -e ZOOKEEPER_CLIENT_PORT=2181 \
  confluentinc/cp-zookeeper:latest
```

#### 🦉 Create and Run Kafka Container

```bash
docker run -d \
  --name kafka \
  -p 9092:9092 \
  -e KAFKA_BROKER_ID=1 \
  -e KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 \
  -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 \
  -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 \
  --link zookeeper \
  confluentinc/cp-kafka:latest
```

✅ Verify containers:

```bash
docker ps
```

You should see both **zookeeper** and **kafka** running.

---

### 2️⃣ Access the Kafka Container Shell

To execute Kafka CLI commands inside the container:

```bash
docker exec -it kafka bash
```

Once inside the container, you can run commands like:

```bash
kafka-topics --list --bootstrap-server localhost:9092
```

---

### 3️⃣ Create a Kafka Topic (Optional)

From inside the Kafka container shell:

```bash
kafka-topics --create \
--topic my-topic \
--bootstrap-server localhost:9092 \
--partitions 1 \
--replication-factor 1
```

Verify the topic:

```bash
kafka-topics --list --bootstrap-server localhost:9092
```

---

### 4️⃣ Run the Applications

1. Ensure **Zookeeper** and **Kafka** containers are running.
2. Run the **Producer** Spring Boot application — it will send messages to Kafka.
3. Run the **Consumer** Spring Boot application — it will receive messages from Kafka.

---

### 📦 Example Message Flow

```
Producer -> Kafka Topic (my-topic) -> Consumer
```

**Producer Output:**

```
Sent message: Hello Kafka!
```

**Consumer Output:**

```
Received message: Hello Kafka!
```

---

### 📚 Summary

This project serves as a **beginner-friendly example** of integrating **Spring Boot** with **Apache Kafka** for **real-time, event-driven communication**.
It also demonstrates how to **run Kafka and Zookeeper using Docker**, making setup quick, clean, and portable.


## 📨 Passing String message

<img width="1382" height="602" alt="kafka1" src="https://github.com/user-attachments/assets/e785e954-a905-4dbb-9951-a5f73815501d" />

<img width="1920" height="1020" alt="kafka consumer " src="https://github.com/user-attachments/assets/5ee49d3a-36cf-4ac7-8d2b-604d80d1f92e" />

## 📨 Passing message as Object

<img width="1755" height="673" alt="kafka porducer send object message" src="https://github.com/user-attachments/assets/1d8ebb8a-2f93-47fb-bd69-077510758869" />

<img width="1920" height="1020" alt="kafka consumer object message " src="https://github.com/user-attachments/assets/641c06e5-ab30-4483-b7f7-682060023e71" />

<!-- Kafka CLI Commands (Click-to-Copy Section) -->
<div align="center">
  <h2>🧠 Apache Kafka CLI Commands (Docker + Localhost Setup)</h2>
  <button onclick="navigator.clipboard.writeText(document.getElementById('kafkaCommands').innerText)">📋 Copy All Commands</button>
</div>

<pre id="kafkaCommands">

🚀 Step 1: Access Kafka Container
docker exec -it <container_id> bash
# Example:
docker exec -it 955553f3ab2a bash


🧩 Step 2: Create a Kafka Topic
kafka-topics --create \
  --topic my-topic \
  --bootstrap-server localhost:9092 \
  --partitions 3 \
  --replication-factor 1
# Output:
# Created topic my-topic.


📋 Step 3: List All Topics
kafka-topics --list --bootstrap-server localhost:9092
# Example Output:
# my-topic
# txn-initiated


🔍 Step 4: Describe a Topic
kafka-topics --describe --topic my-topic --bootstrap-server localhost:9092
# Example Output:
# Topic: my-topic  PartitionCount: 3  ReplicationFactor: 1
# Partition 0 -> Leader:1, Replicas:1, Isr:1


✏️ Step 5: Start Kafka Producer (Send Messages)
kafka-console-producer --topic my-topic --bootstrap-server localhost:9092
# Type messages:
# hello kafka
# this is first message on live producer input mode


📥 Step 6: Start Kafka Consumer (Read Messages)
kafka-console-consumer --topic my-topic --bootstrap-server localhost:9092 --from-beginning
# Example Output:
# hello kafka
# this is first message on live producer input mode

</pre>

