package com.jangir.accountservice.dtos;

import io.swagger.v3.oas.models.annotations.OpenAPI30;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.pl.REGON;

@Data
public class CustomerDto {

    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;
    @NotNull(message = "Mobile number cannot be null")
    @Pattern(regexp = "[0-9]{10}", message = "Mobile number should be valid")
    private String mobileNumber;
    private AccountDto accountDto;
}
