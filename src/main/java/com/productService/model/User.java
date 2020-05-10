package com.productService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class User {

    @NotBlank
    private String id;

    private String firstName;

    private String lastName;

    @NotBlank
    private String userName;

    private Address address;
}
