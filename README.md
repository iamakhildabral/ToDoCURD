# ToDoCURD
# H2 Database Project

This repository contains a Java project that utilizes the H2 database with Spring Boot. It provides a RESTful API for managing tasks, including CRUD operations (Create, Read, Update, Delete).

## Controller

The `TaskController` class handles the HTTP requests and defines the API endpoints for managing tasks. It includes the following methods:

- `getAllTask`: Retrieves all tasks from the database.
- `getTaskById`: Retrieves a task by its ID.
- `addTaskById`: Adds a new task to the database.
- `updateTask`: Updates an existing task with new information.
- `deleteTaskByID`: Deletes a task from the database.

## Model

The `Task` class represents the data model for a task. It includes properties such as `id`, `title`, `description`, `dueDate`, and `createdOn`. The `@Entity` and `@Table` annotations define the mapping to the corresponding database table.

## POM File

The `pom.xml` file is a Maven project configuration file that specifies the project's dependencies and build settings. It includes dependencies for Spring Boot, H2 database, Spring Data JPA, Spring Web, and other related libraries.

## Prerequisites

To run this project, ensure that you have the following prerequisites installed:

- Java Development Kit (JDK) version 17 or higher
- Maven build tool

## Getting Started

To get started with this project, follow these steps:

1. Clone the repository: `git clone https://github.com/iamakhildabral/ToDoCURD.git`
2. Open the project in your preferred Java IDE.
3. Build the project using Maven: `mvn clean install`
4. Run the project: `mvn spring-boot:run`
5. Access the API endpoints using a REST client or web browser.

## API Endpoints

The following API endpoints are available for managing tasks:

- **GET /getAllTask**: Retrieves all tasks.
- **GET /getTaskById/{id}**: Retrieves a task by its ID.
- **POST /addTask**: Adds a new task.
- **PUT /updateTaskByID/{id}**: Updates an existing task.
- **DELETE /deleteByID/{id}**: Deletes a task.

Make sure to replace `{id}` in the endpoint URLs with the actual task ID.

## Database Configuration

This project utilizes the H2 in-memory database. The database connection properties can be configured in the `application.properties` file, which is located in the `src/main/resources` directory. By default, the H2 console is enabled for easy database management and can be accessed at `http://localhost:8080/h2-console`. The database schema and tables will be automatically created based on the entity classes.

## Contributing

If you'd like to contribute to this project, please follow these guidelines:

1. Fork the repository on GitHub.
2. Make your changes in a new branch.
3. Commit your changes and push them to your fork.
4. Submit a pull request explaining your changes and their benefits.

## License

This project is licensed under the MIT License.
