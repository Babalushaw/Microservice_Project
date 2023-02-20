package com.mindstux.userservice.Exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super("Resource not found on server ______");
    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}
