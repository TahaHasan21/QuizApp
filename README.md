# Quiz App API

This is a simple quiz application built using Spring Boot. The application provides API endpoints for starting a quiz session, fetching random questions, submitting answers, and getting a summary of answered questions.

## Features

- Start a new quiz session
- Get a random multiple-choice question
- Submit answers for questions
- Get a summary of the quiz session with correct/incorrect answers

## Assumptions

- The app is seeded with two questions in the H2 database.
- The app assumes only one user (session) at a time.
- The questions are multiple-choice with options A, B, C, and D.
- H2 Database is used for simplicity.

## Prerequisites

Before running the app, ensure you have the following installed:

- **Java 11 or higher**: The app is built with Java.
- **Maven**: To build the app (or use an IDE like IntelliJ IDEA or Eclipse with Maven support).
- **Postman** or any API client for testing the APIs (optional).

## Steps to Run the App

### 1. Clone the Repository

```bash
git clone https://github.com/TahaHasan21/QuizApp.git
cd quiz-app
```

### 2. Install Dependencies
If you have Maven installed, you can build and install the dependencies with:

```bash
mvn clean install
```

Alternatively, if you use an IDE like IntelliJ IDEA, simply open the project as a Maven project, and the dependencies will be automatically resolved.

### 3. Database Configuration
The app uses an **`H2 Database`** for storing questions and quiz session data. The H2 database is embedded in the application and is initialized when the app starts.

#### H2 Configuration in *`application.properties`*
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.jpa.show-sql=true
```

### 3. Run the Application
You can run the Spring Boot application by executing the following command:

```bash
mvn spring-boot:run
```

Alternatively, you can run it directly from your IDE by running the QuizAppApplication.java class.

### 5. Testing the API Endpoints
You can use Postman or curl to test the following API endpoints:

#### Start a New Quiz Session
- Method: POST
- Endpoint: /api/quiz/start
- Response: { "sessionId": <generated_session_id> }

#### Get a Random Question
- Method: GET
- Endpoint: /api/quiz/question
- Response:


```json
{
  "id": 1,
  "questionText": "What is the capital of France?",
  "optionA": "Paris",
  "optionB": "Berlin",
  "optionC": "London",
  "optionD": "Madrid",
  "correctAnswer": "A"
}
```

#### Submit an Answer
- Method: POST
- Endpoint: /api/quiz/submit
- Parameters:
  **`sessionId`**: The session ID returned from the start endpoint.
  **`questionId`**: The ID of the question.
 **`answer`**: The answer choice (A, B, C, or D).

- Example:
  ```bash
  POST /api/quiz/submit?sessionId=1&questionId=1&answer=B
  ```
- Response: Answer submitted successfully!

#### Get Quiz Session Summary

- Method: GET
- Endpoint: /api/quiz/summary?sessionId=<session_id>
- Response:
```json
{
  "id": 1,
  "totalQuestions": 1,
  "correctAnswers": 0,
  "incorrectAnswers": 1
}

```

### 6. Example Flow
#### 1. Start a Quiz Session:
- Make a *`POST`* request to *`/api/quiz/start`* to get a sessionId.
#### 2. Get a Question:
- Make a *`GET`* request to *`/api/quiz/question`* to get a random question.
#### 3. Submit an Answer:
- Make a *`POST`* request to *`/api/quiz/submit`* with the *`sessionId`*, *`questionId`*, and your selected answer.
#### 4. Get the Summary:
- After submitting answers, make a *`GET`* request to *`/api/quiz/summary`* with your *`sessionId`* to see how many questions were answered correctly/incorrectly.

