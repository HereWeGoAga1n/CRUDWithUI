package com.company.executors;

import com.company.executors.impl.BasicFormatExecutor;
import com.company.maper.impl.*;
import com.company.utils.Constants;
import com.company.utils.ScannerFileName;

public class Factory {

    private final Executable jsonExecutable = new BasicFormatExecutor(new JsonModelToStringConverter());
    private final Executable xmlExecutable = new BasicFormatExecutor(new XmlModelToStringConverter());
    private final Executable yamlExecutable = new BasicFormatExecutor(new YamlModelToStringConverter());
    private final Executable csvExecutable = new BasicFormatExecutor(new CsvModelToStringConverter());
    private final Executable binaryExecutable = new BasicFormatExecutor(new BinaryModelToStringConverter());
    ;


    public Executable getInstanceByFormat(String format) {
        Executable result = null;
        switch (format) {
            case Constants.JSON:
                result = jsonExecutable;
                break;
            case Constants.XML:
                result = xmlExecutable;
                break;
            case Constants.YAML:
                result = yamlExecutable;
                break;
            case Constants.CSV:
                result = csvExecutable;
                break;
            case Constants.BINARY:
                result = binaryExecutable;
                break;
            default:
                System.out.println("Sorry, but input incorrect format.");
        }
        return result;
    }
}
