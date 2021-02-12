package databases.impl.nosql;

import databases.impl.IDataBaseModel;
import model.User;

import java.util.List;

public class Cassandra implements IDataBaseModel {


    //root
    //
    //Йцукен1337
/*
    CREATE KEYSPACE cassandra WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'} AND durable_writes = 'true';
*/
    @Override
    public void writeToDB(User user) {

    }

    @Override
    public List<User> readFromDB() {

        return null;
    }

    @Override
    public void updateInDB(long id, String[] newValue) {

    }


    @Override
    public void deleteFromDB(long id) {

    }
}
