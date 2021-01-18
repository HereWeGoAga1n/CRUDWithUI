package com.company.utils;

import com.company.executors.Executable;
import com.company.executors.Factory;

import java.util.Scanner;

import static com.company.utils.Constants.HELP;

public class Utils {
    public static Scanner scanner;
    public static Factory factory;
    public static Executable executable;
    public static ScannerFileName scannerFileName;


    public static ScannerFileName sfn(){
        return scannerFileName = new ScannerFileName();
    }

    public static Scanner scan(){
        return scanner = new Scanner(System.in);
    }

    public static void help() throws NullPointerException {
        System.out.print(HELP);
    }

    public static Executable getExecutable() {
        factory = new Factory();
        executable = factory.getInstanceByFormat(sfn().getFileExtension(sfn().fileName));
        return executable;
    }

}
