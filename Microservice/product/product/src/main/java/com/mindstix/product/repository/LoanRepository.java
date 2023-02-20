package com.mindstix.product.repository;

import com.mindstix.product.entity.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LoanRepository extends MongoRepository<Loan,String> {
//      List<Loan> findByUserId(String userId);
//    List<Loan> findByBankId(String bankId);
}
