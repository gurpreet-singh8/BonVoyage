package com.gl.app.BookingService.controller;


import com.gl.app.BookingService.payload.BookingsDto;
import com.gl.app.BookingService.payload.ResponseDto;
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
    @CrossOrigin("*")
    @GetMapping()
    public List<BookingsDto> getAllBookings(){
        List<BookingsDto> bookingsDto = bookingsService.getAllBookings();
        return bookingsDto;
    }
    @CrossOrigin("*")

    @GetMapping("/{userId}")
    public List<BookingsDto> getAllBookingsById(@PathVariable(name = "userId") String userId){
        List<BookingsDto> bookingsDto = bookingsService.getAllBookingsBy(userId);
        return bookingsDto;
    }
    @CrossOrigin("*")
    @PutMapping
    public ResponseEntity<BookingsDto> updateBookings(@RequestBody BookingsDto bookingsDto){
        BookingsDto bookingsDto1=bookingsService.updateBookings(bookingsDto);
        return new ResponseEntity<>(bookingsDto1,HttpStatus.OK);
    }
    @CrossOrigin("*")
    @PostMapping
    public ResponseEntity<BookingsDto> createBookings(@RequestBody BookingsDto bookingsDto){
        BookingsDto bookingsDto1 = bookingsService.createBookings(bookingsDto);
        return new ResponseEntity<>(bookingsDto1,HttpStatus.CREATED);
    }
    @CrossOrigin("*")
    @DeleteMapping("/{bookingId}")
    public ResponseDto deleteBookings(@PathVariable String bookingId){
        return new ResponseDto(bookingsService.deleteBookings(bookingId));
    }
}
