package com.mindstix.product.service;

import com.mindstix.product.entity.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanService {
    public List<Loan> getAllLoan();
    public Optional<Loan> findById(String loanId);
    public Loan addLone(Loan loan);
      public List<Loan> allByUserId(String userId);
//    public List<Loan> findByBankId(String bankId);
}
