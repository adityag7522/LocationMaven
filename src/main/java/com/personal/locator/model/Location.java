package com.personal.locator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

/**
 *
 * @author aditya
 */
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String longitude;

    private String latitude;

    private String ipAddress;

    private String createdDate;

    public String getCreatedDate() {
        return createdDate;
    }

    public String setCreatedDate(String createdDate) {
        return this.createdDate = createdDate;
    }

    // getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String toString() {
        return "Location [id=" + id + ", longitude=" + longitude + ", latitude=" + latitude + ", ipAddress=" + ipAddress + ", createdDate=" + createdDate + "]";
    }

}
