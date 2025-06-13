package com.example.bookmyshowproject.controllers;

import com.example.bookmyshowproject.Dtos.BookMovieRequestDto;
import com.example.bookmyshowproject.Dtos.BookMovieResponseDto;
import com.example.bookmyshowproject.exceptions.ShowNotFoundException;
import com.example.bookmyshowproject.exceptions.UserNotFoundException;
import com.example.bookmyshowproject.models.Booking;
import com.example.bookmyshowproject.services.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
    private BookingService bookingService;

    public BookMovieResponseDto BookMovie(BookMovieRequestDto request) throws UserNotFoundException, ShowNotFoundException {
        Booking booking = bookingService.bookMovie(request);
        return new BookMovieResponseDto(HttpStatus.ACCEPTED, booking.getBillingAmount(), booking.getId());
    }
}
