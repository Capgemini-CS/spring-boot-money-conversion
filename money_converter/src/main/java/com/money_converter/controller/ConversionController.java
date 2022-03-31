package com.money_converter.controller;

import com.money_converter.dto.ConversionDto;
import com.money_converter.exception.ExceptionMessage;
import com.money_converter.exception.InvalidOperationException;
import com.money_converter.service.ConversionService;
import com.money_converter.validator.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.tinylog.Logger;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/exchange")
public class ConversionController {

    private ValidatorService validatorService;
    private ConversionService conversionService;

    @Autowired
    public ConversionController(ValidatorService validatorService, ConversionService conversionService) {
        this.validatorService = validatorService;
        this.conversionService = conversionService;
    }

    @ExceptionHandler({InvalidOperationException.class, MethodArgumentNotValidException.class} )
    public ResponseEntity<ExceptionMessage> handleInvalidOperationException(Exception e) {
        return new ResponseEntity(new ExceptionMessage("Invalid DTO!"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "/get-conversion")
    public ResponseEntity<ConversionDto> getConversion(@RequestParam int id){
        Logger.info("Conversion returned.");
        return new ResponseEntity<ConversionDto>(conversionService.getConversion(id), HttpStatus.OK);
    }

    @PostMapping(value = "/saved-conversion", consumes = "application/json")
    public ResponseEntity<ConversionDto> createConversion(@Valid @RequestBody ConversionDto conversionDto) {
        var conversion = conversionService.createConversion(conversionDto);
        Logger.info("Conversion created.");
        return ResponseEntity.ok(conversion);
    }

        @PatchMapping(value = "/update-conversion")
    public ResponseEntity<ConversionDto> updateConversion(@RequestParam int id,
                                                          @RequestParam  double amount) {
        return ResponseEntity.ok(conversionService.updateConversion(id, amount));
    }
}
