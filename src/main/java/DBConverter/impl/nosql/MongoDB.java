package DBConverter.impl.nosql;

import DBConverter.IDBConverter;
import project2.model.Person;

import java.util.List;

public class MongoDB implements IDBConverter {

    @Override
    public void writeToDB(Person person) {

    }

    @Override
    public List<Person> readFromDB() {
        return null;
    }

    @Override
    public void updateInDB(long id, String[] newValue) {

    }

    @Override
    public void deleteFromDB(long id) {

    }
}
