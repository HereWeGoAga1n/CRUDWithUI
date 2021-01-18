package com.company.utils;

import java.io.*;

import static com.company.utils.FileHelper.PATH_TO_PATH;


public class ScannerFileName {
    public static String fileName;

    public void scannerFileNameAndCreateFile() throws IOException {
        try {
            System.out.println("Available formats: binary, json, csv, xml, yaml. \n Enter file name and format file (for example, example.json) : ");
            fileName = Utils.scan().nextLine();
            InputStream is = new FileInputStream(PATH_TO_PATH + fileName);
            is.close();
        } catch (FileNotFoundException e) {
            System.out.println("This file does not exist! We are creating it. ");
            new File(PATH_TO_PATH + fileName).createNewFile();
        }
    }

    public String getFileExtension(String inputFileName) {
        // если в имени файла есть точка и она не является первым символом в названии файла
        if (inputFileName.lastIndexOf(".") != -1 && inputFileName.lastIndexOf(".") != 0)
            // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
            return inputFileName.substring(inputFileName.lastIndexOf(".") + 1);
            // в противном случае возвращаем заглушку, то есть расширение не найдено
        else return "False";
    }
}
