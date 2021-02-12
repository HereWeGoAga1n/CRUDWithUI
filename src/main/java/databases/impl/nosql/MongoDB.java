package databases.impl.nosql;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import databases.impl.IDataBaseModel;
import model.User;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class MongoDB implements IDataBaseModel {

    private MongoClient getMongoClient() {
        return new MongoClient("localhost", 27017);
    }

    private MongoCollection<Document> getCollection() {
        return getMongoClient().getDatabase("MongoDB").getCollection("persons");
    }


    @Override
    public void writeToDB(User user) {
        Document document = new Document();
        document.put("Username", user.getUsername());
        document.put("Fullname", user.getFullname());
        document.put("Email", user.getEmail());
        getCollection().insertOne(document);
        getMongoClient().close();
    }

    @Override
    public List<User> readFromDB() {
        MongoCursor<Document> mongoCursor = getCollection().find().iterator();
        List<User> userList = new ArrayList<>();
        User user = new User();
        while (mongoCursor.hasNext()) {
            Document document = mongoCursor.next();
            user.setUserName(document.getString("Username"));
            user.setFullname(document.getString("Fullname"));
            user.setEmail(document.getString("Email"));
            userList.add(user);
        }
        getMongoClient().close();
        return userList;
    }

    @Override
    public void updateInDB(long id, String[] newValue) {
        Bson filter = eq("id", id);
        Bson updateOperation = and(
                set("Username", newValue[1]),
                set("Fullname", newValue[2]),
                set("Email", newValue[3])

        );
        getCollection().updateOne(filter, updateOperation);
        getMongoClient().close();
    }

    @Override
    public void deleteFromDB(long id) {
        Bson filter = eq("id", id);
        getCollection().deleteOne(filter);
        getMongoClient().close();
    }
}
