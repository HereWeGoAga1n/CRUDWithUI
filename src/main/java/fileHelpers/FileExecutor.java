package fileHelpers;

import model.User;

import java.util.List;

public interface FileExecutor {
    void create(String fileName, List<User> persons);

    List<User> read(String fileName);

    void update(long id, String[] newValue, List<User> personList, String fileName);

    void delete(long id, List<User> personList, String fileName);
}
