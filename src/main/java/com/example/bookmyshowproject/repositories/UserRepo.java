package com.example.bookmyshowproject.repositories;

import com.example.bookmyshowproject.models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<user, Long> {

    user save(user user);
}
