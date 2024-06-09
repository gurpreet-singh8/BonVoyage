package com.gl.app.BookingService.controller;


import com.gl.app.BookingService.payload.BookingsDto;
import com.gl.app.BookingService.service.BookingsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("bookings")
public class BookingsController {
     BookingsService bookingsService;

    public BookingsController(BookingsService bookingsService) {
        this.bookingsService = bookingsService;
    }



    @GetMapping("/{userId}")
    public List<BookingsDto> getAllBookings(@PathVariable String userId){
        List<BookingsDto> bookingsDto = bookingsService.getAllBookings(userId);
        return bookingsDto;
    }
    @PutMapping
    public ResponseEntity<BookingsDto> updateBookings(@RequestBody BookingsDto bookingsDto){
        BookingsDto bookingsDto1=bookingsService.updateBookings(bookingsDto);
        return new ResponseEntity<>(bookingsDto1,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<BookingsDto> createBookings(@RequestBody BookingsDto bookingsDto){
        BookingsDto bookingsDto1 = bookingsService.createBookings(bookingsDto);
        return new ResponseEntity<>(bookingsDto1,HttpStatus.CREATED);
    }
    @DeleteMapping("/{bookingId}")
    public String deleteBookings(@PathVariable String bookingId){
        return bookingsService.deleteBookings(bookingId);
    }
}
