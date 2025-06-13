package com.example.bookmyshowproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Seat extends BaseModel {

    private int number;
    private String seatType;
    private int roNumber;
    private int coNumber;

}
