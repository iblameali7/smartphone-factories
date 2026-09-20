package smartphones.abstractfactory;

import java.util.List;
import java.util.Objects;

import smartphones.accessories.Charger;
import smartphones.accessories.Earbuds;
import smartphones.product.Smartphone;

public final class SmartphoneBundle {

    private final Smartphone smartphone;
    private final Charger charger;
    private final Earbuds earbuds;

    public SmartphoneBundle(Smartphone smartphone, Charger charger, Earbuds earbuds) {
        this.smartphone = Objects.requireNonNull(smartphone, "smartphone must not be null");
        this.charger = Objects.requireNonNull(charger, "charger must not be null");
        this.earbuds = Objects.requireNonNull(earbuds, "earbuds must not be null");
    }

    public List<String> unbox() {
        return List.of(
                smartphone.powerOn(),
                charger.charge(smartphone),
                earbuds.pairWith(smartphone));
    }
}
