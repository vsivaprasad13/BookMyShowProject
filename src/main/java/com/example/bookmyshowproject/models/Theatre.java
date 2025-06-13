package com.example.bookmyshowproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

@Entity
public class Theatre extends BaseModel{


    private String name;
    private String address;
    private String city;

    @OneToMany
    private List<Screen> screen;
}
