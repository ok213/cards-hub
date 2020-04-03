package com.example.advicecards.configuration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "advice")
public class AdviceProperties {
    private String executeUrl;
}
