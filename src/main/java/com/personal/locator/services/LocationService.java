package com.personal.locator.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.personal.locator.model.Location;
import com.personal.locator.repository.LocationRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
/**
 * 
 * @author adity
 */

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    @Value("${TWILIO_ACCOUNT_SID}")
    private String sid;

    @Value("${TWILIO_AUTH_TOKEN}")
    private String token;

    
    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public String saveLocation(Location location) {
        locationRepository.save(location);
        String msg = "Location Coordinate: " + location.getLongitude() + ", " + location.getLatitude() + "\nIP Address: " + location.getIpAddress();
        System.out.println(sid + " " + token);
        Twilio.init(sid,token);
        Message message = Message
        .creator(new PhoneNumber("+919718833248"),
                new PhoneNumber("+13203141930"), msg)
        .create();
        
        return message.toString();
    }

    public List<Location> getLocations() {
        List<Location> locations = locationRepository.findAll();
        locations.sort((o2, o1) -> o1.getCreatedDate().compareTo(o2.getCreatedDate()));
        return locations;
    }
}
