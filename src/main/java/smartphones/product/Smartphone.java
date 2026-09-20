package smartphones.product;


public interface Smartphone {

    String getModel();

    OperatingSystem getOperatingSystem();

    int getBatteryCapacityMah();

    String powerOn();

    String takePhoto();
}
