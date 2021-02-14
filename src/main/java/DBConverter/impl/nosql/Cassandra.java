package DBConverter.impl.nosql;

import DBConverter.IDBConverter;
import project1.model.Person;

import java.util.List;

public class Cassandra implements IDBConverter{

    //root
    //
    //Йцукен1337
/*
    CREATE KEYSPACE cassandra WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'} AND durable_writes = 'true';
*/
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
