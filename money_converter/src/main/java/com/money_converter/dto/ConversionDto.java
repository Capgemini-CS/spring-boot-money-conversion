package com.money_converter.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConversionDto {

    @Min(1)
    private int id;

    @NotBlank
    private String actualCurrency;

    @NotBlank
    private String newCurrency;

    @Min(0)
    @Max(100000)
    private double amount;

    @NotNull
    @Min(1)
    @Max(100)
    private double index;

    @Min(0)
    private double total;

}
