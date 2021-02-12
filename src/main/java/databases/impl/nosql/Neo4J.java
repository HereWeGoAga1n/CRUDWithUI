package databases.impl.nosql;

import databases.impl.IDataBaseModel;
import model.User;
import org.neo4j.driver.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Neo4J implements IDataBaseModel {
    User user = new User();

    private Driver driver;

    private Driver getDriver() {
        driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "root"));
        return driver;
    }

    @Override
    public void writeToDB(User user) {
        try (Session session = getDriver().session()) {
            Map<String, Object> params = new HashMap<>();
            params.put("Fullname", user.getFullname());
            params.put("Username", user.getUsername());
            params.put("Email", user.getEmail());

            session.run("CREATE (n:users{fullname:$Fullname,username:$Username,email:$Email})", params);
        }
        driver.close();
    }


    @Override
    public List<User> readFromDB() {
        List<User> userList = new ArrayList<>();
        User user1;
        try (Session session = getDriver().session()) {
            Result result = session.run("MATCH (n) RETURN n.fullname, n.email,n.username");
            while (result.hasNext()) {
                Record record = result.next();
                user1 = new User(record.values().get(0).asString(),
                        record.values().get(1).asString(),
                        record.values().get(2).asString());
                userList.add(user1);
            }
        }
        return userList;
    }

    @Override
    public void updateInDB(long id, String[] newValue) {
        try (Session session = getDriver().session()) {
            Map<String, Object> params = new HashMap<>();
            params.put("Fullname", user.getFullname());
            params.put("Username", user.getUsername());
            params.put("Email", user.getEmail());

            session.run("MATCH (n{username:$Fullname}) SET n.username = $Username , n.email=$Email , n.fullname=$Fullname", params);
        }
    }

    @Override
    public void deleteFromDB(long id){
        try (Session session = getDriver().session()){
            Map<String, Object> params = new HashMap<>();
            params.put("Fullname", user.getFullname());
            params.put("Username", user.getUsername());
            params.put("Email", user.getEmail());


        }

    }
}
