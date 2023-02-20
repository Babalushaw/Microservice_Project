package com.mindstix.product.controller;

import com.mindstix.product.entity.CreditCard;
import com.mindstix.product.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/creditcard")
public class CreditCardController {
    @Autowired
    private CreditCardService creditCardService;
    @PostMapping("/add")
    public ResponseEntity<CreditCard> saveCard(@RequestBody CreditCard creditCard){
        return ResponseEntity.status(HttpStatus.CREATED).body(creditCardService.addCreditcard(creditCard));
    }
    @GetMapping("/{creditCardId}")
    public ResponseEntity<Optional<CreditCard>> getCreditCard(@PathVariable String creditCardId){
        return ResponseEntity.status(HttpStatus.OK).body(creditCardService.findById(creditCardId));
    }
    @GetMapping("/all")
    public ResponseEntity<List<CreditCard>> getAllCreditCard(){
        return ResponseEntity.status(HttpStatus.OK).body(creditCardService.findAllCreditCard());
    }
//    @GetMapping("all/{bankId}")
//    public ResponseEntity<List<CreditCard>> getByBankId(@PathVariable String bankId){
//        return ResponseEntity.status(HttpStatus.OK).body(creditCardService.findByBankId(bankId));
//    }
//    @GetMapping("/{userId}")
//    public ResponseEntity<CreditCard> getByUserId(@PathVariable String userId){
//        return ResponseEntity.status(HttpStatus.OK).body(creditCardService.findByUserId(userId));
//    }

}
