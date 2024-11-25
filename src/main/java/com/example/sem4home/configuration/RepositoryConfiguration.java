package com.example.sem4home.configuration;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "repository")
@ConfigurationPropertiesScan
@Data
public class RepositoryConfiguration {
    private String findAll;
    private String findUserById;
    private String save;
    private String deleteById;
    private String update;
}
