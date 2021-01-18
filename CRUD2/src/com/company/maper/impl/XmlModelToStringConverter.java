package com.company.maper.impl;

import com.company.maper.IModelToStringConverter;
import com.company.model.Person;
import com.company.utils.FileHelper;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class XmlModelToStringConverter implements IModelToStringConverter {

    private final XmlMapper xmlMapper = new XmlMapper();

    @Override
    public String convertPersonToString(List<Person> person) throws JsonProcessingException {
        try {
            return xmlMapper.writeValueAsString(person);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Person> convertStringToPerson(String string) throws IOException {
        return xmlMapper.readValue(string, new TypeReference<List<Person>>() {
        });
    }

}
