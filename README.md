# **Customer Publisher Service**

This Micro Service just has a simple api where it takes all the Customer details and check for simple validations and posts the payload to Kafka

**TechStack**
* Swagger API 
* Java8
* Maven
* Spring Boot
* Rest API
* Integrated with kafka
* javax library for validations across models

**Changes From Initial Commit**

* v1.0.0 - initial commit - [TMOON-3282](https://jira.prokarma.com/browse/TMOON-3282)
* v1.1.0 - create swagger file and generate model classes - [TMOON-3286](https://jira.prokarma.com/browse/TMOON-3286)
  * V1.1.1 - Added validations
* v1.2.0 - create Controller with exception handling and masking logic - [TMOON-3290](https://jira.prokarma.com/browse/TMOON-3290)
  * v1.2.1 - google code format for code formatting - formatted all files
