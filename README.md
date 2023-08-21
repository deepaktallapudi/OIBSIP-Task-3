# OIBSIP-Task-3

# ATM Interface in Java

Welcome to the ATM Interface project, a command-line application that simulates basic banking operations using Java! This application allows users to interact with an ATM to perform tasks such as deposits, withdrawals, balance checks, transfers, and viewing transaction history.

## Features

- **Deposit**: Users can deposit funds into their account and see the updated balance.
- **Withdraw**: Users can withdraw funds from their account, provided they have sufficient balance.
- **Check Balance**: Users can check their account balance at any time.
- **Transfer**: Users can transfer funds to another account within the ATM system.
- **Transaction History**: Users can view their transaction history, including details like date, type (deposit, withdrawal, transfer), and amount.
- **Exit**: Users can exit the application at any time.

## Classes and Functionality

The project is organized into three main classes:

1. **Transaction**: Represents a single transaction with properties like type, amount, and date. It provides a formatted string representation of the transaction.

2. **BankAccount**: Represents a bank account with user ID, balance, and transaction history. It allows for deposit, withdrawal, and transfer operations. It also maintains a history of transactions.

3. **ATM**: Represents the ATM itself. It interacts with the BankAccount class and provides options for deposit, withdrawal, balance check, transfer, and transaction history. The main logic of user interaction resides in this class.

## Getting Started

To run the ATM Interface on your local machine, follow these steps:

1. Ensure you have Java Development Kit (JDK) installed on your computer.
2. Open a terminal or command prompt.
3. Navigate to the directory containing the downloaded or cloned source code.
4. Compile the Java code using the command: `javac ATMInterface.java`
5. Run the compiled program using the command: `java ATMInterface`

## Usage

1. Upon running the application, you'll be prompted to enter the client User ID and initial balance.
2. You'll then see the ATM menu with options from 1 to 6.
3. Choose an option by entering the corresponding number.
4. Follow the prompts to perform the chosen operation.
5. You can perform multiple operations in one session.
6. To exit the application, choose option 6.


https://github.com/deepaktallapudi/OIBSIP-Task-3/assets/103422044/3a92eebf-fb9c-4721-b7bb-d79ded48b8c4

