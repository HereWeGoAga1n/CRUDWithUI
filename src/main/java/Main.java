
import databases.impl.sql.H2;
import model.User;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        User user = new User("Vaysa", "Vitya@mail.", "VasyaVasya");
        H2 h2 = new H2();
        h2.writeToDB(user);
    }
}
