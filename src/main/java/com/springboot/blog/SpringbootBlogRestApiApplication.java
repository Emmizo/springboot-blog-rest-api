package com.springboot.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Blog App REST API", description = "Blog app REST APIs documentation", version = "v1.0",
contact= @Contact(
	name="KWIZERA",
	email="emmizokwizera@gmail.com",
	url = "https://www.linkedin.com/in/kwizera-emmanuel-software-engineer/"
),
license= @License(
	name="apache 2.0",
	url="https://www.linkedin.com/in/kwizera-emmanuel-software-engineer/"
)
),
externalDocs = @ExternalDocumentation(
	description = "Spring boot Blog App documentation",
	url = "https://github.com/Emmizo/springboot-blog-rest-api"
)
)
public class SpringbootBlogRestApiApplication {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBlogRestApiApplication.class, args);
	}

}
