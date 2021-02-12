package databases.impl;

import model.User;

import java.util.List;


public interface IDataBaseModel {

    public void writeToDB(User user);

    public List<User> readFromDB();

    void updateInDB(long id,String[] newValue);

    void deleteFromDB(long id);
}
