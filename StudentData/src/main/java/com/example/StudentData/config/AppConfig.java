package com.example.StudentData.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @Value("${app.author}")
    private String appAuthor;

    public String getAppName(){
        return appName;
    }

    public String getAppVersion(){
        return appVersion;
    }

    public String getAppAuthor(){
        return appAuthor;
    }
}
