package com.example.bookmyshowproject.models;

import com.example.bookmyshowproject.models.enums.Feature;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

@Entity
public class Screen {
    @Id
    private int Id;
    private String name;
    private List<Seat> seat;
    private List<Feature> feature;

}
