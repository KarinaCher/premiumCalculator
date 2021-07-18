package entity;

import java.util.List;
import java.util.Optional;

public interface Policy {
    String getNumber();

    Status getStatus();

    void setStatus(Status status);

    void addObject(PolicyObject object);

    List<PolicyObject> getObjects();

    Optional<PolicyObject> getObjectByName(String objectName);
}
