package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PolicyImpl implements Policy {
    private String number;
    private Status status;
    private List<PolicyObject> objects = new ArrayList<>();

    public PolicyImpl(String number) {
        this.number = number;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public void addObject(PolicyObject policyObject) {
        objects.add(policyObject);
    }

    @Override
    public List<PolicyObject> getObjects() {
        return objects;
    }

    @Override
    public Optional<PolicyObject> getObjectByName(String objectName) {
        return objects.stream()
                .filter(policyObject -> policyObject.getName().equals(objectName))
                .findFirst();
    }
}
