# 🚗 Car Rental Management System

A Java-based Car Rental Management System built using JDBC and MySQL.  
This project follows a layered architecture using DAO and Service patterns to ensure clean separation of concerns and maintainability.

---

## 📌 Features

- Add / View / Update Cars
- Manage Customers
- Rent and Return Cars
- Track Rental Status
- Database Integration using MySQL
- Layered Architecture (DAO, Service, Model)

---

## 🏗️ Project Structure

```
car_rental.sql
src/
├── dao/
│   ├── CarDAO.java
│   ├── CustomerDAO.java
│   └── RentalDAO.java
│
├── model/
│   ├── Car.java
│   ├── CarStatus.java
│   ├── Customer.java
│   └── Rental.java
│
├── service/
│   ├── CarService.java
│   ├── CustomerService.java
│   └── RentalService.java
│
├── util/
│   └── DBConnection.java
│
└── Main.java
```

---

## 🛠️ Technologies Used

- Java
- JDBC
- MySQL
- Object-Oriented Programming (OOP)
- DAO Design Pattern
- Service Layer Architecture

---

## 🗄️ Database Setup

1. Install MySQL.
2. Create the database:

```sql
CREATE DATABASE car_rental;
```
3. Run the provided `car_rental.sql` file to create required tables.

4. Update database credentials inside:

5. Ensure MySQL server is running before starting the application.
