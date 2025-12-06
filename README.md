**This is a lightweight, modular automation framework designed to efficiently and reliably automate end-to-end testing across multi-microservice applications.**

**FINAL ARCHITECTURE (Simple & Clean)**

┌──────────────────────────────┐
│       TestNG Test Suite      │
│  (SauceDemoTest, PetStoreTest)│
└───────────────┬──────────────┘
                │  notifies
                ▼
        LoginSubject (Observable)
                │  calls
                ▼
 ┌───────────────────────────────────┐
 │     Observers (implement interface)│
 │   ✔ KafkaObserver                 │
 │   ✔ LoggerObserver (optional)     │
 └───────────────────────────────────┘
                │
                ▼
       Sends message to Kafka
       
Playwright is only used to automate UI actions.
Kafka is used only for sending messages.
Observer Pattern connects Test → Observer → Kafka.




**How Observer + Kafka Works Between Two Services**

📍 Step-by-Step Flow

1️⃣ Service 1 receives or generates a message

Something happens inside Service 1.
For example:

User created

Order updated

Payment confirmed


2️⃣ Observer watches (observes) that event

The Observer Pattern inside Service 1 detects the change.

It works like:

Subject: Main logic of Service 1

Observer: A listener that waits for new messages/events


When the subject changes → Observer gets notified immediately.

3️⃣ Observer sends the event to Kafka

The Observer then pushes the message to a Kafka topic, for example: topic: service1.events

Kafka stores the message safely.

4️⃣ Kafka delivers the message

Kafka keeps the message and waits for a consumer.

If Service 2 is down → Kafka does not lose the message.

5️⃣ Service 2 consumes the message

Service 2 has a Kafka consumer.

When new events appear in the topic, Kafka automatically delivers them to Service 2.

Service 2 then processes the event.


---

📊 Simple Flow Diagram (Text Version)

+---------------------+
          |    Service 1        |
          |  (Event Producer)   |
          +----------+----------+
                     |
                     | 1. Event happens
                     v
             +-------+--------+
             |    Observer    |
             | (Watches S1)   |
             +-------+--------+
                     |
                     | 2. Observer sends event
                     v
         +-----------+------------------+
         |           Kafka              |
         |   (Message Broker / Topic)   |
         +-----------+------------------+
                     |
                     | 3. Kafka delivers event
                     v
           +---------+----------+
           |    Service 2       |
           |  (Event Consumer)  |
           +---------------------+
