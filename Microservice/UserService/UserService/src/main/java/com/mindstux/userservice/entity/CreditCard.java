package com.mindstux.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CreditCard {
    private String creditCardId;
    private float amountLimit;
    private String expiryDate;
}
