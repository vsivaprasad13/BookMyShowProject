package com.example.bookmyshowproject.repositories;

import com.example.bookmyshowproject.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatRepo extends JpaRepository<ShowSeat, Long> {
}
