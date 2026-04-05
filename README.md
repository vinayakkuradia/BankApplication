# Bank Application SD

A Spring Boot-based bank management system demonstrating modern Java web application architecture with secure user authentication, account management, and transaction processing.

## Overview

This Bank Application is a portfolio project that showcases core banking functionality including customer management, account operations, and transaction tracking. Built with Spring Boot and Spring Security, it demonstrates enterprise-level application design patterns and best practices for a financial management system.

## Features

### Core Banking Operations
- **Customer Management** - Add, view, and update customer information with detailed personal and address data
- **Account Management** - Create and manage multiple account types (Regular Accounts and Savings Accounts)
- **Transaction Processing** - Execute deposits, withdrawals, and transfers with balance validation
- **Transaction History** - Track all account transactions with status and timestamp information
- **Account Status** - Activate/deactivate accounts with activity management

### Security & Access Control
- **User Authentication** - Secure login system with username and password validation
- **Role-Based Access Control (RBAC)** - Admin and User roles with different permission levels
- **Password Security** - Spring Security integration for secure password handling
- **Session Management** - Authenticated user sessions with automatic timeout

### Transaction Management
- **Balance Validation** - Minimum account balance enforcement
- **Fund Transfer** - Inter-account transfers with comprehensive validation
- **Transaction Status Tracking** - Monitor transaction status (Completed, Pending, Failed)
- **Approval Limits** - Transaction amount approval thresholds

## Architecture & Tech Stack

### Technologies
- **Language**: Java 8
- **Framework**: Spring Boot 2.4.10
- **ORM**: Spring Data JPA / Hibernate
- **Database**: SQLite with JDBC
- **Security**: Spring Security 5.3.3
- **View Layer**: JSP (Java Server Pages)
- **Server**: Apache Tomcat (Embedded)
- **Build Tool**: Apache Maven
- **Additional Libraries**: 
  - Lombok (for reducing boilerplate code)
  - JSTL (for JSP tag support)
  - Validation API

### Project Structure

```
BankApplicationSD/
├── src/main/java/application/
│   ├── BankApplication.java (Main entry point)
│   ├── entities/
│   │   ├── dto/ (Data Transfer Objects)
│   │   ├── operational/ (Account, Customer, Transaction, SavingsAccount)
│   │   └── nonoperational/ (Enums and value objects)
│   ├── layer/
│   │   ├── controller/ (Web controllers)
│   │   ├── persistence/ (Repository interfaces)
│   │   └── service/ (Business logic)
│   ├── security/ (Authentication and authorization)
│   └── exception/ (Custom exceptions)
├── src/main/webapp/WEB-INF/views/ (JSP templates)
├── src/main/resources/ (Configuration files)
└── pom.xml (Maven configuration)
```

### Key Components

**Controllers**
- `AccountController` - Account operations (deposit, withdraw, transfer)
- `CustomerController` - Customer management (add, update, view)
- `SavingsAccountController` - Savings account operations
- `TransactionController` - Transaction history and reporting
- `SiteController` - Public pages and navigation

**Entities**
- `Account` - Base account class (abstract) with balance and status
- `SavingsAccount` - Savings account with special interest features
- `Customer` - Customer information and personal details
- `Transaction` - Transaction records with source/target accounts

**Services**
- Implements business logic for accounts, customers, transactions
- Abstracts database operations through repository interfaces
- Handles validation and transaction coordination

**Repositories**
- Spring Data JPA repositories for data access
- Automatic CRUD operations and custom queries

## Installation & Setup

### Prerequisites
- **JDK 8** or higher installed
- **Maven 3.6+** for building the project
- **SQLite** database (included with JDBC driver)

### Step 1: Clone the Repository
```bash
git clone <repository-url>
cd BankApplication
```

### Step 2: Build the Project
```bash
# On Linux
mvnw clean install
# On Windows:
mvnw.cmd clean install
```

### Step 3: Configure Database (Optional)
Database configuration is in `src/main/resources/application.properties`. The application uses SQLite by default, which creates a local database file.

### Step 4: Run the Application
```bash
# On Linux
mvnw spring-boot:run
# On Windows:
mvnw.cmd spring-boot:run
```

The application will start on `http://localhost:8080` by default.

### Step 5: Access the Application
- **Home Page**: `http://localhost:8080/`
- **Login Page**: `http://localhost:8080/login`

