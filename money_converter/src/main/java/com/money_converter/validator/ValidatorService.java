package com.money_converter.validator;

import com.money_converter.dto.ConversionDto;
import com.money_converter.exception.InvalidOperationException;
import org.springframework.stereotype.Service;
import org.tinylog.Logger;

@Service
public class ValidatorService implements ValidatorInterface {

    @Override
    public ConversionDto validateConversionDto(ConversionDto conversionDto) {

        String actualCurrency = conversionDto.getActualCurrency();
        String newCurrency = conversionDto.getNewCurrency();

        if ((actualCurrency.length() < 3 || actualCurrency.length() > 20) ||
                (newCurrency.length() < 3 || newCurrency.length() > 20)) {
            Logger.error("Currency should have length between 2 and 20.");
            throw new InvalidOperationException("Invalid operation!");
        }
    return conversionDto;
    }

}
