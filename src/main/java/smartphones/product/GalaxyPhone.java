package smartphones.product;

public class GalaxyPhone extends AbstractSmartphone {

    private static final String MODEL_NAME = "Galaxy S24 Ultra";
    private static final int BATTERY_CAPACITY_MAH = 5000;
    private static final int CAMERA_MEGAPIXELS = 200;
    private static final String CAMERA_TECHNOLOGY = "Nightography";

    public GalaxyPhone() {
        super(MODEL_NAME, OperatingSystem.ANDROID, BATTERY_CAPACITY_MAH);
    }

    @Override
    public String takePhoto() {
        return String.format("%s takes a %d MP photo using %s",
                getModel(), CAMERA_MEGAPIXELS, CAMERA_TECHNOLOGY);
    }
}
