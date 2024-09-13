# JACK SPARROW ai

![jack](https://i.giphy.com/medai/v1.Y2lkPTc5MGI3NjExZGU1Z2ZkbDlremVoajk4a3h3Z2Q2NnVhdTAycmw5N2VjYWJxNmFjNSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/8JCwuk8n2Y6iI/giphy.gif)

---

## About this little project:

It's a project with to practices integration of Spring ai with Ollama.
This project contains a chat backend and compose to run Ollama ai locally.

---

## Features:

- `POST` localhost:8080/v1/chat
  - `BODY`:
      ``` CURL
      curl --location 'http://localhost:8080/v1/chat' \
      --header 'Content-Type: application/json' \
      --data '{
      "message": "quantos anos voce tem???"
      }' 
      ```
    
---

## Stacks:

- Spring 3.3.3
- Kotlin and Java 21
- Ollama and Llama3.1
- Docker and Docker Compose