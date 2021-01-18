package com.company.executors;

import com.company.model.Person;

import java.io.IOException;
import java.util.List;

public interface Executable {
    void write(List<Person> personList) throws IOException;

    List<Person> read() throws IOException, ClassNotFoundException;

    List<Person> update(List<Person> personList,int id) throws IOException;

    List<Person> delete(List<Person> personList) throws IOException;
}