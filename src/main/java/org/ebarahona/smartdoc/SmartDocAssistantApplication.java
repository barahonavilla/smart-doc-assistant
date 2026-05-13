package org.ebarahona.smartdoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.ebarahona.smartdoc")
public class SmartDocAssistantApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartDocAssistantApplication.class, args);
    }
}