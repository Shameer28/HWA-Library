# HWA-LIBRARY (HWA)

This is a full stack web application incorporated with a Java (backend), HTML, CSS, JavaScript (frontend) that an end user can interact with via a web(HTML pages).
It utilises a MySQL database via a cloud platform instance containing the following entities/tables:

- Library
- Books

Using these tables it performs the various Create, Read, Update, Delete (C.R.U.D) functionalities.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites
1. Goolge Cloud Platform- SQL Instance
2. Java Spingboot- Framework within JAVA (can use eclipse market place to download)
3. MySQL WorkBench 8.0.25- IDE that supports MySQL and gives better visibility into databases. 
4. Visual Studio Code IDE- Ideal for web development
5. Eclipse IDE- Editor that supports java applications
6. Java JDK 11  
7. Gitbash - Continous Integration 
8. Windows Supported

### Installing

Step 1 - Download GitBash in local machine
```
https://git-scm.com/download/win
```
Step 2 - Download Java 11 and setup in local machine's system environment variable
```
https://adoptopenjdk.net/
```
Step 3 - Download MySQL and setup in local machine's your system evironment variable. 
```
https://dev.mysql.com/downloads/mysql/8.0.html
```
Step 4 - Download MySQl WorkBench in local machine
```
https://dev.mysql.com/downloads/workbench/
```
Step 5 - Download Eclipse IDE in local machine
```
https://www.eclipse.org/downloads/
```
Step 6- Download Spingboot via Eclipse Market Place (or use link below)
```
https://marketplace.eclipse.org/content/spring-tools-4-aka-spring-tool-suite-4
```
Step 7- Download Visual Studio Code IDE
```
https://code.visualstudio.com/download
```
## Deployment
A step by step series of examples that tell you how to get a development running

- Use GitBash to clone a copy of this project to your local machine
*Use code: git clone {input repo url}*  

- Then deploy the Eclipse IDE install spring boot in your eclipse from market place. Import the project by going to File and import and selecting 'Existing Project'.

- Connect your MySQL database with the application.prod via the 'application-prod.properties' file located in the src/main/resource/java folder.

- To use a cloud platform such as Google Cloud Platform (GCP) you must create a MySQL instance on GCP and have it running and copy the IP address of that instance to your application-prod.properties' file as mentioned above and establish a connection between your GCP instance and MySQL Workbench, details of which can be found in the 'Library Documentation' folder.   


## Running the tests
- For test purposes you can utilise the depencies already available in the pom.xml file
- For this project Selenium, JUnit and Mockito were used along with SonarQube.
- To run the test right-click on the project folder and run as junit test.
- To see overall test coverage run 'coverage as' junit test.

## Intregration 
- Jira CI Project Management Tool:
https://team-1619528824712.atlassian.net/jira/software/projects/HWA/boards/5
*Need to Request access before using 


## Built With
* [JUnit](https://mvnrepository.com/artifact/junit/junit/) - Dependency
* [Spring](https://marketplace.eclipse.org/content/spring-tools-4-aka-spring-tool-suite-4) - Dependency
* [Maven](https://maven.apache.org/) - Dependency
* [Selenium](https://chromedriver.storage.googleapis.com/index.html)- Google Chrome Web Driver/Dependency

## Versioning

Version Control System- [Git](https://git-scm.com/downloads)

## Authors

* **Shameer Dar** - *Completed Project* [shameer28](https://github.com/Shameer28/HWA-Library)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* QA Community
* Edsel Tham, Jordan Harrison, Alan Davis

