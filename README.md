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
