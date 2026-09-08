\# Selenium TestNG Framework - Page Object Model



A Java-based Selenium test automation framework built using Selenium WebDriver,

TestNG, Maven, Page Object Model (POM), and Apache POI for Excel-based test data.



\## Technologies Used



\- Java

\- Selenium WebDriver 4.18.1

\- TestNG 7.9.0

\- Maven

\- Apache POI 5.2.5

\- Page Object Model (POM)

\- Git \& GitHub



\## Framework Structure



src/test/java/Assign\_Framework/



├── excelData/

│   ├── airbusData.xlsx

│   ├── excelData.xlsx

│   ├── Invalid.xlsx

│   └── excelDataProvider.java

│

├── pageobject/

│   ├── airbusTrainbooking.java

│   ├── confirmregisterPage.java

│   ├── flightBooking.java

│   ├── loginSuccessPage.java

│   ├── pageBase.java

│   ├── registerPage.java

│   └── signIn.java

│

├── resources/

│   ├── config.properties

│   ├── properties.properties

│   └── utility.java

│

└── test/

&#x20;   ├── airbusTrainbookingTest.java

&#x20;   ├── flightReservation.java

&#x20;   ├── loginTest.java

&#x20;   ├── readconfigFile.java

&#x20;   ├── Registration.java

&#x20;   └── testBase.java



\## Framework Components



\### Page Object Model



The framework follows the Page Object Model design pattern.



Page-specific locators and actions are maintained in the `pageobject` package,

while test scenarios are maintained separately in the `test` package.



This helps improve code organization, readability, and maintainability.



\### Test Data



Excel files are maintained under the `excelData` package.



Apache POI is used for reading Excel-based test data.



\### Configuration



Configuration and test-related properties are maintained under the

`resources` package using `.properties` files.



\### Test Scenarios



The framework includes automation scenarios for:



\- User registration

\- User login

\- Flight reservation

\- Airbus train booking



\## TestNG



TestNG is used as the testing framework for:



\- Test execution

\- Test organization

\- Assertions

\- Test configuration



The test suite is maintained in:



`testNG.xml`



\## Maven



Maven is used for dependency management and project build configuration.



The project dependencies are defined in:



`pom.xml`



\## How to Run



\### Prerequisites



Install the following:



\- Java JDK

\- Maven

\- Eclipse IDE or another Java IDE

\- Git



\### Run Using TestNG



The test suite can be executed using:



`testNG.xml`



\### Run Using Maven



From the project root directory:



```bash

mvn test

