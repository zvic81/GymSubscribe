GymSubscribe

GymSubscribe is a Spring Boot application designed for managing subscriptions (memberships) for a gym. The program allows for the tracking of clients and their subscriptions. It utilizes a PostgreSQL database for data storage.
Features

    Client Management: Keep track of gym members and their personal information.
    Subscription Tracking: Record and manage subscriptions, including start date, end date, and pricing information.
    Database Integration: Utilizes a PostgreSQL database for efficient data storage and retrieval.
   
Technologies Used

    * Spring Boot: Java-based framework for creating standalone, production-grade Spring-based applications.
    * PostgreSQL: Open-source relational database management system known for its reliability and robust features.
    * Docker compose

Usage

To run the GymSubscribe application locally, follow these steps:

    1. git clone git@github.com:zvic81/GymSubscribe.git
    
    2. Enter root apps dir GymSubscribe
    
    3. Run in bash: 

        mvn clean package
        docker-compose up -d
        
    4. Open url http://127.0.0.1:8080/

For any inquiries or feedback, please contact at zvic@list.ru.
