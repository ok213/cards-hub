package com.example.advicecards;

import com.example.advicecards.configuration.AdviceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({AdviceProperties.class})
public class AdviceCardsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdviceCardsApplication.class, args);
    }

}
