package com.mindstux.userservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Micro_user")
public class User {
    @Id
    @Column(name="ID")
    private String userId;
    @Column(name="Username")
    private String username;
    @Column(name="Gmail")
    private String email;
    @Transient
    private Bank bank;
    @Transient
    private List<CreditCard> creditCard;
    @Transient
    private List<Loan> loan;
}
