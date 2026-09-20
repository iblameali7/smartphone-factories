package smartphones.factorymethod;

import smartphones.product.IPhone;
import smartphones.product.Smartphone;

public class AppleManufacturer extends SmartphoneManufacturer {

    @Override
    protected Smartphone createSmartphone() {
        return new IPhone();
    }
}
