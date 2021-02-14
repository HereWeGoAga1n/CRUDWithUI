package project1.io;

import java.util.List;
import project1.model.Person;

public interface FileExecutor {
    void create(String fileName, List<Person> persons);

    List<Person> read(String fileName);

    void update(int id, String[] newValue, List<Person> personList, String fileName);

    void delete(int id, List<Person> personList, String fileName);
}
