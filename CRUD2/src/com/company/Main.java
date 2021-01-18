package com.company;

import com.company.controller.UserDialog;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        System.out.println(" *** Welcome! *** \n " +
                "This program you will help  write, read, update, delete to file.");

        UserDialog userDialog = new UserDialog();
        userDialog.swap();
    }
}

// cхема
