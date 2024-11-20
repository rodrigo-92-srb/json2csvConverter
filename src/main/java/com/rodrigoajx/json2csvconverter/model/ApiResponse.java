package com.rodrigoajx.json2csvconverter.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse {

    private String message;

    private boolean success;

    private String data;
}
