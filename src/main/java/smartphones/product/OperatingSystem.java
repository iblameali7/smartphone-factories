package smartphones.product;

public enum OperatingSystem {
    IOS("iOS"),
    ANDROID("Android");

    private final String displayName;

    OperatingSystem(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
