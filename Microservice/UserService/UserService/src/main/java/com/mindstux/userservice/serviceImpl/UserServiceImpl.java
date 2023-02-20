package com.mindstux.userservice.serviceImpl;

import com.mindstux.userservice.Exception.ResourceNotFoundException;
import com.mindstux.userservice.entity.Loan;
import com.mindstux.userservice.entity.User;
import com.mindstux.userservice.external.services.ProductService;
import com.mindstux.userservice.repository.UserRepository;
import com.mindstux.userservice.service.UserService;
import com.netflix.discovery.converters.Auto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Repository
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProductService productService;
    @Override
    public User saveUser(User user) {
        String userId= UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        // get user by id
        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Not found with id" + userId));
        /*
        fetching laon and credit card from product service
        http://localhost:8084/loan/user/userId
         */
//        ArrayList loanList=restTemplate.getForObject( "http://PRODUCT-SERVICE/loan/user/"+userId, ArrayList.class);
        ArrayList loanList= (ArrayList) productService.getLoan(userId);
        Logger log= LoggerFactory.getLogger(UserServiceImpl.class);
//        log.info("",loanList);
        user.setLoan(loanList);
        return user;
    }
}
