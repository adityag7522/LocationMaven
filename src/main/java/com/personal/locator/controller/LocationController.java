/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.personal.locator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.personal.locator.model.Location;
import com.personal.locator.services.LocationService;

/**
 *
 * @author adity
 */

@RestController("")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/saveLocation")
    public ResponseEntity<?> saveLocation(@RequestBody Location location) {
        String res = locationService.saveLocation(location);
        System.out.println(location.toString());
        return ResponseEntity.ok(res);
    }

    @GetMapping("/api/v1/aditya/getLocations")
    public ResponseEntity<?> getLocations() {
        return ResponseEntity.ok().header("Content-Type", "application/json").body(locationService.getLocations());
    }
}
