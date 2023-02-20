package com.bankservice.mindstix.serviceImpl;

import com.bankservice.mindstix.entity.Bank;
import com.bankservice.mindstix.exception.ResourceNotFoundException;
import com.bankservice.mindstix.repository.BankRepository;
import com.bankservice.mindstix.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class BankServiceImpl implements BankService {
    @Autowired
    private BankRepository bankRepository;
    @Override
    public Bank saveBank(Bank bank) {
        bank.setBankId(UUID.randomUUID().toString());
        return bankRepository.save(bank);
    }

    @Override
    public Bank getBank(String bankId) {
        return bankRepository.findById(bankId).orElseThrow(()->new ResourceNotFoundException());
    }

    @Override
    public List<Bank> getAllBank() {
        return bankRepository.findAll();
    }
}
