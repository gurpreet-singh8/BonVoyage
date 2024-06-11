package com.gl.app.BookingService.Repository;

import com.gl.app.BookingService.entity.Bookings;
import com.gl.app.BookingService.payload.BookingsDto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingsRepository extends JpaRepository<Bookings,String>{
    public List<Bookings> findByUserId(String userId);
}
