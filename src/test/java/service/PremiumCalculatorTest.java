package service;

import entity.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static entity.Risk.FIRE;
import static entity.Risk.THEFT;
import static org.junit.jupiter.api.Assertions.*;

class PremiumCalculatorTest {
    private PremiumCalculator calculator = new PremiumCalculator();

    /**
     * If there is one policy, one object and two sub-objects as described below,
     * then calculator should return premium = 2.28 EUR
     * Risk type = FIRE, Sum insured = 100.00
     * Risk type = THEFT, Sum insured = 8.00
     */
    @Test
    public void testAC1() {
        Policy policy = new PolicyImpl("LV20-02-100000-5");
        PolicyObject policyObject = new PolicyObjectImpl("House");
        policyObject.addSubObject(new SubObjectImpl("TV", FIRE, new BigDecimal(100)));
        policyObject.addSubObject(new SubObjectImpl("TV", THEFT, new BigDecimal(8)));
        policy.addObject(policyObject);

        BigDecimal policyPremium = calculator.calculate(policy);

        assertEquals(new BigDecimal(2.28).setScale(2, RoundingMode.HALF_DOWN), policyPremium);
    }

    /**
     * If policy's total sum insured for risk type FIRE
     * and total sum insured for risk type THEFT are as described below,
     * then calculator should return premium = 17.13 EUR
     * Risk type = FIRE, Sum insured = 500.00
     * Risk type = THEFT, Sum insured = 102.51
     */
    @Test
    public void testAC2() {
        Policy policy = new PolicyImpl("LV20-02-100000-5");
        PolicyObject policyObject = new PolicyObjectImpl("House");
        policyObject.addSubObject(new SubObjectImpl("TV", FIRE, new BigDecimal(500)));
        policyObject.addSubObject(new SubObjectImpl("Laptop", THEFT, new BigDecimal(102.51)));
        policy.addObject(policyObject);

        BigDecimal policyPremium = calculator.calculate(policy);

        assertEquals(new BigDecimal(17.13).setScale(2, RoundingMode.HALF_DOWN), policyPremium);
    }

}