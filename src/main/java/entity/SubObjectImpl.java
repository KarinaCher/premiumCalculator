package entity;

import java.math.BigDecimal;

public class SubObjectImpl implements SubObject {

    private Risk risk;
    private BigDecimal sumInsured;

    public SubObjectImpl(Risk risk, BigDecimal sumInsured) {
        this.risk = risk;
        this.sumInsured = sumInsured;
    }

    @Override
    public Risk getRisk() {
        return this.risk;
    }

    @Override
    public BigDecimal getSumInsured() {
        return this.sumInsured;
    }
}
