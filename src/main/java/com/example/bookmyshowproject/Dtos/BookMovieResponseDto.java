package com.example.bookmyshowproject.Dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
public class BookMovieResponseDto {
    private Long BookingId;
    private int amount;
    private HttpStatus responseStatus;

    public BookMovieResponseDto(HttpStatus responseStatus, int billingAmount, Long id) {
        this.responseStatus = responseStatus;
        this.BookingId = id;
        this.amount = billingAmount;
    }
}
