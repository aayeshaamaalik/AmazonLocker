package org.example;

public class Package {
    private final String packageId;
    private final Size size;

    public Package(String packageId, Size size) {
        this.packageId = packageId;
        this.size = size;
    }

    public String getPackageId() {
        return packageId;
    }

    public Size getSize() {
        return size;
    }
}
