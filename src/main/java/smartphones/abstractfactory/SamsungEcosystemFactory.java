package smartphones.abstractfactory;

import smartphones.accessories.Charger;
import smartphones.accessories.Earbuds;
import smartphones.accessories.GalaxyBuds;
import smartphones.accessories.SuperFastCharger;
import smartphones.product.GalaxyPhone;
import smartphones.product.Smartphone;

public class SamsungEcosystemFactory implements EcosystemFactory {

    @Override
    public Smartphone createSmartphone() {
        return new GalaxyPhone();
    }

    @Override
    public Charger createCharger() {
        return new SuperFastCharger();
    }

    @Override
    public Earbuds createEarbuds() {
        return new GalaxyBuds();
    }
}
