package com.bankservice.mindstix.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="bank")
public class Bank {
    @Id
    private String bankId;
    private String name;
    private long branchId;


}
