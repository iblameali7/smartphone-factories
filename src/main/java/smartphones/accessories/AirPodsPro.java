package smartphones.accessories;

import smartphones.product.Smartphone;

public class AirPodsPro implements Earbuds {

    private static final String NAME = "AirPods Pro";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String pairWith(Smartphone smartphone) {
        return String.format("%s pair instantly with %s via iCloud", NAME, smartphone.getModel());
    }
}
