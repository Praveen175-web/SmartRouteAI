package com.smartrouteai.model;

public class UserDetails {

    private String name;
    private String phone;
    private String gmail;
    private String source;
    private String destination;
    private String vehicleType;

    public UserDetails() {
    }

    public UserDetails(
            String name,
            String phone,
            String gmail,
            String source,
            String destination,
            String vehicleType) {

        this.name = name;
        this.phone = phone;
        this.gmail = gmail;
        this.source = source;
        this.destination = destination;
        this.vehicleType = vehicleType;
    }

    // Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Gmail
    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    // Source
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    // Destination
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    // Vehicle Type
    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", gmail='" + gmail + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }
}