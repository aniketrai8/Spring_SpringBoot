# SpringBoot

Spring Boot is a Java framework built on top of Spring that simplifies application development. It eliminates boilerplate code with auto-configuration. Spring Boot comes with an embedded server, making applications production ready out of the box. It supports web apps, REST APIs, microservices, security and seamless cloud deployment.

![SpringBoot Architecture Overview with a  diagram](https://www.geeksforgeeks.org/springboot/introduction-to-spring-boot/)


## Task
### Overview
- Spring Boot Overview<br>
  - Understand Spring<br>
  - Spring Boot Advantage<br>
  - Auto Configuration<br>
### Setup
 - Create SpringBoot project via Spring Intializer<br>

 
### Annotation and Structure
 - @ SpringBootApplication
 - @ RestController
 - @ AutoWired
 - @ packages

### REST API Basics
 - Building REST APIs using Spring Web

### Confriguation & Properties
 - application.properties
 - enviroment variables

### Assignment
 <I>Building a Student Mangement REST APIs, using dependency injection and REST APIs</I>


### Good to know basics of for a better Understanding
 - Dependency Injection
 - Spring Bean Cycle
 - POJO
 - Spring Core
 - Serverlet

### To have a complete understanding of Springboot and Java Backend Development
> JPA Annoation <br>
> Docker <br>
> Architecture <br>
> Unit Testing <br>
> Spring Security <br>

###Auto-Config
* These are classes that already have boilerplate code for most types of database(<ins>Mongo</ins>, <ins>Casandra</ins>) Server codes so we save time in setting up any needed confriguation.

 Some Examples<br>
> TomcatAuto Config<br>
> DispatcherServlet Config<br>
> Java2JsonConvertorAutoConfig<br>

* We use a StarterApp to activate the bootstramp the program, we use the run method inside it to maintain docs
  ```
  class StarterApp{
    //SpringApplication.run(StarterApp,arg){
  }
  ```
  <I> <ins>ConditionalonClass -> </ins> So we make an condition that if only a serverlet class is needed that means it is a web based app and then <ins>only we need a tomcat Server</ins> </I>
  Example->
  ```
  ConditionalOnClass(Server.class)
  @Bean
  createTomcatServer(){
  //
  }
  ```
  Example->
  ```
  @ConditionalOnClass(DS.class)
  @Bean
  createDispatcherServlet(){
  //
  }
  ```
  
  
