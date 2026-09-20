package smartphones.accessories;

import smartphones.product.Smartphone;

public class GalaxyBuds implements Earbuds {

    private static final String NAME = "Galaxy Buds";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String pairWith(Smartphone smartphone) {
        return String.format("%s pair with %s via Samsung SmartThings", NAME, smartphone.getModel());
    }
}
