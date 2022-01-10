package com.locadora.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String BASIC_AUTH = "basicAuth";
	private static final String APPLICATION_JSON = "application/json";

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.locadora"))
				.build()
				.consumes(getContentType())
				.produces(getContentType())
				.apiInfo(apiInfo())
				.securitySchemes(Arrays.asList(securityScheme()))
				.securityContexts(Arrays.asList(securityContexts()));
	}

	private SecurityContext securityContexts() {
		return SecurityContext.builder()
				.securityReferences(Arrays.asList(basicAuthReference()))
				.forPaths(PathSelectors.any())
				.build();
	}

	private SecurityScheme securityScheme() {
		return new BasicAuth(BASIC_AUTH);
	}

	private SecurityReference basicAuthReference() {
		return new SecurityReference(BASIC_AUTH, new AuthorizationScope[0]);
	}

	private Set<String> getContentType() {
		final HashSet<String> mediaType = new HashSet<>();
		mediaType.add(APPLICATION_JSON);
		return mediaType;
	}

	public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Locadora-API")
                .description("Locadora-API é a API de um sistema de locação de filmes.")
                .contact(new Contact("Marcos Esmeraldino", null, "marcosesmeraldino@gmail.com"))
                .build();
	}
}