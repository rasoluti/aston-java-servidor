//package com.rasoluti.infrastructure.swagger;
//
//
//import java.util.Collections;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//
//@Configuration
//@EnableSwagger2
//@ConfigurationProperties(prefix = "app")
//public class SwaggerConfig {
//    private String name;
//
//    private String version;
//
//    private String description;
//
//    private String organization;
//
//    private String contextPath;
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("br.com.fujioka"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo())
//                .useDefaultResponseMessages(false);
//    }
//
//    private ApiInfo apiInfo() {
//
//        return new ApiInfo(
//                name,
//                description,
//                version,
//                "",
//                new Contact(
//                        organization, "https://www.fujiokadistribuidor.com.br/", "fujiokati@fujioka.inf.br"),
//                "Licença Swagger",
//                "https://swagger.io/license/",
//                Collections.emptyList());
//    }
//}
