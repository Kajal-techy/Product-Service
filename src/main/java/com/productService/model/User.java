package com.productService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class User {

    @NonNull
    @NotBlank
    @NotEmpty
    private String id;

    private String firstName;

    private String lastName;

    @NonNull
    @NotBlank
    @NotEmpty
    private String userName;

    private Address address;
}
