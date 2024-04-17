package com.example.pegination.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "pagination")
@Data
public class PaginationProperties {

    private Integer size;

}
