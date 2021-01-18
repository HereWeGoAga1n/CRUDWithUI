package com.company.utils;

public class Constants {

    public static final String JSON = "json";
    public static final String XML = "xml";
    public static final String YAML = "yaml";
    public static final String CSV = "csv";
    public static final String BINARY = "bin";
    public static final String HELP = " *** Help *** \n" +
            "\n" +
            "1. CREATE Command  is used to record a new file. If the file does not exist, the program will create it. \n" +
            " To write to a file you need to type: id, first name, last name, age, city. \n" +
            " 2. READ Command  is used to read information from a file. \n" +
            " 3. UPDATE Command changes one of the Person parameters (first name, last name, age, city) by id. \n " +
            " For this you need to enter: id, which parameter you want to replace (for example, first name) and the text to which you want to change (for example, Peter). \n" +
            " 4. DELETE Command deletes the data of one Person by id. \n" +
            " 5. After the EXIT Command, the application is exited.\n" +
            " 6. After the HELP Command, the available commands and their format are displayed.\n" +
            " 7. After the SWITCH Command, you return to the main menu. \n" +
            " 8. After the START Command, the changed data is saved.";
    public static final String COMMANDS = "Commands to use:\n" +
            "1. Create          " + "5. Exit\n" +
            "2. Update          " + "6. Help\n" +
            "3. Read            " + "7. Switch\n" +
            "4. Delete          " + "8. Start\n";

    public static final String COM_NUMB = "Enter the command number you want to use:";
}
