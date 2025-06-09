package com.example.bookmyshowproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

@Entity
public class Theatre {

    @Id
    private int theatre_id;
    private String theatre_name;
    private String theatre_address;
    private String theatre_city;
    private List<Screen> screen;
}
