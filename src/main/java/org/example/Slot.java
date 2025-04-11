package org.example;

import java.time.LocalDateTime;

public class Slot {
    private final String slotId;
    private final Size size;
    private final Locker locker;

    private Package storedPackage;
    private LocalDateTime allocationTime;

    public Slot(String slotId, Size size, Locker locker) {
        this.slotId = slotId;
        this.size = size;
        this.locker = locker;
    }

    public boolean isAvailable() {
        return storedPackage == null;
    }

    public boolean canAccommodate(Package pkg) {
        return isAvailable() && size.canFit(pkg.getSize());
    }

    public void allocate(Package pkg) {
        if (!canAccommodate(pkg)) {
            throw new IllegalArgumentException("Slot cannot accommodate this package.");
        }
        this.storedPackage = pkg;
        this.allocationTime = LocalDateTime.now();
    }

    public void deallocate() {
        this.storedPackage = null;
        this.allocationTime = null;
    }

    public String getSlotId() {
        return slotId;
    }

    public Size getSize() {
        return size;
    }

    public Locker getLocker() {
        return locker;
    }

    public Package getStoredPackage() {
        return storedPackage;
    }

    public LocalDateTime getAllocationTime() {
        return allocationTime;
    }
}
