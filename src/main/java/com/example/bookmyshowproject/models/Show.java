package com.example.bookmyshowproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

@Entity
public class Show extends BaseModel {

    private Date startTime;
    private Date endTime;
    private String Movie;

    @OneToOne
    private Screen screen;


}
