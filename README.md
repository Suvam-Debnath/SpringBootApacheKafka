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
