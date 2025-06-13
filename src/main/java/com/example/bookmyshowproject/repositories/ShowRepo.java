package com.example.bookmyshowproject.repositories;

import com.example.bookmyshowproject.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepo extends JpaRepository<Show, Long> {
}
