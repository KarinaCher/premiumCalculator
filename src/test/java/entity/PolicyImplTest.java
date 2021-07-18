package entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

import static entity.Risk.FIRE;
import static entity.Risk.THEFT;
import static entity.Status.APPROVED;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PolicyImplTest {

    @Test
    public void testPolicyInitialization() {
        Policy policy = new PolicyImpl("LV20-02-100000-5");
        policy.setStatus(APPROVED);

        PolicyObject policyObject1 = new PolicyObjectImpl("House");
        policyObject1.addSubObject(new SubObjectImpl("TV", FIRE, new BigDecimal(100)));
        policyObject1.addSubObject(new SubObjectImpl("Laptop", THEFT, new BigDecimal(8)));
        policy.addObject(policyObject1);

        PolicyObject policyObject2 = new PolicyObjectImpl("Office");
        policyObject2.addSubObject(new SubObjectImpl("TV", FIRE, new BigDecimal(200)));
        policy.addObject(policyObject2);

        PolicyObject house = policy.getObjectByName("House").get();
        PolicyObject office = policy.getObjectByName("Office").get();
        assertAll(
                () -> assertEquals("LV20-02-100000-5", policy.getNumber()),
                () -> assertEquals(APPROVED, policy.getStatus()),
                () -> assertEquals(2, policy.getObjects().size()),
                () -> assertEquals("House", house.getName()),
                () -> assertEquals(2, house.getSubObjects().size()),
                () -> assertEquals(Arrays.asList("TV", "Laptop"),
                        house.getSubObjects().stream()
                                .map(subObject -> subObject.getName())
                                .collect(Collectors.toList())),
                () -> assertEquals(Arrays.asList(FIRE, THEFT),
                        house.getSubObjects().stream()
                                .map(subObject -> subObject.getRisk())
                                .collect(Collectors.toList())),
                () -> assertEquals(Arrays.asList(new BigDecimal(100), new BigDecimal(8)),
                        house.getSubObjects().stream()
                                .map(subObject -> subObject.getSumInsured())
                                .collect(Collectors.toList())),
                () -> assertEquals("Office", office.getName()),
                () -> assertEquals(1, office.getSubObjects().size())
        );
    }

}