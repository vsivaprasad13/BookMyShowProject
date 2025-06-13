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
public class user {
    @Id
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String password;

    @OneToMany
    private List<Booking> booking;

}
