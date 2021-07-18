package entity;

import java.util.List;

public interface PolicyObject {
    void addSubObject(SubObject subObject);

    List<SubObject> getSubObjects();
}
