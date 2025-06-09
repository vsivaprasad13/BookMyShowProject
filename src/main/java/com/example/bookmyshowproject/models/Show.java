package com.example.bookmyshowproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Show {
    @Id
    private int id;
    private int startTime;
    private int endTime;
    private String Movie;
    @OneToOne(mappedBy = "Screen")
    private Screen screen;


}
