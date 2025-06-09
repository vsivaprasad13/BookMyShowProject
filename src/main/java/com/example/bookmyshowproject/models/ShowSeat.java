package com.example.bookmyshowproject.models;

import com.example.bookmyshowproject.models.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeat {
    private Show show;
    private Seat seat;
    private Status status;
}
