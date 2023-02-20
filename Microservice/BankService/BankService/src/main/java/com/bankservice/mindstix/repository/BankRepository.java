package com.bankservice.mindstix.repository;

import com.bankservice.mindstix.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface BankRepository extends JpaRepository<Bank,String> {
}
