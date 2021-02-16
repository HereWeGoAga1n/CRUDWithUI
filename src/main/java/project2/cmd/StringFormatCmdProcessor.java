package project2.cmd;

import data_format_converter.IConverter;
import org.json.simple.parser.ParseException;
import project2.io.FileHelper;
import project2.model.Person;

import java.io.IOException;
import java.util.List;
import static project2.UserDialogController.*;
public class StringFormatCmdProcessor implements Executable {
    FileHelper fileHelper = new FileHelper();
    IConverter converter;

    public StringFormatCmdProcessor(IConverter converter) {
        this.converter = converter;
    }

    @Override
    public void start() throws IOException {
        String personsStr = converter.getStrFromPersons(personsBeforeSave);
        fileHelper.writeToFile(personsStr);
    }

    @Override
    public List<Person> read() throws IOException {
        String content = fileHelper.getFile();
        return converter.getPersonsFromString(content);
    }

    @Override
    public void update(long id, String valueToBeUpdated, String valueToChange) throws IOException, ParseException, ClassNotFoundException {
        isFileDataDownloaded(isFileDataDownloaded);
        String content = converter.getStrFromPersons(personsBeforeSave);
        personsBeforeSave = converter.updateDataInPerson(id, valueToBeUpdated, valueToChange, content);
    }

    @Override
    public void delete(long id) throws IOException, ParseException, ClassNotFoundException {
     //   isFileDataDownloaded(isFileDataDownloaded);
        String content = converter.getStrFromPersons(personsBeforeSave);
        personsBeforeSave = converter.removePersonsFromList(id, content);
    }
}
