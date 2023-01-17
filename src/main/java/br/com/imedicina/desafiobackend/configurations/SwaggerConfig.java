package br.com.imedicina.desafiobackend.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Value("${swagger.scan.base-package}")
    private String basePackages;

    private ApiInfo apiInfo() {
        return new ApiInfo("API Desafio Backend IMedicina",
                "API desenvolvinda em desafio backend",
                "1.0.0",
                "Uso para estudos permitindo alteração ou melhorias e redistribuição",
                new Contact("Luciano Brito", "linkedin.com/in/luciano-brito-dev", "lucianobrito.dev@gmail.com"),
                "MIT License",
                "github.com/lucianobritodev/imed-challenge-full-stack-back",
                Collections.emptyList());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackages))
                .paths(PathSelectors.any())
                .build();
    }

}
