package entity;

import java.util.ArrayList;
import java.util.List;

public class PolicyImpl implements Policy {
    private List<PolicyObject> objects = new ArrayList<>();

    @Override
    public void addObject(PolicyObject policyObject) {
        objects.add(policyObject);
    }

    @Override
    public List<PolicyObject> getObjects() {
        return objects;
    }
}
