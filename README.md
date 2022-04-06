# FilmQueryProject

## Overview
The FilmQueryProject is a app which allows the user to query the film database. First the app will display a menu with three options, Look up a film by its id, Look up a film by a search keyword, Exit the application. The application will only exit when the user enters "exit" or "3". If the user enters "1" or "Look up a film by a search keyword" the user will be prompted to enter the film id they want to query. If a film is found the film info will be displayed. The user will then be taken back to the main menu. When the user enters "2" or "Look up a film by a search keyword" the user will be prompted to enter the keyword they want to search the database for. If the database has a film who's title or description contains the keyword then it will be displayed.

## Technologies Used
JDBC  
MySql  
Join tables  
SQL Queries  
  - SELECT  
  - FOMR  
  - WHERE  
  - LIKE  
  - IN  
  - JOINS   

Object-Relational Mapping (ORM)  
Maven  
JUnit5  

## Lessons learned
Object-Relational Mapping is code that translates the entities (tables/rows) and attributes (columns) of a relational database schema to the objects and fields of an OO language application, and vice versa.

PreparedStatements are always better then Statements when querying databases. This is the first layer of protection against SQL injection.
