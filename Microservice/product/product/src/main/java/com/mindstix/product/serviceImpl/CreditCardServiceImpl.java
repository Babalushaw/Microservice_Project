package com.mindstix.product.serviceImpl;

import com.mindstix.product.entity.CreditCard;
import com.mindstix.product.repository.CreditCardRepository;
import com.mindstix.product.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CreditCardServiceImpl implements CreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;


    @Override
    public CreditCard addCreditcard(CreditCard creditCard) {
        creditCard.setCreditCardId(UUID.randomUUID().toString());
        creditCard.setExpiryDate((new Date()).toString());
        return creditCardRepository.save(creditCard);
    }

    @Override
    public List<CreditCard> findAllCreditCard() {
        return creditCardRepository.findAll();
    }
    @Override
    public Optional<CreditCard> findById(String creditCardId) {
        return creditCardRepository.findById(creditCardId);
    }

//    @Override
//    public CreditCard findByUserId(String userId) {
//        return creditCardRepository.findByUserId(userId);
//    }
//    @Override
//    public List<CreditCard> findByBankId(String bankId) {
//        return creditCardRepository.findByBankId(bankId);
//    }
}
