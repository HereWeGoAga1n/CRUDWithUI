package databases.impl;

import fileHelpers.FileExecutor;
import model.User;

import java.util.List;

public class DBExecutor implements FileExecutor{
    private final IDataBaseModel iDataBaseModel ;

      public DBExecutor(IDataBaseModel iDataBaseModel) {
          this.iDataBaseModel = iDataBaseModel;
      }

    @Override
    public void create(String fileName, List<User> users) {
        for (User user : users) {
            iDataBaseModel.writeToDB(user);
        }
    }

    @Override
    public List<User> read(String fileName) {
        return iDataBaseModel.readFromDB();

    }


    @Override
    public void update(long id, String[] newValue, List<User> personList, String fileName) {
        iDataBaseModel.updateInDB(id, newValue);

    }

    @Override
    public void delete(long id, List<User> personList, String fileName) {
        iDataBaseModel.deleteFromDB(id);
    }

}
