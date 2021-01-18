package com.company.maper.impl;

import com.company.maper.IModelToStringConverter;
import com.company.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;


import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

public class CsvModelToStringConverter implements IModelToStringConverter {

    private final CsvMapper csvMapper = new CsvMapper();
    CsvSchema schema = csvMapper.schemaFor(Person.class);

    @Override
    public String convertPersonToString(List<Person> person) throws JsonProcessingException {
        try {
            return csvMapper.writer(schema.withUseHeader(true)).writeValueAsString(person);
        } catch (MismatchedInputException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return csvMapper.writer(schema.withUseHeader(true)).writeValueAsString(person);
    }

    @Override
    public List<Person> convertStringToPerson(String string) throws JsonProcessingException {
        ArrayList<Person> listPerson = new ArrayList<>();
        try {
            return csvMapper.readValue(string, new TypeReference<List<Person>>() {
            });
        } catch (MismatchedInputException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listPerson;
    }
}
