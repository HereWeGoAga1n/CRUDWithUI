package com.company.controller;

import com.company.Main;
import com.company.executors.Executable;
import com.company.executors.Factory;
import com.company.maper.IModelToStringConverter;
import com.company.model.Person;
import com.company.utils.FileHelper;
import com.company.utils.ScannerFileName;
import com.company.utils.Utils;

import static com.company.utils.Utils.*;
import static com.company.utils.Constants.*;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;


public class UserDialog {

//    Person person = new Person();
    FileHelper fileHelper;
    IModelToStringConverter converter;

    public UserDialog() throws ClassNotFoundException, IOException {
        this.fileHelper = new FileHelper();
        this.converter = converter;
    }

    public int startApp() throws IOException, ClassNotFoundException, NullPointerException {

        int commandMainMenu = 0;
        boolean boo = false;

        do {
            System.out.printf(COMMANDS);

            System.out.println(COM_NUMB);
            commandMainMenu = Utils.scan().nextInt();

            if (commandMainMenu < 1 || commandMainMenu > 8) {
                System.out.println(" Sorry! Incorrect choice. Enter again:");
                commandMainMenu = Utils.scan().nextInt();
            } else boo = true;
        }while (boo == false);
        return commandMainMenu;
    }

    public void swap() throws IOException, ClassNotFoundException {
        do {

            switch (startApp()) {
                case 1:
                    sfn().scannerFileNameAndCreateFile();
                    getExecutable().write(fileHelper.createPerson());
                    getExecutable().read();
                    break;
                case 2:
                    sfn().scannerFileNameAndCreateFile();
                    getExecutable().read();
                    System.out.println("Enter your id : ");
                    int id = Utils.scan().nextInt();
                    getExecutable().update(getExecutable().read(), id);
                    break;
                case 3:
                    sfn().scannerFileNameAndCreateFile();
                    getExecutable().read();
                    break;
                case 4:
                    sfn().scannerFileNameAndCreateFile();
                    List<Person> personToDelete = getExecutable().read();
                    getExecutable().delete(personToDelete);
                    break;
                case 5:
                    exit();
                    break;
                case 6:
                    Utils.help();
                    break;
                case 7:
                    startApp();
                    break;
                case 8:
                    start();
                    break;
                default:
            }
        }while (true);
    }


    public void start() {
        System.out.println("Yours data saved.");
    }

    private void exit() throws IOException {
        while (true) {
            System.out.println("Are you sure that you want to quit the app?");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String answer = reader.readLine();
            if (answer.toLowerCase().equals("yes")) System.exit(0);
            else if (!answer.toLowerCase().equals("no")) System.out.println("Please answer \"yes\" or \"no\"");
            else break;
        }
    }
}

