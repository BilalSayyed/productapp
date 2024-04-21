package com.bca.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {
    private Integer id;
    @NotEmpty(
            message = "{product.name.absent}"
    )
    @Pattern(
            regexp = "([A-Za-z]+[A-Za-z]+)*"
    )
    private String name;
    @NotNull(
            message = "{product.price.absent}"
    )
    @Range(
            min = 10L,
            max = 200000L,
            message = "{product.name.invalid}"
    )
    private BigDecimal price;
}