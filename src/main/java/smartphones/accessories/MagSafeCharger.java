package smartphones.accessories;

import smartphones.product.Smartphone;

public class MagSafeCharger implements Charger {

    private static final String NAME = "MagSafe Charger";
    private static final int POWER_WATTS = 25;

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
        return String.format("%s (%d W) wirelessly charges %s",
                NAME, POWER_WATTS, smartphone.getModel());
    }
}
