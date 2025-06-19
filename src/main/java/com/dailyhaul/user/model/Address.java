package com.dailyhaul.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String id;

    private String street;

    private String city;

    private String state;

    private String country;

    private String zipcode;

    public Address(String street, String city, String state, String country, String zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
    }
}
