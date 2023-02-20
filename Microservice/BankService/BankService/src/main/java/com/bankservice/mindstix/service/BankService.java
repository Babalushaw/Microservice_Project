package com.bankservice.mindstix.service;

import com.bankservice.mindstix.entity.Bank;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BankService {
    public Bank saveBank(Bank bank);
    public Bank getBank(String bankId);
    public List<Bank> getAllBank();
}
