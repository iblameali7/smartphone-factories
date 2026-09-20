package smartphones.accessories;

import smartphones.product.Smartphone;

public class SuperFastCharger implements Charger {

    private static final String NAME = "Super Fast Charger";
    private static final int POWER_WATTS = 45;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int getPowerWatts() {
        return POWER_WATTS;
    }

    @Override
    public String charge(Smartphone smartphone) {
        return String.format("%s (%d W) charges %s over USB-C",
                NAME, POWER_WATTS, smartphone.getModel());
    }
}
