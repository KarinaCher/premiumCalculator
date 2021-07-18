package entity;

import java.util.List;

public interface PolicyObject {
    String getName();

    void addSubObject(SubObject subObject);

    List<SubObject> getSubObjects();
}
