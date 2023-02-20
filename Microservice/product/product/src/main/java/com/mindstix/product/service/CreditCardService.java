package com.mindstix.product.service;

import com.mindstix.product.entity.CreditCard;

import java.util.List;
import java.util.Optional;

public interface CreditCardService {
   public CreditCard addCreditcard(CreditCard creditCard);
   public List<CreditCard> findAllCreditCard();
   public Optional<CreditCard> findById(String creditCardId);
//   public List<CreditCard> findByBankId(String bankId);
//   public CreditCard findByUserId(String userId);
}
