package io.instacode.automation.department.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SpringFoxConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(new ApiInfoBuilder()
            .title("Automation University")
            .description("University REST Service")
            .version("1.0")
            .license("MIT")
            .build())
        .select()
        .apis(RequestHandlerSelectors.basePackage("io.instacode.university"))
        .paths(PathSelectors.any())
        .build();
  }
}
