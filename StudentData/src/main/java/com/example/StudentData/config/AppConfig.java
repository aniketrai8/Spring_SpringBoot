package com.example.StudentData.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Application configuration component that loads custom properties
 * from the application's configuration file (e.g., {@code application.properties}).
 * <p>
 * This class is annotated with {@link Component}, making it a Spring-managed bean.
 * It uses {@link Value} annotations to inject property values at runtime.
 * </p>
 *
 * Example usage in {@code application.properties}:
 * <pre>
 * app.name=Student Management System
 * app.version=1.0.0
 * app.author=Aniket
 * </pre>
 *
 * These values can be accessed in the application via the provided getter methods.
 *
 * @author Aniket
 * @version 1.0
 */
@Component
public class AppConfig {

    /** The application name loaded from the configuration. */
    @Value("${app.name}")
    private String appName;

    /** The application version loaded from the configuration. */
    @Value("${app.version}")
    private String appVersion;

    /** The application author loaded from the configuration. */
    @Value("${app.author}")
    private String appAuthor;

    /**
     * Gets the application name.
     *
     * @return the configured application name
     */
    public String getAppName() {
        return appName;
    }

    /**
     * Gets the application version.
     *
     * @return the configured application version
     */
    public String getAppVersion() {
        return appVersion;
    }

    /**
     * Gets the application author.
     *
     * @return the configured application author
     */
    public String getAppAuthor() {
        return appAuthor;
    }
}
