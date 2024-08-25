# AppCharge


## Overview

This project is an automated testing framework using Selenium WebDriver for browser automation, Java as the programming language, Maven as the build tool, and TestNG as the testing framework.

## Prerequisites

Before running the tests, ensure you have the following installed:

- **Java JDK 8 or higher**
- **Maven 3.6.0 or higher**
- **A suitable web browser** (e.g., Chrome, Firefox)

## Project Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/project.git
   cd selenium-java-maven-testng
   

## Install dependencies:

Maven handles project dependencies. Run the following command to download and install them:


mvn install


## Configuration

WebDriver Setup:

ChromeDriver: Download the latest ChromeDriver from ChromeDriver Download. Place the chromedriver executable in a directory included in your system's PATH, or specify its location in the WebDriverManager configuration.
GeckoDriver: For Firefox, download GeckoDriver from GeckoDriver Releases and place it similarly.

TestNG Configuration:

The TestNG XML configuration file is located at src/test/resources/testng.xml. You can configure different test suites and test parameters here.

## Running Tests
You can run the tests using Maven from the command line:


mvn test OR righ click on testng.xml and select Run [testng document] OR right click over the classes and Select Run
This commands will execute all TestNG tests as configured in the testng.xml file.

## Directory Structure:

src/main/java - Contains the source code for the application.
src/test/java - Contains test classes and test data(see test classes here).
src/test/resources - Contains TestNG configuration files and other resources.

## Reporting
TestNG generates an HTML report after test execution. You can find the reports in the test-output and Targets directories. 

