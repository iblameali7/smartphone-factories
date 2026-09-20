package smartphones;

import smartphones.abstractfactory.AppleEcosystemFactory;
import smartphones.abstractfactory.EcosystemFactory;
import smartphones.abstractfactory.SamsungEcosystemFactory;
import smartphones.abstractfactory.SmartphoneBundleAssembler;
import smartphones.factorymethod.AppleManufacturer;
import smartphones.factorymethod.SamsungManufacturer;
import smartphones.factorymethod.SmartphoneManufacturer;
import smartphones.product.Smartphone;

/** Composition root: the only place where concrete creators and factories are chosen. */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Part A: Factory Method ===");
        demonstrateFactoryMethod(new AppleManufacturer());
        demonstrateFactoryMethod(new SamsungManufacturer());

        System.out.println("=== Part B: Abstract Factory ===");
        demonstrateAbstractFactory(new AppleEcosystemFactory());
        demonstrateAbstractFactory(new SamsungEcosystemFactory());
    }

    private static void demonstrateFactoryMethod(SmartphoneManufacturer manufacturer) {
        Smartphone smartphone = manufacturer.orderSmartphone();
        System.out.println(smartphone.powerOn());
        System.out.println(smartphone.takePhoto());
        System.out.println();
    }

    private static void demonstrateAbstractFactory(EcosystemFactory ecosystemFactory) {
        SmartphoneBundleAssembler assembler = new SmartphoneBundleAssembler(ecosystemFactory);
        assembler.assemble().unbox().forEach(System.out::println);
        System.out.println();
    }
}
