package com.company.maper.impl;

import com.company.maper.IModelToStringConverter;
import com.company.utils.FileHelper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.company.model.Person;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class JsonModelToStringConverter implements IModelToStringConverter {

    private final ObjectMapper objectMapper = new ObjectMapper();
    Scanner scanner = new Scanner(System.in);
    @Override
    public String convertPersonToString(List<Person> person) {
        try {
            return objectMapper.writeValueAsString(person);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Person> convertStringToPerson(String strPersons) throws IOException {
        try {
            return objectMapper.readValue(strPersons, new TypeReference<List<Person>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



