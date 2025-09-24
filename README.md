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
 <ins> Assignment Prep Roadmap </ins>

Day 1–2 → Learn annotations (@SpringBootApplication, @RestController, @Service, @Autowired). <br>

Day 3–4 → Practice REST basics (CRUD with dummy in-memory list). <br>

Day 5–6 → Add database (H2 first, then MySQL/Postgres). <br>

Day 7 → Learn application.properties & environment-specific configs. <br>

Day 8–9 → Implement layered architecture (Controller → Service → Repository → DB). <br>

Day 10 → Add exception handling & validation. <br>

Day 11+ → Refactor into clean Student Management System. <br>
-----------------------------------------------

### Good to know basics of for a better Understanding
 - Dependency Injection
 - Spring Bean Cycle
 - POJO
 - Spring Core
 - Serverlet
---------------------------------------------------
### To have a complete understanding of Springboot and Java Backend Development
> JPA Annoation <br>
> Docker <br>
> Architecture <br>
> Unit Testing <br>
> Spring Security <br>
-----------------------------------------------------
# Documentation
### Auto-Config
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
  - It is a combination of Three Annotation like @Confirguation, @EnableAutoConfriguation,@ComponentScan, @
  - The Annotaion is used only once in the whole SpringBoot Project, and is the main Startung class of the project
  - It does the work of @confriguation, @EnableAutoCOnfriguation @ComponentScan
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
- Works on constructor, setter, or field injection.

```
@Service
public class StudentService(){
  public String Greet(){
    return "hello Student"
  }
}
@RESTController
@RequestMapping
public class StudentController(){
  private final StudentService studentservice;

@Autowired
public StudentController(StudentService studentservice){
  this.studentService = SudentService;
}

@GetMapping
public String greetStudent(){
  return StudentService.greet();
}
}






```
 

### Spring MVC vs SpringBoot
 ## Spring MVC
 Spring MVC Framework is a widely used tool for creating scalabale web application, It consits of multiples modules like <ins>Model, View, Controller, Front Controller </ins> 
 - Model - A model can be an object or collection of objects which basically contains the data of the application.
 - View - A view is used for displaying the information to the user in a specific format. Spring supports various technologies like freemarker, velocity, and thymeleaf.
 - Controller - It contains the logical part of the application. @Controller annotation is used to mark that class as a controller.
 - Front Controller - It remains responsible for managing the flow of the web application. Dispatcher Servlet acts as a front controller in Spring MVC.
  
Spring MVC confroguation are needed to be done manually, we need to define dependency indivisdually doesnt alllow powerful batch processing system unline Spring Boot


### Project Structure (SpringBoot)
> .idea <br>
- Is simply a file related to Intelij Idea
> .mvn <br>
- Is a Maven Wrapper class
> Src<br>
- main<br>
  - Java<br>
    Contains the Java code
  - Resources <br>
    <ins>Static</ins> is used to store things like images<br>
    <ins>application.properties</ins> 
     Can contain confriguation like MongoDB Sever Confriguation
  - Test
     - Contains the Test Logics
  - pom.xml
    * How it will be built
    *It contains all the external libraries
    * project tag is the main Tag, contains all the logic


### Suugested Package and Project Structure

```
com.example.studentapp
│
├── controller    → REST APIs (@RestController)
├── service       → Business logic (@Service)
├── repository    → DB logic (@Repository / JpaRepository)
├── model/entity  → Student, Course entities (@Entity)
└── config        → Extra config classes


```
  # Some Spring and SpringBoot Core Concepts
  --------------------------------------------------------------------
  ### IOC -<br>
  Inversion of Control is one of the core concepts of Springboot, it means now the SprinBoot and not the developer holds the power to create objects its called as <I> Inversion of Control </I> <br> It helps create and manage objects inject dependencies and manage their kife cycles.

   There are two types of IOC containers in Spring ->
  * <I> Bean Factory </I>
    - It provides basic support for Dependency Injection and Bean lifecycle Mangement
    - It suitable for lightweight application where advanced feathures are not required
  * <I> Application Context </I>
    - It built on top of BeanFactory Mangement it helps in more enterprise level applications
   
  ### DI - <br>
 * Dependency Injection, so when we talk of giving SpringBoot the right to create objects, here IOC is the Principle but DI is the real design Pattern how it is able to achieve this.<br>
 * Dependency Injections are preffered bcoz it helps avoid very tight coupling of classes, as loose couling enable easier testng and manintainabkity of code. 
  
  
