package tn.esprit.stockmanagement.configuration;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author AMR MOUJBANI-PC ON 16/12/2021
 * @project IntelliJ IDEA
 */
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo () {
        return new ApiInfoBuilder()
                .title("Stock Management Swagger Configuration")
                .description("\"Spring Boot Swagger configuration\"")
                .version("1.1.0").build();
    }
}
