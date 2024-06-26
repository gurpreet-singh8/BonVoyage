package com.gl.app.BookingService.service;

import com.gl.app.BookingService.payload.BookingsDto;

import java.util.List;

public interface BookingsService {
    public BookingsDto createBookings(BookingsDto bookingsDto);

    public BookingsDto updateBookings(BookingsDto bookingsDto);

//    public BookingsDto getBookings(String bookingId);

    public List<BookingsDto> getAllBookingsBy(String userId);
    public List<BookingsDto> getAllBookings();

    public String deleteBookings(String bookingId);
}
