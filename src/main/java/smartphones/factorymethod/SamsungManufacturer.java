package smartphones.factorymethod;

import smartphones.product.GalaxyPhone;
import smartphones.product.Smartphone;

public class SamsungManufacturer extends SmartphoneManufacturer {

    @Override
    protected Smartphone createSmartphone() {
        return new GalaxyPhone();
    }
}
