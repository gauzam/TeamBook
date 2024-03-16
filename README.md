
# TeamBook - an Employee Management Portal

- I developed a RESTful API using Spring Boot and MySQL for the back-end, tested it with Postman, and integrated it into a React front-end using Axios.

- CREATE, READ, UPDATE and DELETE (CRUD) appliction.

- This repository contains the back-end and the front-end of a Full Stack personal project, which is responsible for storing employee information and is implemented using the Spring Boot Java Framework which serves as the web framework for the back-end.

- This application allows users to view, add, remove, and edit individuals within their management system.


## 🎯 Aims and Motivation

- The main objective of this project was to create a thorough Full Stack Application using Spring Boot & MySQL as the back-end and React as the front-end.

- Driven by an unwavering enthusiasm for learning and self-improvement, I dedicated my personal time to meticulously develop and refine this Full Stack Application.
## ⚙️ Technologies, Requirements and Software Tools

Requirements listed below are for the front-end and back-end.

#### Programming and Scripting Languages

- Java
- JavaScript
- HTML
- CSS
- JSON

#### Frameworks & Libraries

- Spring Boot - Back-end
- React - Front-end
- Bootstrap - Front-end & Back-end

#### npm Requirements (React)

- nmp axios
- npm react-router-dom

#### Other Software Tools

- MySQLWorkbench played a role where the back-end relied on this technology to store user information.
- DataGrip was also used to support the back-end in storing user information.
- Postman was used to test PUT, GET, POST and DELETE requests to the database.



## ✏️ Design - Back-end

#### Back-end Technology Stack

- Java served as the back-end programming language for the web application, while the Spring Boot framework was employed to facilitate its development and operation.
- Spring Boot was utilised to create user models, which were subsequently employed to store employee information in the database. The user models were established using the Jakarta Persistence import and annotations, including @Entity, @Id, and @GeneratedValue. This approach facilitated the maintenance of the REST API, making it more manageable and easier to maintain in the long run.
- MySQL Workbench and DataGrip were employed to store employee information. The back-end, developed with Spring Boot, was configured to connect with the database, while the front-end, built with React, was responsible for retrieving and displaying this information.
- Spring Boot was additionally utilised to create custom exceptions, specifically designed for handling scenarios where the user ID was not found or encountered other exceptional conditions.


#### React & Spring Boot Summarisation Diagram


