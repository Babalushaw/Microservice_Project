package com.bankservice.mindstix.controller;

import com.bankservice.mindstix.entity.Bank;
import com.bankservice.mindstix.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/bank")
@RestController
public class BankController {
    @Autowired
    private BankService bankService;
    @PostMapping("/add")
    public ResponseEntity<Bank> saveBank(@RequestBody Bank bank){
        return ResponseEntity.status(HttpStatus.CREATED).body(bankService.saveBank(bank));
    }
    @GetMapping("/{bankId}")
    public ResponseEntity<Bank> getBank(@PathVariable String bankId){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(bankService.getBank(bankId));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Bank>> getallBank(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(bankService.getAllBank());
    }
}
