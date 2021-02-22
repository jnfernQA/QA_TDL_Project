# Project : TO DO LIST WEB APPLICATION (TDL)

Link to Jira - (https://qatraineeacadamy.atlassian.net/jira/software/c/projects/QTP/boards/4/roadmap?shared=&atlOrigin=eyJpIjoiZjIwNjkwZDI2MWQzNDNjMGJkYWU2MzNkMjkyNzJkZWUiLCJwIjoiaiJ9)

Uses a CRUD functionality in a Web Application using chrome to create a to do list and storing it in a database for Lists and Items

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
1.MySQL database (Create "list" database first)
2.JDK 11 and Eclipse IDE or Spring (IDE) (preferbly Spring)
3.JUnit5, Mockito, Selenium (included in Spring for testing)
4.Google Chrome Version 88.0.4324.182
5.Gitbash
```

### Installing and Running


```
1.Clone this repository to your local repository using Gitbash
2.Open the Spring IDE and open the project folder from your local repository
3.Development of the code can be done in "/src/main/java"
4.Open a cmd console and change directory to the project folder and in console type "cd target" to move to the target folder and then type - "java -jar QA_TDL_Project-0.0.1-SNAPSHOT.jar" (fat.jar)
5.Make sure in MySql the database follows the sql schema of provided in "src/main/resources"
6. If not go to application.properties and change "prod" to "dev" for a temporary h2 databases
7.Running the fat.jar from step 4 will allow to start the TDL program
8. Go on browser go to "http://localhost:9090" to start the web app
```
## Running the tests

Explain how to run the automated tests for this system. Break down into which tests and what they do

### Unit and Integration Tests and User Acceptance

These Tests make sure the base code does what it requires to do and does a coverage test to compare expected result to actual results
using JUnit and mockito

```
1.In the src/test/java you can run a coverage test
2. Can modify tests 
3. Run JUnit test on fronEndtest while application is running
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **James Fernande** - [jnfernQA](https://github.com/jnfernQA)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

