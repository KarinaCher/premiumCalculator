package entity;

import java.util.List;

public interface Policy {
    void addObject(PolicyObject object);

    List<PolicyObject> getObjects();
}
