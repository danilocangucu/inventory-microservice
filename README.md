# Inventory Management Microservice

This is a Spring Boot-based microservice for managing inventory operations, including suppliers, stock, orders, and more. It provides a REST API to handle CRUD operations and business logic for inventory management.

---

## **Getting Started**

### **Clone the Repository**  

1. Open your terminal or command line.
2. Run the following command to clone the repository:
   ```
   git clone https://github.com/danilocangucu/inventory-microservice.git
   cd inventory-microservice
   ```

### **Ensure Java 17 or Higher is Installed**

1. **Check if Java is Installed**  
   Open your terminal and run the following command:  
   ```
   java -version
   ```  
   If you have **Java 17 or higher** installed, you should see something like this:
   ```
   openjdk version "17.x.x" 2021-09-14
   OpenJDK Runtime Environment (build 17.x.x)
   OpenJDK 64-Bit Server VM (build 17.x.x, mixed mode)
   ```  
   If the installed version is lower than **Java 17** or if Java is not installed, follow the instructions below to install it.

2. **Install Java 17**

   **For Windows**:
   - Go to the [Oracle JDK Downloads page](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).
   - Download the Windows installer for **JDK 17**.
   - Run the installer and follow the on-screen instructions.

   After installation, you may need to set up the `JAVA_HOME` environment variable:  
   
   - Right-click on **This PC** (or **My Computer**) and select **Properties**.  
   - Click on **Advanced system settings** and then **Environment Variables**.  
   - Under **System Variables**, click **New** and set:  
     - **Variable Name**: `JAVA_HOME`
     - **Variable Value**: The directory where Java 17 was installed, e.g., `C:\Program Files\Java\jdk-17`.
   - Find the **Path** variable, click **Edit**, and add a new entry: `%JAVA_HOME%\bin`.

   **For macOS**:  
   
   - Install **Homebrew** (if it's not already installed). Open a terminal and run:
     ```
     /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
     ```
   - Install Java 17 with Homebrew:
     ```
     brew install openjdk@17
     ```
   - After installation, link Java 17:
     ```
     sudo ln -sfn /usr/local/opt/openjdk@17/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-17.jdk
     ```

   **For Linux (Ubuntu)**:  
   
   - Open a terminal and run:  
     ```
     sudo apt update
     sudo apt install openjdk-17-jdk
     ```
   - Verify installation by checking the version:  
     ```
     java -version
     ```

### **Ensure PostgreSQL is Installed and Running**

Before running the application, you need to make sure that PostgreSQL is installed and running on your system. Follow the instructions for your operating system:

#### **For Windows:**
1. **Install PostgreSQL**:
   - Download and install PostgreSQL from [here](https://www.postgresql.org/download/windows/).
   - During installation, make sure to remember the username (`postgres`) and set a password for the `postgres` user.
   
2. **Start PostgreSQL**:
   - After installation, PostgreSQL should start automatically. If it's not running, you can start it manually:
     - Open the **Services** application (`services.msc`).
     - Find **PostgreSQL** in the list, right-click it, and select **Start**.

#### **For macOS:**
1. **Install PostgreSQL**:
   - If you have **Homebrew** installed, use the following command:
     ```
     brew install postgresql
     ```

2. **Start PostgreSQL**:
   - After installation, start PostgreSQL using:
     ```
     brew services start postgresql
     ```

#### **For Ubuntu:**
1. **Install PostgreSQL**:
   - Update package lists and install PostgreSQL:
     ```
     sudo apt update
     sudo apt install postgresql postgresql-contrib
     ```

2. **Start PostgreSQL**:
   - After installation, start PostgreSQL:
     ```
     sudo service postgresql start
     ```
     
### **Update `application.properties` with Database Credentials**

After ensuring PostgreSQL is installed and running, update the credentials in the `application.properties` file for the application to connect to your database.

1. **Locate `application.properties`**:  
	Navigate to `src/main/resources/application.properties`.

2. **Update Database Connection Information**:  
   Update the file with your correct database credentials:  
   
   ```
	spring.application.name=Inventory Management System

	# PostgreSQL Database Configuration
	spring.datasource.url=jdbc:postgresql://localhost:5432/inventory
	spring.datasource.username=postgres
	spring.datasource.password=YOUR_PASSWORD
	spring.jpa.hibernate.ddl-auto=update
	spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
	api.key=YOUR_API_KEY
   ```

   - Replace `YOUR_PASSWORD` with the password you set for the `postgres` user during installation.
   - Replace `YOUR_API_KEY` with the appropriate API key if needed.
   <!-- NOTE: Check what was the API key is for this application. -->

## **Running the Application**

### **Windows**
1. Open Command Prompt or PowerShell.
2. Navigate to the project folder using the `cd` command.
3. Run the following commands to build and run the application:

   ```
   gradlew clean build  
   gradlew bootRun  
   ```

### **macOS**
1. Open Terminal.
2. Navigate to the project folder using the `cd` command.
3. Run the following commands to build and run the application:

   ```
   ./gradlew clean build
   ./gradlew bootRun
   ```

### **Ubuntu**
1. Open Terminal.
2. Navigate to the project folder using the `cd` command.
3. Run the following commands to build and run the application:

   ```
   ./gradlew clean build
   ./gradlew bootRun
   ```

### **IntelliJ IDEA**
1. Open IntelliJ IDEA.
2. Select `File > Open` and navigate to the folder containing the cloned repository.
3. IntelliJ should automatically detect the Gradle project and download dependencies.
4. Run the application by clicking the green "Run" button or using the `bootRun` Gradle task.

Here’s a draft for the README that includes instructions on how to interact with the API using the Postman collection you provided:

---

## API Testing with Postman

This guide provides instructions on how to interact with the API using the Postman collection available in this project. The collection includes multiple endpoints for interacting with the **/api/products**, **/api/stocks**, and **/api/orders** routes. Follow the steps below to test the API via Postman.

---

### Prerequisites

1. **Postman**: Make sure you have [Postman](https://www.postman.com/downloads/) installed.
2. **API Key**: Ensure you have the API key that was used when building and configuring the application. This key will be required for authentication to access the API.

---

Here’s a corrected and better-formatted version of the **Getting Started** section:

---

### Getting Started

1. **Import the Postman Collection**:
   - Create a [Postman account](https://www.postman.com/signup) (if you don’t have one).
   - Log in with your Postman credentials.
   - Open Postman and create a new Workspace named **"Inventory Microservice"**.
   - In the workspace, click on **Collections** and then click the **Import** button in the top-left corner.
   - Select **Import From File** and choose the Postman collection JSON file located in the project's `postman` folder.
   - After importing, the API endpoints will be visible under the collection named **"Inventory Microservice"**.

2. **Set Up the Environment**:
   - After selecting the **Inventory Microservice** collection, click on the **Variables** tab.
   - Update the `api-key` environment variable’s current value (`YOUR_API_KEY_FROM_THE_APP`) with the actual API key.
   - Click **Save** to apply the changes.

---

## API Endpoints

### **1. /api/products**

**Description**: Manages product-related operations.

- **GET /api/products**: Retrieves a list of all products.
  - **Test**: Confirms that the status code returned is 200.
  
- **GET /api/products/{productId}**: Retrieves data for a specific product by ID.
  - **Test**: Confirms that the status code returned is 200.
  
- **POST /api/products**: Creates a new product with details such as `name`, `price`, and `stock`.
  - **Test**: Confirms that the status code returned is 200 or 201.
  - **Request Body**: Provide the necessary details for the new product (e.g., `name`, `price`, etc.).
  
- **PUT /api/products/{productId}**: Updates an existing product's information.
  - **Test**: Confirms that the status code returned is 200, 201, or 204.
  - **Request Body**: Update product details (e.g., price, stock).
  
- **DELETE /api/products/{productId}**: Deletes a product by ID.
  - **Test**: Confirms that the status code returned is 200, 202, or 204.

---

### **2. /api/stocks**

**Description**: Manages stock-related operations.

- **GET /api/stocks**: Retrieves the current stock levels for products.
  - **Test**: Confirms that the status code returned is 200.
  
- **GET /api/stocks/{stockId}**: Retrieves stock data by stock ID.
  - **Test**: Confirms that the status code returned is 200.
  
- **POST /api/stocks**: Adds or updates stock levels for a specific product.
  - **Test**: Confirms that the status code returned is 200 or 201.
  - **Request Body**: Include the product ID and stock quantity.
  
- **PUT /api/stocks/{stockId}**: Updates the stock levels for a specific product.
  - **Test**: Confirms that the status code returned is 200, 201, or 204.
  - **Request Body**: Provide the new stock quantity.
  
- **DELETE /api/stocks/{stockId}**: Deletes stock data for a specific product.
  - **Test**: Confirms that the status code returned is 200, 202, or 204.

---

### **3. /api/orders**

**Description**: Manages order-related operations.

- **GET /api/orders**: Retrieves a list of all orders.
  - **Test**: Confirms that the status code returned is 200.
  
- **GET /api/orders/{orderId}**: Retrieves order details for a specific order by ID.
  - **Test**: Confirms that the status code returned is 200.
  
- **POST /api/orders**: Creates a new order with product details.
  - **Test**: Confirms that the status code returned is 200 or 201.
  - **Request Body**: Include the list of items, product IDs, and quantities.
  
- **PUT /api/orders/{orderId}**: Updates an existing order's details, such as its status or items.
  - **Test**: Confirms that the status code returned is 200, 201, or 204.
  - **Request Body**: Update the order status or item quantities.
  
- **PUT /api/orders/{orderId}/cancel**: Cancels an existing order by updating its status.
  - **Test**: Confirms that the status code returned is 200, 201, or 204.
  
- **DELETE /api/orders/{orderId}**: Deletes an existing order by ID.
  - **Test**: Confirms that the status code returned is 200, 202, or 204.

---

## How to Test the API Endpoints

1. **Choose an Endpoint**: Select the API endpoint you want to test from the Postman collection.
2. **Select the HTTP Method**: The Postman collection already sets up the HTTP methods for each endpoint (GET, POST, PUT, DELETE).
3. **Provide Parameters (if applicable)**:
   - For `GET` requests, you may need to pass query parameters (like `id=1`).
   - For `POST` and `PUT` requests, ensure you provide the necessary request body (e.g., JSON data).
4. **Send the Request**: Click **Send** to send the request to the API.
5. **Check Response**: The response from the API will appear in the **Response** section. Check the status code (e.g., `200 OK`, `201 Created`) to verify successful execution.
6. **View Tests**: If the tests in Postman are set up, you can view the results under the **Tests** tab after sending the request.

---

## Example: Creating a Product

1. Select the **POST /api/products** request from the Postman collection.
2. Under the **Body** tab, select `raw` and choose **JSON** format.
3. Enter the JSON data for the new product:

   ```json
   {
     "name": "Sample Product",
     "price": 29.99,
     "stock": 100
   }
   ```

4. Click **Send** to create the product.
5. Check the **Response** section to confirm that the product was successfully created.
