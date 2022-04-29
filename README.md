<h1 align="center">Booster Bank
	<br/>
</h1>

[![Author](https://img.shields.io/badge/author-LeoMSSilva-blue?style=flat-square)](https://github.com/LeoMSSilva)
[![Version](https://img.shields.io/badge/version-1.0.0-blue.svg?cacheSeconds=2592000)](https://github.com/LeoMSSilva)
[![Languages](https://img.shields.io/github/languages/count/LeoMSSilva/finalProjectWipro-bankAccountManagement?color=blue&style=flat-square)](#)
[![Stars](https://img.shields.io/github/stars/LeoMSSilva/finalProjectWipro-bankAccountManagement?color=blue&style=flat-square)](https://github.com/LeoMSSilva/finalProjectWipro-bankAccountManagement/stargazers)
[![Forks](https://img.shields.io/github/forks/LeoMSSilva/finalProjectWipro-bankAccountManagement?color=blue&style=flat-square)](https://github.com/LeoMSSilva/finalProjectWipro-bankAccountManagement/network/members)
[![Contributors](https://img.shields.io/github/contributors/LeoMSSilva/finalProjectWipro-bankAccountManagement?color=blue&style=flat-square)](https://github.com/LeoMSSilva/finalProjectWipro-bankAccountManagement/graphs/contributors)

---

# :pushpin: Table of Contents

- :house: [About](#house-about)
- :dart: [Installation](#dart-installation)
- :rocket: [Getting started](#rocket-getting-started)
- :computer: [Techs](#computer-techs)
- :bar_chart: [Diagrams](#bar_chart-diagrams)
  - [UML - Use Case and Class Diagrams](#uml---use-case-and-class-diagrams)
  - [Entity and Relationship Diagram](#entity-and-relationship-diagram)
- :cyclone: [Tests](#cyclone-tests)
  - [Test in Postman](#test-in-postman)
  - [Unit Test](#unit-test)
- :bust_in_silhouette: [Authors](#bust_in_silhouette-authors)
- :handshake: [Contributing](#handshake-contributing)
- :scroll: [License](#scroll-license)

---

# :house: About

This project was developed with **Java**, using **Spring Boot** and **Spring Data JPA**.

**MySQL** was used as a database in development. **MySQL Workbench** was the SGBD used.

**PostgreSQL** was used as a database in production.

**Maven** was used as a dependency manager.

**Junit** was used for unit tests.

**Postman** and **insomnia** were used to perform **functional tests**.

**Swagger** was used to create the documentation, along with the interactive front-end **Swagger UI**.

**Heroku** was used to host the api with its documentation.

This api represents the creation of Spring Booster bank with current account and special account operations.

We have the following operations:

- Withdraw

- Deposit

- Bank transfer

---

# :dart: Installation

**First you need to install:**

- [Java OpenJDK 11](https://openjdk.java.net/projects/jdk/11) (required)

- [Eclipse IDE](https://www.eclipse.org/downloads) (required)

- [Spring Boot](https://spring.io/projects/spring-boot) (required)

**Then in order, clone the project.**

By HTTPS, running this command:

```bash
  git clone https://github.com/LeoMSSilva/finalProjectWipro-bankAccountManagement.git
```

Or by ssh, running this command:

```bash
  git clone git@github.com:LeoMSSilva/finalProjectWipro-bankAccountManagement.git
```

SSH is a secure protocol, but you need to register a key ssh in your github before.

---

# :rocket: Getting Started

Once all dependencies are downloaded, installed and configured correctly, you will need to create your environment variables in eclipse:

Navigate to Window>Show View>Other

Search boot panel

With the project open, go to the Boot Dashboard panel, right click on your project

Select Open Configuration

Write your environment variables inside the Replace properties field. Follow the model below substituting your own variables.

```bash
  DATABASE_URL=urlUsedForDatabaseAccess
  USER=yourMysqlUser
  PASSWORD=passwordUsedInYourMysqlUser
```

Access endpoints through **[swagger](https://booster-bank-api.herokuapp.com/swagger-ui/index.html)**.

---

# :computer: Techs

- Heroku
- Java
- JUnit
- Maven
- MySQL
- Mysql Driver
- MySQL Workbench
- PostgreSQL
- Postman / Insomnia
- Spring Boot
- Spring Data JPA
- Spring Web
- Swagger
- Swagger UI

---
# :bar_chart: Diagrams

We work with the following diagrams:

# UML - Use Case and Class Diagrams

<h1 align="center">	
<img src="https://github.com/LeoMSSilva/finalProjectWipro-bankAccountManagement/blob/main/assets/UML-UseCaseDiagram.png" alt="UML - Use Case Diagram" width="300"/>&nbsp;<img src="https://github.com/LeoMSSilva/finalProjectWipro-bankAccountManagement/blob/main/assets/UML-ClassDiagram.png"  alt="UML - Class Diagram"  width="300"/>
</h1>

# Entity and Relationship Diagram

<h1 align="center">	
  <img src="https://github.com/LeoMSSilva/finalProjectWipro-bankAccountManagement/blob/main/assets/EntityAndRelationshipDiagram.png" alt="Entity And Relationship Diagram" width="600"/>
</h1>

---

# :cyclone: Tests

We work with the following tests:

# Test in Postman

Project running locally and having its endpoints tested through the Postman application.

![Testing At The Postman](https://github.com/LeoMSSilva/finalProjectWipro-bankAccountManagement/blob/main/assets/TestingAtThePostman.gif)

# Unit Test

We used the Junit frameworks in version 5, and mockito, to move the data so that it was not persisted in the database. 

They were tested in the service pack classes.

![testee](https://user-images.githubusercontent.com/86155080/166067310-d934bb58-58d7-434f-8280-176b9756f851.png)

---

# :bust_in_silhouette: Authors

| Collaborator | <img src="https://github.com/LeoMSSilva.png" alt="@LeoMSSilva" width="100"/> |     <img src="https://github.com/EdersonDeMelo.png" width="100"/>     | <img src="https://github.com/israelld.png" width="100"/> |     <img src="https://github.com/jefersonfavero.png" width="100"/>      |     <img src="https://github.com/Nathybozzon.png" width="100"/>      |
| :----------- | :--------------------------------------------------------------------------: | :-------------------------------------------------------------------: | :------------------------------------------------------: | :---------------------------------------------------------------------: | :------------------------------------------------------------------: |
| Github       |                 [@LeoMSSilva](https://github.com/LeoMSSilva)                 |          [@EdersonDeMelo](https://github.com/EdersonDeMelo)           |         [@israelld](https://github.com/israelld)         |          [@jefersonfavero](https://github.com/jefersonfavero)           |            [@Nathybozzon](https://github.com/Nathybozzon)            |
| LinkedIn     |              [@LeoMSSilva](https://linkedin.com/in/LeoMSSilva)               | [@EdersonDeMelo](https://www.linkedin.com/in/ederson-machado-de-melo) | [@israelld](https://www.linkedin.com/in/israellimadias)  | [@jefersonfavero](https://www.linkedin.com/in/jeferson-favero-3a3b7ba6) | [@Nathybozzon](https://www.linkedin.com/in/nathalie-bozzon-32383256) |

---

# :handshake: Contributing

Contributions, issues and feature requests are welcome! Feel free to **file a new issue** on the [finalProjectWipro-bankAccountManagement](https://github.com/LeoMSSilva/finalProjectWipro-bankAccountManagement/issues) repository. If you already found a solution to your problem, **I would love to review your pull request**!

---

# :scroll: License

Copyright :copyright: 2022 [@LeoMSSilva](https://github.com/LeoMSSilva), [@EdersonDeMelo](https://github.com/EdersonDeMelo), [@israelld](https://github.com/israelld), [@jefersonfavero](https://github.com/jefersonfavero) and [@Nathybozzon](https://github.com/Nathybozzon).

<br/>
This project is [MIT](https://github.com/LeoMSSilva/finalProjectWipro-bankAccountManagement/blob/main/assets/LICENSE) licensed.

---
