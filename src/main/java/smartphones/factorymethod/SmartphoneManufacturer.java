package smartphones.factorymethod;

import smartphones.product.Smartphone;

/**
 * Creator (Factory Method pattern).
 * Declares the factory method and reuses it in {@link #orderSmartphone()},
 * so the ordering flow never depends on a concrete smartphone class.
 */
public abstract class SmartphoneManufacturer {

    private static final int MINIMUM_BATTERY_CAPACITY_MAH = 3000;

    /** The factory method: subclasses decide which concrete Smartphone is created. */
    protected abstract Smartphone createSmartphone();

    public final Smartphone orderSmartphone() {
        Smartphone smartphone = createSmartphone();
        runQualityCheck(smartphone);
        return smartphone;
    }

    private void runQualityCheck(Smartphone smartphone) {
        if (smartphone.getBatteryCapacityMah() < MINIMUM_BATTERY_CAPACITY_MAH) {
            throw new IllegalStateException(String.format(
                    "%s failed quality check: battery %d mAh is below the minimum of %d mAh",
                    smartphone.getModel(), smartphone.getBatteryCapacityMah(), MINIMUM_BATTERY_CAPACITY_MAH));
        }
    }
}
