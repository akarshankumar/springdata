package com.spring.springdata.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("author")
@Data
public class BasicConfiguration {
    private String name;
    private String salutation;
}
