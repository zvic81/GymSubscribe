GymSubscribe

GymSubscribe is a Spring Boot application designed for managing subscriptions (memberships) for a gym. The program allows for the tracking of clients and their subscriptions. It utilizes a PostgreSQL database for data storage.
Features

    Client Management: Keep track of gym members and their personal information.
    Subscription Tracking: Record and manage subscriptions, including start date, end date, and pricing information.
    Database Integration: Utilizes a PostgreSQL database for efficient data storage and retrieval.
   
Technologies Used

    Spring Boot: Java-based framework for creating standalone, production-grade Spring-based applications.
    PostgreSQL: Open-source relational database management system known for its reliability and robust features.
    Docker compose

Usage

To run the GymSubscribe application locally, follow these steps:
    1. '''git clone git@github.com:zvic81/GymSubscribe.git'''
    2. Enter root apps dir GymSubscribe
    3. Run in bash: 
        '''docker-compose up -d'''
    4. Open url http://127.0.0.1:8080/

How to build (NOT FOR USER!, developers only):
    pom.xml:
        <packaging>war</packaging>
        .............
        <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    mvn clean package



Getting Started

To get started with GymSubscribe, follow the instructions provided in the Installation Guide.
Contributing

Contributions are welcome! Feel free to fork the repository and submit pull requests for any enhancements or bug fixes.
License

This project is licensed under the MIT License - see the LICENSE file for details.
Contact

For any inquiries or feedback, please contact us at zvic@list.ru.