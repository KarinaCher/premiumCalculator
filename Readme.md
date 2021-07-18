# Premium calculator module

Add this to your project to calculate policy premium.

To get policy premium use PremiumCalculator.calculate(Policy policy) method.
Method take as parameter Policy instance.

Policy contain PolicyObjects, each of them contains policy sub-objects with information of risk and sum insured.

Policy instance initialization example:
```
Policy policy = new PolicyImpl("LV20-02-100000-5");
PolicyObject policyObject = new PolicyObjectImpl("House");
policyObject.addSubObject(new SubObjectImpl("TV", FIRE, new BigDecimal(100)));
policyObject.addSubObject(new SubObjectImpl("Laptop", THEFT, new BigDecimal(8)));
policy.addObject(policyObject);
```