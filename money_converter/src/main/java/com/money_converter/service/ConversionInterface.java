package com.money_converter.service;

import com.money_converter.dto.ConversionDto;

public interface ConversionInterface {


    ConversionDto createConversion(ConversionDto conversionDto);


    ConversionDto updateConversion(int id, double amount);

    ConversionDto getConversion(int id);
}
