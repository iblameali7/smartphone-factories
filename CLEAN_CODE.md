# Clean Code principles applied

Each principle shows a naive "before" (not in the repository) and the real "after" from the code.

## 1. Meaningful, intention-revealing names

**Before**
```java
Phone p = f.make();
p.go();
```
**After** — `SmartphoneManufacturer.java`, `Main.java`
```java
Smartphone smartphone = manufacturer.orderSmartphone();
System.out.println(smartphone.powerOn());
```
Names say what happens (`orderSmartphone`, `powerOn`) and what the type is (`Smartphone`, not `Phone`/`P`),
so no comment is needed to read the flow.

## 2. Small methods that do one thing

**Before** — one method creates, validates and prints
```java
public Phone order() {
    Phone p = new IPhone();
    if (p.battery < 3000) { System.out.println("bad"); return null; }
    System.out.println("ok");
    return p;
}
```
**After** — `SmartphoneManufacturer.java`
```java
public final Smartphone orderSmartphone() {
    Smartphone smartphone = createSmartphone();
    runQualityCheck(smartphone);
    return smartphone;
}
```
`orderSmartphone` only coordinates; creating is `createSmartphone`, checking is `runQualityCheck`.
Each method is 3–8 lines and has a single reason to change.

## 3. No magic numbers or strings

**Before**
```java
super("iPhone 16 Pro", "iOS", 3582);
...
if (battery < 3000) { ... }
```
**After** — `IPhone.java`, `SmartphoneManufacturer.java`
```java
private static final String MODEL_NAME = "iPhone 16 Pro";
private static final int BATTERY_CAPACITY_MAH = 3582;
super(MODEL_NAME, OperatingSystem.IOS, BATTERY_CAPACITY_MAH);
...
private static final int MINIMUM_BATTERY_CAPACITY_MAH = 3000;
```
Every literal has a name that explains it. The operating system is an `enum`
(`OperatingSystem.IOS`), so a typo like `"ios"` is a compile error, not a runtime bug.

## 4. Validated construction (fail fast with a clear message)

**Before** — invalid objects can exist and fail later, far from the cause
```java
public AbstractSmartphone(String model, int battery) {
    this.model = model;
    this.battery = battery;
}
```
**After** — `AbstractSmartphone.java`
```java
this.model = requireNonBlank(model, "model");
this.operatingSystem = Objects.requireNonNull(operatingSystem, "operatingSystem must not be null");
this.batteryCapacityMah = requirePositive(batteryCapacityMah, "batteryCapacityMah");
...
throw new IllegalArgumentException(fieldName + " must be positive, but was " + value);
```
A `Smartphone` with a blank model or a non-positive battery can never be created.
`SmartphoneBundle` and `SmartphoneBundleAssembler` apply the same idea with `Objects.requireNonNull`.

## 5. Small, focused classes (Single Responsibility) and no duplication (DRY)

**Before** — one class knows every phone, charger and brand
```java
class Store {
    Phone makePhone(String brand) { ... }
    Charger makeCharger(String brand) { ... }
    String describe(...) { ... }
}
```
**After** — `AbstractSmartphone` holds shared state and validation once; `IPhone` / `GalaxyPhone`
add only what differs (`takePhoto`). `Charger`, `Earbuds`, `EcosystemFactory`,
`SmartphoneBundleAssembler` each have one job. No validation code is copied between phones.

## 6. Replace conditionals with polymorphism

**Before**
```java
Smartphone create(String brand) {
    if (brand.equals("apple")) return new IPhone();
    else if (brand.equals("samsung")) return new GalaxyPhone();
    throw new IllegalArgumentException(brand);
}
```
**After** — `AppleManufacturer.java`
```java
@Override
protected Smartphone createSmartphone() {
    return new IPhone();
}
```
The `if/else` chain is replaced by subclasses. Adding a brand means adding a class, not editing a
growing conditional — this is exactly what Factory Method gives us.
