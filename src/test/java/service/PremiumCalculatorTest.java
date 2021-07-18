package service;

import entity.Policy;
import entity.PolicyImpl;
import entity.PolicyObjectImpl;
import entity.SubObjectImpl;
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
        Policy policy = new PolicyImpl();
        policy.addObject(new PolicyObjectImpl());
        policy.getObjects().get(0).addSubObject(new SubObjectImpl(FIRE, new BigDecimal(100))); //0.024 2.4
        policy.getObjects().get(0).addSubObject(new SubObjectImpl(THEFT, new BigDecimal(8))); //0.11

        BigDecimal actual = calculator.calculate(policy);

        assertEquals(new BigDecimal(2.28).setScale(2, RoundingMode.HALF_DOWN), actual);
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
        Policy policy = new PolicyImpl();
        policy.addObject(new PolicyObjectImpl());
        policy.getObjects().get(0).addSubObject(new SubObjectImpl(FIRE, new BigDecimal(500)));
        policy.getObjects().get(0).addSubObject(new SubObjectImpl(THEFT, new BigDecimal(102.51)));

        BigDecimal actual = calculator.calculate(policy);

        assertEquals(new BigDecimal(17.13).setScale(2, RoundingMode.HALF_DOWN), actual);
    }

}