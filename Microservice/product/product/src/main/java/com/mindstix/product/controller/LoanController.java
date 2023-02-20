package com.mindstix.product.controller;

import com.mindstix.product.entity.Loan;
import com.mindstix.product.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loan")
public class LoanController {
    @Autowired
    private LoanService loanService;
    @PostMapping("/add")
    public ResponseEntity<Loan> addLoan(@RequestBody Loan loan){
        return ResponseEntity.status(HttpStatus.CREATED).body(loanService.addLone(loan));
    }
    @GetMapping("/{loanId}")
    public ResponseEntity<Optional<Loan>> getLoanById(@PathVariable String loanId){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.findById(loanId));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Loan>> getAllLoan(){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.getAllLoan());
    }
//    @GetMapping("/all/{bankId}")
//    public ResponseEntity<List<Loan>> getAllByBankId(@PathVariable String bankId){
//        return ResponseEntity.status(HttpStatus.OK).body(loanService.findByBankId(bankId));
//    }
    @GetMapping("user/{userId}")
    public ResponseEntity<List<Loan>> getByUserId(@PathVariable String userId){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.allByUserId(userId));
    }
}
