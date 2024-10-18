# AskMate

AskMate is a fullstack application where users can ask questions, manage them, and perform basic CRUD operations. The backend is built with Java and Spring Boot, and the frontend is built using React with Vite.

## Tech Stack

- ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
- ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
- ![React](https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB)
- ![Vite](https://img.shields.io/badge/Vite-646CFF?style=for-the-badge&logo=vite&logoColor=white)

## Prerequisites

- Java JDK (>= 11)
- Node.js (>= 14.x)
- Maven (for Java project)
- npm

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/E-Zsofi/AskMate.git
   cd AskMate
2. Backend setup:
Navigate to the backend directory:
  ```
  cd backend
```
3. Build the Spring Boot project with Maven:
```
./mvnw clean install
```
4. Start the Spring Boot server:
```
./mvnw spring-boot:run
```
5. Frontend setup:
Open a new terminal and navigate to the frontend directory:
```
cd ../frontend
```
6. Install frontend dependencies:
```
npm install
```
7. Start the Vite development server:
 ```
npm run dev
```
The frontend should now run at http://localhost:3000.

8. Backend: Ensure the Spring Boot server is running with the command:
```
cd backend
./mvnw spring-boot:run
```
