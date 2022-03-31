package com.money_converter.service;

import com.money_converter.dto.ConversionDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConversionService implements ConversionInterface {

    private ConversionDto conversionDto;
    static private List<ConversionDto> conversionDtoList = new ArrayList<>();

    @Override
    public ConversionDto createConversion(ConversionDto conversionDto) {

        conversionDtoList.add(this.conversionDto = ConversionDto.builder()
                .id(conversionDto.getId())
                .actualCurrency(conversionDto.getActualCurrency())
                .newCurrency(conversionDto.getNewCurrency())
                .index(conversionDto.getIndex())
                .build());
        return this.conversionDto;
    }

    private double executeConversion() {
        return conversionDto.getIndex() * conversionDto.getAmount();
    }

    @Override
    public ConversionDto updateConversion(int id, double amount) {

        ConversionDto conversionDto = getConversion(id);

        conversionDto.setAmount(amount);
        conversionDto.setTotal(executeConversion());

        return conversionDto;
    }


    @Override
    public ConversionDto getConversion(int id) {
        for(ConversionDto conversionDto : conversionDtoList){
            if(conversionDto.getId() == id){
                this.conversionDto = conversionDto;
            }
        }
        return conversionDto;
    }
}
