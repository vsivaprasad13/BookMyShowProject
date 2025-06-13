package com.example.bookmyshowproject.Dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class SignUpRequestDto {
    private String email;
    private String password;

}
