package com.Aniket.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point of the Spring Boot application.
 * <p>
 * This class is annotated with {@link SpringBootApplication}, which marks it as the
 * primary Spring Boot configuration class. It triggers component scanning,
 * auto-configuration, and allows the application to be launched.
 * </p>
 *
 * @author Aniket
 * @version 1.0
 */
@SpringBootApplication
public class Application {

    /**
     * The main method which serves as the entry point of the Java application.
     * <p>
     * It delegates to {@link SpringApplication#run(Class, String...)} to bootstrap
     * the Spring context and launch the embedded web server.
     * </p>
     *
     * @param args command-line arguments passed during application startup
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
