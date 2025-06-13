package com.example.bookmyshowproject.repositories;

import com.example.bookmyshowproject.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingRepo extends JpaRepository<Booking, Long> {
}
