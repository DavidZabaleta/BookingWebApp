package com.zaba.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    /**After the application starts, the beans are and the application context
     * are created, all the classes that implements CommandLineRunner are executed.
     * We can give them an order of execution as well.
     * In this case it's implemented to create the database.
     **/
    private BookingRepository bookingRepository;

    @Autowired
    public DatabaseSeeder(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    //A 'bookings' variable is created to save in a list every instance of the class 'HotelBooking'.
    @Override
    public void run(String... strings) throws Exception {

        List<HotelBooking> bookings = new ArrayList<>();

        bookings.add(new HotelBooking("Marriot", 210.5,4));
        bookings.add(new HotelBooking("Estelar", 120.4,3));

        bookingRepository.saveAll(bookings);
    }
}
