package com.example.bookmyshowproject.services;

import com.example.bookmyshowproject.Dtos.BookMovieRequestDto;
import com.example.bookmyshowproject.exceptions.SeatsNotFoundException;
import com.example.bookmyshowproject.exceptions.ShowNotFoundException;
import com.example.bookmyshowproject.exceptions.UserNotFoundException;
import com.example.bookmyshowproject.models.*;
import com.example.bookmyshowproject.models.enums.BookingStatus;
import com.example.bookmyshowproject.models.enums.ShowSeatStatus;
import com.example.bookmyshowproject.repositories.BookingRepo;
import com.example.bookmyshowproject.repositories.ShowRepo;
import com.example.bookmyshowproject.repositories.ShowSeatRepo;
import com.example.bookmyshowproject.repositories.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.transaction.annotation.Isolation.SERIALIZABLE;

@Service
public class BookingService {

    private UserRepo userRepo;
    private BookingRepo bookingRepo;
    private ShowRepo showRepo;
    private ShowSeatRepo showSeatRepo;


    public Booking bookMovie(BookMovieRequestDto request) throws UserNotFoundException, ShowNotFoundException, SeatsNotFoundException {

        //validate if user is present or not
        // validate id show is present or not
        // reserve Showseats
        // createbooking object

        validateUser(request);

        validateShow(request);

        List<ShowSeat> reserveSeats = reserveSeats(request.getShowSeatIds());

        Booking booking = createBooking(reserveSeats);

        return bookingRepo.save(booking);
    }

    private static Booking createBooking(List<ShowSeat> reserveSeats) {
        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.pending);
        booking.setShowSeats(reserveSeats);
        booking.setBillingAmount(1000);
        booking.setPayments(new ArrayList<>());
        return booking;
    }

    private void validateShow(BookMovieRequestDto request) throws ShowNotFoundException {
        Optional<Show> show = showRepo.findById(request.getShowId());
        if (!show.isPresent()) {
            throw new ShowNotFoundException();
        }
    }

    private void validateUser(BookMovieRequestDto request) throws UserNotFoundException {
        Optional<user> user = userRepo.findById(request.getUserId());
        if (!user.isPresent()) {
            throw new UserNotFoundException();
        }
    }

    @Transactional(isolation = SERIALIZABLE)
    public List<ShowSeat> reserveSeats(List<Long> showSeatIds) throws SeatsNotFoundException {
        List<ShowSeat> showSeats = showSeatRepo.findAllById(showSeatIds);
        boolean allAvailable = areAllSeatsAvailable(showSeats, true);

        if (allAvailable) {
            marksSeatsAsLocked(showSeats);
        }

        if (!allAvailable) {
            throw new SeatsNotFoundException();
        }

        return showSeats;
    }

    private void marksSeatsAsLocked(List<ShowSeat> showSeats) {
        for (ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatRepo.save(showSeat);
        }
    }

    private static boolean areAllSeatsAvailable(List<ShowSeat> showSeats, boolean allAvailable) {


        for(ShowSeat showSeat : showSeats) {
            if (showSeat.getLockedAt().equals(ShowSeatStatus.LOCKED)) {
                Long lockDuration = Duration.between(showSeat.getLockedAt(), new Date().toInstant()).toMinutes();
                if (lockDuration<5) {
                    allAvailable = false;
                    break;
                }
            }
            else if(showSeat.getLockedAt().equals(ShowSeatStatus.BOOKED)){
                allAvailable = false;break;
            }

        }
        return allAvailable;
    }
}
