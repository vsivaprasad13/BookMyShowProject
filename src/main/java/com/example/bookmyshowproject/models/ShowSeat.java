package com.example.bookmyshowproject.models;



import com.example.bookmyshowproject.models.enums.ShowSeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;

    @ManyToOne
    private Seat seat;

    @UpdateTimestamp
    private Instant lockedAt;

    private ShowSeatStatus showSeatStatus;
}
