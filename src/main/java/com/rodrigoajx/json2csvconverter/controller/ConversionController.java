package com.rodrigoajx.json2csvconverter.controller;

import com.rodrigoajx.json2csvconverter.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/converter")
public class ConversionController {

    @Autowired
    private ConversionService conversionService;

    @PostMapping("/jsontocsv")
    public ResponseEntity<ApiResponse> convertJsonToCsv(@RequestBody String json) {

        return ResponseEntity.ok(new ApiResponse("Conversion successful", true, json));
    }
}
