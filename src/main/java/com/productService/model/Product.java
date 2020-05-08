package com.productService.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Product {

    @Id
    String id;

    @NonNull @NotBlank
    String name;

    @NonNull @NotBlank
    String image;

    @NonNull @NotBlank
    String price;

    @NonNull @NotBlank
    String unit;

    String description;

    String rating;

    List<String> reviews;

    @NonNull
    ProductStatus status;

    @NonNull
    List<PaymentMode> paymentmode;

    User sellerDetails;
}