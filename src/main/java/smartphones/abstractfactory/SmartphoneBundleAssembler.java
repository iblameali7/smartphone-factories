package smartphones.abstractfactory;

import java.util.Objects;


public class SmartphoneBundleAssembler {

    private final EcosystemFactory ecosystemFactory;

    public SmartphoneBundleAssembler(EcosystemFactory ecosystemFactory) {
        this.ecosystemFactory = Objects.requireNonNull(ecosystemFactory, "ecosystemFactory must not be null");
    }

    public SmartphoneBundle assemble() {
        return new SmartphoneBundle(
                ecosystemFactory.createSmartphone(),
                ecosystemFactory.createCharger(),
                ecosystemFactory.createEarbuds());
    }
}
