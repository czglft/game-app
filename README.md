# Game App

## Overview

The Game App is a Spring-based service that serves as a simple user profile matcher. It extracts player profiles from a
database, matches them with current campaign settings, and updates profiles based on certain conditions.

## Features

- **Profile Matching:** The app matches player profiles with current campaign conditions.
- **Campaign Data:** Mocked API service returns campaign data for matching.
- **RESTful API:** Provides a RESTful API for retrieving client configurations.

## Technologies Used

- **Spring Boot:** Framework for building Java-based enterprise applications.
- **Couchbase:** NoSQL database used for storing player profiles.
- **Docker:** Containerization for easy deployment.
- **IntelliJ HTTP Client:** Convenient tool for testing HTTP endpoints.

## How to Run Locally

To run the app with the `prod` profile locally, follow these steps:

1. **Couchbase Setup:**
    - Make sure you have a Couchbase Server running on `localhost:8091`.
    - Create a bucket named `Players`.
    - Set up a Couchbase user with the required permissions and note down the username and password, set as "user" and "
      password" for defaults.

2. **Build & run the Application:**
   ```bash
   git clone https://github.com/czglft/game-app.git
   cd game-app
   ./mvnw spring-boot:run -Dspring-boot.run.profiles=prod 

## How to Run with Docker

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/czglft/game-app.git
   cd game-app
2. **Build the Docker Image:**

    ```bash
    docker-compose build

3. **Run the Docker Containers:**
      ```bash
    docker-compose up -d

## Run the app
1. **Access the API:**

The API will be available at http://localhost:8080.

2. **Test Endpoints:**

Use the IntelliJ HTTP client, cURL, Postman or any other tool to test the endpoints. See call-game-api.http for an example.

## Ideas for Extension

* Additional Matchers: Extend the matching logic with new matchers, such as time-based matchers, user behavior matchers,
etc.
* User Authentication: Implement user authentication to secure access to the API.
* Dynamic Campaign Management: Allow the dynamic creation and management of campaigns.
* Monitoring and Analytics: Integrate monitoring tools or analytics for tracking user interactions.
