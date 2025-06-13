package com.example.bookmyshowproject.models;

import com.example.bookmyshowproject.models.enums.PaymentMode;
import com.example.bookmyshowproject.models.enums.BookingStatus;
import com.example.bookmyshowproject.models.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Payment extends BaseModel {

    private String refNumber;
    private PaymentStatus paymentStatus;
    private int amount;
    private String provider;
    private PaymentMode paymentMode;
}
