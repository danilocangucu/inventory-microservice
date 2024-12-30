### Inventory Management Microservice

#### Description
This is a Spring Boot-based microservice for managing inventory operations, including suppliers, stock, orders, and more. It provides a REST API to handle CRUD operations and business logic for inventory management.

---

#### **Getting Started**

##### **Clone the Repository**  

1. Open your terminal or command line.
2. Run the following command to clone the repository:
   ```
   git clone https://github.com/danilocangucu/inventory-microservice.git
   cd inventory-microservice
   ```

##### **Ensure Java 17 or Higher is Installed**

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

#### **Ensure PostgreSQL is Installed and Running**

Before running the application, you need to make sure that PostgreSQL is installed and running on your system. Follow the instructions for your operating system:

##### **For Windows:**
1. **Install PostgreSQL**:
   - Download and install PostgreSQL from [here](https://www.postgresql.org/download/windows/).
   - During installation, make sure to remember the username (`postgres`) and set a password for the `postgres` user.
   
2. **Start PostgreSQL**:
   - After installation, PostgreSQL should start automatically. If it's not running, you can start it manually:
     - Open the **Services** application (`services.msc`).
     - Find **PostgreSQL** in the list, right-click it, and select **Start**.

##### **For macOS:**
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

##### **For Ubuntu:**
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
     
#### **Update `application.properties` with Database Credentials**

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

### **Running the Application**

#### **Windows**
1. Open Command Prompt or PowerShell.
2. Navigate to the project folder using the `cd` command.
3. Run the following commands to build and run the application:

   ```
   gradlew clean build  
   gradlew bootRun  
   ```

#### **macOS**
1. Open Terminal.
2. Navigate to the project folder using the `cd` command.
3. Run the following commands to build and run the application:

   ```
   ./gradlew clean build
   ./gradlew bootRun
   ```

#### **Ubuntu**
1. Open Terminal.
2. Navigate to the project folder using the `cd` command.
3. Run the following commands to build and run the application:

   ```
   ./gradlew clean build
   ./gradlew bootRun
   ```

#### **IntelliJ IDEA**
1. Open IntelliJ IDEA.
2. Select `File > Open` and navigate to the folder containing the cloned repository.
3. IntelliJ should automatically detect the Gradle project and download dependencies.
4. Run the application by clicking the green "Run" button or using the `bootRun` Gradle task.
```
