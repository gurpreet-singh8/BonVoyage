package com.gl.app.BookingService.Repository;

import com.gl.app.BookingService.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingsRepository extends JpaRepository<Bookings,String>{
    public Bookings findByUserId(String userId);
}
