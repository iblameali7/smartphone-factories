package smartphones.product;

public class IPhone extends AbstractSmartphone {

    private static final String MODEL_NAME = "iPhone 16 Pro";
    private static final int BATTERY_CAPACITY_MAH = 3582;
    private static final int CAMERA_MEGAPIXELS = 48;
    private static final String CAMERA_TECHNOLOGY = "Deep Fusion";

    public IPhone() {
        super(MODEL_NAME, OperatingSystem.IOS, BATTERY_CAPACITY_MAH);
    }

    @Override
    public String takePhoto() {
        return String.format("%s takes a %d MP photo using %s",
                getModel(), CAMERA_MEGAPIXELS, CAMERA_TECHNOLOGY);
    }
}
