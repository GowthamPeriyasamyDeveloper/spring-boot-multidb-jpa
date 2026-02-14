
# Spring Boot Multi-Database JPA Project

A Spring Boot application designed to demonstrate connecting to and managing multiple databases (MySQL and PostgreSQL) within a single application using Spring Data JPA.

## 📋 Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Configuration](#configuration)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Running with Docker](#running-with-docker)
  - [Running Locally](#running-locally)
- [API Endpoints](#api-endpoints)

## 📖 Overview
This project solves the challenge of distributing data across different database technologies. It configures separate `EntityManagerFactory`, `DataSource`, and `TransactionManager` beans for MySQL and PostgreSQL, ensuring complete isolation between the two data sources.

## ✨ Features
* **Multi-Datasource Support:** Simultaneous connections to MySQL and PostgreSQL.
* **Isolated Configuration:** Distinct JPA configurations for Entities and Repositories for each database.
* **Docker Ready:** specific `Dockerfile` and `docker-compose.yml` for containerized environments.
* **Actuator Integration:** Health checks and monitoring enabled.

## 🛠 Tech Stack
* **Java:** 21
* **Framework:** Spring Boot
* **Databases:**
    * MySQL 8
    * PostgreSQL 15
* **Build Tool:** Maven

## 📂 Project Structure
The application uses a package-by-feature approach to separate database logic:

```text
src/main/java/io/github/gowtham/spring_boot_multidb_jpa/
├── config/             # Shared JPA configurations
├── mysql/              # MySQL domain (Config, Controller, Entity, Repo)
├── postgres/           # PostgreSQL domain (Config, Controller, Entity, Repo)
└── service/            # Service layer orchestrating calls to both DBs

```

## ⚙️ Configuration

The application uses distinct configuration prefixes to map properties to the correct datasource:

* **MySQL:** Uses prefix `mysql.datasource` and scans `...mysql.repository`.
* **PostgreSQL:** Uses prefix `postgres.datasource` and scans `...postgres.repository`.

## 🚀 Getting Started

### Prerequisites

* Java 21
* Maven
* Docker & Docker Compose

### Running with Docker

The project includes a `docker-compose.yml` that provisions the app, MySQL, and Postgres containers.

1. Build the project:
```bash
mvn clean package -DskipTests

```


2. Start the services:
```bash
docker-compose -f docker/docker-compose.yml up --build

```



### Running Locally

To run without Docker, ensure you have local MySQL and Postgres instances running with the credentials found in `src/main/resources/application-local.yml`.

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=local

```

## 🔌 API Endpoints

### MySQL (Users)

| Method | Endpoint | Description |
| --- | --- | --- |
| POST | `/api/mysql/users` | Create a User in MySQL |
| GET | `/api/mysql/users` | List all Users from MySQL |

### PostgreSQL (Employees)

| Method | Endpoint | Description |
| --- | --- | --- |
| POST | `/api/postgres/employee` | Create an Employee in Postgres |
| GET | `/api/postgres/employee` | List all Employees from Postgres |

### Health Check

* `/actuator/health`

