package com.company.utils;

import com.company.model.Person;

import java.io.*;
import java.util.*;

public class FileHelper {
    public Scanner scanner = new Scanner(System.in);

    public static final String PATH_TO_PATH = "src/com/company/resources/";

    public void saveToFile(String content) throws IOException {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(PATH_TO_PATH + ScannerFileName.fileName, false))) {
            out.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFromFile() {
        String content = null;
        File file = new File(PATH_TO_PATH + ScannerFileName.fileName);
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(content);
        return content;
    }

    public void writeToFile(String content) throws RuntimeException {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(PATH_TO_PATH + ScannerFileName.fileName, false))) {
            out.write(content);
           /* out.flush;
            out.close;*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*private Executable getExecutable() {
        Factory factory = new Factory();
        Executable executable = factory.getInstanceByFormat(scannerFileName.getFileExtension(ScannerFileName.fileName));
        return executable;
    }*/

    public List<Person> createPerson() {
        Person person = new Person();
        List<Person> personList = new ArrayList<Person>();

        System.out.println("Enter id : ");
        person.setId(scanner.nextInt());

        System.out.println("Enter first name : ");
        person.setFirstName(scanner.next());

        System.out.println("Enter last name : ");
        person.setLastName(scanner.next());

        System.out.println("Enter age : ");
        person.setAge(scanner.nextInt());

        System.out.println("Enter city : ");
        person.setCity(scanner.next());

        personList.add(person);

        return personList;
    }

}
