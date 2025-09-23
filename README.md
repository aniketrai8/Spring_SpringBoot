# SpringBoot

Spring Boot is a Java framework built on top of Spring that simplifies application development. It eliminates boilerplate code with auto-configuration. Spring Boot comes with an embedded server, making applications production ready out of the box. It supports web apps, REST APIs, microservices, security and seamless cloud deployment.

![SpringBoot Architecture Overview with a  diagram](images/SpringArch.webp)

### Spring simplies many tasks like
* Creating web Application
* Working with Database
* Managing Transcations
  


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
  ## Annotation
  <b> @SpringBootApplication </b> -
  - We use SpringBootApplication annotation on the main class. This Single annotation replaces the need for Setting up a manual Spring Application context. <br>
  - We no longer need to explicitly create an application context using AnnotationCOnfigApllicatonContext as Spring Boot Handles that behind the secnes. <br>
  - The annotation alone brings in a lot of pre-configured feathures, including automatic component scanning and embedded server confriguation, which would requireed more steps in
    a Traditional Spring setup
  <b> @RestControllers </b> -
  - is a Spring annotation used to define a controller that handles HTTP requests and returns responses directly (usually JSON).
  ```
  @RestController
  public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Spring Boot!";
    }
  }
  ```

<b> @AutoWired </b> -
- It is used for dependency Injection(DI) in Spring.
- It tells Spring to AUtomatically inject instance of a bean into your class.
- Avoids manual object creation -> Spring manages it for you
 









### Spring MVC vs SpringBoot
 ## Spring MVC
 Spring MVC Framework is a widely used tool for creating scalabale web application, It consits of multiples modules like <ins>Model, View, Controller, Front Controller </ins> 
 - Model - A model can be an object or collection of objects which basically contains the data of the application.
 - View - A view is used for displaying the information to the user in a specific format. Spring supports various technologies like freemarker, velocity, and thymeleaf.
 - Controller - It contains the logical part of the application. @Controller annotation is used to mark that class as a controller.
 - Front Controller - It remains responsible for managing the flow of the web application. Dispatcher Servlet acts as a front controller in Spring MVC.
  
Spring MVC confroguation are needed to be done manually, we need to define dependency indivisdually doesnt alllow powerful batch processing system unline Spring Boot
