package com.zaba.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    private BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    //Method that returns in JSON all the bookings created.
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<HotelBooking> getAll() {
        return bookingRepository.findAll();
    }

    //Method that filter the hotels with an affordable price given by the user in the variable {price}.
    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    public List<HotelBooking> getAffordable(@PathVariable double price){
        return bookingRepository.findByPricePerNightLessThan(price);
    }

    //Create a new hotel via POST request in a JSON, the hotel is added to the 'bookings' list.
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking){
        bookingRepository.save(hotelBooking);
        return bookingRepository.findAll();
    }

    //Delete an existing hotel with the id provided in the URL
    @RequestMapping(value = "/delete/{id}")
    public  List<HotelBooking> remove(@PathVariable long id){
        bookingRepository.deleteById(id);

        return bookingRepository.findAll();
    }

}