Default credentials can be initialized in the `BankApplication.java` class (currently commented out in the `run()` method).

## Usage

### User Roles

#### Admin User
- Full access to customer management
- Account creation and management
- View all transactions
- User and permission management

#### Regular User (Clerk)
- View assigned customer information
- Process account transactions (deposits, withdrawals)
- View transaction history
- Limited to assigned accounts

### Common Workflows

**1. Creating a Customer**
- Navigate to "Customers" → "Add New Customer"
- Fill in personal details (name, sex, address)
- Provide contact information
- Submit to create customer

**2. Creating an Account**
- Go to "Accounts" → "Create Account"
- Select customer
- Choose account type (Regular or Savings)
- Set initial balance (minimum 1,000)
- Confirm to activate account

**3. Processing a Transaction**
- Select account from "Accounts" menu
- Choose transaction type (Deposit/Withdraw/Transfer)
- Enter amount
- Confirm transaction
- Transaction is processed and recorded

**4. Viewing Transaction History**
- Navigate to "Transactions"
- View all transactions with details
- Filter by account or date range
- Check transaction status

## Database Schema

### Core Tables

**Customer Table**
- `customerId` (Primary Key)
- `customerName` (Embedded Name object)
- `sex` (Enum)
- `customerData` (Embedded CustomerData)
- `accountOpeningDate`

**Account Table** (Base table for inheritance)
- `accountNumber` (Primary Key, UUID)
- `accountActiveStatus`
- `balance` (BigDecimal)
- `accountType`
- `customerId` (Foreign Key)

**SavingsAccount Table** (Inherits from Account)
- `interestRate`
- `minimumBalance`
- Additional savings-specific fields

**Transaction Table**
- `txnId` (Primary Key)
- `sourceAccNo` (Foreign Key to Account)
- `targetAccNo` (Foreign Key to Account)
- `type` (Enum - Deposit, Withdraw, Transfer)
- `transactionAmount`
- `transactionStatus`
- `transactionDateTime`

**User Table** (Security)
- `userId` (Primary Key)
- `username` (Unique)
- `password` (Encrypted)
- `role` (AuthRole)
- `enabled`

### Business Rules Enforced
- Minimum account balance: 1,000
- Transaction approval limit: 200,000
- Balance cannot be negative
- Transaction amount must be positive
- Only active accounts can process transactions

## API Endpoints

### Accounts
- `GET /account/operations` - Display account operations page
- `POST /account/deposit` - Process deposit transaction
- `POST /account/withdraw` - Process withdrawal transaction
- `POST /account/transfer` - Process transfer transaction
- `GET /account/showAllAccounts` - List all accounts

### Customers
- `GET /customer/addCustomer` - Show add customer form
- `POST /customer/addCustomer` - Create new customer
- `GET /customer/showAllCustomers` - List all customers
- `GET /customer/updateCustomer` - Show update form
- `POST /customer/updateCustomer` - Update customer details
- `GET /customer/deleteCustomer/{id}` - Delete customer

### Savings Accounts
- `GET /savingsaccount/addSavingsAccount` - Show create form (step 1)
- `POST /savingsaccount/addSavingsAccount` - Proceed to step 2
- `POST /savingsaccount/createSavingsAccount` - Create savings account
- `GET /savingsaccount/showAllSavingsAccounts` - List all savings accounts

### Transactions
- `GET /transaction/showAllTransactions` - View transaction history

### Site
- `GET /` or `/home` - Home page
- `GET /login` - Login page
- `POST /login` - Process login

## Project Status & Notes

- **Phase**: Portfolio demonstration project
- **Database**: Currently uses SQLite for development/demonstration
- **Authentication**: Comment out user initialization in `BankApplication.java` class to auto-create admin accounts
- **View Layer**: Uses JSP templates; can be modernized with Thymeleaf or Spring WebFlux
- **Testing**: Test framework includes JUnit with Spring Boot Test support

## Future Enhancement Opportunities

- Unit test coverage expansion
- REST API implementation (move from JSP to JSON)
- Frontend modernization with React/Angular
- Database migration to MySQL/PostgreSQL for production
- PDF statement generation
- Email notifications for transactions
- Account analytics and reporting
- Mobile application support

## License

This is a portfolio/educational project.

---

**Note**: This application is designed for educational and portfolio purposes. For production use, additional security hardening, comprehensive testing, and compliance reviews are recommended.
