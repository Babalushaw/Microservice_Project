package com.mindstix.product.repository;

import com.mindstix.product.entity.CreditCard;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CreditCardRepository extends MongoRepository<CreditCard,String> {
//    CreditCard findByUserId(String userId);
//
//    List<CreditCard> findByBankId(String bankId);
}
