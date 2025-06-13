package com.example.bookmyshowproject.controllers;

import com.example.bookmyshowproject.Dtos.SignUpRequestDto;
import com.example.bookmyshowproject.Dtos.SignUpResponseDto;
import com.example.bookmyshowproject.exceptions.UserNotFoundException;
import com.example.bookmyshowproject.models.user;
import com.example.bookmyshowproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public SignUpResponseDto signUp(SignUpRequestDto request) throws UserNotFoundException {
        user user = userService.createUser(request);
        return new SignUpResponseDto(user.getId(), HttpStatus.ACCEPTED);
    }
}
