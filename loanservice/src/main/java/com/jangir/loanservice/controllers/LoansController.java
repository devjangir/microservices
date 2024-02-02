package com.jangir.loanservice.controllers;

import com.jangir.loanservice.dto.LoansDto;
import com.jangir.loanservice.dto.ResponseDto;
import com.jangir.loanservice.service.ILoanService;
import com.jangir.loanservice.service.LoanServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/loan")
public class LoansController {
    ILoanService loanService;
    @PostMapping
    public ResponseEntity<ResponseDto> createLoan(@RequestParam String mobileNumber) {
        loanService.createLoan(mobileNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseDto("201", "Loan Created")
        );
    }

    @GetMapping
    public ResponseEntity<LoansDto> fetchLoanDetails(@RequestParam String mobileNumber) {
        LoansDto dto = loanService.getLoanDetails(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PutMapping
    public String updateLoan() {
        return "Loan Updated";
    }

    @DeleteMapping
    public String deleteLoan() {
        return "Loan Deleted";
    }
}
