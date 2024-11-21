package com.rodrigoajx.json2csvconverter.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ConversionService {

    public String convertJsonToCsv(String json) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(json);

            if(!jsonNode.isArray() || jsonNode.isEmpty()){
                throw new IllegalAccessException("O JSON deve ser um array de elementos e não pode estar vazio.");
            }

            String csv = "";

            JsonNode firstElement = jsonNode.get(0);
            Iterator<String> fieldNames = firstElement.fieldNames();
            List<String> fieldNameList = new ArrayList<>();
            while (fieldNames.hasNext()) {
                fieldNameList.add(fieldNames.next());
            }

            for (String fieldName : fieldNameList) {
                csv += fieldName + ",";
            }
            csv = csv.substring(0, csv.length() - 1) + "\n";

            for(JsonNode node : jsonNode){
                for (String fieldName : fieldNameList) {
                    csv += node.get(fieldName).asText() + ",";
                }
                csv = csv.substring(0, csv.length() - 1) + "\n";
            }
            return csv;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
