package com.springboot.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.blog.entity.Role;
import com.springboot.blog.repository.RoleRepository;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

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
public class SpringbootBlogRestApiApplication implements CommandLineRunner{
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBlogRestApiApplication.class, args);
	}

	@Autowired
	private RoleRepository roleRepository;
	@Override
	public void run(String... args) throws Exception {
		Role adminRole =  new Role();
		adminRole.setName("ROLE_ADMIN");
		roleRepository.save(adminRole);
		Role userRole = new Role();
		userRole.setName("ROLE_USER");
		roleRepository.save(userRole);
	}

}
