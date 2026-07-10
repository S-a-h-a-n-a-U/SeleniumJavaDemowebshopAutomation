**#Question**
UI Automation 
Visit the following website https://demowebshop.tricentis.com/ and browse through different pages. 
Automate the following test cases in Selenium java and use TestNG framework to write and run your test cases: 
Sign up and verify successful sign up 
Login and verify successful login 
Create a wishlist and validate the items  
Edit the wishlist and validate the items 
Add multiple items to compare list and validate 
Create an order and validate the successful order creation 
Validate orders in my account > order section 
Create a checkout with multiple address 
Note: For email signup you can use disposable email address sites like yopmail.com etc

# Demo Web Shop UI Automation Framework
## Overview
This project is a Selenium UI Automation Framework developed using **Java**, **Selenium WebDriver**, **TestNG**, and **Maven** following the **Page Object Model (POM)** design pattern.
The framework automates the major user workflows of the Demo Web Shop application and was developed as part of an automation assignment.
---
##Technologies Used
- Java 24
- Selenium WebDriver 4.33.0
- TestNG 7.11.0
- Maven
- IntelliJ IDEA
- Git & GitHub
---
## Design Pattern
- Page Object Model (POM)
- Reusable Base Page
- Explicit Wait Utility
- Test Data Utility
- Base Test for WebDriver initialization
---
## Project Structure
```
DemoWebShopUIAutomation
│
├── src
│   ├── main
│   │   └── java
│   │       ├── constants
│   │       ├── pages
│   │       └── utilities
│   │
│   └── test
│       └── java
│           ├── base
│           └── tests
│
├── pom.xml
├── testng.xml
├── .gitignore
└── README.md
```
---
## Automated Test Scenarios
### User Registration
- Register a new user
- Verify successful registration
### Login
- Login with valid credentials
- Verify successful login
### Wishlist
- Add product to wishlist
- Validate wishlist items
### Edit Wishlist
- Remove/Edit wishlist items
- Validate updated wishlist
### Product Comparison
- Add multiple products to comparison list
- Validate compared products
### Search
- Search products
- Validate search results
### Order Creation
- Add product to cart
- Complete checkout
- Validate successful order creation
### Order History
- Navigate to My Account
- Verify Orders section
### Multiple Address Checkout
- Add multiple addresses
- Checkout using saved addresses
### Logout
- Logout successfully
---
## Framework Features
- Page Object Model
- Explicit Waits
- Reusable Components
- Maven Build
- TestNG Test Execution
- Easy Maintenance
- Scalable Framework Structure
---
## Test Execution
Clone the repository:
```bash
git clone https://github.com/<your-github-username>/DemoWebShopUIAutomation.git
```
Open the project in IntelliJ IDEA.
Install Maven dependencies:
```bash
mvn clean install
```
Run all tests:
```bash
mvn test
```
Or execute using TestNG:
```
testng.xml
```
---
## Application Under Test
Demo Web Shop
https://demowebshop.tricentis.com/
---
## Author
**U.Sahana**
GitHub:
https://github.com/<your-github-username>
---
## Future Enhancements
- Extent Reports
- Screenshot Capture on Failure
- Log4j Logging
- Cross Browser Execution
- Jenkins CI/CD Integration
- Data Driven Testing using Excel/JSON
- Parallel Test Execution
- Docker Support
---
## Assignment Coverage
| Requirement | Status |
|------------|--------|
| User Registration | ✅ |
| Login | ✅ |
| Wishlist | ✅ |
| Edit Wishlist | ✅ |
| Compare Products | ✅ |
| Order Creation | ✅ |
| Order History Validation | ✅ |
| Multiple Address Checkout | ✅ |
---
## License
This project is developed for learning and demonstration purposes.
