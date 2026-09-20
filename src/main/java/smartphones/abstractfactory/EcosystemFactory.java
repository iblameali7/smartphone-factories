package smartphones.abstractfactory;

import smartphones.accessories.Charger;
import smartphones.accessories.Earbuds;
import smartphones.product.Smartphone;


public interface EcosystemFactory {

    Smartphone createSmartphone();

    Charger createCharger();

    Earbuds createEarbuds();
}
