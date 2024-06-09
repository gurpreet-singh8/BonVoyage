package com.gl.app.BookingService;

import java.util.concurrent.atomic.AtomicInteger;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.ModelMap;

@SpringBootApplication
public class BookingServiceApplication {
	@Bean
	ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(BookingServiceApplication.class, args);
	}
	private static final AtomicInteger counter = new AtomicInteger(100); 

    public static String generateId(String prefix) {
        int currentValue = counter.incrementAndGet();
        return prefix + currentValue;
    }

}
