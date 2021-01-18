package com.company.maper.impl;

import com.company.executors.Executable;
import com.company.maper.IModelToStringConverter;
import com.company.model.Person;
import com.company.utils.FileHelper;
import com.company.utils.ScannerFileName;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static com.company.utils.FileHelper.PATH_TO_PATH;

public class BinaryModelToStringConverter implements IModelToStringConverter {

    Scanner scanner = new Scanner(System.in);


    @Override
    public String convertPersonToString(List<Person> person) throws IOException {
        String result = "0";
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH_TO_PATH + ScannerFileName.fileName, true));
            oos.writeObject(person);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public List<Person> convertStringToPerson(String string) throws IOException, RuntimeException {
        List<Person> secondPerson = new ArrayList<Person>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_TO_PATH + ScannerFileName.fileName))) {
            secondPerson = ((ArrayList<Person>) ois.readObject());
            return secondPerson;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
