# The Java framework

Java framework is a front-end framework. All components hosted in GitHub repo.**

## Technologies
Project is created with:
* Java: 1.8
* Maven: 3.6.3
* Selenium for Java
* IntelliJ IDEA 
* GIT

## Installation

You need to install Java, Selenium and Maven for test execution by webDriver.
For load testing you should download and install k6 and Docker.

## Documentation
How to configure installed apps:
- [Maven](https://maven.apache.org/) 

## Project structure

Main structure

```
.
├── driver                  # Drivers for Selenium
├── src                     # Source files
├── test                    # Automated tests
├── testng.xml              # File for tests execution
├── pom.xml					# Dependency and plugins
└── README.md

```

Java files location

```
/src/
├── ...
├── main                    
│   ├── core          	    # @Test configurations, drivers settings, etc.
│   └── uiLayer             # Code for IU tests
│                   
└── testng.xml              # Сonfig file
...
```

Test files location

```
/src/
├── ...
├── test                    
│   └── Test                # UI tests for Selenium
└── ...
```

## Usage Java framework
After all apps was successfully configured. We can start working with framework.
#### Executing tests from IDEA 
   1. Open any test in folder "Test" and try to run
#### Executing tests from CMD / terminal
   1. Open CMD from testng.xml file location
   2. Execute:
   ```
   mvn test
   ```