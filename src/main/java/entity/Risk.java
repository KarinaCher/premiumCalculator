package entity;

import java.math.BigDecimal;
import java.util.function.Predicate;

public enum Risk {
    FIRE(new BigDecimal(0.014), sum -> sum.compareTo(new BigDecimal(100)) > 0, new BigDecimal(0.024)),
    THEFT(new BigDecimal(0.11), sum -> sum.compareTo(new BigDecimal(15)) >= 0, new BigDecimal(0.05)),
    ;

    private BigDecimal coefficient;
    private Predicate<? super BigDecimal> condition;
    private BigDecimal extraCoefficient;

    Risk(BigDecimal coefficient, Predicate<? super BigDecimal> condition, BigDecimal extraCoefficient) {
        this.coefficient = coefficient;
        this.condition = condition;
        this.extraCoefficient = extraCoefficient;
    }

    public BigDecimal getCoefficient(BigDecimal sumInsured) {
        if (this.condition.test(sumInsured)) {
            return this.extraCoefficient;
        }
        return this.coefficient;
    }
}
