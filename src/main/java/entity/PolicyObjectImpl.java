package entity;

import java.util.ArrayList;
import java.util.List;

public class PolicyObjectImpl implements PolicyObject{
    private List<SubObject> subObjects = new ArrayList<>();

    @Override
    public void addSubObject(SubObject subObject) {
        // TODO validate
        subObjects.add(subObject);
    }

    @Override
    public List<SubObject> getSubObjects() {
        return subObjects;
    }
}
