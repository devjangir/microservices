package com.jangir.accountservice.controllers;

import com.jangir.accountservice.constants.AccountConstants;
import com.jangir.accountservice.dtos.AccountDto;
import com.jangir.accountservice.dtos.CustomerDto;
import com.jangir.accountservice.dtos.ResponseDto;
import com.jangir.accountservice.service.IAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
@Validated
@Tag(name = "Account Service",
        description = "Account Service API")
public class AccountController {
    private IAccountService accountService;

    @Value("${build.version}")
    private String buildVersion;

    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/greet")
    public String greeting() {
        return "Hello New User";
    }

    @PostMapping
    @Operation(summary = "Create Account REST API",
            description = "Create Account API")
    @ApiResponse(responseCode = "201",
            description = "Account created successfully")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto){
        accountService.createAccount(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountConstants.STATUS_201, AccountConstants.STATUS_201_MESSAGE));
    }

    @GetMapping
    @Operation(summary = "Get Account REST API",
            description = "Get Account API")
    @ApiResponse(responseCode = "200",
            description = "Account Details Fetched successfully")
    public ResponseEntity<CustomerDto> getCustomer( @RequestParam String mobileNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(accountService.getCustomer(mobileNumber));
    }

    @GetMapping("/version")
    public String getVersion() {
        return "Account Service Version: " + buildVersion;
    }
}
