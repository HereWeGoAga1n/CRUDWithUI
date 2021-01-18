package com.company.maper;

import com.company.model.Person;

import java.io.IOException;
import java.util.List;

public interface IModelToStringConverter {

    String convertPersonToString(List<Person> person) throws IOException;

    List<Person> convertStringToPerson(String string) throws IOException, RuntimeException;

}
