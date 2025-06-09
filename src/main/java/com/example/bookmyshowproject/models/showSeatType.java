package com.example.bookmyshowproject.models;

import com.example.bookmyshowproject.models.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class showSeatType {

    @Id
    private Show show;
    private SeatType seatType;
    private long price;
}
