package com.mindstix.product.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("credit-card-product")
public class CreditCard {
    @Id
    private String creditCardId;
    private float amountLimit;
    private String expiryDate;
    private String userId;
}
