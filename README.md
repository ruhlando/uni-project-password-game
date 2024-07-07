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

## Special Algorithm: Boyer-Moore

The `ContainsDopamineSymbolRule` class uses the Boyer-Moore algorithm to efficiently search for the pattern of
the chemical formula for dopamine within the password. The Boyer-Moore algorithm is known for its efficiency in string
searching by skipping sections of the text, thus reducing the number of comparisons needed.

### Boyer-Moore Algorithm Overview

- **Bad Character Table**: A table is built to determine how far the pattern can shift when a mismatch occurs.
- **Search Process**: The algorithm compares the pattern from the end to the start and uses the bad character table to
- skip sections of the text where mismatches occur.

## Project Structure

- `validation.interfaces`: Contains the `Rule` interface.
- `validation.rules`: Contains individual rule classes implementing the `Rule` interface.
- `validation.algorithms`: Contains the implementation of the Boyer-Moore algorithm.
- `validation`: Contains the `RuleHandler` class which manages the rule validation process.
- `webSocket`: Contains the `Message` class and `WebSocketMessageHandler` class for handling WebSocket messages.
- `UniProjectPasswordGameApplication`: The main class to run the Spring Boot application.

## Requirements for Execution

- Java 21 or higher
- Maven
- A web browser to test the WebSocket functionality

## Installation Instructions

### Step 1: Install Java

Make sure you have Java 21 or higher installed. You can download it from the [official Oracle website](https://www.oracle.com/java/technologies/downloads/) 
or use a package manager like `sdkman`, `brew`, `apt`, etc.

### Step 2: Install Maven

#### On Linux and macOS

1. **Download and extract Maven:**
   - Go to the [Apache Maven download page](https://maven.apache.org/download.cgi).
   - Download the binary zip archive and extract it to your desired location.

2. **Add Maven to the PATH:**
   - Open your shell configuration file (`.bashrc`, `.bash_profile`, or `.zshrc`):
     ```bash
     nano ~/.bashrc
     ```
   - Add the following line, replacing `/path/to/apache-maven-3.9.8` with the actual path:
     ```bash
     export PATH=/path/to/apache-maven-3.9.8/bin:$PATH
     ```
   - Save and close the file, then apply the changes:
     ```bash
     source ~/.bashrc
     ```
Here you can find detailed instructions: (https://www.digitalocean.com/community/tutorials/install-maven-mac-os)

#### On Windows

1. **Download and extract Maven:**
   - Go to the [Apache Maven download page](https://maven.apache.org/download.cgi).
   - Download the binary zip archive and extract it to your desired location.

2. **Add Maven to the PATH:**
   - Open the Start Search, type in "env", and select "Edit the system environment variables".
   - In the System Properties window, click on the "Environment Variables" button.
   - In the Environment Variables window, find the "Path" variable in the "System variables" section, and select it. Click on the "Edit" button.
   - Click "New" and add the path to the `bin` directory of your Maven installation (e.g., `C:\path\to\apache-maven-3.9.8\bin`).
   - Click "OK" to close all the windows.

Here you can find detailed instructions: (https://phoenixnap.com/kb/install-maven-windows)

### Step 3: Verify Maven Installation

Open a new terminal or command prompt and run:
   ```bash
    mvn -version
   ```

## How to Run

1. **Clone the Repository**

   ```bash
   git clone https://github.com/ruhlando/uni-project-password-game.git
   ```
   ```bash
   cd uni-project-password-game
   ```

2. **Build the Project**
- Use Maven to build the project
   ```bash
   mvn clean install
   ```
   
3. **Run the Application**
- Start the Spring Boot application
   ```bash
   mvn spring-boot:run

4. **Test the Application & have fun :)**
 - Open a web browser
 - Connect to WebSocket Endpoint: http://localhost:8080/

  

   