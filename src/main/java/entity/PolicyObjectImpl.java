package entity;

import java.util.ArrayList;
import java.util.List;

public class PolicyObjectImpl implements PolicyObject{
    private final String name;
    private List<SubObject> subObjects = new ArrayList<>();

    public PolicyObjectImpl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void addSubObject(SubObject subObject) {
        subObjects.add(subObject);
    }

    @Override
    public List<SubObject> getSubObjects() {
        return subObjects;
    }
}
