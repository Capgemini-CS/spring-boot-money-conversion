package com.money_converter.validator;

import com.money_converter.dto.ConversionDto;

public interface ValidatorInterface {
    ConversionDto validateConversionDto(ConversionDto conversionDto);
}
