package com.jangir.loanservice.mapper;

import com.jangir.loanservice.dto.LoansDto;
import com.jangir.loanservice.entity.Loans;

public class LoanMapper {
    public static LoansDto mapToLoanDto(Loans loan, LoansDto loanDto) {
        loanDto.setMobileNumber(loan.getMobileNumber());
        loanDto.setLoanNumber(loan.getLoanNumber());
        loanDto.setLoanType(loan.getLoanType());
        loanDto.setTotalLoan(loan.getTotalLoan());
        loanDto.setAmountPaid(loan.getAmountPaid());
        loanDto.setOutstandingAmount(loan.getOutstandingAmount());
        return loanDto;
    }
}
