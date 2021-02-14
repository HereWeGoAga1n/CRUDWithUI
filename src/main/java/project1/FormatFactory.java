package project1;

import DataFormatConverter.impl.CSVConverter;
import DataFormatConverter.impl.XMLConverter;
import DataFormatConverter.impl.YamlConverter;
import util.Constants.Format;
import DataFormatConverter.impl.JasonConverter;
import project1.cmd.BinaryFormatCmdProcessor;
import project1.cmd.Executable;
import project1.cmd.StringFormatCmdProcessor;

public class FormatFactory {

    private final Executable jsonExecutable = new StringFormatCmdProcessor(new JasonConverter());
    private final Executable xmlExecutable = new StringFormatCmdProcessor(new XMLConverter());
    private final Executable csvExecutable = new StringFormatCmdProcessor(new CSVConverter());
    private final Executable yamlExecutable = new StringFormatCmdProcessor(new YamlConverter());
    private final Executable binaryExecutable = new BinaryFormatCmdProcessor();

    public Executable getInstance(String format) {
        Executable instance;
        switch (format.toLowerCase()) {
            case Format.YAML:
                instance = yamlExecutable;
                break;
            case Format.CSV:
                instance = csvExecutable;
                break;
            case Format.XML:
                instance = xmlExecutable;
                break;
            case Format.JSON:
                instance = jsonExecutable;
                break;
            case Format.BINARY:
                instance = binaryExecutable;
                break;
            default:
                throw new IllegalArgumentException("Данная программа не работает введенным форматом.\n");
        }
        return instance;
    }
}