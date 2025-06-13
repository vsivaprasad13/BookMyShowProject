package com.example.bookmyshowproject.services;


import com.example.bookmyshowproject.Dtos.SignUpRequestDto;
import com.example.bookmyshowproject.exceptions.UserNotFoundException;
import com.example.bookmyshowproject.models.user;
import com.example.bookmyshowproject.repositories.UserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public boolean login(String email, String password) throws UserNotFoundException {
        Optional<user> userOptional = userRepo.findByEmail(email);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException();
        }

        user existinguser = userOptional.get();
        return encoder.matches(password, existinguser.getPassword());
    }


    public user createUser(SignUpRequestDto request) throws UserNotFoundException {
        Optional<user> user = userRepo.findByEmail(request.getEmail());
        if (!user.isPresent()) {
            throw new UserNotFoundException();
        }

        user newuser = new user();
        newuser.setEmail(request.getEmail());
        newuser.setPassword(encoder.encode(request.getPassword()));

        return userRepo.save(newuser);

    }
}
