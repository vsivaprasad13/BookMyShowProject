package com.example.bookmyshowproject.Dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class SignUpResponseDto {

    private Long userId;
    private HttpStatus httpStatus;

    public SignUpResponseDto(Long id, HttpStatus httpStatus) {
        this.userId = id;
        this.httpStatus = HttpStatus.ACCEPTED;
    }
}
