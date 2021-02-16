package project2;

import org.json.simple.parser.ParseException;
import project2.cmd.Executable;
import project2.model.Person;

import java.io.IOException;
import java.util.List;

public class SwingUiController implements Executable {
    @Override
    public void create(List<Person> persons) throws IOException, ParseException, ClassNotFoundException {

    }

    @Override
    public void start() throws IOException {

    }

    @Override
    public List<Person> read() throws IOException, ParseException, ClassNotFoundException {
        return null;
    }

    @Override
    public void update(long id, String valueToBeUpdated, String valueToChange) throws IOException, ParseException, ClassNotFoundException {

    }

    @Override
    public void delete(long id) throws IOException, ParseException, ClassNotFoundException {

    }

    @Override
    public void isFileDataDownloaded(boolean isFileDataDownloaded) throws ParseException, IOException, ClassNotFoundException {

    }

}
