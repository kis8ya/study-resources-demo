package com.github.kis8ya.studyresourcesdemo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "greeting")
public class Greeting {

    private String name;
    private String mainPage;
}
