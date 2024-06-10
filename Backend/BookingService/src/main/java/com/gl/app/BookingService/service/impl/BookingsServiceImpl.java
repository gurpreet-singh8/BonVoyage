package com.gl.app.BookingService.service.impl;

import com.gl.app.BookingService.Repository.BookingsRepository;
import com.gl.app.BookingService.entity.Bookings;
import com.gl.app.BookingService.exception.ResourceNotFoundException;
import com.gl.app.BookingService.payload.BookingsDto;
import com.gl.app.BookingService.service.BookingsService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class BookingsServiceImpl implements BookingsService {

    public BookingsServiceImpl(BookingsRepository bookingsRepository, ModelMapper modelMapper) {
        this.bookingsRepository = bookingsRepository;
        this.modelMapper = modelMapper;
    }

    private final BookingsRepository bookingsRepository;
    private final ModelMapper modelMapper;

    public Bookings maptoEntity(BookingsDto bookingsDto){
        return modelMapper.map(bookingsDto,Bookings.class);
    }
    public BookingsDto maptoDto(Bookings bookings){
        return modelMapper.map(bookings,BookingsDto.class);
    }
    @Override
    public BookingsDto createBookings(BookingsDto bookingsDto) {
        Bookings bookings = maptoEntity(bookingsDto);
         Bookings bookings1 = bookingsRepository.save(bookings);
        return maptoDto(bookings1);


    }

    @Override
    public BookingsDto updateBookings(BookingsDto bookingsDto) {
            Bookings bookings=bookingsRepository.findByUserId(bookingsDto.getUserId());
            Bookings bookings1=bookingsRepository.findById(bookings.getBookingId()).orElseThrow(
                    ()-> new ResourceNotFoundException("Bookings","userId",bookings.getUserId())
            );
            bookings1.setUserId(bookingsDto.getUserId());
            bookings1.setPackageId(bookingsDto.getPackageId());
            bookings1.setBookingDate(bookingsDto.getBookingDate());
            bookings1.setBookingPerson(bookingsDto.getBookingPerson());
            bookings1.setBookingRooms(bookingsDto.getBookingRooms());
            bookings1=bookingsRepository.save(bookings1);
            return maptoDto(bookings1);
    }

    @Override
    public List<BookingsDto> getAllBookings(){
        List<Bookings> bookings =bookingsRepository.findAll().stream().toList();

        List<BookingsDto> bookingsDtos= bookings.stream().map(this::maptoDto).toList();

        return bookingsDtos;
    }
//    @Override
//    public BookingsDto getBookings(String userId) {
//
//       Bookings bookings = bookingsRepository.findByUserId(userId);
//       Bookings bookings1 = bookingsRepository.findById(bookings.getBookingId()).orElseThrow(
//               ()-> new ResourceNotFoundException("Bookings","userId",userId)
//       );
//       return maptoDto(bookings1);
//
//    }

    @Override
    public String deleteBookings(String bookingId) {
        Bookings bookings=bookingsRepository.findById(bookingId).orElseThrow(
                ()-> new ResourceNotFoundException("Bookings","bookingId",bookingId)
        );
        bookingsRepository.deleteById(bookingId);
        return "Deleted";
    }
}
