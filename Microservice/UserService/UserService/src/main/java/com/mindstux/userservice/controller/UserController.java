package com.mindstux.userservice.controller;

import com.mindstux.userservice.entity.User;
import com.mindstux.userservice.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    Logger log= LoggerFactory.getLogger(UserController.class);
    @PostMapping("/add")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        try{
            User user1=userService.saveUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(user1);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    int retryCount=1;
    @GetMapping("/userId/{userId}")
//    @CircuitBreaker(name="loanServiceBreaker",fallbackMethod = "loanfallbackmethod")
//    @Retry(name="loanServiceRetry",fallbackMethod = "loanfallbackmethod")
    @RateLimiter(name="userRateLimiter", fallbackMethod ="loanfallbackmethod" )
    public ResponseEntity<User> getUser(@PathVariable String userId){
        log.info("Retry count: {}",retryCount);
        retryCount++;
        User user1 =userService.getUser(userId);
        return ResponseEntity.ok(user1);
    }

    public ResponseEntity<User> loanfallbackmethod(String userId,Exception ex){
//        log.info("fallback executed because service is down",ex.getMessage());

        User user= new User();
        user.setUserId("unknown");user.setEmail("unknown");user.setUsername("dummy");
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> list =userService.getAllUser();
        return ResponseEntity.ok(list);
    }
}
