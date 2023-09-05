package com.importer.importxmlbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ImportXmlBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImportXmlBackendApplication.class, args);
    }

}
