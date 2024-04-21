package com.bca.config;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@Data
@ConfigurationProperties(prefix = "spring.datasource1")
@Validated
public class DbConfig {
    @NotEmpty
    String url;
    @NotEmpty
    String username;
    @NotEmpty
    String password;
    @NotEmpty
    String driverClassName;
}
