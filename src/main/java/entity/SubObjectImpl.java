package entity;

import java.math.BigDecimal;

public class SubObjectImpl implements SubObject {

    private final String name;
    private final Risk risk;
    private final BigDecimal sumInsured;

    public SubObjectImpl(String name, Risk risk, BigDecimal sumInsured) {
        this.name = name;
        this.risk = risk;
        this.sumInsured = sumInsured;
    }

    @Override
    public String getName() {
        return name;
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
