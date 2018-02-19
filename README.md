The goal of this task is to implement a service for sending messages. The service should be able to send different types of messages. Currently supported types are:
- e-mail,
- text message (sms).
 
The service should be extendable as more message types can be added in future. There is no need to implement sending mechanism – the message should only be logged.
 
The service is expected to expose 2 REST interfaces: one for sending a message and one for reading the list of messages that were sent. Messages can be kept in memory or in in-memory database.
 
The code should be tested with unit/integration tests.
 
The code should be committed to any of public repositories, ie. github, bitbucket, etc. It is important for us to see the history of commits to the repository so that we can see how the application was developed.
 
Preferred technology stack:
- Java 8,
- Spring/Spring Boot,
- JSON,
- gradle/maven,
- git.