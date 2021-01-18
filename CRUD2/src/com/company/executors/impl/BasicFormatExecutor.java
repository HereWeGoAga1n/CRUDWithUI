package com.company.executors.impl;

import com.company.controller.UserDialog;
import com.company.maper.IModelToStringConverter;
import com.company.utils.FileHelper;
import com.company.executors.Executable;
import com.company.model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BasicFormatExecutor implements Executable {

    private final FileHelper fileHelper;
    private final IModelToStringConverter converter;

    public BasicFormatExecutor(IModelToStringConverter converter) {
        this.fileHelper = new FileHelper();
        this.converter = converter;
    }

    Scanner scanner = new Scanner(System.in);

    @Override
    public void write(List<Person> personList) throws IOException {
        String personStr = converter.convertPersonToString(personList);
        fileHelper.saveToFile(personStr);
    }

    @Override
    public List<Person> read() throws IOException, ClassNotFoundException {
        String content = fileHelper.readFromFile();
        return converter.convertStringToPerson(content);
    }


    @Override
    public List<Person> update(List<Person> personList,int id) throws IOException {
        List<Person> personList1 = personList;
        int count = 0;
        for (Person p : personList1) {
            if (count == 0) {
                if (p.getId() == id) {
                    System.out.println("First name: ");
                    p.setFirstName(scanner.nextLine());
                    System.out.println("Last name: ");
                    p.setLastName(scanner.nextLine());
                    System.out.println("City: ");
                    p.setCity(scanner.nextLine());
                    System.out.println("Age: ");
                    p.setAge(scanner.nextInt());
                    count++;
                }
            } else if (count <= 0) {
                System.out.println("Person is not found!");
            }
        }
        fileHelper.writeToFile(converter.convertPersonToString(personList1));
        return personList1;
    }

    @Override
    public List<Person> delete(List<Person> personList) throws IOException {
        int count = 0;
        Person personForDelete = new Person();
        System.out.println("Sir");
        int id = scanner.nextInt();
        for (Person p : personList) {
            if (p.getId() == id) {
                personForDelete = p;
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Person not found!");
        }
        personList.remove(personForDelete);
        fileHelper.writeToFile(converter.convertPersonToString(personList));
        return personList;
    }
}
