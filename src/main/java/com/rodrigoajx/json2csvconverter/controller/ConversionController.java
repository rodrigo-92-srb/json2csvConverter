package com.rodrigoajx.json2csvconverter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rodrigoajx.json2csvconverter.model.ApiResponse;
import com.rodrigoajx.json2csvconverter.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<ApiResponse> convertJsonToCsv(@RequestBody String json) throws JsonProcessingException {
        try{
            String csv = conversionService.convertJsonToCsv(json);
            return ResponseEntity.ok(new ApiResponse("Conversion successful", true, csv));

        } catch (Exception e) {
           return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), false, null));
        }




    }
}
