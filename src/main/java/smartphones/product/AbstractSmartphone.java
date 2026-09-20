package smartphones.product;

import java.util.Objects;


public abstract class AbstractSmartphone implements Smartphone {

    private final String model;
    private final OperatingSystem operatingSystem;
    private final int batteryCapacityMah;

    protected AbstractSmartphone(String model, OperatingSystem operatingSystem, int batteryCapacityMah) {
        this.model = requireNonBlank(model, "model");
        this.operatingSystem = Objects.requireNonNull(operatingSystem, "operatingSystem must not be null");
        this.batteryCapacityMah = requirePositive(batteryCapacityMah, "batteryCapacityMah");
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    @Override
    public int getBatteryCapacityMah() {
        return batteryCapacityMah;
    }

    @Override
    public String powerOn() {
        return model + " is booting " + operatingSystem.getDisplayName();
    }

    private static String requireNonBlank(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " must not be null or blank");
        }
        return value;
    }

    private static int requirePositive(int value, String fieldName) {
        if (value <= 0) {
            throw new IllegalArgumentException(fieldName + " must be positive, but was " + value);
        }
        return value;
    }
}
