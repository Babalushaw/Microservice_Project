package com.mindstux.userservice.external.services;

import com.mindstux.userservice.entity.Loan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="PRODUCT-SERVICE")
public interface ProductService {
//    Declarative approach
    @GetMapping("/loan/user/{userId}")
    public List<Loan> getLoan(@PathVariable String userId);
}
