package com.jangir.loanservice.service;

import com.jangir.loanservice.dto.LoansDto;
import org.springframework.stereotype.Service;


public interface ILoanService {
    void createLoan(String mobileNumber);

    LoansDto getLoanDetails(String mobileNumber);
}
