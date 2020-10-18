# Eurocoincol

Simple CRUD application for Coin Collection management.
It is a Maven project (mvn command included in project) 
A MySQL database is required (data source url and credentials need to be changed in application.properties file)
npm is also required.

## Stack 
- Back-end = Spring boot, Web MVC, JPA-hibernate, mySQL database, Thymeleaf (template engine) -- appli launched with maven Spring boot plugin
- Front-end = HTML, JS, bootstrap, datatables (all dependencies listed in package.json under resources folder) -- dependencies installed with npm

## How to run the project 
- run your mySQL instance (local instance or docker instance) 
- change the url and credentials for database access on resources/application.properties file
- Go to resources/static folder
- do : npm install
- Go to root folder and do : mvnw spring-boot:run

