package com.mindstix.product.serviceImpl;

import com.mindstix.product.entity.Loan;
import com.mindstix.product.repository.LoanRepository;
import com.mindstix.product.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private LoanRepository loanRepository;

    @Override
    public List<Loan> getAllLoan() {
        return loanRepository.findAll();
    }
    @Override
    public Optional<Loan> findById(String loanId) {
        return loanRepository.findById(loanId);
    }

    @Override
    public Loan addLone(Loan loan) {
        loan.setLoanId(UUID.randomUUID().toString());
        return loanRepository.save(loan);
    }

    @Override
    public List<Loan> allByUserId(String userId) {
        List<Loan> loanList=loanRepository.findAll().stream().filter(l->l.getUserId().compareTo(userId)==0).collect(Collectors.toList());
        return loanList;
    }
//
//    @Override
//    public List<Loan> findByBankId(String bankId) {
//        return loanRepository.findByBankId(bankId);
//    }
}
