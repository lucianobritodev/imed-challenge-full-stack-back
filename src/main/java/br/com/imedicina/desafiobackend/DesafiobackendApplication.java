package br.com.imedicina.desafiobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "br.com.imedicina.desafiobackend.domain.services",
        "br.com.imedicina.desafiobackend.domain.repositories",
        "br.com.imedicina.desafiobackend.resources",
        "br.com.imedicina.desafiobackend.configurations"
})
public class DesafiobackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesafiobackendApplication.class, args);
    }

}
