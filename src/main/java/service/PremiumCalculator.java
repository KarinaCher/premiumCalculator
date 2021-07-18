package service;

import entity.Policy;
import entity.Risk;
import entity.SubObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PremiumCalculator {
    public BigDecimal calculate(Policy policy) {
        Map<Risk, List<SubObject>> riskListMap = policy.getObjects().stream()
                .flatMap(policyObject -> policyObject.getSubObjects().stream())
                .collect(Collectors.groupingBy(SubObject::getRisk));

        BigDecimal sum = BigDecimal.ZERO;
        for (Risk risk : riskListMap.keySet()) {
            List<SubObject> subObjects = riskListMap.get(risk);
            BigDecimal totalSum = subObjects.stream()
                    .map(subObject -> subObject.getSumInsured())
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal riskSum = totalSum.multiply(risk.getCoefficient(totalSum));
            sum = sum.add(riskSum);
        }

        return sum.setScale(2, RoundingMode.HALF_DOWN);
    }

}
