package com.company.maper.impl;

import com.company.maper.IModelToStringConverter;
import com.company.model.Person;
import com.company.utils.FileHelper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class YamlModelToStringConverter implements IModelToStringConverter {

    private final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

    @Override
    public String convertPersonToString(List<Person> person) throws IOException {
        try {
            return objectMapper.writeValueAsString(person);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Person> convertStringToPerson(String string) throws IOException {
        try {
            return objectMapper.readValue(string, new TypeReference<List<Person>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}