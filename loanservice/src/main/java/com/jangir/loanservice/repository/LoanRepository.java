package com.jangir.loanservice.repository;

import com.jangir.loanservice.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loans, String> {
    Optional<Loans> findByMobileNumber(String mobileNumber);
}
