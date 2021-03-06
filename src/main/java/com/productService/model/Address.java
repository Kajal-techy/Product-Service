package com.productService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Address {

    private int houseNumber;

    private int streetNo;

    private String streetName;

    private String city;

    private String state;

    private String country;

    private int pincode;
}
