package com.productService.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Product {

    @Id
    String id;

    @NotBlank
    String name;

    @NotBlank
    String image;

    @NotBlank
    String price;

    @NotBlank
    String unit;

    String description;

    String rating;

    List<String> reviews;

    ProductStatus status;

    @NonNull
    List<PaymentMode> paymentmode;

    User sellerDetails;
}