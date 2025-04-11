package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Locker {
    private final String lockerId;
    private final List<Slot> slots;

    public Locker(String lockerId) {
        this.lockerId = lockerId;
        this.slots = new ArrayList<>();
    }

    public void addSlot(Slot slot) {
        slots.add(slot);
    }

    public List<Slot> getAvailableSlots() {
        return slots.stream()
                .filter(Slot::isAvailable)
                .collect(Collectors.toList());
    }

    public String getLockerId() {
        return lockerId;
    }

    public List<Slot> getAllSlots() {
        return slots;
    }
}
