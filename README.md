# Bank Management System

## Problem Statement
The objective of this project is to develop a simple, object-oriented, console-based bank account management system. The system should allow users to securely log in to their accounts and perform common banking operations such as depositing funds, withdrawing money, transferring funds to other accounts, checking their balance, generating mini statements, and closing their accounts. It aims to demonstrate core programming principles without relying on complex, external frameworks.

## Approach / Logic Used
This application is built using Java and relies entirely on Object-Oriented Programming (OOP) concepts. The logic is divided into modular classes representing real-world banking entities:
- **`Bank`**: Acts as the central registry, managing collections of `Customer`s and overall `Transaction` logs, and providing core services like account creation and deletion.
- **`Customer`**: Represents a bank user, holding personal details, security credentials (PIN), and a list of associated `Account`s. It includes logic for user authentication.
- **`Account`**: Represents a financial account. It encapsulates the balance and contains methods for financial operations (`deposit`, `withdraw`), ensuring safety constraints (e.g., sufficient balance, frozen status).
- **`Transaction`**: A simple record-keeping class that logs details of every successful financial operation (deposits, withdrawals, transfers).
- **`MiniStatement`**: A utility class that filters the global transaction log to display recent activity for a specific account.
- **`Main`**: The entry point of the application. It initializes dummy data and runs a continuous `while` loop, providing an interactive console menu using `Scanner` for user input.

## Steps to Execute the Code

1. **Prerequisites**: Ensure you have the Java Development Kit (JDK) installed on your system.
2. **Navigate to the Project Directory**: Open your terminal or command prompt and navigate to the folder containing the `.java` files.
   ```bash
   cd path/to/BankManagement
   ```
3. **Compile the Source Code**: Compile all the Java files using the `javac` command.
   ```bash
   javac *.java
   ```
4. **Run the Application**: Execute the main class to start the console application.
   ```bash
   java Main
   ```
5. **Usage**: Use the dummy accounts provided in the code to log in:
   - Account Number: `1001`, PIN: `1234`
   - Account Number: `1002`, PIN: `5678`
   Follow the on-screen menu prompts to interact with the system.
