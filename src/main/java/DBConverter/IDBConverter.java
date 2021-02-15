package DBConverter;

import project1.model.Person;

import java.util.List;

public interface IDBConverter {

    public void writeToDB(Person person);

    public List<Person> readFromDB();

    void updateInDB(long id,String[] newValue);

    void deleteFromDB(long id);
}
