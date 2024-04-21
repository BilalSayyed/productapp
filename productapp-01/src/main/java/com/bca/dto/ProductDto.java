package com.bca.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@ToString
public class ProductDto {
//    @NotEmpty
    private Integer id;
    @NotEmpty(message = "{product.name.absent}")
    @Pattern(regexp = "([A-Za-z]+[A-Za-z]+)*")
    private String name;
    @NotNull(message = "{product.price.absent}")
    @Range(min = 10, max = 200000, message = "{product.name.invalid}")
    private BigDecimal price;


}
