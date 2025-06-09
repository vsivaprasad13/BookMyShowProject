package com.example.bookmyshowproject.models;

import com.example.bookmyshowproject.models.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Payment {
    @Id
    private int id;
    private long referenceNumber;;
    private Status Status;
    private long amount;;
    private String paymentProvider;
    private String mode;
}
