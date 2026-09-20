package smartphones.abstractfactory;

import smartphones.accessories.AirPodsPro;
import smartphones.accessories.Charger;
import smartphones.accessories.Earbuds;
import smartphones.accessories.MagSafeCharger;
import smartphones.product.IPhone;
import smartphones.product.Smartphone;

public class AppleEcosystemFactory implements EcosystemFactory {

    @Override
    public Smartphone createSmartphone() {
        return new IPhone();
    }

    @Override
    public Charger createCharger() {
        return new MagSafeCharger();
    }

    @Override
    public Earbuds createEarbuds() {
        return new AirPodsPro();
    }
}
