package com.helloWorld.beautyShop.DTOs;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
public class ProductInventoryForm {

    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotNull(message = "Price is mandatory")
    private BigDecimal price;

    @NotNull(message = "Quantity is mandatory")
    private Integer quantity;

    private String formType;

    public ProductInventoryForm(String name, String description, BigDecimal price, Integer quantity, String formType) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.formType = formType;
    }
}

