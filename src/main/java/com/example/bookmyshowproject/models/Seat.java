package com.example.bookmyshowproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Seat {
    @Id
    private int row;
    private int column;
    private int seatId;
    private String number;
    private String seatType;

}
