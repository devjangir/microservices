package com.jangir.loanservice.service;

import com.jangir.loanservice.constants.LoanConstants;
import com.jangir.loanservice.dto.LoansDto;
import com.jangir.loanservice.entity.Loans;
import com.jangir.loanservice.exception.LoanAlreadyExistException;
import com.jangir.loanservice.exception.ResourceNotFoundException;
import com.jangir.loanservice.mapper.LoanMapper;
import com.jangir.loanservice.repository.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements ILoanService {
    LoanRepository loanRepository;
    @Override
    public void createLoan(String mobileNumber) {
        // first check loan already exist for the mobile number
        Optional<Loans> loanOptional = loanRepository.findByMobileNumber(mobileNumber);
        if(loanOptional.isPresent()){
            throw new LoanAlreadyExistException("Loan already exist for mobile number: "+mobileNumber);
        }
        loanRepository.save(createNewLoan(mobileNumber));
        System.out.println("Loan created for mobile number: " + mobileNumber);
    }

    private Loans createNewLoan(String mobileNumber) {
        Loans newLoan = new Loans();
        long loanNumber = 10000000000L + new Random().nextInt(1000000000);
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanNumber(Long.toString(loanNumber));
        newLoan.setLoanType(LoanConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoanConstants.NEW_LOAN_LIMIT);
        newLoan.setOutstandingAmount(LoanConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setCreatedAt(LocalDateTime.now());
        newLoan.setCreatedBy("SYSTEM");
        return newLoan;
    }

    @Override
    public LoansDto getLoanDetails(String mobileNumber) {
        Loans loanOptional = loanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan not found with mobile number: " + mobileNumber)
        );
        return LoanMapper.mapToLoanDto(loanOptional, new LoansDto());
    }
}
