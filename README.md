# Inventory Management System

## Overview
The Inventory Management System is a Java-based application that allows users to manage product inventory through a simple user interface. The application supports CRUD (Create, Read, Update, Delete) operations for products, along with search and sort functionalities.

## Features
- Add, update, delete, and view products
- Search products by name
- Sort products by price or quantity
- User-friendly dashboard interface

## Project Structure
```
inventory-management-system
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── App.java
│   │   │   ├── dao
│   │   │   │   └── ProductDAO.java
│   │   │   ├── model
│   │   │   │   └── Product.java
│   │   │   └── ui
│   │   │       └── Dashboard.java
│   │   └── resources
│   │       └── application.properties
├── sql
│   └── schema.sql
├── package.json
└── README.md
```

## Setup Instructions
1. **Clone the repository**
   ```
   git clone https://github.com/yourusername/inventory-management-system.git
   cd inventory-management-system
   ```

2. **Database Setup**
   - Open the `sql/schema.sql` file and execute the SQL commands to create the necessary database tables.

3. **Configuration**
   - Update the `src/main/resources/application.properties` file with your database connection details.

4. **Build and Run**
   - Use your preferred IDE or build tool to compile and run the application. The entry point is `src/main/java/App.java`.

## Usage
- Launch the application to access the dashboard.
- Use the interface to add, update, delete, or view products.
- Utilize the search and sort features to manage your inventory effectively.

## Dependencies
- Java Development Kit (JDK)
- JDBC Driver for your database
- Any additional libraries specified in `package.json`

## License
This project is licensed under the MIT License. See the LICENSE file for more details.