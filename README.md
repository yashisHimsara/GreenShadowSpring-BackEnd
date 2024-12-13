# Green Shadow Spring Boot Application


![Spring Boot](https://1.bp.blogspot.com/-TevOgPVC2dE/WnILAnucRVI/AAAAAAAAGU0/OlrnoLsf2fs9aKpm9_BGEqk5R54gUCZbgCLcBGAs/s1600/spring-boot.png)


## Overview
The Green Shadow application is a robust backend system built on Spring Boot. It offers a suite of RESTful APIs designed for comprehensive management of crops, equipment, fields, staff, users, vehicles, monitoring logs, and transactions. The application leverages a range of technologies including Spring Boot, JPA, Hibernate, Spring Security, and MySQL for seamless database connectivity.

## Features
- **Equipment Management**: Efficiently manage equipment inventory and details.
- **Field Management**: Oversee field data and operations.
- **Staff Management**: Handle staff information and roles.
- **User  Management**: Manage user accounts and permissions.
- **Vehicle Management**: Track and manage vehicle details.
- **Monitoring Log Management**: Maintain logs for monitoring activities.
- **Role-Based Access Control**: Implement user roles for secure access.
- **Token Generation**: Generate secure tokens for user sessions.
- **Token Validation**: Validate tokens for secure API access.
- **Token Refresh**: Refresh tokens to maintain user sessions.
- **Spring Security Integration**: Secure the application with Spring Security.
- **Custom Authentication Provider**: Implement a tailored authentication mechanism.
- **Secure Password Storage**: Store passwords securely using best practices.
- **Profile Management**: Manage user profiles and settings.
- **Login Attempt Auditing**: Track login attempts for security purposes.
- **Activity Logging**: Log user activities for auditing.
- **Protected Endpoints**: Secure API endpoints to prevent unauthorized access.
- **Transaction Processing**: Handle transactions efficiently.
- **Exception Handling and Validation**: Utilize Hibernate Validator for data validation and error handling.
- **JSON Response Formatting**: Standardize API responses in JSON format.
- **Logs with Logback**: Capture logs using Logback for monitoring and debugging.

## Technologies
- **Java Version**: JDK 21
- **Backend Framework**: Spring Boot (v3.4.0)
- **Database**: MySQL
- **ORM**: JPA, Hibernate
- **Server**: Apache Tomcat
- **Validation**: Hibernate Validator
- **Logger**: Logback

## Architecture Overview
- **Entities**: Representations for Crop, Email, Equipment, Field, Staff, User, Vehicle, and Monitoring Log.
- **Data Transfer Objects (DTOs)**: Includes CropDTO, EmailDTO, EquipmentDTO, FieldDTO, StaffDTO, UserDTO, VehicleDTO, and MonitorLogDTO.
- **Repositories**: Interfaces for database operations.
- **Services**: Business logic for management.
- **Controllers**: API endpoints for handling requests.
- **Utilities**: Helper classes for various tasks.
- **Exceptions**: Custom error handling mechanisms for specific scenarios.
- **Configuration**: Application setup classes such as `application.properties` and `application-dev.properties`.

## Validation
Data validation is enforced through Hibernate Validator annotations within the DTO classes, ensuring both data integrity and accuracy.

## Logging
Logging is configured with Logback, capturing logs in both the console and a dedicated file for easy monitoring.

## Custom Exceptions
Custom exceptions are implemented to address specific error situations, providing clear and informative error messages to clients.

## Setup and Configuration
### Prerequisites
- JDK 21
- MySQL server
- Maven

## Credits
- **Pathum Rathnayaka**

## License
This project is licensed under the MIT License.
