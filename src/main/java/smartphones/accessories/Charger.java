package smartphones.accessories;

import smartphones.product.Smartphone;

public interface Charger {

    String getName();

    int getPowerWatts();

    String charge(Smartphone smartphone);
}
