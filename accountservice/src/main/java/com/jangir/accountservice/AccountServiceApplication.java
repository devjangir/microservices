package com.jangir.accountservice;

import com.jangir.accountservice.dtos.AccountContactInfoDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef="auditAwareImpl")
@EnableConfigurationProperties(AccountContactInfoDto.class)
@OpenAPIDefinition(info = @Info(
		title = "Account Service API",
		version = "1.0",
		description = "Documentation Account Service API v1.0",
		contact = @Contact(
				name = "Dev Jangir",
				email = "devpassion7@gmail.com"
		)))
public class AccountServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}
}
