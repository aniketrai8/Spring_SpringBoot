package com.Aniket.SpringBoot;

import org.springframework.stereotype.Component;

/**
 * Represents a Dog component in the Spring Boot application.
 * <p>
 * This class is annotated with {@link Component}, making it a Spring-managed bean.
 * It can be injected into other components using dependency injection.
 * </p>
 *
 * @author Aniket
 * @version 1.0
 */
@Component
public class Dog {

    /**
     * A simple method that returns a placeholder message.
     * <p>
     * This method currently returns the string {@code "something"}.
     * It can be extended in the future to provide actual dog-related functionality.
     * </p>
     *
     * @return a {@link String} message
     */
    public String fun() {
        return "something";
    }
}
