# 🏦 Simple Banking / Wallet System

A learning project built with **Java Spring Boot** and **PostgreSQL** to simulate an industry‑level banking system.  
This project mirrors real‑world banking domains (like Barclays) and focuses on handling multiple users, accounts, transactions, and concurrency control.

---

## 🚀 Features
- **User Management**
  - Register and authenticate users
  - Roles: `User`, `Admin`
- **Accounts**
  - Create accounts linked to users
  - Account types: `Saving_Account`, `Current_Account`
  - Balance validation (no negative balances)
- **Transactions**
  - Transfer money between accounts
  - Transaction history with status (`PENDING`, `SUCCESSFUL`, `FAILED`)
- **Concurrency Control**
  - Row‑level locking
  - Optimistic locking with `@Version`
- **Security**
  - Password hashing with BCrypt
  - Spring Security integration (JWT planned)

---

## 🛠️ Tech Stack
- **Backend:** Java 17, Spring Boot
- **Database:** PostgreSQL
- **ORM:** Hibernate / JPA
- **Build Tool:** Maven
- **Testing:** JUnit, Spring Boot Test

---

## 📂 Project Structure
