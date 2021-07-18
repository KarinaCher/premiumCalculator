package entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static entity.Risk.FIRE;
import static entity.Risk.THEFT;
import static org.junit.jupiter.api.Assertions.*;

class RiskTest {
    @Test
    public void test() {
        assertAll(
                () -> assertEquals(new BigDecimal(0.014), FIRE.getCoefficient(new BigDecimal(10))),
                () -> assertEquals(new BigDecimal(0.014), FIRE.getCoefficient(new BigDecimal(100))),
                () -> assertEquals(new BigDecimal(0.024), FIRE.getCoefficient(new BigDecimal(200))),
                () -> assertEquals(new BigDecimal(0.11), THEFT.getCoefficient(new BigDecimal(10))),
                () -> assertEquals(new BigDecimal(0.05), THEFT.getCoefficient(new BigDecimal(15))),
                () -> assertEquals(new BigDecimal(0.05), THEFT.getCoefficient(new BigDecimal(20)))
        );
    }
}