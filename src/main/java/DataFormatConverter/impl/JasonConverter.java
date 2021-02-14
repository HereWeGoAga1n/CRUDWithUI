package DataFormatConverter.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import DataFormatConverter.IConverter;
import project1.model.Person;

import java.lang.reflect.Type;
import java.util.List;

public class JasonConverter implements IConverter {
    Gson json = new Gson();

    @Override
    public String getStrFromPersons(List<Person> persons) {
        return json.toJson(persons);
    }

    public List<Person> getPersonsFromString(String strPersons) {
        Type collectionType = new TypeToken<List<Person>>() {}.getType();
        return json.fromJson(strPersons, collectionType);
    }

}
