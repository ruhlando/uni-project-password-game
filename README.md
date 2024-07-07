# uni-project-password-game

## Project Overview

This project is a password validation game inspired by Neal's [Password Game](https://neal.fun/password-game/). It is 
implemented using Java as the backend and utilizes Spring Boot for the web application. The application involves a series 
of rules that a password must meet, and these rules are validated in parallel using multithreading.

## Features (Requirements University)

- **Parallelism**: Rules are validated in parallel using `ExecutorService` and `Future`.
- **Generics**: Used in the `RuleHandler` class to ensure type safety.
- **Algorithm Implementation**: Each rule involves specific validation logic (e.g., summing digits in a password to check if they equal 42).
- **Special Algorithm**: The `ContainsDopamineSymbolRule` uses the Boyer-Moore algorithm for efficient pattern searching.
- **Interface Usage**: A `Rule` interface defines the contract for all password validation rules.


## Requirements for Execution

- Java 21 or higher
- A web browser to test the WebSocket functionality

## Requirements for Development

- IntelliJ 2024.1.4
- [Maven](https://maven.apache.org/index.html)

## Project Structure

- `validation.interfaces`: Contains the `Rule` interface.
- `validation.rules`: Contains individual rule classes implementing the `Rule` interface.
- `validation.algorithms`: Contains the implementation of the Boyer-Moore algorithm.
- `validation`: Contains the `RuleHandler` class which manages the rule validation process.
- `webSocket`: Contains the `Message` class and `WebSocketMessageHandler` class for handling WebSocket messages.
- `UniProjectPasswordGameApplication`: The main class to run the Spring Boot application.

## How to Run

1. **Clone the Repository**

   ```bash
   git clone <https://github.com/ruhlando/uni-project-password-game.git>
   cd uni-project-password-game

2. **Build the Project**

   ```bash
   mvn clean, compile and package
   
3. **Run the Application**
   - navigate to target folder

   ```bash
   java -jar ./uniProjectPasswordGame-0.0.1-SNAPSHOT.jar

4. **Test the Application & have fun :)**

   ```bash
   1. Open a web browser
   2. Connect to WebSocket Endpoint: http://localhost:8080/

## Special Algorithm: Boyer-Moore

The `ContainsDopamineSymbolRule` class uses the Boyer-Moore algorithm to efficiently search for the pattern of 
the chemical formula for dopamine within the password. The Boyer-Moore algorithm is known for its efficiency in string 
searching by skipping sections of the text, thus reducing the number of comparisons needed.

### Boyer-Moore Algorithm Overview

- **Bad Character Table**: A table is built to determine how far the pattern can shift when a mismatch occurs.
- **Search Process**: The algorithm compares the pattern from the end to the start and uses the bad character table to 
- skip sections of the text where mismatches occur.

  

   