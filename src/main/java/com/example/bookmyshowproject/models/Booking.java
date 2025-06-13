package com.example.bookmyshowproject.models;


import com.example.bookmyshowproject.models.enums.BookingStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

@Entity
public class Booking extends BaseModel {
    private BookingStatus bookingStatus;

    @OneToMany
    private List<ShowSeat> showSeats;
    private int billingAmount;

    @OneToMany
    private List<Payment> payments;
}
