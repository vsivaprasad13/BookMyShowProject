package com.example.bookmyshowproject.models;

import com.example.bookmyshowproject.models.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

@Entity
public class Booking {
    @Id
    private int bookingID;
    private Status status;
    private List<ShowSeat> showSeat;
    private long amount;
    private List<Payment> payment;
}
