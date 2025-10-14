package com.Aniket.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A REST controller that exposes HTTP endpoints for testing the application.
 * <p>
 * This class demonstrates how to inject a Spring-managed component ({@link Dog})
 * using {@link Autowired} and expose REST APIs using {@link GetMapping}.
 * </p>
 *
 * @author Aniket
 * @version 1.0
 */
@RestController
public class MyClass {

    /**
     * An instance of {@link Dog} that is automatically injected by Spring.
     */
    @Autowired
    private Dog dog;

    /**
     * A simple GET endpoint mapped to <b>/ok</b>.
     * <p>
     * When called, it delegates to {@link Dog#fun()} and returns the response.
     * </p>
     *
     * @return a {@link String} message returned by {@link Dog#fun()}
     */
    @GetMapping("/ok")
    public String ok() {

        return dog.fun();
    }
}